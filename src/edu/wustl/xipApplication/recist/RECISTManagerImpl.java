/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.recist;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.nema.dicom.wg23.ObjectLocator;
import edu.wustl.xipApplication.aim.AimParser;
import edu.wustl.xipApplication.aim.AimParseEvent;
import edu.wustl.xipApplication.aim.AimParseListener;

/**
 * @author Jaroslaw Krych
 *
 */
public class RECISTManagerImpl implements RECISTManager, AimParseListener {	
	List<Tumor> tumors = Collections.synchronizedList(new ArrayList<Tumor>()); 		
	int numThreads = 3;
	ExecutorService exeService = Executors.newFixedThreadPool(numThreads);			
	
	public void parseAIMObjects(List<ObjectLocator> items){									 							
		aimGroupPrev = new ArrayList<File>();
		aimGroupCurr = new ArrayList<File>();
		for(int i = 0; i < items.size(); i++){									
			AimParser parser;
			try {				
				parser = new AimParser(new File(new URI(items.get(i).getUri())));
				parser.addAimParseListener(this);						
				exeService.execute(parser);		
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
	}
	
	
	/* (non-Javadoc)
	 * @see edu.wustl.xipApplication.recist.RECISTManager#getNumberOfTumors()
	 */
	public int getNumberOfTumors(){
		return tumors.size();		
	}	
	
	/* (non-Javadoc)
	 * @see edu.wustl.xipApplication.recist.RECISTManager#getTumors()
	 */
	public List<Tumor> getTumors(){
		return tumors;
	}
	boolean contains(Tumor tumor){
		for (int i = 0; i < tumors.size(); i++){
			/*if(tumors.get(i).getTumorID().equalsIgnoreCase(tumor.getTumorID()) == true){				
				return true;
			}*/
			if(tumors.get(i).getTumorName().equalsIgnoreCase(tumor.getTumorName()) == true){				
				return true;
			}
		}
		return false;
	}
	
	/*Tumor getTumor(String tumorID){
		for (int i = 0; i < tumors.size(); i++){
			if(tumors.get(i).getTumorID().equalsIgnoreCase(tumorID) == true){				
				return tumors.get(i);
			}
		}
		return null;
	}*/
	public Tumor getTumor(String tumorName){
		for (int i = 0; i < tumors.size(); i++){
			if(tumors.get(i).getTumorName().equalsIgnoreCase(tumorName) == true){				
				return tumors.get(i);
			}
		}
		return null;
	}	
	
	int k= 0;
	List<File> aimGroupPrev;
	List<File> aimGroupCurr;
	public void parsedAimAvailable(AimParseEvent event) {						
		AimParser aimParser = (AimParser)event.getSource();					
		String tumorID = aimParser.getTumorID();
		String tumorName = aimParser.getTumorName();		
		Tumor tumor = new Tumor(tumorID, tumorName);
		String raterID = aimParser.getRaterID();		
		String raterName = aimParser.getRaterName();				
		Rater rater = new Rater(raterID, raterName);		
		if(this.contains(tumor) == false){						
			rater.setAIMDescription(aimParser.getAIMDescription());
			rater.setAIMStringXML(aimParser.getXMLString());
			if (sopInstanceUIDPrev.contains(aimParser.getRefSOPInstanceUID()) && aimParser.getRaterName().equalsIgnoreCase("A")) {								
				rater.setAsPreviousReport(true);
				aimGroupPrev.add(aimParser.getAIMFile());
				tumor.addBaseRater(rater);
				tumors.add(tumor);	
			} else if (sopInstanceUIDCurr.contains(aimParser.getRefSOPInstanceUID())) {
				rater.setAsPreviousReport(false);
				aimGroupCurr.add(aimParser.getAIMFile());
				tumor.addRater(rater);
				tumors.add(tumor);				
			}									
		}else{			
			//Tumor foundTumor = getTumor(tumor.getTumorID());
			Tumor foundTumor = getTumor(tumor.getTumorName());						
			rater.setAIMDescription(aimParser.getAIMDescription());
			rater.setAIMStringXML(aimParser.getXMLString());
			if (sopInstanceUIDPrev.contains(aimParser.getRefSOPInstanceUID()) && aimParser.getRaterName().equalsIgnoreCase("A")) {
				rater.setAsPreviousReport(true);
				aimGroupPrev.add(aimParser.getAIMFile());
				foundTumor.addBaseRater(rater);
			} else if (sopInstanceUIDCurr.contains(aimParser.getRefSOPInstanceUID())) {		
				rater.setAsPreviousReport(false);
				aimGroupCurr.add(aimParser.getAIMFile());
				foundTumor.addRater(rater);
			}												
		}
	}

	List<String> sopInstanceUIDPrev;
	List<String> sopInstanceUIDCurr;
	public void setSOPInstanceUIDPrev(List<String> sopInstanceUIDPrev) {
		this.sopInstanceUIDPrev = sopInstanceUIDPrev;		
	}
	public void setSOPInstanceUIDCurr(List<String> sopInstanceUIDCurr) {
		this.sopInstanceUIDCurr = sopInstanceUIDCurr;		
	}
	
	public List<File> getAIMPrevious(){
		return aimGroupPrev;
	}
	public List<File> getAIMCurrent(){
		return aimGroupCurr;
	}

	public String getOutputDir() {		
		return outputDir;
	}

	String outputDir;
	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;		
	}
}
