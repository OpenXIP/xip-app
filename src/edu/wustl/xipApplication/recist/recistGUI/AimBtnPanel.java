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

package edu.wustl.xipApplication.recist.recistGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Jaroslaw Krych
 *
 */
public class AimBtnPanel extends JPanel {
	Font font = new Font("Tahoma", 0, 12);			
	JButton btnUseAsNextBaseReport = new JButton("Use as next base report");	
	JButton btnEdit = new JButton("Edit AIM");
	Color xipColor = new Color(51, 51, 102);
	
	public AimBtnPanel(){
		JButton[] btns = new JButton[2];
		btns[0] = btnUseAsNextBaseReport;
		btns[1] = btnEdit;
		for(int i = 0; i < btns.length; i++){    	
			btns[i].setFont(font);
	    	btns[i].setBackground(new Color(51, 51, 102));
	    	btns[i].setForeground(Color.WHITE);
	    	btns[i].setOpaque(true);        	
	    	btns[i].setRolloverEnabled(true);
	    	btns[i].setPreferredSize(new Dimension((int)btns[i].getPreferredSize().getWidth(), 30));
		}				
		add(btnUseAsNextBaseReport);
		add(btnEdit);
		setBackground(xipColor);    	
    	
	}	
}
