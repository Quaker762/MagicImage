/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.system;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.whsoftwareinc.actionlistener.LoadImageActionListener;

public class ImageLoader {
	
	public BufferedImage image;
	
	/*----------------------------------------------------------------------------
    Name        : loadImage
    Description : Load the image to a buffered image
    Inputs      : File
    Outputs     : 
    Return      : BufferedImage
	----------------------------------------------------------------------------*/
	public BufferedImage loadImage(File file)
	{
		try 
		{
			image = ImageIO.read(file);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return image;
	}
	
	/*----------------------------------------------------------------------------
    Name        : getImage
    Description : Get current iamge
    Inputs      : 
    Outputs     : 
    Return      : BufferedImage
	----------------------------------------------------------------------------*/
	public BufferedImage getImage()
	{
		return image;
	}
	
	/*----------------------------------------------------------------------------
    Name        : Write Image
    Description : Writes an image
    Inputs      : 
    Outputs     : 
    Return      : 
	----------------------------------------------------------------------------*/
	public void writeImage(RenderedImage image, String format, File out)
	{
		try 
		{
			ImageIO.write(image, format, out);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
