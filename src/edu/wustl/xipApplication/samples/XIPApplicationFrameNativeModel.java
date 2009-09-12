/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.samples;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import edu.wustl.xipApplication.applicationGUI.XIPApplicationFrame;

/**
 * <font  face="Tahoma" size="2">
 * XIPApplicationFrame is undecorated JFrame, containing buttons panel included for testing purposes.<br></br>
 * @version	January 2008
 * @author Jaroslaw Krych
 * </font>
 */
public class XIPApplicationFrameNativeModel extends JFrame implements MouseListener {		
	private static final long serialVersionUID = 1L;
	public JTextField xpathBox = new JTextField(50);	
	public JButton btnQuery = new JButton("XPath Query");
	public JButton btnGetModels = new JButton("Get Models");
	public JButton btnClear = new JButton("Clear");
	
	public JPanel btnPanel = new JPanel();
	JPanel displayPanel;		
	Color xipColor = new Color(51, 51, 102);
	public static final String OS = System.getProperty("os.name");
	
	public XIPApplicationFrameNativeModel (){				
		if(OS.contains("Windows")){
			setUndecorated(true);
		}else{
			setUndecorated(false);
			setTitle("XIPApplication_NativeModel XPath Query Test Application");	
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
		displayPanel = new JPanel();
		//xpathBox.setText("/DICOM_DATASET/ELEMENT[@name=\"SOPInstanceUID\"]/value[@number=\"1\"]/text()");
		//xpathBox.setText("/");
		xpathBox.setText("/DicomDataSet/DicomAttribute[@keyword=\"SOPInstanceUID\"]/Value[@number=\"1\"]/text()");
		xpathBox.setBackground(Color.LIGHT_GRAY);		
		xpathBox.setEditable(true);
		xpathBox.setFocusable(true);		
		xpathBox.addMouseListener(this);
		xpathBox.requestFocusInWindow();
		btnQuery.setBackground(xipColor);
		btnQuery.setForeground(Color.WHITE);
		btnGetModels.setBackground(xipColor);
		btnGetModels.setForeground(Color.WHITE);
		btnClear.setBackground(xipColor);
		btnClear.setForeground(Color.WHITE);
		btnPanel.setLayout(new GridLayout(1, 3));
		btnPanel.add(xpathBox);
		btnPanel.add(btnQuery);
		btnPanel.add(btnGetModels);
		btnPanel.add(btnClear);	
		displayPanel.setLayout(new BorderLayout());
		//buildDisplayPanel();
				
		displayPanel.add(btnPanel, BorderLayout.NORTH);
		add(displayPanel);				
		displayPanel.setBackground(Color.BLACK);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
		btnPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), 25));
		//displayPanel.setPreferredSize(new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight() - 85));
				
		//setExtendedState (JFrame.MAXIMIZED_BOTH);  
		//frame.pack();
		//setUndecorated(true);
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
		
		XIPApplicationFrame frame = new XIPApplicationFrame();
		frame.addWindowListener(new WindowAdapter(){	         
		public void windowClosing(WindowEvent e){    	        	 	        										
			System.exit(0);
			}	         
		});
	}
	
	public void mouseClicked(MouseEvent arg0) {
		xpathBox.selectAll();		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
