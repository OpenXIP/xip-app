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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.xml.bind.JAXBException;
import edu.wustl.xipApplication.aim.AimSerializer;
import edu.wustl.xipApplication.recist.RECISTFactory;
import edu.wustl.xipApplication.recist.RECISTManager;
import edu.wustl.xipApplication.recist.Rater;
import edu.wustl.xipApplication.recist.Tumor;
import edu.wustl.xipApplication.wg23.OutputAvailableEvent;
import edu.wustl.xipApplication.wg23.OutputAvailableListener;

public class AIMPanel extends JPanel implements ActionListener{	
	RadioButtonPanel radioBtnPanel = new RadioButtonPanel();
	JTabbedPane tabbedPaneTumor = new JTabbedPane();
	JPanel btnPanel = new JPanel();	
	JButton btnSave = new JButton("Save");
	Color xipColor = new Color(51, 51, 102);
	Color xipLightBlue = new Color(156, 162, 189);
	Border border = BorderFactory.createLoweredBevelBorder();	
	TumorTabMouseAdapter tumorTabMouseAdapter = new TumorTabMouseAdapter();
	RatersTabMouseAdapter ratersTabMouseAdapter = new RatersTabMouseAdapter();	
	List<JButton> listOfAimMarkBtns = new ArrayList<JButton>();
	List<JButton> listOfEditBtns = new ArrayList<JButton>();
	AimExceptionDialog exceptionDialog = new AimExceptionDialog();
	
	public AIMPanel(){
		add(radioBtnPanel);				
		tabbedPaneTumor.addMouseListener(tumorTabMouseAdapter);   					
		add(tabbedPaneTumor);		
		btnSave.setBackground(xipColor);
		btnSave.setForeground(Color.WHITE);
		btnSave.setPreferredSize(new Dimension(100, 30));
		btnSave.setFont(new Font("Tahoma", 0, 12));	
		btnSave.addActionListener(this);
		btnPanel.setBackground(xipColor);
		btnPanel.add(btnSave);
		add(btnPanel);
		setBackground(xipColor);
		buildLayout();
		exceptionDialog.btn.addActionListener(this);
	}
	
	boolean setDefaultTabs = true;
	public void addTumorTab(Tumor tumor){
		TumorPanel tumorPanel = new TumorPanel();		
		tumorPanel.setBackground(xipColor);						
		//add adjudicator
		JTabbedPane tabbedPanePrevReport = new JTabbedPane();	
		JTextArea textAreaPrevReport = new JTextArea(10, 70);
		textAreaPrevReport.setBackground(xipLightBlue);
		textAreaPrevReport.setForeground(Color.BLACK);
		textAreaPrevReport.setBorder(border);
				
		//get PreviousReport rater, check is previous report exists
		if(tumor != null && tumor.getBaseRater() != null){			
				List<String> aimDescPrev = tumor.getBaseRater().getAIMDescription();
				for(int i = 0; i < aimDescPrev.size(); i++){
					textAreaPrevReport.append(aimDescPrev.get(i) + "\r\n");
			}			
		}
		JScrollPane scrollPanePrevReport = new JScrollPane(textAreaPrevReport);
		scrollPanePrevReport.setPreferredSize(new Dimension(550, adjustForResolution()));
		tabbedPanePrevReport.addTab("Previous Report", null, scrollPanePrevReport, null);
		tumorPanel.add(tabbedPanePrevReport);		
		
		//add raters if exist
		JTabbedPane tabbedPaneRaters = new JTabbedPane();
		tabbedPaneRaters.addMouseListener(ratersTabMouseAdapter);
		if(tumor != null && tumor.getRaters().size() > 0){			
			List<Rater> raters = tumor.getRaters();
			for(int i = 0; i < raters.size(); i++){
				JTextArea textAreaRater = new JTextArea(10, 70);
				textAreaRater.setBackground(xipLightBlue);
				textAreaRater.setForeground(Color.BLACK);
				textAreaRater.setBorder(border);
				List<String> aimDesc = raters.get(i).getAIMDescription();
				for(int j = 0; j < aimDesc.size(); j++){
					textAreaRater.append(aimDesc.get(j) + "\r\n");
				}				
				JScrollPaneRater scrollPaneRater = new JScrollPaneRater(textAreaRater);
				scrollPaneRater.setRaterName(raters.get(i).getRaterName());
				scrollPaneRater.setPreferredSize(new Dimension(550, adjustForResolution()));												
				tabbedPaneRaters.addTab("Rater " + raters.get(i).getRaterName(), null, scrollPaneRater, null);				
			}								
		}else{
			JTextArea textAreaRater = new JTextArea(10, 70);
			textAreaRater.setBackground(xipLightBlue);
			textAreaRater.setForeground(Color.BLACK);
			textAreaRater.setBorder(border);
			JScrollPaneRater scrollPaneRater = new JScrollPaneRater(textAreaRater);
			scrollPaneRater.setRaterName("Default Rater");
			scrollPaneRater.setPreferredSize(new Dimension(550, adjustForResolution()));
			tabbedPaneRaters.addTab("Default Rater", null, scrollPaneRater, null);
		}
		tumorPanel.add(tabbedPaneRaters);
		tumorPanel.setRatersTabbedPane(tabbedPaneRaters);		
		AimBtnPanel aimBtnPanel = new AimBtnPanel();
		aimBtnPanel.btnUseAsNextBaseReport.addActionListener(this);
		aimBtnPanel.btnEdit.addActionListener(this);
		tumorPanel.add(aimBtnPanel);
		listOfAimMarkBtns.add(aimBtnPanel.btnUseAsNextBaseReport);
		listOfEditBtns.add(aimBtnPanel.btnEdit);
		buildTumorPanelLayout(tumorPanel, tabbedPanePrevReport, tabbedPaneRaters, aimBtnPanel);
		if(tumor != null){
			tumorPanel.setTumorName(tumor.getTumorName());
			tabbedPaneTumor.addTab("Tumor " + tumor.getTumorName(), null, tumorPanel, null);						
		}else {
			tumorPanel.setTumorName("Default Tumor");
			tabbedPaneTumor.addTab("Default Tumor ", null, tumorPanel, null);
		}
		
		if(setDefaultTabs == true){
			tabbedPaneTumor.setSelectedIndex(0);
			selectedTumorName = ((TumorPanel)tabbedPaneTumor.getComponentAt(0)).getTumorName();
			tabbedPaneRaters.setSelectedIndex(0);
			selectedRaterName = ((JScrollPaneRater)tabbedPaneRaters.getComponentAt(0)).getRaterName();
			selectedTabbedPane = tabbedPaneRaters;
			setDefaultTabs = false;
		}					
	}	
		
	void buildLayout(){
    	GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(layout);
        constraints.fill = GridBagConstraints.HORIZONTAL;        
        constraints.gridx = 0;
        constraints.gridy = 0;	     
        //constraints.gridwidth = 2;
        constraints.insets.top = 10;
        constraints.insets.bottom = 0;                
        layout.setConstraints(radioBtnPanel, constraints);
        
        constraints.fill = GridBagConstraints.NONE;        
        constraints.gridx = 0;
        constraints.gridy = 1;	        
        constraints.insets.top = 15;
        constraints.insets.left = 30;
        constraints.insets.right = 10;
        constraints.insets.bottom = 10;        
        constraints.anchor = GridBagConstraints.CENTER;
        layout.setConstraints(tabbedPaneTumor, constraints);
        
        constraints.fill = GridBagConstraints.NONE;        
        constraints.gridx = 0;
        constraints.gridy = 2;	        
        constraints.insets.left = 30;
        constraints.insets.right = 10;
        constraints.insets.bottom = 10;       
        constraints.anchor = GridBagConstraints.EAST;
        layout.setConstraints(btnPanel, constraints);   
    }
	
	void buildTumorPanelLayout(JPanel tumorPanel, JTabbedPane tabbedPaneAdjudicator, JTabbedPane tabbedPaneRaters, AimBtnPanel aimBtnPanel){
		GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        tumorPanel.setLayout(layout);
        constraints.fill = GridBagConstraints.HORIZONTAL;        
        constraints.gridx = 0;
        constraints.gridy = 1;	     
        constraints.insets.top = 0;
        constraints.insets.left = 10;
        constraints.insets.right = 20;
        constraints.insets.bottom = 10; 
        constraints.anchor = GridBagConstraints.NORTH;
        layout.setConstraints(tabbedPaneAdjudicator, constraints);
        
        constraints.fill = GridBagConstraints.NONE;        
        constraints.gridx = 1;
        constraints.gridy = 0;	        
        constraints.insets.top = 10;       
        constraints.insets.right = 10;
        constraints.insets.bottom = 10;
        constraints.anchor = GridBagConstraints.EAST;
        layout.setConstraints(aimBtnPanel, constraints);   
        
        constraints.fill = GridBagConstraints.HORIZONTAL;        
        constraints.gridx = 1;
        constraints.gridy = 1;	        
        constraints.insets.top = 0;       
        constraints.insets.right = 10;
        constraints.insets.bottom = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        layout.setConstraints(tabbedPaneRaters, constraints);   
	}
	
	
	String selectedTumorName;
	class TumorTabMouseAdapter extends MouseAdapter{		
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == 1){
				if(e.getSource() == tabbedPaneTumor){					
					int i = (((JTabbedPane)e.getSource()).getSelectedIndex());										
					//System.out.println((((JTabbedPane)e.getSource()).getTitleAt(i)));
					selectedTumorName = ((TumorPanel)((JTabbedPane)e.getSource()).getComponentAt(i)).getTumorName();
					JTabbedPane ratersTabbedPane = ((TumorPanel)((JTabbedPane)e.getSource()).getComponentAt(i)).getRatersTabbedPane();
					selectedIndex = ratersTabbedPane.getSelectedIndex();
					selectedRaterName = ((JScrollPaneRater)ratersTabbedPane.getComponentAt(selectedIndex)).getRaterName();
					selectedTabbedPane = ratersTabbedPane;
				}
			}
		}
	}
	
	
	String selectedRaterName;	
	JTabbedPane selectedTabbedPane;
	int selectedIndex;
	class RatersTabMouseAdapter extends MouseAdapter{		
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == 1 || e.getButton() == 3){									
				selectedIndex = (((JTabbedPane)e.getSource()).getSelectedIndex());
				selectedTabbedPane = ((JTabbedPane)e.getSource());
				//System.out.println(((JScrollPaneRater)((JTabbedPane)e.getSource()).getComponentAt(i)).getRaterName());				
				selectedRaterName = ((JScrollPaneRater)((JTabbedPane)e.getSource()).getComponentAt(selectedIndex)).getRaterName();
			}			
		}		
	}	
	
	class JScrollPaneRater extends JScrollPane {		
		public JScrollPaneRater(JTextArea textArea){
			super(textArea);
		}
		String raterName;
		public void setRaterName(String raterName){
			this.raterName = raterName;
		}
		public String getRaterName(){
			return raterName;
		}
	}
	
	class TumorPanel extends JPanel {
		String tumorName;
		JTabbedPane tabbedPaneRaters;
		public void setTumorName(String tumorName){
			this.tumorName = tumorName;
		}
		public String getTumorName(){
			return tumorName;
		}
		public void setRatersTabbedPane(JTabbedPane tabbedPaneRaters){
			this.tabbedPaneRaters = tabbedPaneRaters;
		}
		public JTabbedPane getRatersTabbedPane(){
			return tabbedPaneRaters;
		}		
	}

	RECISTManager recistMgr = RECISTFactory.getInstance();	
	public void actionPerformed(ActionEvent e) {										
		if(listOfAimMarkBtns.contains(e.getSource()) 
				&& !selectedTumorName.equalsIgnoreCase("Default Tumor")
				&& !selectedRaterName.equalsIgnoreCase("Default Rater")){
			Tumor tumor = recistMgr.getTumor(selectedTumorName);
			//Unmark all reports
			for(int i = 0 ; i < tumor.getRaters().size(); i++){
				tumor.getRaters().get(i).setAsNextBaseReport(false);
			}
			Rater rater = tumor.getRater(selectedRaterName);
			rater.setAsNextBaseReport(true);
			int i = selectedTabbedPane.getTabCount();
			for(int j = 0 ; j < i; j++){
				selectedTabbedPane.setBackgroundAt(j, new Color(212, 208, 200));				
			}		
			//selectedTabbedPane.setBackgroundAt(selectedIndex, xipLightBlue);
			selectedTabbedPane.setBackgroundAt(selectedIndex, new Color(254, 255, 130));			
		}else if(listOfEditBtns.contains(e.getSource())){
			new UnderDevelopmentDialog(((JButton)e.getSource()).getLocationOnScreen());
		}else if(e.getSource() == btnSave){
			List<Tumor> listOfTumorsWithNoReportMarked = new ArrayList<Tumor>();
			List<Rater> markedReports = new ArrayList<Rater>();
			//1. Check if there is exactly one report marked for each tumor
			List<Tumor> tumors = recistMgr.getTumors();			
			if(tumors.size() == 0)return;
			for(int j = 0; j < tumors.size(); j++){
				boolean bln = false;
				List<Rater> raters = tumors.get(j).getRaters();
				for(int k = 0; k < raters.size(); k++){
					if(raters.get(k).isNextBaseReport()){
						bln = true;
						markedReports.add(raters.get(k));
					}
				}
				if(bln == false){
					listOfTumorsWithNoReportMarked.add(tumors.get(j));
				}
			}
			if(listOfTumorsWithNoReportMarked.size() > 0){				
				exceptionDialog.display(listOfTumorsWithNoReportMarked);
				return;
			}			
			AimSerializer serializer = new AimSerializer();			
			try {
				List<File> serializedAIMs = new ArrayList<File>();
				for(int m = 0; m < markedReports.size(); m++){
					serializer.serialize(markedReports.get(m).getAIMStringXML());
					File aimFile = serializer.getSerializedAIMFile();
					serializedAIMs.add(aimFile);
				}								
				notifyDataAvailable(serializedAIMs);				
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource() == exceptionDialog.btn){
			exceptionDialog.closeDialog();
		}
	};
		
	OutputAvailableListener listener; 
	public void addOutputAvailableListener(OutputAvailableListener l){
		 this.listener = l;
	}
		
	void notifyDataAvailable(List<File> serializedAIMs){
		OutputAvailableEvent event = new OutputAvailableEvent(serializedAIMs);
		listener.outputAvailable(event);
	}
	
	public RadioButtonPanel getRadioButtonPanel(){
		return radioBtnPanel;
	}
	
	int adjustForResolution(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		int height = (int)screenSize.getHeight();
		int preferredHeight = 200;
		if (height < 768 && height >= 600 ){
			preferredHeight = 100;
		}else if(height < 1024 && height >= 768 ){
			preferredHeight = 100;
		}else if (height >= 1024 && height < 1200){
			preferredHeight = 200;
		}else if(height > 1200 && height <= 1440){
			preferredHeight = 200;
		}
		return preferredHeight;		
	}	
}
