package asat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyinputs implements KeyListener {
	
	
	demopanel d;
public keyinputs(demopanel d) {
	this.d=d;
}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
int code =e.getKeyCode()	;
if(code== KeyEvent.VK_ENTER) {
	d.search();
}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
