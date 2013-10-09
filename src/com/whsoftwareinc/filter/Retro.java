/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.filter;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import com.whsoftwareinc.MagicImage;
import com.whsoftwareinc.system.Constants;
import com.whsoftwareinc.system.ImageLoader;

public class Retro implements PhotoFilter {
	
	public BufferedImage image;
	public ImageLoader loader = MagicImage.img;
	private WritableRaster raster;
	private int depth = 8;
	private int r, g, b, a;
	
	public void renderFilter() 
	{
		image = loader.getImage();
		raster = image.getRaster();
		int[] pixels = new int[image.getWidth() * image.getHeight() * Constants.PIXEL_ARRAY_ALPHA_CHANNEL];
		raster.getPixels(0, 0, image.getWidth(), image.getHeight(), pixels);
		
		for(int i = 0; i < pixels.length; i += depth)
		{
			r = pixels[i];
			g = pixels[i+1];
			b = pixels[i+2];
			a = pixels[i+3];
			
			r = g = b = a;
			
			pixels[i] = r;
			pixels[i+1] = g;
			pixels[i+2] = b;
			pixels[i+3] = a;
		}
		raster.setPixels(0, 0, image.getWidth(), image.getHeight(), pixels);
		MagicImage.frame.panel.repaint();
	}
}
