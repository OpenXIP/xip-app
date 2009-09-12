/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.wg23;

import java.io.File;
import java.util.EventObject;
import java.util.List;

public class OutputAvailableEvent extends EventObject{
	public OutputAvailableEvent(List<File> source){	
			super(source);
		}
}
