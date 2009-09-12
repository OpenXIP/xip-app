/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.application;

import java.util.Timer;
import java.util.TimerTask;

import javax.xml.ws.Endpoint;
/**
 * @author Jaroslaw Krych
 *
 */
public class ApplicationScheduler {
		
	    private final Timer timer = new Timer();
	    private final int ms = 0;

	    Endpoint endpoint;
	    public ApplicationScheduler(Endpoint endpoint) {
	       this.endpoint = endpoint;
	    }

	    public void start() {
	        timer.schedule(new TimerTask() {
	            public void run() {
	            	endpoint.stop();
	            	timer.cancel();
	            	
	                
	            }	            
	        }, ms);
	        System.exit(0);
	    }
}
