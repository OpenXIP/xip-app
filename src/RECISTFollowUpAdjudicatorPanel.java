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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JPanel;

import edu.wustl.xipApplication.recist.recistGUI.AIMPanel;

public class RECISTFollowUpAdjudicatorPanel extends JPanel implements ActionListener {	
    ivCanvas mivCanvas; 
    AIMPanel aimPanel = new AIMPanel();    
   
	public RECISTFollowUpAdjudicatorPanel() {       	
		setLayout(new GridLayout(2, 1));		
		mivCanvas = new ivCanvas();
		add(mivCanvas);
		add(aimPanel);
	    mivCanvas.initialize();
		loadLibrary();		
	    runRECIST();
	    aimPanel.getRadioButtonPanel().rbLockedScroll.addActionListener(this);
	    aimPanel.getRadioButtonPanel().rbUnlockedScroll.addActionListener(this);
	    aimPanel.getRadioButtonPanel().rbZoomPan.addActionListener(this);
	    aimPanel.getRadioButtonPanel().rbMeasure.addActionListener(this);
	}
    
	void buildLayout(){
    	GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(layout);
        constraints.fill = GridBagConstraints.HORIZONTAL;        
        constraints.gridx = 0;
        constraints.gridy = 0;	             
        constraints.anchor = GridBagConstraints.CENTER;
        layout.setConstraints(mivCanvas, constraints);
        
        constraints.fill = GridBagConstraints.HORIZONTAL;        
        constraints.gridx = 0;
        constraints.gridy = 1;	        
        constraints.insets.top = 30;//40        
        constraints.insets.bottom = 10;//40        
        constraints.anchor = GridBagConstraints.CENTER;
        layout.setConstraints(aimPanel, constraints);        
    }
		
	public void loadLibrary() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("./ivJava.ini"));
			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.length() > 0) {
					int index = line.indexOf("LoadLibrary=");
					if (index >= 0) {
						String Library = line.substring(index + 12);
						Library = Library.replace(';', ',');
						System.out.println("Loading rad extensions : ");
						System.out.println(Library);
						if (!mivCanvas.loadLibraries(Library))
							System.out.println("Not all rad extensions could be loaded");
						break;
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
 	 
	public void runRECIST(){	   
		File recistFile = new File("./xip_rsna_recist_final1.iv");
	    String filePth;
	    if(recistFile.exists()) {
	    	filePth = recistFile.getAbsolutePath();
	    } else {
	    	return;
	    }	              	          
		if (null != mivCanvas && filePth.length() != 0) {
			try {
				mivCanvas.loadGraphOpenGL(filePth);
				mivCanvas.repaint();	    
			} catch (Exception e) {
				  e.printStackTrace();
			}
		}
	}  
   
	public ivCanvas getIvCanvas(){
		return mivCanvas;
	}
	   
	public AIMPanel getAIMPanel(){
		return aimPanel;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == aimPanel.getRadioButtonPanel().rbLockedScroll){
			getIvCanvas().set("SelectMode1.index", "2");
			getIvCanvas().set("SelectMode2.index", "2");
			getIvCanvas().set("LockModeToggle.toggle", "");
			getIvCanvas().set("LockModeToggle.on", "");
			getIvCanvas().set("DicomExaminer1.viewAll", "");				
			getIvCanvas().set("DicomExaminer2.viewAll", "");
			getIvCanvas().processQueue();
		}else if(e.getSource() == aimPanel.getRadioButtonPanel().rbUnlockedScroll){
			getIvCanvas().set("SelectMode1.index", "2");
			getIvCanvas().set("SelectMode2.index", "2");
			getIvCanvas().set("LockModeToggle.toggle", "");
			getIvCanvas().set("LockModeToggle.off", "");			
			getIvCanvas().processQueue();
		}else if(e.getSource() == aimPanel.getRadioButtonPanel().rbZoomPan){
			getIvCanvas().set("SelectMode1.index", "1");
			getIvCanvas().set("SelectMode2.index", "1");
			getIvCanvas().set("LockModeToggle.toggle", "");
			getIvCanvas().set("LockModeToggle.on", "");
			getIvCanvas().processQueue();
		}else if(e.getSource() == aimPanel.getRadioButtonPanel().rbMeasure){
			getIvCanvas().set("SelectMode1.index", "2");
			getIvCanvas().set("SelectMode2.index", "0");
			getIvCanvas().set("LockModeToggle.toggle", "");
			getIvCanvas().set("LockModeToggle.on", "");
			getIvCanvas().processQueue();
		}
		
		
	}	
}
