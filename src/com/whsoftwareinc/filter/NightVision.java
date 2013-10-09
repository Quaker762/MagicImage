/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import com.whsoftwareinc.MagicImage;
import com.whsoftwareinc.system.Constants;
import com.whsoftwareinc.system.ImageLoader;

public class NightVision implements PhotoFilter {

	public BufferedImage image;
	public ImageLoader loader = MagicImage.img;
	private WritableRaster raster;
	private int amount = 10;
	private int r, g, b;
	
	public void renderFilter() 
	{
		image = loader.getImage();
		raster = image.getRaster();
		int[] pixels = new int[image.getWidth() * image.getHeight() * Constants.PIXEL_ARRAY_NO_ALPHA];
		raster.getPixels(0, 0, image.getWidth(), image.getHeight(), pixels);

		for(int i = 0; i < pixels.length; i += 3)
		{
			r = pixels[i];
			g = pixels[i+1];
			b = pixels[i+2];

			//Make it gray
			r = b = g;
			
			//Boost the green only
			g += (amount * 4);
			
			if(r > 255) r = 255;
			if(g > 255) g = 255;
			if(b > 255) b = 255;
			if(r < 0) r = 0;
			if(g < 0) g = 0;
			if(b < 0) b = 0;
			
			pixels[i] = r;
			pixels[i+1] = g;
			pixels[i+2] = b;
		
		}
		raster.setPixels(0, 0, image.getWidth(), image.getHeight(), pixels);
		MagicImage.frame.panel.repaint();
	}
}
