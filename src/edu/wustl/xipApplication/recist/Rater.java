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
