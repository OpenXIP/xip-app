/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.recist;


/**
 * @author Jaroslaw Krych
 *
 */
public class RECISTFactory {
	private static RECISTManager recistMgr = new RECISTManagerImpl();
	
	private RECISTFactory(){}
	
	public static RECISTManager getInstance(){
		return recistMgr;
	}	
}
