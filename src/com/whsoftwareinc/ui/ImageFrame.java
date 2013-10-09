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
	private JMenu fx;
	private JMenuItem clear;
	private JMenuItem exit;
	private JMenuItem loaditem;
	private JMenuItem saveitem;
	private JMenuItem refresh;
	//FX
	private JMenuItem sepia;
	private JMenuItem bright; 
	private JMenuItem invert;
	private JMenuItem warmth;
	private JMenuItem retro;
	private JMenuItem nv;
	private JMenuItem bw;
	
	private JButton left;
	private JButton right;
	
	public boolean isClear = true;
	
	public ImageFrame(int width, int height, String title)
	{
		panel = new JPanel();
		mbar = new JMenuBar();
		buttonbar = new JMenuBar();
		fmenuitem = new JMenu("File");
		fx = new JMenu("IMGFX");
		
		sepia = new JMenuItem("Sepia");
		bright = new JMenuItem("Bright");
		invert = new JMenuItem("Invert Colors");
		warmth = new JMenuItem("Warmth");
		retro = new JMenuItem("Retro Scanlines");
		nv = new JMenuItem("Nightvision");
		bw = new JMenuItem("Black and White");
		
		loaditem = new JMenuItem("Load");
		saveitem = new JMenuItem("Save");
		clear = new JMenuItem("Clear");
		refresh = new JMenuItem("Refresh Frame");
		exit = new JMenuItem("Exit");
		
		left = new JButton("<--");
		right = new JButton("-->");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setTitle(title);
		this.addWindowListener(new ImageFrameListener());
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
		mbar.add(fx);
		fmenuitem.add(loaditem);
		fmenuitem.add(saveitem);
		fmenuitem.add(clear);
		fmenuitem.add(refresh);
		fmenuitem.add(exit);
		
		fx.add(sepia);
		fx.add(bright);
		fx.add(invert);
		fx.add(warmth);
		fx.add(retro);
		fx.add(nv);
		fx.add(bw);
		
		mbar.add(left);
		mbar.add(right);
		
		loaditem.addActionListener(new LoadImageActionListener());
		saveitem.addActionListener(new SaveImageActionListener());
		clear.addActionListener(new ClearFrameActionListener());
		refresh.addActionListener(new RefreshFrameActionListener());
		exit.addActionListener(new ExitActionListener());
		right.addActionListener(new ImageRightActionListener());
		
		sepia.addActionListener(new SepiaActionListener());
		bright.addActionListener(new BrightnessActionListener());
		invert.addActionListener(new InvertActionListener());
		warmth.addActionListener(new WarmthActionListener());
		retro.addActionListener(new RetroFilterActionListener());
		nv.addActionListener(new NightvisionActionListener());
		bw.addActionListener(new BlackWhiteActionListener());
	}
}
