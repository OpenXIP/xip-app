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
