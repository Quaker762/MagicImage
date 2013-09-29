/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.whsoftwareinc.MagicImage;
import com.whsoftwareinc.ui.ImageFrame;

public class ClearFrameActionListener implements ActionListener{

	private ImageFrame frame = MagicImage.frame;
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(!frame.isClear)
		{
			frame.panel.removeAll();
			frame.panel.repaint();
			frame.setSize(300, 300);
			frame.isClear = true;
			System.out.println("Cleared the frame.");
		}
		else 
		{
			System.out.println("Frame is already clear...");
		}
	}
}
