/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.application;

import java.net.URL;
import javax.xml.ws.Endpoint;
import org.nema.dicom.wg23.Application;
import edu.wustl.xipApplication.wg23.ApplicationImpl;
import edu.wustl.xipApplication.wg23.ClientToHost;

public class WG23Application {
	ClientToHost client; 
	
	Application app;
	Endpoint endpoint;
	
	/**
	 * 
	 */
	URL appURL;
	public WG23Application (URL hostURL, URL appURL){				
		this.appURL = appURL;								
		client = new ClientToHost(hostURL);	
	}
	
	public void setAndDeployApplicationService(ApplicationImpl appImpl){
		app = (Application) appImpl;
		String appServiceURL = appURL.toString();
		endpoint = Endpoint.publish(appServiceURL, app);		
	}
	
	public ClientToHost getClientToHost(){
		return client;
	}
	
	public Endpoint getEndPoint(){
		return endpoint;
	}	
}
