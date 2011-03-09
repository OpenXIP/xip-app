/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.*/
package edu.wustl.xipApplication.wg23;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import org.nema.dicom.wg23.ArrayOfObjectLocator;
import org.nema.dicom.wg23.ArrayOfQueryResult;
import org.nema.dicom.wg23.ArrayOfString;
import org.nema.dicom.wg23.ArrayOfUUID;
import org.nema.dicom.wg23.AvailableData;
import org.nema.dicom.wg23.Host;
import org.nema.dicom.wg23.HostService;
import org.nema.dicom.wg23.ModelSetDescriptor;
import org.nema.dicom.wg23.Rectangle;
import org.nema.dicom.wg23.State;
import org.nema.dicom.wg23.Status;
import org.nema.dicom.wg23.Uid;


public class ClientToHost implements Host{	
	URL hostInterfaceEPR;
	HostService service; 
	Host hostProxy; 
	
	public ClientToHost(URL url){			
		URL wsdlLocation = null;
		try {
			wsdlLocation = new URL(url.toExternalForm() + "?wsdl");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service = new HostService(
				wsdlLocation, new QName("http://wg23.dicom.nema.org/", "HostService"));
		hostProxy = service.getHostPort();		
	}

	public Uid generateUID() {
		Uid uid = hostProxy.generateUID();
		return uid;
	}
	
	public ModelSetDescriptor getAsModels(ArrayOfUUID uuids, Uid classUID, Uid transferSyntaxUID) {
		//TODO make use of transferSyntaxUID
		return hostProxy.getAsModels(uuids, classUID, transferSyntaxUID);
	}

	
	public Rectangle getAvailableScreen(Rectangle appPreferredScreen) {
		return hostProxy.getAvailableScreen(appPreferredScreen);		
	}
	
	public ArrayOfObjectLocator getDataAsFile(ArrayOfUUID uuids, boolean includeBulkData) {
		// TODO make use of includeBulkData
		return hostProxy.getDataAsFile(uuids, includeBulkData);
	}
	
	public ArrayOfObjectLocator getDataAsSpecificTypeFile(ArrayOfUUID objectUUIDs, String mimeType, Uid transferSyntaxUID, boolean includeBulkData) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOutputDir() {
		return hostProxy.getOutputDir();		
	}

	public String getTmpDir() {
		return hostProxy.getTmpDir();
	}

	public boolean notifyDataAvailable(AvailableData availableData, boolean lastData) {
		return hostProxy.notifyDataAvailable(availableData, lastData);		
	}

	public void notifyStateChanged(State newState) {
		hostProxy.notifyStateChanged(newState);
		
	}

	public void notifyStatus(Status newStatus) {
		hostProxy.notifyStatus(newStatus);		
	}

	public ArrayOfQueryResult queryModel(ArrayOfUUID objUUIDs, ArrayOfString modelXpaths, boolean includeBulkDataPointers) {
		// TODO make use of includeBulkDataPointers
		return hostProxy.queryModel(objUUIDs, modelXpaths, includeBulkDataPointers);
	}
	
	public static void main(String arg[]) throws MalformedURLException{
		//ClientToHost client = new ClientToHost(new URL("http://localhost:8090/HostService"+"?wsdl"));
		ClientToHost client = new ClientToHost(new URL("http://localhost:8080/xiphostservice/host"));
		//ClientToHost client = new ClientToHost(new URL("http://localhost:8080/xiphostservice/host"));
		System.out.println(client.generateUID().getUid());
	}
}
