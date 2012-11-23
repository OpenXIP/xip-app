/**
 * Copyright (c) 2007 Washington University in St. Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.wg23;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.nema.dicom.PS3_19.ArrayOfObjectDescriptor;
import org.nema.dicom.PS3_19.ArrayOfPatient;
import org.nema.dicom.PS3_19.ArrayOfSeries;
import org.nema.dicom.PS3_19.ArrayOfStudy;
import org.nema.dicom.PS3_19.AvailableData;
import org.nema.dicom.PS3_19.MimeType;
import org.nema.dicom.PS3_19.Modality;
import org.nema.dicom.PS3_19.ObjectDescriptor;
import org.nema.dicom.PS3_19.ObjectLocator;
import org.nema.dicom.PS3_19.Patient;
import org.nema.dicom.PS3_19.Study;
import org.nema.dicom.PS3_19.UID;

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
		org.nema.dicom.PS3_19.Series series = new org.nema.dicom.PS3_19.Series();				
		ArrayOfSeries arraySeries = new ArrayOfSeries();
		List<org.nema.dicom.PS3_19.Series> listOfSeries = arraySeries.getSeries();
		listOfSeries.add(series);
		study.setSeries(arraySeries);
		ArrayOfObjectDescriptor arrayObjectDescriptors = new ArrayOfObjectDescriptor();		
		List<ObjectDescriptor> listObjectDescriptors = arrayObjectDescriptors.getObjectDescriptor();				
		List<ObjectLocator> objLocators = new ArrayList<ObjectLocator>(); 
		for(int i = 0; i < files.size(); i++){
			try {
				ObjectDescriptor objDesc = new ObjectDescriptor();
				//set objDesc
				org.nema.dicom.PS3_19.UUID objDescUUID = new org.nema.dicom.PS3_19.UUID();
				objDescUUID.setUuid(UUID.randomUUID().toString());
				objDesc.setDescriptorUuid(objDescUUID);				
				MimeType mimeType = new MimeType();			
				mimeType.setType(DicomUtil.mimeType(files.get(i)));
				objDesc.setMimeType(mimeType);
				if(mimeType.getType().equalsIgnoreCase("application/dicom")){
					dicomParser.parse(files.get(i));
					String classUID = dicomParser.getSOPClassUID();
					UID uid = new UID();
					uid.setUid(classUID);
					objDesc.setClassUID(uid);
					String transferSyntax;
					transferSyntax = dicomParser.getTransferSyntaxUID();
					UID tsUID = new UID();
					tsUID.setUid(transferSyntax);
					objDesc.setTransferSyntaxUID(tsUID);
					String modCode = dicomParser.getModality();						
					Modality modality = new Modality();
					modality.setModality(modCode);
					objDesc.setModality(modality);
					listObjectDescriptors.add(objDesc);	
				}else{
					UID uid = new UID();
					uid.setUid("");
					objDesc.setClassUID(uid);
					String modCode = "";						
					Modality modality = new Modality();
					modality.setModality(modCode);
					objDesc.setModality(modality);
					listObjectDescriptorsAvailableData.add(objDesc);
				}										
				ObjectLocator objLoc = new ObjectLocator();				
				objLoc.setSource(objDescUUID);				
				objLoc.setLocator(objDescUUID);	// TODO Set to a new UUID?
				objLoc.setOffset(0L);
				objLoc.setLength(files.get(i).length());
				objLoc.setTransferSyntax(objDesc.getTransferSyntaxUID());
				objLoc.setURI(files.get(i).toURI().toURL().toExternalForm());				
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
	
	public static void main (String [] args){
		File file = new File("./test-content/AIM_2/Vasari-TCGA6330140190470283886.xml");
		List<File> files = new ArrayList<File>();
		files.add(file);
		new WG23DataModelImpl(files);				
	}
	
}
