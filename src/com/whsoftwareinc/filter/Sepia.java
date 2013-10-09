/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd
	
	NOTE: THIS FILTER DOES NOT WORK WITH .PNG IMAGES
	There's an alpha channel, which messes with the array;
	
	I've tried * 4 and += 4, but the image goes gray, not sepia, and for some reason
	has these awkward scanlines. 

/--**/
package com.whsoftwareinc.filter;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import com.whsoftwareinc.MagicImage;
import com.whsoftwareinc.system.ImageLoader;
public class Sepia implements PhotoFilter {

	public BufferedImage image;
	public ImageLoader loader = MagicImage.img;
	private int intensity = 30;
	private int depth = 20;
	private int r, g, b;
	private WritableRaster raster;
	
	public void renderFilter() 
	{
		image = loader.getImage();
		raster = image.getRaster();
		int[] pixels = new int[image.getWidth() * image.getHeight() * 3];
		raster.getPixels(0, 0, image.getWidth(), image.getHeight(), pixels);
		
		for(int i = 0; i < pixels.length; i += 3)
		{
			r = pixels[i];
			g = pixels[i+1];
			b = pixels[i+2];
			
			int gry = (r + g + b) / 4;
			r = g = b = gry;
			r = r + (depth * 2);
			g = g + depth;
			
			if (r>255) r=255;
			if (g>255) g=255;
			if (b>255) b=255;

			// Darken blue color to increase sepia effect
			b-= intensity;

			// normalize if out of bounds
			if (b<0) b=0;
			if (b>255) b=255;

			pixels[i] = r;
			pixels[i+1]= g;
			pixels[i+2] = b;
			}
			raster.setPixels(0, 0, image.getWidth(), image.getHeight(), pixels);
			MagicImage.frame.panel.repaint();
	}
}
