/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.samples;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
import org.nema.dicom.wg23.QueryResult;
import org.nema.dicom.wg23.Rectangle;
import org.nema.dicom.wg23.Series;
import org.nema.dicom.wg23.State;
import org.nema.dicom.wg23.Study;
import org.nema.dicom.wg23.Uid;
import org.nema.dicom.wg23.Uuid;
import edu.wustl.xipApplication.application.ApplicationTerminator;
import edu.wustl.xipApplication.applicationGUI.ExceptionDialog;
import edu.wustl.xipApplication.applicationGUI.TextDisplayPanel;
import edu.wustl.xipApplication.application.WG23Application;
import edu.wustl.xipApplication.applicationGUI.XIPApplicationFrame;
import edu.wustl.xipApplication.wg23.ApplicationImpl;
import edu.wustl.xipApplication.wg23.WG23Listener;

public class XIPApplication_WashU_3 extends WG23Application implements ActionListener, WG23Listener {
	XIPApplicationFrame frame = new XIPApplicationFrame();
	TextDisplayPanel contents = new TextDisplayPanel();			
	
	String outDir;
	State appCurrentState;		
	
	public XIPApplication_WashU_3(URL hostURL, URL appURL) {
		super(hostURL, appURL);						
		JScrollPane scrollPane = new JScrollPane(contents);
		frame.getDisplayPanel().add(scrollPane);
		//frame.setVisible(true);
		frame.btnUID.addActionListener(this);
		frame.btnAsFiles.addActionListener(this);
		frame.btnODir.addActionListener(this);
		frame.btnTDir.addActionListener(this);
		frame.btnNotifyOutput.addActionListener(this);
		frame.btnQuery.addActionListener(this);
		frame.btnQuery.setEnabled(false);
		frame.btnGetAsModels.addActionListener(this);
		frame.setFocusableWindowState(true);			
		/*Set application dimensions */
		Rectangle rect = getClientToHost().getAvailableScreen(null);
		//TODO getAvailableScreen needs to be reworked to get the right position and size for Mac OS X
		frame.setBounds(rect.getRefPointX(), rect.getRefPointY(), rect.getWidth(), rect.getHeight());		
		/*Notify Host application was launched*/					
		ApplicationImpl appImpl = new ApplicationImpl();
		appImpl.addWG23Listener(this);
		setAndDeployApplicationService(appImpl);
		getClientToHost().notifyStateChanged(State.IDLE);
		return;
	}
	
	public static void main(String[] args) {					
		try {
			/*args = new String[4];
			args[0] = "--hostURL";
			args[1] = "http://localhost:8090/HostInterface";
			args[2] = "--applicationURL";
			args[3] = "http://localhost:8091/ApplicationInterface";*/
			
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
			new XIPApplication_WashU_3(hostURL, applicationURL);						
					
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
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == frame.btnUID){
			contents.append("----- Host generated UID -----------" + "\r\n");				
		}else if (e.getSource() == frame.btnAsFiles ){				
			contents.append(" " + "\r\n");
			contents.append("----- Retrieved ObjectLocators ------------------" + "\r\n");
			ArrayOfUUID arrayUUIDs = new ArrayOfUUID();
			List<Uuid> listUUIDs = arrayUUIDs.getUuid();
			for(int i = 0; i < getAllUUIDs().size(); i++){
				listUUIDs.add(getAllUUIDs().get(i));
			}			
			ArrayOfObjectLocator objLocs = getClientToHost().getDataAsFile(arrayUUIDs, true);
			List<ObjectLocator> listObjLocs = objLocs.getObjectLocator();			
			for(int i = 0; i < listObjLocs.size(); i++){
				ObjectLocator objLoc = listObjLocs.get(i);
				contents.append(objLoc.getUuid().getUuid() + "   " + objLoc.getUri() + "\r\n");								
			}
			getClientToHost().notifyStateChanged(State.COMPLETED);						
		}else if (e.getSource() == frame.btnODir ){	
			contents.append(" " + "\r\n");
			contents.append("----- Host output Dir -----------" + "\r\n");
			String outDir = getClientToHost().getOutputDir();
			contents.append(outDir + "\r\n");
			
		}else if (e.getSource() == frame.btnTDir ){				
			contents.append(" " + "\r\n");
			contents.append("----- Host Tmp Dir ------------------" + "\r\n");
			String tmpDir = getClientToHost().getTmpDir();
			contents.append(tmpDir + "\r\n");			
		}else if (e.getSource() == frame.btnNotifyOutput ){	
			
			contents.append(" " + "\r\n");
			contents.append(" " + "\r\n");
		}else if (e.getSource() == frame.btnGetAsModels ){	
			contents.append(" " + "\r\n");
			List<Uuid> objUUIDs = getAllUUIDs();
			ArrayOfUUID arrayUUIDs = new ArrayOfUUID();
			List<Uuid> listUUIDs = arrayUUIDs.getUuid();
			for(int i = 0; i < objUUIDs.size(); i++){
				listUUIDs.add(objUUIDs.get(i));
			}
			Uid uid = new Uid();
			//uid 1 is used for native models
			uid.setUid("1");
			Uid transferSyntaxUID = new Uid();
			transferSyntaxUID.setUid("");
			long t1 = System.currentTimeMillis();						
			ModelSetDescriptor msd = getClientToHost().getAsModels(arrayUUIDs, uid, transferSyntaxUID);
			long t2 = System.currentTimeMillis();
			contents.append("Total time to get ModelSetDescriptor " + (t2 - t1) + "\r\n");
			models = msd.getModels();
			List<Uuid> nmUUIDs = msd.getModels().getUuid();
			contents.append("Native models: " + "\r\n");
			for(int i = 0; i < nmUUIDs.size(); i++){
				contents.append(nmUUIDs.get(i).getUuid() + "\r\n");
			}
			contents.append("Failed Source Objects: " + "\r\n");
			List<Uuid> failedUUIDs = msd.getFailedSourceObjects().getUuid();
			for(int i = 0; i < failedUUIDs.size(); i++){
				contents.append(failedUUIDs.get(i).getUuid() + "\r\n");
			}			
			contents.append(" " + "\r\n");
			frame.btnQuery.setEnabled(true);
		}else if (e.getSource() == frame.btnQuery ){				
			ArrayOfString modelXPaths = new ArrayOfString();
			List<String> listString = modelXPaths.getString();			
			listString.add("/DicomDataSet/DicomAttribute[@keyword=\"SOPInstanceUID\"]/Value[@number=\"1\"]/text()");									               
			long t1 = System.currentTimeMillis();			
			ArrayOfQueryResult results = getClientToHost().queryModel(models, modelXPaths, true);	
			long t2 = System.currentTimeMillis();			
			List<QueryResult> listQueryResults = results.getQueryResult();
			for(int i = 0; i < listQueryResults.size(); i++){
				contents.append("Result " + i + "\r\n");
				if(listQueryResults.get(i).getResults().getString() != null && listQueryResults.get(i).getResults().getString().size() > 0){					
					contents.append(listQueryResults.get(i).getResults().getString().get(0) + "\r\n");
				}
			}								
			contents.append(" " + "\r\n");			
			contents.append("Total time to query models " + (t2 - t1) + "\r\n");
			contents.updateUI();			
		}		
	}	

	public boolean setState(State newState) {
		contents.append(" " + "\r\n");
		contents.append("----- Application state was changed. -----------" + "\r\n");
		contents.append("----- Current state is: " + newState.toString() + "\r\n");
		contents.repaint();
		
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
		}else if(State.valueOf(newState.toString()).equals(State.IDLE)){
			getClientToHost().notifyStateChanged(State.IDLE);
		}else{
			getClientToHost().notifyStateChanged(newState);
		}
		return true;
	}		
	
	List<Uuid> uuids = new ArrayList<Uuid>();
	List<Uuid> getAllUUIDs(){
		return uuids;
	}
	
	public void notifyDataAvailable(AvailableData availableData, boolean lastData) {		
		contents.append(" " + "\r\n");
		contents.append("----- New data available. -----------" + "\r\n");		
		if(availableData.getObjectDescriptors() != null){
			List<ObjectDescriptor> listObjDescs = availableData.getObjectDescriptors().getObjectDescriptor();
			if(listObjDescs.size() > 0){
				contents.append("AvailableData object descriptors: " +  "\r\n");
			}
			for(int i = 0; i < listObjDescs.size(); i++){			
				contents.append(i + ". " + listObjDescs.get(i).getUuid().getUuid() +  "   MIME: " + listObjDescs.get(i).getMimeType() + "\r\n");
				uuids.add(listObjDescs.get(i).getUuid());
			}
			contents.append("\r\n");
		}		
		List<Patient> patients = availableData.getPatients().getPatient();		
		for(int i = 0; i < patients.size(); i++){
			Patient patient = patients.get(i);
			contents.append(i + ". Patient name: " + patient.getName() +  "\r\n");
			List<Study> studies = patient.getStudies().getStudy();
			for(int j = 0; j < studies.size(); j++){
				Study study = studies.get(j);
				contents.append(j + ". StudyUID : " + study.getStudyUID() +  "\r\n");
				List<Series> listOfSeries = study.getSeries().getSeries();
				for(int k = 0; k < listOfSeries.size(); k++){
					Series series = listOfSeries.get(k);			
					contents.append(k + ". SeriesUID: " + series.getSeriesUID() + "\r\n");			
					ArrayOfObjectDescriptor descriptors = series.getObjectDescriptors();
					List<ObjectDescriptor> listDescriptors = descriptors.getObjectDescriptor();
					for(int m =0;  m < listDescriptors.size(); m++){
						ObjectDescriptor desc = listDescriptors.get(m);
						uuids.add(desc.getUuid());
						contents.append( desc.getUuid().getUuid()+ "   " + desc.getModality().getModality() + "   " + desc.getMimeType() + "\r\n");
					}
					contents.append("\r\n");
				}
				contents.append("\r\n");
			}
			contents.append("\r\n");
		}		
		contents.repaint();		
	}
	@Override
	public boolean bringToFront() {	
		bringToFrontImpl();
		return true;
	}
	
	private void bringToFrontImpl() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                if(frame != null) {
                    frame.toFront();
                    frame.repaint();
                }
            }
        });
    }
	
	void deiconify(Frame frame) {
        int state = frame.getExtendedState();
        state &= ~Frame.ICONIFIED;
        frame.setExtendedState(state);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }

	@Override
	public State getState() {
		return appCurrentState;
	}
	
	/*public static void iconify(Frame frame) {
		int state = frame.getExtendedState();
		state |= Frame.ICONIFIED;
		frame.setExtendedState(state);
	}*/		
}
