/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.nema.dicom.wg23.ArrayOfObjectDescriptor;
import org.nema.dicom.wg23.ArrayOfObjectLocator;
import org.nema.dicom.wg23.ArrayOfUUID;
import org.nema.dicom.wg23.AvailableData;
import org.nema.dicom.wg23.ObjectDescriptor;
import org.nema.dicom.wg23.ObjectLocator;
import org.nema.dicom.wg23.Patient;
import org.nema.dicom.wg23.Rectangle;
import org.nema.dicom.wg23.Series;
import org.nema.dicom.wg23.State;
import org.nema.dicom.wg23.Study;
import org.nema.dicom.wg23.Uuid;
import edu.wustl.xipApplication.application.ApplicationTerminator;
import edu.wustl.xipApplication.applicationGUI.ExceptionDialog;
import edu.wustl.xipApplication.application.WG23Application;
import edu.wustl.xipApplication.samples.ApplicationFrameTempl;
import edu.wustl.xipApplication.wg23.ApplicationImpl;
import edu.wustl.xipApplication.wg23.WG23Listener;

public class RECIST extends WG23Application implements WG23Listener {
	ApplicationFrameTempl frame = new ApplicationFrameTempl();
	RECISTPanel appPanel = new RECISTPanel();			
	
	String outDir;
	State appCurrentState;	
	
	public RECIST(URL hostURL, URL appURL) {
		super(hostURL, appURL);		
		frame.getDisplayPanel().add(appPanel);
		frame.setVisible(true);	
		/*Set application dimensions */
		Rectangle rect = getClientToHost().getAvailableScreen(null);			
		frame.setBounds(rect.getRefPointX(), rect.getRefPointY(), rect.getWidth(), rect.getHeight());
		/*Notify Host application was launched*/					
		ApplicationImpl appImpl = new ApplicationImpl();
		appImpl.addWG23Listener(this);
		setAndDeployApplicationService(appImpl);
		getClientToHost().notifyStateChanged(State.IDLE);		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			/*
			args = new String[4];
			args[0] = "--hostURL";
			args[1] = "http://localhost:8090/HostService?wsdl";
			args[2] = "--applicationURL";
			args[3] = "http://localhost:8091/ApplicationService?wsdl";
			*/
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			System.out.println("Number of parameters: " + args.length);
			for (int i = 0; i < args.length; i++){
				System.out.println(i + ". " + args[i]);
			}
			URL hostURL = null;
			URL applicationURL = null;
			for (int i = 0; i < args.length; i++){
				if (args[i].equalsIgnoreCase("--hostURL")){
					hostURL = new URL(args[i + 1]);
				}else if(args[i].equalsIgnoreCase("--applicationURL")){
					applicationURL = new URL(args[i + 1]);
				}					
			}									
			new RECIST(hostURL, applicationURL);										
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		} catch (NullPointerException e){
			new ExceptionDialog("List of parameters is not valid!", 
					"Ensure: --hostURL url1 --applicationURL url2",
					"Launch Application Dialog");
			System.exit(0);
		}
	}
	
	public String getSceneGraphInput(List<ObjectLocator> objLocs){
		String input = new String();
		int size = objLocs.size();
		for (int i = 0; i < size; i++){
			if(i == 0){
				String filePath;				
				filePath = new File(objLocs.get(i).getUri()).getPath();
				// input = input + "\"" + nols.get(i).getURI() + "\"" + ", ";					
				filePath = filePath.substring(6 , filePath.length());
				input = "[" + "\"" + filePath + "\"" + ", ";								
			} else if(i < size -1){
				String filePath = new File(objLocs.get(i).getUri()).getPath();
				//input = input + "\"" + nols.get(i).getURI() + "\"" + ", ";
				filePath = filePath.substring(6 , filePath.length());
				input = input + "\"" + filePath + "\"" + ", ";
			}else if(i == size -1){
				String filePath = new File(objLocs.get(i).getUri()).getPath();
				//input = input + "\"" + nols.get(i).getURI() + "\"" + ", ";
				filePath = filePath.substring(6 , filePath.length());
				input = input + "\"" + filePath + "\"" + "]";
			}				
		}
		return input;
	}		
	
	public boolean bringToFront() {
		frame.setAlwaysOnTop(true);
		frame.setAlwaysOnTop(false);
		return true;
	}	
	
	public void notifyDataAvailable(AvailableData availableData, boolean lastData) {
		List<Uuid> uuidsPrev = new ArrayList<Uuid>();
		List<Uuid> uuidsCurr = new ArrayList<Uuid>();
		//TODO provide implementation for AIM objects
		/*if(availableData.getObjectDescriptors() != null){
			List<ObjectDescriptor> listObjDescs = availableData.getObjectDescriptors().getObjectDescriptor();
			for(int i = 0; i < listObjDescs.size(); i++){						
				uuids.add(listObjDescs.get(i).getUuid());
			}
		}*/	
		List<Patient> patients = availableData.getPatients().getPatient();		
		for(int i = 0; i < patients.size(); i++){
			Patient patient = patients.get(i);		
			List<Study> studies = patient.getStudies().getStudy();
			for(int j = 0; j < studies.size(); j++){
				Study study = studies.get(j);				
				List<Series> listOfSeries = study.getSeries().getSeries();
				//System.out.println("Study " + j + " number of series " + listOfSeries.size());
				for(int k = 0; k < listOfSeries.size(); k++){
					Series series = listOfSeries.get(k);					
					ArrayOfObjectDescriptor descriptors = series.getObjectDescriptors();
					List<ObjectDescriptor> listDescriptors = descriptors.getObjectDescriptor();
					for(int m = 0;  m < listDescriptors.size(); m++){
						ObjectDescriptor desc = listDescriptors.get(m);
						if(j == 0){
							uuidsPrev.add(desc.getUuid());
						}else if(j == 1){
							uuidsCurr.add(desc.getUuid());
						}	
					}
				}
			}
		}
		//System.out.println("Prev size " + uuidsPrev.size());
		//System.out.println("Curr size " + uuidsCurr.size());
		//get previous dataset
		ArrayOfUUID arrayUUIDsPrev = new ArrayOfUUID();
		List<Uuid> listUUIDsPrev = arrayUUIDsPrev.getUuid();
		for(int i = 0; i < uuidsPrev.size(); i++){
			listUUIDsPrev.add(uuidsPrev.get(i));
		}			
		ArrayOfObjectLocator objLocsPrev = getClientToHost().getDataAsFile(arrayUUIDsPrev, true);
		List<ObjectLocator> listObjLocsPrev = objLocsPrev.getObjectLocator();					
		
		//get current dataset
		ArrayOfUUID arrayUUIDsCurr = new ArrayOfUUID();
		List<Uuid> listUUIDsCurr = arrayUUIDsCurr.getUuid();
		for(int i = 0; i < uuidsCurr.size(); i++){
			listUUIDsCurr.add(uuidsCurr.get(i));
		}					
		ArrayOfObjectLocator objLocsCurr = getClientToHost().getDataAsFile(arrayUUIDsCurr, true);
		List<ObjectLocator> listObjLocsCurr = objLocsCurr.getObjectLocator();
		
		
		//update scene graph
		if(appPanel.getIvCanvas().set("LoadDicom1.name", getSceneGraphInput(listObjLocsPrev))){
		appPanel.getIvCanvas().set("DicomExaminer1.viewAll", "");
		//appPanel.getIvCanvas().processQueue();
		}
		if(appPanel.getIvCanvas().set("LoadDicom2.name", getSceneGraphInput(listObjLocsCurr))){
			appPanel.getIvCanvas().set("DicomExaminer2.viewAll", "");
			//appPanel.getIvCanvas().processQueue();
		}
		appPanel.getIvCanvas().set("Lut1.bitsUsed", "16");
		appPanel.getIvCanvas().set("DicomExaminer1.imageIndex", "0");
		appPanel.getIvCanvas().set("DicomExaminer2.imageIndex", "0");
	}	
	
	public boolean setState(State newState) {
		if(State.valueOf(newState.toString()).equals(State.CANCELED)){
			getClientToHost().notifyStateChanged(State.CANCELED);
			getClientToHost().notifyStateChanged(State.IDLE);
		}else if(State.valueOf(newState.toString()).equals(State.EXIT)){
			getClientToHost().notifyStateChanged(State.EXIT);						
			//terminating endpoint and existing system is accomplished through ApplicationTerminator
			//and ApplicationScheduler. ApplicationSechduler is present to alow termination delay if needed (posible future use)
			ApplicationTerminator terminator = new ApplicationTerminator(getEndPoint());
			Thread t = new Thread(terminator);
			t.start();	
		}else{
			getClientToHost().notifyStateChanged(newState);
		}
		return true;
	}
}
