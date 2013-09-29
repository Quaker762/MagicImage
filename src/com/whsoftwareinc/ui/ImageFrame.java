/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.ui;

import java.awt.BorderLayout;

import javax.swing.*;

import com.whsoftwareinc.actionlistener.*;

public class ImageFrame extends JFrame {
	
	public JPanel panel;
	public JMenuBar mbar;
	private JMenuBar buttonbar;
	private JMenu fmenuitem;
	private JMenuItem clear;
	private JMenuItem exit;
	private JMenuItem loaditem;
	private JMenuItem saveitem;
	private JButton left;
	private JButton right;
	
	public boolean isClear = true;
	
	public ImageFrame(int width, int height, String title)
	{
		panel = new JPanel();
		mbar = new JMenuBar();
		buttonbar = new JMenuBar();
		fmenuitem = new JMenu("File");
		loaditem = new JMenuItem("Load");
		saveitem = new JMenuItem("Save");
		clear = new JMenuItem("Clear");
		exit = new JMenuItem("Exit");
		
		left = new JButton("<--");
		right = new JButton("-->");
		setSize(width, height);
		setTitle(title);
		this.setIconImage(new ImageIcon("res/wand.png").getImage());
	}
	
	/*----------------------------------------------------------------------------
    Name        : render
    Description : Render the frame to the screen
    Inputs      : 
    Outputs     : 
    Return      :
	----------------------------------------------------------------------------*/
	public void render()
	{
		setVisible(true);
		add(mbar, BorderLayout.NORTH);
		//add(buttonbar, BorderLayout.SOUTH);
		add(panel);
		mbar.add(fmenuitem);
		fmenuitem.add(loaditem);
		fmenuitem.add(saveitem);
		fmenuitem.add(clear);
		fmenuitem.add(exit);
		mbar.add(left);
		mbar.add(right);
		
		loaditem.addActionListener(new LoadImageActionListener());
		saveitem.addActionListener(new SaveImageActionListener());
		clear.addActionListener(new ClearFrameActionListener());
		exit.addActionListener(new ExitActionListener());
		right.addActionListener(new ImageRightActionListener());
	}
}
