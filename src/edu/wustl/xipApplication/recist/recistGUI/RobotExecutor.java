/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.recist.recistGUI;

import java.awt.AWTException;
import java.awt.Robot;

/**
 * @author Jaroslaw Krych
 *
 */
public class RobotExecutor implements Runnable{
	Robot robot;
	public void run() {
		try {
			robot = new Robot();
			robot.mouseMove(500, 500);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
