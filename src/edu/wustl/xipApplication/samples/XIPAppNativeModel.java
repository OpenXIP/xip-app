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

package edu.wustl.xipApplication.samples;

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
import org.nema.dicom.wg23.ArrayOfQueryResult;
import org.nema.dicom.wg23.ArrayOfString;
import org.nema.dicom.wg23.ArrayOfUUID;
import org.nema.dicom.wg23.AvailableData;
import org.nema.dicom.wg23.ModelSetDescriptor;
import org.nema.dicom.wg23.ObjectDescriptor;
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
import edu.wustl.xipApplication.wg23.ApplicationImpl;
import edu.wustl.xipApplication.wg23.WG23Listener;


/**
 * @author Jaroslaw Krych
 *
 */
public class XIPAppNativeModel extends WG23Application implements ActionListener, WG23Listener{
	XIPApplicationFrameNativeModel frame = new XIPApplicationFrameNativeModel();
	TextDisplayPanel txtArea = new TextDisplayPanel();				
	State appCurrentState;
	
	public XIPAppNativeModel(URL hostURL, URL appURL) {
		super(hostURL, appURL);
		JScrollPane scrollPane = new JScrollPane(txtArea);
		frame.getDisplayPanel().add(scrollPane);	
		frame.setVisible(true);									
		frame.btnGetModels.addActionListener(this);			
		frame.btnQuery.addActionListener(this);		
		frame.btnQuery.setEnabled(false);
		frame.btnClear.addActionListener(this);
		
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
			new XIPAppNativeModel(hostURL, applicationURL);	
			
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
	
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == frame.btnGetModels){			
			txtArea.append(" " + "\r\n");
			txtArea.append("----- Getting native models ------------------" + "\r\n");
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
			ModelSetDescriptor msd = getClientToHost().getAsModels(arrayUUIDs, uid, transferSyntaxUID);			
			models = msd.getModels();
			List<Uuid> nmUUIDs = msd.getModels().getUuid();
			txtArea.append("Native models: " + "\r\n");
			for(int i = 0; i < nmUUIDs.size(); i++){
				txtArea.append(nmUUIDs.get(i).getUuid() + "\r\n");
			}
			txtArea.append("Done" + "\r\n");
			frame.btnQuery.setEnabled(true);
		}else if(e.getSource() == frame.btnQuery){								
			String xpath = frame.xpathBox.getText();
			//"/DICOM_DATASET/ELEMENT[@name=\"SOPInstanceUID\"]/value[@number=\"1\"]/text()"
			ArrayOfString modelXPaths = new ArrayOfString();
			List<String> listString = modelXPaths.getString();			
			listString.add(xpath);
			txtArea.append(" " + "\r\n");
			txtArea.append("----- Querying native models ------------------" + "\r\n");			
			ArrayOfUUID models = getModels();			
			long time1 = System.currentTimeMillis();			
			ArrayOfQueryResult results = getClientToHost().queryModel(models, modelXPaths, true);	
			long time2 = System.currentTimeMillis();
			txtArea.append("Total query time: " + (time2 - time1)+ " ms" + "\r\n");
			List<QueryResult> listQueryResults = results.getQueryResult();
			for(int i = 0; i < listQueryResults.size(); i++){
				txtArea.append("Result " + i + "\r\n");								
				if(listQueryResults.get(i).getResults().getString() != null && listQueryResults.get(i).getResults().getString().size() > 0){					
					txtArea.append(listQueryResults.get(i).getResults().getString().get(0) + "\r\n");
				}				
			}		
			txtArea.append(" " + "\r\n");			
			txtArea.append("Total query time: " + (time2 - time1)+ " ms"+"\r\n");
			txtArea.updateUI();
		} else if(e.getSource() == frame.btnClear){
			txtArea.setText("");
		}else{
									
		}
			
	}

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
			//getClientToHost().notifyStateChanged(State.IDLE);
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

	@Override
	public State getState() {
		return appCurrentState;
	}	
}
