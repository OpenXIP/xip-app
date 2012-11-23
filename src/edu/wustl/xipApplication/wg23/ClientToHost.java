/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.*/
package edu.wustl.xipApplication.wg23;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;

import org.nema.dicom.PS3_19.ArrayOfMimeType;
import org.nema.dicom.PS3_19.ArrayOfObjectLocator;
import org.nema.dicom.PS3_19.ArrayOfQueryResult;
import org.nema.dicom.PS3_19.ArrayOfQueryResultInfoSet;
import org.nema.dicom.PS3_19.ArrayOfUID;
import org.nema.dicom.PS3_19.ArrayOfstring;
import org.nema.dicom.PS3_19.ArrayOfUUID;
import org.nema.dicom.PS3_19.AvailableData;
import org.nema.dicom.PS3_19.IHostService20100825;
import org.nema.dicom.PS3_19.HostService20100825;
import org.nema.dicom.PS3_19.ModelSetDescriptor;
import org.nema.dicom.PS3_19.Rectangle;
import org.nema.dicom.PS3_19.State;
import org.nema.dicom.PS3_19.Status;
import org.nema.dicom.PS3_19.UID;


public class ClientToHost implements IHostService20100825{	
	URL hostInterfaceEPR;
	HostService20100825 service; 
	IHostService20100825 hostProxy; 
	
	public ClientToHost(URL url){			
		URL wsdlLocation = null;
		try {
			wsdlLocation = new URL(url.toExternalForm() + "?wsdl");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service = new HostService20100825(
				wsdlLocation, new QName("http://dicom.nema.org/PS3.19/HostService-20100825", "HostService-20100825"));
		hostProxy = service.getHostServiceBinding();		
	}

	@Override
	public UID generateUID() {
		UID uid = hostProxy.generateUID();
		return uid;
	}

	@Override
	public Rectangle getAvailableScreen(Rectangle appPreferredScreen) {
		return hostProxy.getAvailableScreen(appPreferredScreen);		
	}
	
	@Override
	public String getOutputLocation(ArrayOfstring preferredProtocols) {
		return hostProxy.getOutputLocation(preferredProtocols);		
	}

	@Override
	public void notifyStateChanged(State state) {
		hostProxy.notifyStateChanged(state);
		
	}

	@Override
	public void notifyStatus(Status status) {
		hostProxy.notifyStatus(status);		
	}

	@Override
	public Boolean notifyDataAvailable(AvailableData data, Boolean lastData) {
		return hostProxy.notifyDataAvailable(data, lastData);		
	}

	@Override
	public ArrayOfObjectLocator getData(ArrayOfUUID objects, ArrayOfUID acceptableTransferSyntaxes, Boolean includeBulkData) {
		// TODO make use of includeBulkData
		return hostProxy.getData(objects, acceptableTransferSyntaxes, includeBulkData);
	}
	
	@Override
	public void releaseData(ArrayOfUUID objects) {
		hostProxy.releaseData(objects);
	}

	@Override
	public ModelSetDescriptor getAsModels(ArrayOfUUID objects, UID classUID,
			ArrayOfMimeType supportedInfoSetTypes) {
		return hostProxy.getAsModels(objects, classUID, supportedInfoSetTypes);
	}

	@Override
	public void releaseModels(ArrayOfUUID models) {
		hostProxy.releaseModels(models);	
	}

	@Override
	public ArrayOfQueryResult queryModel(ArrayOfUUID models,
			ArrayOfstring xPaths) {
		return hostProxy.queryModel(models, xPaths);
	}

	@Override
	public ArrayOfQueryResultInfoSet queryInfoSet(ArrayOfUUID models,
			ArrayOfstring xPaths) {
		return hostProxy.queryInfoSet(models, xPaths);
	}

	public static void main(String arg[]) throws MalformedURLException{
		//ClientToHost client = new ClientToHost(new URL("http://localhost:8090/HostService"+"?wsdl"));
		ClientToHost client = new ClientToHost(new URL("http://localhost:8080/xiphostservice/host"));
		//ClientToHost client = new ClientToHost(new URL("http://localhost:8080/xiphostservice/host"));
		System.out.println(client.generateUID().getUid());
	}
}
