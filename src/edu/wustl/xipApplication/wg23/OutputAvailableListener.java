/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.wg23;

import java.util.EventListener;

public interface OutputAvailableListener extends EventListener{
	public void outputAvailable(OutputAvailableEvent e);
}
