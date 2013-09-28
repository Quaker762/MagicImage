/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import com.whsoftwareinc.MagicImage;
import com.whsoftwareinc.system.ImageLoader;
import com.whsoftwareinc.ui.ImageFrame;

public class LoadImageActionListener implements ActionListener {
	
	private BufferedImage image;
	private ImageFrame frame = MagicImage.frame;
	private JLabel imglbl;
	
	public static String dir = "";
	
	public void actionPerformed(ActionEvent e) 
	{
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
		frame.setSize(image.getWidth(), image.getHeight() + (frame.mbar.getHeight() * 2));
		System.out.println(image.getWidth() + ", " + image.getHeight());
		dir = getDir(loader.getSelectedFile());
		System.out.println(dir);
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
