/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.whsoftwareinc.MagicImage;


public class ImageFrameListener implements WindowListener {

	public void windowActivated(WindowEvent e) 
	{

	}
	public void windowClosed(WindowEvent e) 
	{
		System.gc();
		System.exit(0);
	}
	public void windowClosing(WindowEvent e) 
	{
		System.gc();
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent e) 
	{

	}
	public void windowDeiconified(WindowEvent e) 
	{

	}
	public void windowIconified(WindowEvent e) 
	{

	}

	public void windowOpened(WindowEvent e) 
	{

	}

}
