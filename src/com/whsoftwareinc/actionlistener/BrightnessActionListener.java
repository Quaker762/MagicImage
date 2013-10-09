/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.*;
import com.whsoftwareinc.filter.*;

public class BrightnessActionListener implements ActionListener {
	
	private Brightness filter = new Brightness();
	
	public void actionPerformed(ActionEvent e)
	{
		filter.renderFilter();
	}
}
