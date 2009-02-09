/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.applicationGUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 * <font  face="Tahoma" size="2">
 * Panel use to display messages exchanged between host and application.<br></br>
 * @version	January 2008
 * @author Jaroslaw Krych
 * </font>
 */
public class TextDisplayPanel extends JTextArea {		
	private static final long serialVersionUID = 1L;
	Font font_1 = new Font("Tahoma", 0, 12);
	public TextDisplayPanel(){
		super(40, 80);
		setEditable(false);
		setFont(font_1);
		setToolTipText("Data retrieved from the Host");
		setLineWrap(true);
		setWrapStyleWord(true);
		setCaretPosition(0);
		//setForeground(new Color(127, 255, 0));
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);		
	}
}
