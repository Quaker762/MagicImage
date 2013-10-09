/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import com.whsoftwareinc.MagicImage;
import com.whsoftwareinc.ui.ImageFrame;

public class LoadImageActionListener implements ActionListener {
	
	private BufferedImage image;
	private ImageFrame frame = MagicImage.frame;
	private JLabel imglbl;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private double sWidth;
	private double sHeight;
	
	public static String dir = "";
	
	public void actionPerformed(ActionEvent e) 
	{
		sWidth = screenSize.getWidth();
		sHeight = screenSize.getHeight();
		clearFrame();
		load();
	}
	
	private void load()
	{
		JFileChooser loader = new JFileChooser();
		loader.showOpenDialog(frame);
		image = MagicImage.img.loadImage(loader.getSelectedFile());
		imglbl = new JLabel(new ImageIcon(image));
		frame.panel.add(imglbl);
		frame.panel.repaint();
		//If the image width is greater than the 
		if(image.getWidth() >= sWidth)
		{
			frame.setSize((int)sWidth, image.getHeight() + (frame.mbar.getHeight() * 2));
		}
		else if(image.getHeight() >= sHeight)
		{
			frame.setSize(image.getWidth(), (int)sHeight);
		}
		else
		{
			frame.setSize(image.getWidth(), image.getHeight() + (frame.mbar.getHeight() * 2));
		}
		System.out.println(image.getWidth() + ", " + image.getHeight());
		dir = getDir(loader.getSelectedFile());
		frame.isClear = false;
		frame.panel.repaint();
		System.out.println(dir);
		System.out.println("Loaded an Image!");
	}
	
	private void clearFrame()
	{
		frame.panel.removeAll();
		frame.panel.repaint();
	}
	
	public String getDir(File file)
	{
		return file.getAbsolutePath();
	}
	
	public BufferedImage getImage()
	{
		return this.image;
	}
}
