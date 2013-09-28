/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFileChooser;

import com.whsoftwareinc.MagicImage;
import com.whsoftwareinc.system.ImageLoader;

public class SaveImageActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent arg0) 
	{
		saveFile();
	}
	
	private void saveFile()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.showSaveDialog(MagicImage.frame);
		BufferedImage image = MagicImage.img.getImage();
		MagicImage.img.writeImage(image, "jpg", chooser.getSelectedFile());
		System.out.println("Wrote file: " + chooser.getSelectedFile().getName() + " at Location" + chooser.getSelectedFile().getAbsolutePath());
		
	}
}
