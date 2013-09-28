/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;

public class ImageDialog extends JDialog {
	
	private BufferedImage image;
	
	public ImageDialog()
	{
		
	}
	
	public ImageDialog(BufferedImage image, String fname)
	{
		this.image = image;
		try 
		{
			image = ImageIO.read(new File(fname));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	//Render the frame.
	public void render()
	{
		
	}
}
