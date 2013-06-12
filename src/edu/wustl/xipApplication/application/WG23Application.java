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
