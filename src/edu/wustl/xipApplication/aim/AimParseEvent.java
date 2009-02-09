/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.aim;

import java.util.EventObject;

/**
 * @author Jaroslaw Krych
 *
 */
public class AimParseEvent extends EventObject{
	public AimParseEvent(AimParser source){	
		super(source);
}
}
