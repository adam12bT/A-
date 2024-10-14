package asat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class node extends JButton   implements ActionListener   {
	node parent;
	int row;
	int col;
	int gcost;
	int hcost;
	int fcost;
	boolean solide;
	boolean start;
	boolean goal;
	boolean open;
	public node(int col,int row) {
		this.col=col;
		this.row=row;
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		addActionListener(this);
	}
	public void setastar() {
		setBackground(Color.BLUE);
		setForeground(Color.WHITE);
		setText("start");
		start=true;
	}
	public void setagoal() {
		setBackground(Color.YELLOW);
		setForeground(Color.WHITE);
		setText("goal");
		goal=true;
	}
	public void setasolide() {
	    setBackground(Color.BLACK);
	    setForeground(Color.BLACK);
	
		solide=true;
	}
	public void setasopen() {
		open=true; 
	}

	public void setaspath() {
		setBackground(Color.green);
		setForeground(Color.BLACK);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 setasolide(); // Set the node as "solid."
	}
	
	   private int distance = Integer.MAX_VALUE;
	    boolean visited = false;

	    public int getDistance() {
	        return distance;
	    }

	    public void setDistance(int distance) {
	        this.distance = distance;
	    }



	    public void setVisited() {
			if(start==false && goal ==false) {
				setBackground(Color.ORANGE);
				setForeground(Color.BLACK);

			}
			visited=true;
		}

	

}
