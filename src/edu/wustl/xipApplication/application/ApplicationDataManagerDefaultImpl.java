/**
 * Copyright (c) 2009 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.application;

import edu.wustl.xipApplication.wg23.WG23DataModel;

/**
 * @author jkrych01
 *
 */
public class ApplicationDataManagerDefaultImpl implements ApplicationDataManager{
	
	public WG23DataModel getOutputData() {		
		return wg23DM;
	}

	WG23DataModel wg23DM;
	public void setOutputData(WG23DataModel wg23DM) {
		this.wg23DM = wg23DM;		
	}
}
