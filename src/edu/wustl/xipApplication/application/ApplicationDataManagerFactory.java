/**
 * Copyright (c) 2009 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.application;

/**
 * @author jkrych01
 *
 */
public class ApplicationDataManagerFactory {
	private static ApplicationDataManager dataMgr = new ApplicationDataManagerDefaultImpl();
	
	private ApplicationDataManagerFactory(){}
	
	public static ApplicationDataManager getInstance(){
		return dataMgr;
	}	
}
