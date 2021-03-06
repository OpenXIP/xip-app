/*
Copyright (c) 2013, Washington University in St.Louis.
All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package edu.wustl.xipApplication.aim;

import gme.cacore_cacore._3_2.edu_northwestern_radiology.DICOMImageReference;
import gme.cacore_cacore._3_2.edu_northwestern_radiology.Image;
import gme.cacore_cacore._3_2.edu_northwestern_radiology.ImageAnnotation;
import gme.cacore_cacore._3_2.edu_northwestern_radiology.ImageReference;
import gme.cacore_cacore._3_2.edu_northwestern_radiology.ImagingObservation;
import gme.cacore_cacore._3_2.edu_northwestern_radiology.Series;
import gme.cacore_cacore._3_2.edu_northwestern_radiology.Study;
import gme.cacore_cacore._3_2.edu_northwestern_radiology.Annotation.User;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author Jaroslaw Krych
 *
 */
public class AimParser implements Runnable{
	JAXBContext jc;
	Unmarshaller u;
	Marshaller marshaller;
	File aimFile;
	public AimParser(File aimFile){
		try {
			jc = JAXBContext.newInstance( "gme.cacore_cacore._3_2.edu_northwestern_radiology" );
			u = jc.createUnmarshaller();
			marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		} catch (JAXBException e) {			
			e.printStackTrace();
		}					        
		this.aimFile = aimFile;
	}
	
	public void run() {
		unmarshall(aimFile);
		notifyAimParsed();
	}	
		
	String tumorID;
	String tumorName;
	String raterID;
	String raterName;
	List<String> aimDesc;
	String refSOPInstanceUID;
	String xmlString;	
	public void unmarshall(File aimXmlFile){				
		aimDesc = new ArrayList<String>();		
		try {			
			JAXBElement<?> obj = (JAXBElement<?>)u.unmarshal(aimXmlFile);							        
			ImageAnnotation imageAnnotation = ((ImageAnnotation)obj.getValue());
			tumorID = String.valueOf(imageAnnotation.getId());
			tumorName = imageAnnotation.getName();			
			User rater = imageAnnotation.getUser();
			raterID = String.valueOf(rater.getUser().getId());
			raterName = rater.getUser().getName();
			
			//AIM INFO
			String imageAnnotationType = imageAnnotation.getCodeMeaning();			
			aimDesc.add(imageAnnotationType + " " + getTumorName());
			aimDesc.add("Author " + raterName);
			String anatomicRegion = imageAnnotation.getAnatomicEntityCollection().getAnatomicEntity().get(0).getCodeMeaning();
			aimDesc.add("Anatomic Region " + anatomicRegion);			
			String calcType = imageAnnotation.getCalculationCollection().getCalculation().get(0).getCodeMeaning();				
			double calcTypeValue = imageAnnotation.getCalculationCollection().getCalculation().get(0).getCalculationResultCollection().getCalculationResult().get(0).getDataCollection().getData().get(0).getValue();
			aimDesc.add(calcType + " " + String.valueOf(calcTypeValue));
			List<ImagingObservation> imagingObservationColl = imageAnnotation.getImagingObservationCollection().getImagingObservation();
			for(int i = 0; i < imagingObservationColl.size(); i++){
				ImagingObservation imagingObservation = imagingObservationColl.get(i);
				String str1 = imagingObservation.getCodeMeaning();
				String str2 = imagingObservation.getImagingObservationCharacteristicCollection().getImagingObservationCharacteristic().get(0).getCodeMeaning();
				aimDesc.add(str1 + ": " + str2);
			}
			ImageReference imageReference = imageAnnotation.getImageReferenceCollection().getImageReference().get(0);
			DICOMImageReference ref = (DICOMImageReference) imageReference;
        	Study study = ref.getStudy().getStudy();	        		        		        	
        	Series series = study.getSeries().getSeries();
        	Image image = series.getImageCollection().getImage().get(0);
        	refSOPInstanceUID = image.getSopInstanceUID();  
        	        	
        	StringWriter sw = new StringWriter();
			marshaller.marshal(obj, sw);
			xmlString = sw.toString();			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}		
	
	public String getTumorID(){
		return tumorID;
	}
	public String getTumorName(){
		return tumorName;
	}
	public String getRaterID(){
		return raterID;
	}
	public String getRaterName(){
		return raterName;
	}
	public List<String> getAIMDescription(){
		return aimDesc;
	}
	public String getRefSOPInstanceUID(){
		return refSOPInstanceUID;
	}
	public File getAIMFile(){
		return aimFile;
	}
	public String getXMLString(){
		return xmlString;
	}
	
	AimParseListener listener;
    public void addAimParseListener(AimParseListener l) {        
        listener = l;          
    }
	void notifyAimParsed(){
		AimParseEvent event = new AimParseEvent(this);         		
        listener.parsedAimAvailable(event);
	}	
	
	public static void main (String[] atgs){
		File file = new File("C:/OurDocuments/WashUConsulting/Project/AIM/Sample_AIMAnnotations_TCGA_09302009/AIMAnnotations/Baseline/0022BaselineA.xml");
		AimParser aimParser = new AimParser(file);		
		aimParser.run();
		List<String> desc = aimParser.getAIMDescription();
		for(int i = 0; i < desc.size(); i++){
			System.out.println(desc.get(i));
		}
		System.out.println("-----------------");
		System.out.println(aimParser.getXMLString());
		
	}

}
