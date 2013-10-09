/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.filter;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import com.whsoftwareinc.MagicImage;
import com.whsoftwareinc.system.Constants;
import com.whsoftwareinc.system.ImageLoader;

public class Invert implements PhotoFilter {
	
	public BufferedImage image;
	public ImageLoader loader = MagicImage.img;
	private WritableRaster raster;
	private int r, g, b, a;
	
	public void renderFilter() 
	{
		image = loader.getImage();
		raster = image.getRaster();
		int[] pixels = new int[image.getWidth() * image.getHeight() * Constants.PIXEL_ARRAY_ALPHA_CHANNEL];
		raster.getPixels(0, 0, image.getWidth(), image.getHeight(), pixels);
		
		for(int i = 0; i < pixels.length; i += Constants.PIXEL_ARRAY_ALPHA_CHANNEL)
		{
			r = pixels[i];
			g = pixels[i+1];
			b = pixels[i+2];
			a = pixels[i+3];
			
			r = 255 - r;
			g = 255 - g;
			b = 255 - b;
			
			if(loader.getImageType() == 5)
			{
				//Minus the alpha from 255 and set it
				a = 255 - a;
			}
			else 
			{
				//Just keep the alpha as is.
				a = a;
			}
			
			pixels[i] = r;
			pixels[i+1] = g;
			pixels[i+2] = b;
			pixels[i+3] = a;
		}
		raster.setPixels(0, 0, image.getWidth(), image.getHeight(), pixels);
		MagicImage.frame.panel.repaint();
	}
}
