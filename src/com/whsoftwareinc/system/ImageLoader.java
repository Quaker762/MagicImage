/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.system;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public BufferedImage image;
	public String type;
	public File file;
	
	/*----------------------------------------------------------------------------
    Name        : loadImage
    Description : Load the image to a buffered image
    Inputs      : File
    Outputs     : 
    Return      : BufferedImage
	----------------------------------------------------------------------------*/
	public BufferedImage loadImage(File file)
	{
		this.file = file;
		
		try 
		{
			image = ImageIO.read(file);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		String fname = file.getName();
		fname = fname.substring(fname.lastIndexOf('.'), fname.length());
		extensionToFormatType(fname);
		System.out.println(getFname());
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
	
	//Make the image null
	public void unloadImageReset()
	{
		image = null;
	}

	public WritableRaster raster()
	{
		return getImage().getRaster();
	}
	
	public int getImageType()
	{
		return getImage().getType();
	}
	
	public String getFname()
	{
		return this.file.getName();
	}
	
	public int extensionToFormatType(String name)
	{
		switch(name)
		{
			case ".jpeg":
				return 3;
			case ".png":
				return 4;
			default:
				return 0;
		}
	}
}
