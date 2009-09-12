package edu.wustl.xipApplication.recist.recistGUI;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonPanel extends JPanel{
	public JRadioButton rbLockedScroll = new JRadioButton("Locked Scroll");
    public JRadioButton rbMeasure = new JRadioButton("Measure");
    public JRadioButton rbUnlockedScroll = new JRadioButton("Unlocked Scroll");
    public JRadioButton rbZoomPan = new JRadioButton("Zoom/Pan");
	ButtonGroup btnGroup = new ButtonGroup();
	Color xipColor = new Color(51, 51, 102);
	Color textColor = new Color(212, 213, 234);
    
    public RadioButtonPanel(){    	
    	setLayout(new FlowLayout());
    	btnGroup.add(rbLockedScroll);
    	btnGroup.add(rbUnlockedScroll);
    	btnGroup.add(rbZoomPan);
    	btnGroup.add(rbMeasure);     	
    	add(rbLockedScroll);
    	add(rbUnlockedScroll);
    	add(rbZoomPan);
    	add(rbMeasure);
    	rbLockedScroll.setBackground(xipColor);
    	rbLockedScroll.setSelected(true);
    	rbLockedScroll.setForeground(textColor);
    	rbUnlockedScroll.setBackground(xipColor);
    	rbUnlockedScroll.setForeground(textColor);
    	rbZoomPan.setBackground(xipColor);
    	rbZoomPan.setForeground(textColor);
    	rbMeasure.setBackground(xipColor);
    	rbMeasure.setForeground(textColor);
    	setBackground(xipColor);
    }    
}
