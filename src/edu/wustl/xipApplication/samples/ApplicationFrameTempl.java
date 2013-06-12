/*
Copyright (c) 2013, Washington University in St.Louis.
All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package edu.wustl.xipApplication.samples;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * <font  face="Tahoma" size="2">
 * <br></br>
 * @version	January 2008
 * @author Jaroslaw Krych
 * </font>
 */
public class ApplicationFrameTempl extends JFrame {		
	private static final long serialVersionUID = 1L;	
	JPanel displayPanel;		
	
	public ApplicationFrameTempl (){				
		displayPanel = new JPanel();		
		displayPanel.setLayout(new BorderLayout());
						
		add(displayPanel);				
		displayPanel.setBackground(Color.BLACK);
				
		setUndecorated(true);
		setVisible(true);		
	}
	
	public Dimension getAppPanelDimension(){
		return getPreferredSize();
	}
	
	public void setAppPanelDimension(Dimension size){
		setPreferredSize(size);
	}			
	
	public JPanel getDisplayPanel(){
		return displayPanel;
	}
	
	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		ApplicationFrameTempl frame = new ApplicationFrameTempl();
		frame.addWindowListener(new WindowAdapter(){	         
		public void windowClosing(WindowEvent e){    	        	 	        										
			System.exit(0);
			}	         
		});
	}
	
}
