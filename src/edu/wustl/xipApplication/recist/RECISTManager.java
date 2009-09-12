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