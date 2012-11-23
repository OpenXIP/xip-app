/**
 * Copyright (c) 2009 Washington University in St. Louis. All Rights Reserved.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.nema.dicom.PS3_19.Rectangle;

import edu.wustl.xipApplication.recist.RECISTFactory;
import edu.wustl.xipApplication.recist.RECISTManager;
import edu.wustl.xipApplication.recist.Tumor;

/**
 * <font  face="Tahoma" size="2">
 * <br></br>
 * @version	May 2009
 * @author Lawrence Tarbox
 * </font>
 * This file is derived from ApplicationFrameTeml.java in the edu.wustl.xipApplication.samples directory.
 */
public class RECISTFollowUpAdjudicatorFrame extends JFrame {		
	private static final long serialVersionUID = 1L;	
	RECISTFollowUpAdjudicatorPanel appPanel = new RECISTFollowUpAdjudicatorPanel();
	RECISTFollowUpAdjudicator mainApp;
	
	public RECISTFollowUpAdjudicatorFrame (RECISTFollowUpAdjudicator mainAppIn){
		mainApp = mainAppIn;
		
		setUndecorated(true);
		
		/*Set application dimensions */
		Rectangle rect = mainApp.getClientToHost().getAvailableScreen(null);			
		setBounds(rect.getRefPointX(), rect.getRefPointY(), rect.getWidth(), rect.getHeight());

		// previously in RECISTFollowUpAdjudicator
		appPanel.setVisible(false);
		appPanel.getAIMPanel().addOutputAvailableListener(mainApp);

		setContentPane(appPanel);

		setVisible(true);
	}
	
	public Dimension getAppPanelDimension(){
		return getPreferredSize();
	}
	
	public void setAppPanelDimension(Dimension size){
		setPreferredSize(size);
	}			
	
	public JPanel getDisplayPanel(){
		return appPanel;
	}
	
	public void setSceneGraphInputs(String prev, String curr)
	{
		if(appPanel.getIvCanvas().set("LoadDicom1.name", prev)){
			appPanel.getIvCanvas().set("DicomExaminer1.viewAll", "");
			appPanel.getIvCanvas().processQueue();
		}
		if(appPanel.getIvCanvas().set("LoadDicom2.name", curr)){
			appPanel.getIvCanvas().set("DicomExaminer2.viewAll", "");
			appPanel.getIvCanvas().processQueue();
		}
		//appPanel.getIvCanvas().set("Lut1.bitsUsed", "16");
		appPanel.getIvCanvas().set("DicomExaminer1.imageIndex", "1");
		appPanel.getIvCanvas().set("DicomExaminer2.imageIndex", "1");
		
		appPanel.getIvCanvas().set("OverlayManager2.create", "1");
		appPanel.getIvCanvas().set("OverlayManager2.menuEnabled", "1");
		appPanel.getIvCanvas().set("SelectMode1.index", "2");
		appPanel.getIvCanvas().set("SelectMode2.index", "2");
		appPanel.getIvCanvas().set("LockModeToggle.toggle", "");
		appPanel.getIvCanvas().set("LockModeToggle.on", "");
				
		RECISTManager recistMgr = RECISTFactory.getInstance();
		int numTumors = recistMgr.getNumberOfTumors();				
		if(numTumors == 0){
			Tumor tumor = null;
			appPanel.getAIMPanel().addTumorTab(tumor);
		}
		for(int i = 0; i< numTumors; i++){
			Tumor tumor = recistMgr.getTumors().get(i);						
			appPanel.getAIMPanel().addTumorTab(tumor);						
		}				

		appPanel.setVisible(true);
		appPanel.repaint();	
		
	}

}
