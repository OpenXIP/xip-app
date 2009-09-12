/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.application;

import javax.xml.ws.Endpoint;

/**
 * @author Jaroslaw Krych
 *
 */
public class ApplicationTerminator implements Runnable{

	Endpoint endpoint;
	public ApplicationTerminator(Endpoint endpoint){
		this.endpoint = endpoint;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public void run() {
		//endpoint.stop();
		//System.exit(0);
		ApplicationScheduler appScheduler = new ApplicationScheduler(endpoint);
		appScheduler.start();
	}

}
