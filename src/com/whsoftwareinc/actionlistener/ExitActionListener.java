/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent arg0) 
	{
		System.out.println("Exiting...");
		System.gc();
		System.out.println("System released resources (System.gc())");
		System.exit(0);
	}
}