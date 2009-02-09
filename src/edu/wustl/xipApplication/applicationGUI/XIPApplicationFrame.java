/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.applicationGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <font  face="Tahoma" size="2">
 * XIPApplicationFrame is undecorated JFrame, containing buttons panel included for testing purposes.<br></br>
 * @version	January 2008
 * @author Jaroslaw Krych
 * </font>
 */
public class XIPApplicationFrame extends JFrame {			
	public JButton btnUID = new JButton("GetUID");
	public JButton btnAsFiles = new JButton("DataAsFiles");		
	public JButton btnODir = new JButton("Get output DIR");
	public JButton btnTDir = new JButton("Get tmp DIR");
	public JButton btnNotifyOutput = new JButton("Notify output available");	
	public JButton btnGetAsModels = new JButton("NativeModels");
	public JButton btnQuery = new JButton("QueryModels");
	public JPanel btnPanel = new JPanel();
	JPanel displayPanel;
	public static final String OS = System.getProperty("os.name");
	
	public XIPApplicationFrame (){				
		//setUndecorated(false);
		if(OS.contains("Windows")){
			setUndecorated(true);
		}else{
			setUndecorated(false);
			setTitle("XIPApplication_WashU_3");	
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
		displayPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1, 8));
		btnPanel.add(btnUID);
		btnPanel.add(btnAsFiles);		
		btnPanel.add(btnODir);
		btnPanel.add(btnTDir);
		btnPanel.add(btnNotifyOutput);
		btnPanel.add(btnQuery);
		btnPanel.add(btnGetAsModels);
		displayPanel.setLayout(new BorderLayout());				
		displayPanel.add(btnPanel, BorderLayout.SOUTH);
		add(displayPanel);				
		displayPanel.setBackground(Color.BLACK);		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
		btnPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), 25));
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
}
