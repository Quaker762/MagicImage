/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.filter;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import com.whsoftwareinc.MagicImage;
import com.whsoftwareinc.system.Constants;
import com.whsoftwareinc.system.ImageLoader;

public class BlackWhite implements PhotoFilter {

	public BufferedImage image;
	public ImageLoader loader = MagicImage.img;
	private WritableRaster raster;
	private int r, g, b, a;
	private int gray;
	private int[] pixels;
	
	public void renderFilter() 
	{
		image = loader.getImage();
		raster = image.getRaster();
		
		if(image.getType() > 5)
		{
			pixels = new int[image.getWidth() * image.getHeight() * 4];
		}
		else
		{
			pixels = new int[image.getWidth() * image.getHeight() * 3];
		}
		
		raster.getPixels(0, 0, image.getWidth(), image.getHeight(), pixels);

		if(image.getType() > 5)
		{
			for(int i = 0; i < pixels.length; i += 4)
			{
				r = pixels[i];
				g = pixels[i+1];
				b = pixels[i+2];
				a = pixels[i+3];
				gray = (r + g + b) / 3;
				
				r = gray;
				g = gray;
				b = gray;
				a = a;
				
				if(r<0) r = 0;
				if(g<0) g = 0;
				if(b<0) b = 0;
				if(a<0) a = 0;
				if(r>255) r = 255;
				if(g>255) g = 255;
				if(b>255) b = 255;
				if(a>255) a = 255;
				
				pixels[i] = r;
				pixels[i+1] = g;
				pixels[i+2] = b;
				pixels[i+3] = a;
			}
		}
		else
		{
			for(int i = 0; i < pixels.length; i += 3)
			{
				r = pixels[i];
				g = pixels[i+1];
				b = pixels[i+2];
				gray = (r + g + b) / 3;
				
				r = gray;
				g = gray;
				b = gray;
				
				if(r<0) r = 0;
				if(g<0) g = 0;
				if(b<0) b = 0;
				if(a<0) a = 0;
				if(r>255) r = 255;
				if(g>255) g = 255;
				if(b>255) b = 255;
				if(a>255) a = 255;
			
				pixels[i] = r;
				pixels[i+1] = g;
				pixels[i+2] = b;	
			}
		}
		raster.setPixels(0, 0, image.getWidth(), image.getHeight(), pixels);
		MagicImage.frame.panel.repaint();
	}
}