/**
 * Copyright (c) 2008 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.wg23;

import org.nema.dicom.PS3_19.AvailableData;
import org.nema.dicom.PS3_19.ObjectLocator;

/**
 * @author Jaroslaw Krych
 *
 */
public interface WG23DataModel {
	public AvailableData getAvailableData();
	public ObjectLocator[] getObjectLocators();	
}
