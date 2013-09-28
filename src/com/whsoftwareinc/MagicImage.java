/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc;

import com.whsoftwareinc.system.ImageLoader;
import com.whsoftwareinc.ui.ImageFrame;

public class MagicImage {
	
	public static ImageFrame frame;
	public static ImageLoader img = new ImageLoader();

	public static void main(String[] args) 
	{
		new MagicImage().init();
	}
	
	//Program initilisation routine.
	private void init()
	{
		frame = new ImageFrame(300, 300, "Magic Image");
		frame.render();
	}
}