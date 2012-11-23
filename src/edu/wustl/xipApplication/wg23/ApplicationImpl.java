/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.wg23;

import java.util.List;

import javax.jws.WebService;

import org.nema.dicom.PS3_19.ArrayOfMimeType;
import org.nema.dicom.PS3_19.ArrayOfQueryResultInfoSet;
import org.nema.dicom.PS3_19.ArrayOfUID;
import org.nema.dicom.PS3_19.IApplicationService20100825;
import org.nema.dicom.PS3_19.ArrayOfObjectLocator;
import org.nema.dicom.PS3_19.ArrayOfQueryResult;
import org.nema.dicom.PS3_19.ArrayOfstring;
import org.nema.dicom.PS3_19.ArrayOfUUID;
import org.nema.dicom.PS3_19.AvailableData;
import org.nema.dicom.PS3_19.ModelSetDescriptor;
import org.nema.dicom.PS3_19.ObjectLocator;
import org.nema.dicom.PS3_19.Rectangle;
import org.nema.dicom.PS3_19.State;
import org.nema.dicom.PS3_19.UID;
import org.nema.dicom.PS3_19.UUID;
import edu.wustl.xipApplication.application.ApplicationDataManager;
import edu.wustl.xipApplication.application.ApplicationDataManagerFactory;
import edu.wustl.xipApplication.wg23.WG23Listener;


/**
 * @author Jaroslaw Krych
 *
 */
@WebService(
		serviceName = "ApplicationService-20100825",
        portName="ApplicationServiceBinding",
        targetNamespace = "http://dicom.nema.org/PS3.19/ApplicationService-20100825",
        endpointInterface = "org.nema.dicom.PS3_19.IApplicationService20100825")
public class ApplicationImpl implements IApplicationService20100825 {

	@Override
	public State getState() {
		return listener.getState();
	}

	@Override
	public Boolean setState(State state) {
		listener.setState(state);
		//System.out.println("Application recieved:" + newState.toString());
		return true;
	}

	@Override
	public Boolean bringToFront(Rectangle location) {		
		return listener.bringToFront(location);		
	}

	@Override
	public Boolean notifyDataAvailable(AvailableData availableData, Boolean lastData) {
		//TODO make use of lastData
		listener.notifyDataAvailable(availableData, lastData);
		return true;
	}
		
	@Override
	public ArrayOfObjectLocator getData(ArrayOfUUID objects, ArrayOfUID acceptableTransferSyntaxes, Boolean includeBulkData) {
		ArrayOfObjectLocator arrayObjLoc = new ArrayOfObjectLocator();					
		ApplicationDataManager dataMgr = ApplicationDataManagerFactory.getInstance();
		ObjectLocator[] objLocs = dataMgr.getOutputData().getObjectLocators();
		if(objects == null){			
			return arrayObjLoc;  // TODO check final to see if a null object list gives all objects
		}
		// TODO use acceptableTransferSyntaxes
		List<UUID> listUUIDs = objects.getUUID();		
		List<ObjectLocator> listObjLocs = arrayObjLoc.getObjectLocator();				
		for(int i = 0; i < listUUIDs.size(); i++){			
			for(int j = 0; j < objLocs.length; j++){								
				if(objLocs[j].getSource().getUuid().equalsIgnoreCase(listUUIDs.get(i).getUuid())){										
					ObjectLocator obj = objLocs[j];
					listObjLocs.add(obj);
				}
			}
		}						
		return arrayObjLoc;	
	}

	@Override
	public void releaseData(ArrayOfUUID objects) {
		// TODO Auto-generated method stub
	}

	@Override
	public ModelSetDescriptor getAsModels(ArrayOfUUID objects, UID classUID, ArrayOfMimeType supportedInfoSetTypes) {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public void releaseModels(ArrayOfUUID models) {
		// TODO Auto-generated method stub
		
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
	@Override
	public ArrayOfQueryResult queryModel(ArrayOfUUID models, ArrayOfstring xPaths) {
		// TODO Auto-generated method stub
		return null;
	}  
	
	@Override
	public ArrayOfQueryResultInfoSet queryInfoSet(ArrayOfUUID models, ArrayOfstring modelXpaths) {
		// TODO Auto-generated method stub
		return null;
	}  
	
	
	WG23Listener listener;
    public void addWG23Listener(WG23Listener l) {        
        listener = l;                
    }
}
