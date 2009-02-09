/**
 *
 * @author Ranajoy Malakar, Anthony Dass
 */

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;


public class RECISTPanel extends JPanel {
    ivCanvas mivCanvas;
   
	public RECISTPanel() {       					
		setLayout(new BorderLayout());
		mivCanvas = new ivCanvas();	    
		add(mivCanvas, BorderLayout.CENTER);		
	    mivCanvas.initialize();
		loadLibrary();		
	    runRECIST();	    
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
}
