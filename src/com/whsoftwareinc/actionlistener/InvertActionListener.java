/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.whsoftwareinc.filter.Invert;

public class InvertActionListener implements ActionListener {

	private Invert filter = new Invert();
	
	public void actionPerformed(ActionEvent e) 
	{
		filter.renderFilter();
	}
}
