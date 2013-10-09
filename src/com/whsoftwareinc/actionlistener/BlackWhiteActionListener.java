/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.whsoftwareinc.filter.BlackWhite;

public class BlackWhiteActionListener implements ActionListener {

	private BlackWhite filter = new BlackWhite();
	
	public void actionPerformed(ActionEvent e) 
	{
		filter.renderFilter();
	}
}
