/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.wg23;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.nema.dicom.wg23.ArrayOfObjectDescriptor;
import org.nema.dicom.wg23.ArrayOfPatient;
import org.nema.dicom.wg23.ArrayOfSeries;
import org.nema.dicom.wg23.ArrayOfStudy;
import org.nema.dicom.wg23.AvailableData;
import org.nema.dicom.wg23.Modality;
import org.nema.dicom.wg23.ObjectDescriptor;
import org.nema.dicom.wg23.ObjectLocator;
import org.nema.dicom.wg23.Patient;
import org.nema.dicom.wg23.Study;
import org.nema.dicom.wg23.Uid;
import org.nema.dicom.wg23.Uuid;

import edu.wustl.xipHost.dicom.BasicDicomParser2;
import edu.wustl.xipHost.dicom.DicomUtil;

/**
 * @author Jaroslaw Krych
 *
 */
public class WG23DataModelImpl implements WG23DataModel{
	AvailableData availableData;
	ObjectLocator[] objLocators;
	
	public WG23DataModelImpl(List<File> files){
		makeWG23DataModel(files);
	}
	
	public AvailableData getAvailableData() {		
		return availableData;
	}

	public ObjectLocator[] getObjectLocators() {
		return objLocators;
	}	

	BasicDicomParser2 dicomParser = new BasicDicomParser2();
	public WG23DataModel makeWG23DataModel(List<File> files){
		if(files == null){return null;}
		AvailableData availableData = new AvailableData();
		Patient patient = new Patient();								
		ArrayOfPatient patients = new ArrayOfPatient();					
		patients.getPatient().add(patient);					
		availableData.setPatients(patients);
		ArrayOfObjectDescriptor arrayObjectDescriptorsAvailableData = new ArrayOfObjectDescriptor();		
		List<ObjectDescriptor> listObjectDescriptorsAvailableData = arrayObjectDescriptorsAvailableData.getObjectDescriptor();
		ArrayOfStudy arrayOfStudy = new ArrayOfStudy();
		Study study = new Study();		
		arrayOfStudy.getStudy().add(study);						
		patient.setStudies(arrayOfStudy);
		org.nema.dicom.wg23.Series series = new org.nema.dicom.wg23.Series();				
		ArrayOfSeries arraySeries = new ArrayOfSeries();
		List<org.nema.dicom.wg23.Series> listOfSeries = arraySeries.getSeries();
		listOfSeries.add(series);
		study.setSeries(arraySeries);
		ArrayOfObjectDescriptor arrayObjectDescriptors = new ArrayOfObjectDescriptor();		
		List<ObjectDescriptor> listObjectDescriptors = arrayObjectDescriptors.getObjectDescriptor();				
		List<ObjectLocator> objLocators = new ArrayList<ObjectLocator>(); 
		for(int i = 0; i < files.size(); i++){
			try {
				ObjectDescriptor objDesc = new ObjectDescriptor();
				//set objDesc
				Uuid objDescUUID = new Uuid();
				objDescUUID.setUuid(UUID.randomUUID().toString());
				objDesc.setUuid(objDescUUID);				
				String mimeType;			
				mimeType = DicomUtil.mimeType(files.get(i));
				objDesc.setMimeType(mimeType);
				if(mimeType.equalsIgnoreCase("application/dicom")){
					dicomParser.parse(files.get(i));
					String classUID = dicomParser.getSOPClassUID();
					Uid uid = new Uid();
					uid.setUid(classUID);
					objDesc.setClassUID(uid);
					String modCode = dicomParser.getModality();						
					Modality modality = new Modality();
					modality.setModality(modCode);
					objDesc.setModality(modality);
					listObjectDescriptors.add(objDesc);	
				}else{
					Uid uid = new Uid();
					uid.setUid("");
					objDesc.setClassUID(uid);
					String modCode = "";						
					Modality modality = new Modality();
					modality.setModality(modCode);
					objDesc.setModality(modality);
					listObjectDescriptorsAvailableData.add(objDesc);
				}										
				ObjectLocator objLoc = new ObjectLocator();				
				objLoc.setUuid(objDescUUID);				
				objLoc.setUri(files.get(i).toURI().toURL().toExternalForm());				
				objLocators.add(objLoc);
			} catch (IOException e) {				
				return null;
			}			
		}
		series.setObjectDescriptors(arrayObjectDescriptors);				
		availableData.setObjectDescriptors(arrayObjectDescriptorsAvailableData);
		this.availableData = availableData;
		ObjectLocator[] objLocs = new ObjectLocator[objLocators.size()];
		objLocators.toArray(objLocs);
		this.objLocators = objLocs;				
		return this;
	}	
}
