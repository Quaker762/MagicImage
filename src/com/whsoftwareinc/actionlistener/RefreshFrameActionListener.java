/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.whsoftwareinc.MagicImage;

public class RefreshFrameActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e) 
	{
		MagicImage.frame.panel.repaint();
	}
}
