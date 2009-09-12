/**
 * Copyright (c) 2007 Washington University in Saint Louis. All Rights Reserved.
 */
package edu.wustl.xipApplication.recist;

import java.util.List;

/**
 * @author Jaroslaw Krych
 *
 */
public class Rater {
	String raterID;
	String raterName;	
	boolean isPreviousReport = false;
	boolean isNextBaseReport = false;
	List<String> aimDesc;
	
	public Rater(String raterID, String raterName){
		this.raterID = raterID;
		this.raterName = raterName;
	}

	public String getRaterID(){
		return raterID;
	}
	public String getRaterName(){
		return raterName;
	}
	
	public void setAsPreviousReport(boolean isPreviousReport){
		this.isPreviousReport = isPreviousReport;
	}
	
	public void setAsNextBaseReport(boolean isNextBaseReport){
		this.isNextBaseReport = isNextBaseReport;
	}
	public boolean isNextBaseReport(){
		return isNextBaseReport;
	}
		
	public void setAIMDescription(List<String> aimDesc){
		this.aimDesc = aimDesc;
	}
	public List<String> getAIMDescription(){
		return aimDesc;
	}
	
	public boolean isPreviousReport(){
		return isPreviousReport;
	}
	String strAIM;
	public void setAIMStringXML(String strAIM){
		this.strAIM = strAIM;
	}
	public String getAIMStringXML(){
		return strAIM;
	}
}
