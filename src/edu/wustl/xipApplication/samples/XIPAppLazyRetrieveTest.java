/**
 * Copyright (c) 2010 Washington University in St. Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.samples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.nema.dicom.wg23.ArrayOfObjectDescriptor;
import org.nema.dicom.wg23.ArrayOfUUID;
import org.nema.dicom.wg23.AvailableData;
import org.nema.dicom.wg23.ObjectDescriptor;
import org.nema.dicom.wg23.Patient;
import org.nema.dicom.wg23.Rectangle;
import org.nema.dicom.wg23.Series;
import org.nema.dicom.wg23.State;
import org.nema.dicom.wg23.Study;
import org.nema.dicom.wg23.Uuid;
import edu.wustl.xipApplication.application.ApplicationTerminator;
import edu.wustl.xipApplication.applicationGUI.ExceptionDialog;
import edu.wustl.xipApplication.application.WG23Application;
import edu.wustl.xipApplication.wg23.ApplicationImpl;
import edu.wustl.xipApplication.wg23.WG23Listener;


/**
 * @author Jaroslaw Krych
 *
 */
public class XIPAppLazyRetrieveTest extends WG23Application implements WG23Listener{
	State appCurrentState;
	
	public XIPAppLazyRetrieveTest (URL hostURL, URL appURL) {
		super(hostURL, appURL);
		JFrame frame = new JFrame("XIP Application - Lazy Retrieve Test");	
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
			/*args = new String[4];
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
			//final XIPApplication_WashU app = new XIPApplication_WashU(new URL(args[0]), new URL(args[1]));			
			new XIPAppLazyRetrieveTest(hostURL, applicationURL);	
			
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
					"Ensure: -hostURL url1 -applicationURL url2",
					"Launch Application Dialog");
			System.exit(0);
		}
	}
	ArrayOfUUID models;
	ArrayOfUUID getModels(){
		return models;
	}

	public boolean bringToFront() {		
		return true;
	}
	
	List<Uuid> uuids = new ArrayList<Uuid>();
	List<Uuid> getAllUUIDs(){
		return uuids;
	}
	
	public void notifyDataAvailable(AvailableData availableData, boolean lastData) {		
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
				for(int k = 0; k < listOfSeries.size(); k++){
					Series series = listOfSeries.get(k);											
					ArrayOfObjectDescriptor descriptors = series.getObjectDescriptors();
					List<ObjectDescriptor> listDescriptors = descriptors.getObjectDescriptor();
					for(int m =0;  m < listDescriptors.size(); m++){
						ObjectDescriptor desc = listDescriptors.get(m);
						uuids.add(desc.getUuid());
					}
				}
			}
		}									
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
