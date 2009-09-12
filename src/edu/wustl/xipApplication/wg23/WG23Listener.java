/**
 * Copyright (c) 2008 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.wg23;

import java.util.EventListener;

import org.nema.dicom.wg23.AvailableData;
import org.nema.dicom.wg23.State;

/**
 * @author Jaroslaw Krych
 *
 */
public interface WG23Listener extends EventListener {
	public boolean setState(State newState);
	public void notifyDataAvailable(AvailableData availableData, boolean lastData);
	public boolean bringToFront();
}
