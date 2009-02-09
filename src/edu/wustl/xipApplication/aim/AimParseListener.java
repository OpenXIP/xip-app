/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.aim;

import java.util.EventListener;

/**
 * @author Jaroslaw Krych
 *
 */
public interface AimParseListener extends EventListener{
	public void parsedAimAvailable(AimParseEvent e);
}
