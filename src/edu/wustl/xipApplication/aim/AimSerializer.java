/**
 * Copyright (c) 2009 Washington University in St. Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.aim;

import edu.wustl.xipApplication.recist.RECISTFactory;
import edu.wustl.xipApplication.recist.RECISTManager;
import gme.cacore_cacore._3_2.edu_northwestern_radiology.ImageAnnotation;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
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
public class AimSerializer {
	String aimXMLString;
	JAXBContext jc;
	Unmarshaller unmarshaller;
	Marshaller marshaller;
	RECISTManager recistMgr = RECISTFactory.getInstance();
	
	public AimSerializer(){
		try {
			jc = JAXBContext.newInstance( "gme.cacore_cacore._3_2.edu_northwestern_radiology" );
			unmarshaller = jc.createUnmarshaller();
			marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	File aimFile;
	public void serialize(String aimXMLString) throws UnsupportedEncodingException, JAXBException, FileNotFoundException{
		this.aimXMLString = aimXMLString;		
	    byte[] bytes = aimXMLString.getBytes("UTF-8");
	    InputStream input = new ByteArrayInputStream(bytes);
		JAXBElement obj = (JAXBElement)unmarshaller.unmarshal(input);
		ImageAnnotation imageAnnotation = ((ImageAnnotation)obj.getValue());
		//TODO CAUTION: next line contains hard coded value
		imageAnnotation.setCodeMeaning("Target Lesion Complete Response");
		String outDir = recistMgr.getOutputDir();		
		URI uri = null;
		try {
			uri = new URI(outDir);
			File file = new File(uri);
			aimFile = File.createTempFile("AIM-RECIST", ".xml", file);
			marshaller.marshal(obj, new FileOutputStream(aimFile));
			marshaller.setProperty("jaxb.schemaLocation", "gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM AIM_TCGA09302009_XML.xsd");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}						
	}
	
	public File getSerializedAIMFile(){
		return aimFile;
	}
	
	public static void main (String[] atgs){
		RECISTManager recistMgr = RECISTFactory.getInstance();
		File fileOut = new File("C:/OurDocuments/WashUConsulting/Project/AIM/Test/");
		try {
			recistMgr.setOutputDir(fileOut.toURI().toURL().toExternalForm());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File file = new File("C:/OurDocuments/WashUConsulting/Project/AIM/Sample_AIMAnnotations_TCGA_09302009/AIMAnnotations/Baseline/0022BaselineA.xml");
		AimParser aimParser = new AimParser(file);		
		aimParser.unmarshall(file);		
		String aimXMLString = aimParser.getXMLString();
		System.out.println(aimXMLString);
		System.out.println("----------------------------------------------------------");
		AimSerializer aimSerializer = new AimSerializer();
		try {
			aimSerializer.serialize(aimXMLString);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
