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

import java.io.File;
import java.util.List;
import org.nema.dicom.wg23.ObjectLocator;

import edu.wustl.xipApplication.wg23.ClientToHost;
import edu.wustl.xipApplication.wg23.WG23DataModel;

public interface RECISTManager {

	public abstract void parseAIMObjects(List<ObjectLocator> items);
	public abstract int getNumberOfTumors();
	public abstract List<Tumor> getTumors();
	public abstract Tumor getTumor(String tumorName);		
	public abstract void setSOPInstanceUIDPrev(List<String> sopInstanceUIDPrev);
	public abstract void setSOPInstanceUIDCurr(List<String> sopInstanceUIDCurr);
	public abstract List<File> getAIMPrevious();
	public abstract List<File> getAIMCurrent();
	public abstract void setOutputDir(String outputDir);
	public abstract String getOutputDir();	
}
