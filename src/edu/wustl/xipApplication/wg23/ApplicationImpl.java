/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.wg23;

import java.util.List;

import javax.jws.WebService;
import org.nema.dicom.wg23.Application;
import org.nema.dicom.wg23.ArrayOfObjectDescriptor;
import org.nema.dicom.wg23.ArrayOfObjectLocator;
import org.nema.dicom.wg23.ArrayOfQueryResult;
import org.nema.dicom.wg23.ArrayOfString;
import org.nema.dicom.wg23.ArrayOfUUID;
import org.nema.dicom.wg23.AvailableData;
import org.nema.dicom.wg23.ModelSetDescriptor;
import org.nema.dicom.wg23.ObjectDescriptor;
import org.nema.dicom.wg23.ObjectLocator;
import org.nema.dicom.wg23.Patient;
import org.nema.dicom.wg23.Series;
import org.nema.dicom.wg23.State;
import org.nema.dicom.wg23.Study;
import org.nema.dicom.wg23.Uid;
import org.nema.dicom.wg23.Uuid;
import edu.wustl.xipApplication.application.ApplicationDataManager;
import edu.wustl.xipApplication.application.ApplicationDataManagerFactory;
import edu.wustl.xipApplication.wg23.WG23Listener;


/**
 * @author Jaroslaw Krych
 *
 */
@WebService(
		serviceName = "ApplicationService",
        portName="ApplicationPort",
        targetNamespace = "http://wg23.dicom.nema.org/",
        endpointInterface = "org.nema.dicom.wg23.Application")
public class ApplicationImpl implements Application {

	public boolean bringToFront() {		
		return listener.bringToFront();		
	}

	public ModelSetDescriptor getAsModels(ArrayOfUUID uuids, Uid classUID, Uid transferSyntaxUID) {
		// TODO Auto-generated method stub
		return null;
	}	

	public ArrayOfObjectLocator getDataAsFile(ArrayOfUUID uuids, boolean includeBulkData) {
		ArrayOfObjectLocator arrayObjLoc = new ArrayOfObjectLocator();					
		ApplicationDataManager dataMgr = ApplicationDataManagerFactory.getInstance();
		ObjectLocator[] objLocs = dataMgr.getOutputData().getObjectLocators();
		if(uuids == null){			
			return arrayObjLoc;
		}
		List<Uuid> listUUIDs = uuids.getUuid();		
		List<ObjectLocator> listObjLocs = arrayObjLoc.getObjectLocator();				
		for(int i = 0; i < listUUIDs.size(); i++){			
			for(int j = 0; j < objLocs.length; j++){								
				if(objLocs[j].getUuid().getUuid().equalsIgnoreCase(listUUIDs.get(i).getUuid())){										
					ObjectLocator obj = objLocs[j];
					listObjLocs.add(obj);
				}
			}
		}						
		return arrayObjLoc;		
	}	

	public ArrayOfObjectLocator getDataAsSpecificTypeFile(ArrayOfUUID objectUUIDs, String mimeType, Uid transferSyntaxUID, boolean includeBulkData) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public State getState() {
		return listener.getState();
	}

	public boolean notifyDataAvailable(AvailableData availableData, boolean lastData) {
		List<Patient> patients = availableData.getPatients().getPatient();		
		for(int i = 0; i < patients.size(); i++){
			Patient patient = patients.get(i);
			System.out.println(patient.getName());
			List<Study> studies = patient.getStudies().getStudy();
			for(int j = 0; j < studies.size(); j++){
				Study study = studies.get(j);
				System.out.println("   " + study.getStudyUID());
				List<Series> listOfSeries = study.getSeries().getSeries();
				for(int k = 0; k < listOfSeries.size(); k++){
					Series series = listOfSeries.get(k);											
					System.out.println("      " + series.getSeriesUID());
				}
				for(int k = 0; k < listOfSeries.size(); k++){
					Series series = listOfSeries.get(k);											
					ArrayOfObjectDescriptor descriptors = series.getObjectDescriptors();
					List<ObjectDescriptor> listDescriptors = descriptors.getObjectDescriptor();
					for(int m =0;  m < listDescriptors.size(); m++){
						ObjectDescriptor desc = listDescriptors.get(m);
						System.out.println(desc.getUuid().getUuid());
					}
				}
			}
		}
		System.out.println("Last item? " + lastData);
		System.out.println("Listener: " + listener == null);
		//TODO make use of lastData
		listener.notifyDataAvailable(availableData, lastData);
		return true;
	}
		
	public ArrayOfQueryResult queryModel(ArrayOfUUID objUUIDs, ArrayOfString modelXpaths, boolean includeBulkDataPointers) {
		// TODO Auto-generated method stub
		return null;
	}  
	
	
	public boolean setState(State newState) {
		listener.setState(newState);
		//System.out.println("Application recieved:" + newState.toString());
		return true;
	}

	WG23Listener listener;
    public void addWG23Listener(WG23Listener l) {        
        listener = l;                
    }
}
