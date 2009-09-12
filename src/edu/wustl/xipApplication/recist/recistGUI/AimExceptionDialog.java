/**
 * Copyright (c) 2008 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.recist.recistGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

import edu.wustl.xipApplication.recist.Tumor;

/**
 * @author Jaroslaw Krych
 *
 */
public class AimExceptionDialog extends JPanel implements ActionListener {	
	JLabel lbl = new JLabel();
	JTextArea textArea = new JTextArea(10, 70);
	Border border = BorderFactory.createLoweredBevelBorder();
	JScrollPane scrollPane;
	JButton btn = new JButton("OK");	
	Font font = new Font("Tahoma", 0, 12);
	Color xipColor = new Color(51, 51, 102);	
	Color xipLightBlue = new Color(156, 162, 189);
	
	
	public AimExceptionDialog(){									
		setBackground(xipColor);		
		lbl.setText("Warning: AIM objects cannot be saved. Approve reports for the following tumors.");
		lbl.setFont(font);
		lbl.setForeground(Color.WHITE);
		textArea.setBackground(xipLightBlue);
		textArea.setForeground(Color.BLACK);
		textArea.setBorder(border);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(550, 200));
		add(lbl);
		add(scrollPane);
		btn.setFont(font);
    	btn.setBackground(new Color(51, 51, 102));
    	btn.setForeground(Color.WHITE);    	
    	btn.setPreferredSize(new Dimension(150, 30));
		add(btn);
		buildLayout();
	}
	
	
	
	void buildLayout(){				
		GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(layout);         
                       
        constraints.fill = GridBagConstraints.NONE;        
        constraints.gridx = 0;
        constraints.gridy = 0;        
        constraints.insets.top = 30;
        constraints.insets.left = 20;
        constraints.insets.right = 20;            
        constraints.anchor = GridBagConstraints.WEST;
        layout.setConstraints(lbl, constraints);
        
        constraints.fill = GridBagConstraints.HORIZONTAL;        
        constraints.gridx = 0;
        constraints.gridy = 1;        
        constraints.insets.left = 20;
        constraints.insets.right = 20;        
        constraints.anchor = GridBagConstraints.CENTER;
        layout.setConstraints(scrollPane, constraints);
                
        constraints.fill = GridBagConstraints.NONE;        
        constraints.gridx = 0;
        constraints.gridy = 2;                
        constraints.insets.top = 20;
        constraints.insets.left = 20;
        constraints.insets.right = 20;    
        constraints.insets.bottom = 20;               
        constraints.anchor = GridBagConstraints.CENTER;
        layout.setConstraints(btn, constraints); 
        
	}
	
	JDialog frame;	
	public void display(List<Tumor> listOfTumorsWithNoReportMarked){			
		textArea.setText("");
		for(int i = 0; i < listOfTumorsWithNoReportMarked.size(); i++){
			textArea.append(listOfTumorsWithNoReportMarked.get(i).getTumorName() + "\r\n");
		}		
		updateUI();		
		frame =  new JDialog(new JFrame(), "RECIST Adjudicator Dialog", false);
		JRootPane rootPane = frame.getRootPane();	
		registerEscapeKey(rootPane);
		//frame.setUndecorated(true);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.getContentPane().add(this);
		frame.setVisible(true);		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {			      
		        frame.dispose();
			}
		});		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = frame.getPreferredSize();
        frame.setBounds((screenSize.width - windowSize.width) / 2, (screenSize.height - windowSize.height) /2,  windowSize.width, windowSize.height);		
	}
	
	public void closeDialog(){
		frame.dispose();
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();			
		AimExceptionDialog panel = new AimExceptionDialog();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = frame.getPreferredSize();
        frame.setBounds((screenSize.width - windowSize.width) / 2, (screenSize.height - windowSize.height) /2,  windowSize.width, windowSize.height);
		frame.pack();		
	}

	public void actionPerformed(ActionEvent e) {

	}	
	
	void registerEscapeKey (JRootPane rootPane) {
		KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
		Action escapeAction = new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				 frame.dispose();
			
			}
		};		 
		rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
		rootPane.getActionMap().put("ESCAPE", escapeAction);
	}
	
	
}
