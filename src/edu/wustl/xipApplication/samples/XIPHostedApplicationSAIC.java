/**
 * Copyright (c) 2010 Washington University in St. Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.samples;

import java.awt.Font;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.nema.dicom.PS3_19.ArrayOfObjectDescriptor;
import org.nema.dicom.PS3_19.ArrayOfObjectLocator;
import org.nema.dicom.PS3_19.ArrayOfUID;
import org.nema.dicom.PS3_19.ArrayOfUUID;
import org.nema.dicom.PS3_19.AvailableData;
import org.nema.dicom.PS3_19.ObjectDescriptor;
import org.nema.dicom.PS3_19.ObjectLocator;
import org.nema.dicom.PS3_19.Patient;
import org.nema.dicom.PS3_19.Rectangle;
import org.nema.dicom.PS3_19.Series;
import org.nema.dicom.PS3_19.State;
import org.nema.dicom.PS3_19.Study;
import org.nema.dicom.PS3_19.UID;
import org.nema.dicom.PS3_19.UUID;
import edu.wustl.xipApplication.application.ApplicationTerminator;
import edu.wustl.xipApplication.applicationGUI.ExceptionDialog;
import edu.wustl.xipApplication.applicationGUI.TextDisplayPanel;
import edu.wustl.xipApplication.applicationGUI.XIPApplicationFrame;
import edu.wustl.xipApplication.application.WG23Application;
import edu.wustl.xipApplication.wg23.ApplicationImpl;
import edu.wustl.xipApplication.wg23.WG23Listener;


/**
 * @author Jaroslaw Krych
 *
 */
public class XIPHostedApplicationSAIC extends WG23Application implements WG23Listener{
	State appCurrentState;
	public static final String OS = System.getProperty("os.name");
	JFrame frame = new JFrame("XIP Application - Lazy Retrieve Test");	
	TextDisplayPanel txtArea = new TextDisplayPanel();
	Font font = new Font("Tahoma", 1, 12);	
	
	public XIPHostedApplicationSAIC (URL hostURL, URL appURL) {
		super(hostURL, appURL);
		frame.setTitle("XIPHostedApplicationSAIC");	
		txtArea.setFont(font);
		JScrollPane scrollPane = new JScrollPane(txtArea);
		frame.add(scrollPane);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
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
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());			
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
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
		}		    
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
			new XIPHostedApplicationSAIC(hostURL, applicationURL);	
			
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

	public boolean bringToFront(Rectangle location) {		
		if (location != null) {
			frame.setLocation(location.getRefPointX(), location.getRefPointY());
			frame.setSize(location.getWidth(), location.getHeight());
		}
		// Trick to get the window on top
		frame.setAlwaysOnTop(true);						
		frame.setAlwaysOnTop(false);		
		if(XIPApplicationFrame.OS.contains("Windows") == false){
			deiconify(frame);
		}		
		return true;
	}

	public static void deiconify(Frame frame) {
        int state = frame.getExtendedState();
        state &= ~Frame.ICONIFIED;
        frame.setExtendedState(state);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
	
	List<UUID> uuids;
	List<UUID> getAllUUIDs(){
		return uuids;
	}
	
	int notificationNumber = 1;
	public void notifyDataAvailable(AvailableData availableData, boolean lastData) {		
		uuids = new ArrayList<UUID>();
		/*if(availableData.getObjectDescriptors() != null){
			List<ObjectDescriptor> listObjDescs = availableData.getObjectDescriptors().getObjectDescriptor();
			for(int i = 0; i < listObjDescs.size(); i++){						
				uuids.add(listObjDescs.get(i).getUuid());
			}
		}*/		
		txtArea.append("Notification: " + notificationNumber++ + "\r\n");
		String defaultTSString = "1.2.840.10008.1.2.1";
		UID lastDescriptorTS = new UID();
		Boolean sawDefaultTS = false;
		lastDescriptorTS.setUid("");
		ArrayOfUID requestedTSArray = new ArrayOfUID();
		List<UID> listTS = requestedTSArray.getUID();
		List<Patient> patients = availableData.getPatients().getPatient();		
		for(int i = 0; i < patients.size(); i++){
			Patient patient = patients.get(i);
			txtArea.append(" " + "\r\n");
			txtArea.append(patient.getName() + "\r\n");
			System.out.println(patient.getName());
			List<Study> studies = patient.getStudies().getStudy();
			for(int j = 0; j < studies.size(); j++){
				Study study = studies.get(j);
				txtArea.append("   " + study.getStudyUID() + "\r\n");
				System.out.println("   " + study.getStudyUID());
				List<Series> listOfSeries = study.getSeries().getSeries();
				for(int k = 0; k < listOfSeries.size(); k++){
					Series series = listOfSeries.get(k);											
					txtArea.append("      " + series.getSeriesUID() + "\r\n");
					System.out.println("      " + series.getSeriesUID());
				}
				txtArea.append("\r\n");
				txtArea.append("Items UUIDs: " + "\r\n");
				for(int k = 0; k < listOfSeries.size(); k++){
					Series series = listOfSeries.get(k);											
					ArrayOfObjectDescriptor descriptors = series.getObjectDescriptors();
					List<ObjectDescriptor> listDescriptors = descriptors.getObjectDescriptor();
					for(int m =0;  m < listDescriptors.size(); m++){
						ObjectDescriptor desc = listDescriptors.get(m);
						if ((desc.getTransferSyntaxUID() != null) 
							&& ( ! desc.getTransferSyntaxUID().getUid().matches(lastDescriptorTS.getUid()))) 
						{
							listTS.add(desc.getTransferSyntaxUID());
							lastDescriptorTS.setUid(desc.getTransferSyntaxUID().getUid());
							if (lastDescriptorTS.getUid().matches(defaultTSString)) {
								sawDefaultTS = true;
							}
						}
						uuids.add(desc.getDescriptorUuid());
						txtArea.append(desc.getDescriptorUuid().getUuid() + "\r\n");
						System.out.println(desc.getDescriptorUuid().getUuid());
					}
				}
			}
		}
		if ( ! sawDefaultTS) {
			// add the default transfer syntax if not already there
			UID defaultTS = new UID();
			defaultTS.setUid(defaultTSString);
			listTS.add(defaultTS); 
		}
		txtArea.append("Last item? " + lastData + "\r\n");
		System.out.println("Last item? " + lastData);
		ArrayOfUUID arrayUUIDs = new ArrayOfUUID();
		List<UUID> listUUIDs = arrayUUIDs.getUUID();
		for(int i = 0; i < getAllUUIDs().size(); i++){
			UUID uuid = getAllUUIDs().get(i);
			listUUIDs.add(uuid);
		}
		ArrayOfObjectLocator objLocs = getClientToHost().getData(arrayUUIDs, requestedTSArray, true);
		List<ObjectLocator> listObjectLocators = objLocs.getObjectLocator();
		txtArea.append("\r\n");
		txtArea.append("Items location: " + "\r\n");
		for(ObjectLocator objectLocator : listObjectLocators){
			txtArea.append(objectLocator.getLocator().getUuid() + "   " + objectLocator.getURI() + "\r\n");
		}
		txtArea.append("Recieved data. Analysis being performed for 10s." + "\r\n");
		//from 1 to 11
		for(int i = 1; i < 6; i++) {
			txtArea.append(" " + i + " ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
		txtArea.append("\r\n");
		txtArea.append("Analysis complete." + "\r\n");
		txtArea.append("Notifying host about available data." + "\r\n");
		try {
			//Thread.sleep(3000);
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtArea.append("Notifying host state changed to COMPLETED." + "\r\n");
		try {
			//Thread.sleep(3000);
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setState(State.COMPLETED);
		txtArea.append("Notifying host state changed to IDLE." + "\r\n");
		txtArea.append("-----------------------------------------------------------------------" + "\r\n");
		try {
			//Thread.sleep(3000);
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setState(State.IDLE);
	}
	
	public boolean setState(final State newState) {		
		Runnable runner = new Runnable(){
			@Override
			public void run() {
				if(State.valueOf(newState.toString()).equals(State.CANCELED)){
					getClientToHost().notifyStateChanged(State.CANCELED);
					appCurrentState = State.CANCELED;
					getClientToHost().notifyStateChanged(State.IDLE);
					appCurrentState = State.CANCELED;
				}else if(State.valueOf(newState.toString()).equals(State.EXIT)){
					getClientToHost().notifyStateChanged(State.EXIT);
					appCurrentState = State.EXIT;
					//terminating endpoint and existing system is accomplished through ApplicationTerminator
					//and ApplicationScheduler. ApplicationSechduler is present to alow termination delay if needed (posible future use)
					ApplicationTerminator terminator = new ApplicationTerminator(getEndPoint());
					Thread t = new Thread(terminator);
					t.start();	
				}else{
					appCurrentState = newState;
					getClientToHost().notifyStateChanged(newState);
				}
			}
		};
		//Do not execute in a thread to avoid state synchronization issues
		//Thread t= new Thread(runner);
		//t.start();
		runner.run();
		return true;
	}
	
	@Override
	public State getState() {
		System.out.println("Application current state: " + appCurrentState);
		return appCurrentState;
	}	
}
