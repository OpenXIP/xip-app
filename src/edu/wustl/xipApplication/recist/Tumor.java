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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jaroslaw Krych
 *
 */
public class Tumor {
	String tumorID;
	String tumorName;	
	List<Rater> raters = Collections.synchronizedList(new ArrayList<Rater>());
	Rater baseRater;
		
	public Tumor(String tumorID, String tumorName){
		this.tumorID = tumorID;
		this.tumorName = tumorName;
	}
	
	public String getTumorID(){
		return tumorID;
	}
	public String getTumorName(){
		return tumorName;
	}
	
	public List<Rater> getRaters(){
		return raters;
	}
	
	public boolean addRater(Rater rater){				
		if(!contains(rater)){
			return raters.add(rater);
		}		
		return false;
	}
	
	public void addBaseRater(Rater rater){
		this.baseRater = rater;
	}
	public Rater getBaseRater(){
		return baseRater;
	}
	
	public boolean contains(Rater rater){		
		for (int i = 0; i < raters.size(); i++){
			/*if(raters.get(i).getRaterID().equalsIgnoreCase(rater.getRaterID()) == true){				
				return true;
			}*/
			if(raters.get(i).getRaterName().equalsIgnoreCase(rater.getRaterName()) == true){				
				return true;
			}
		}
		return false;
	}
	
	/*Rater getRater(String raterID){
		for (int i = 0; i < raters.size(); i++){
			if(raters.get(i).getRaterID().equalsIgnoreCase(raterID) == true){				
				return raters.get(i);
			}
		}
		return null;
	}*/
	public Rater getRater(String raterName){
		for (int i = 0; i < raters.size(); i++){
			if(raters.get(i).getRaterName().equalsIgnoreCase(raterName) == true){				
				return raters.get(i);
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		Tumor tumor = new Tumor("123", "TestTumor");
		System.out.println(tumor.addRater(new Rater("456", "Jarek")));
		System.out.println(tumor.addRater(new Rater("456", "Jarek")));
		
	}
	
}
