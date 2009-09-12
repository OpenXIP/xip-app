/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
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
