/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.whsoftwareinc.MagicImage;
import com.whsoftwareinc.filter.Sepia;
import com.whsoftwareinc.system.ImageLoader;

public class SepiaActionListener implements ActionListener {

	private Sepia filter = new Sepia();
	private ImageLoader loader = MagicImage.img;
	
	public void actionPerformed(ActionEvent e) 
	{
		//Check if the image has an Alpha channel...
		if(loader.getImageType() > 5)
		{
			JOptionPane.showMessageDialog(MagicImage.frame, "This effect is only for JPG images!");
		}
		else
		{
			filter.renderFilter();
		}
	}
}
