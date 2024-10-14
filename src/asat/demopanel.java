package asat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class demopanel extends JPanel{
	final int maxcol=15;
	final int maxrow=15;
	final int nodesize=50;
	final int screenwidth=nodesize*maxrow;
	final int screenheight=nodesize*maxcol;
	node[][] Node= new node[maxcol][maxrow];
	node startnode,goalnode,currentnode;
	ArrayList<node>openlist=new ArrayList<>();
	ArrayList<node>chekedlist=new ArrayList<>();

	
	boolean goealreached=false;
	int step=0;
	
	
	public demopanel() {
		this.setPreferredSize(new Dimension(screenwidth,screenheight));
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(maxrow,maxcol));
		this.addKeyListener(new keyinputs(this));
		this.setFocusable(true);
		
		
		int col=0;
		int row=0;
		while(col<maxcol && row< maxrow) {
			Node[col][row]= new node(col,row);
			this.add(Node[col][row]);
			col++;
			if(col==maxcol) {
				col=0;
				row++;
			}
		}
		setstartingnode(14,10);
		setgoalnode(3,0);
		 setsolidenode(6,10);
		 setsolidenode(5,10);
		 setsolidenode(4,10);
		 setsolidenode(3,10);
		 setsolidenode(2,10);
		 setsolidenode(1,10);
		 setsolidenode(5,12);
		 setsolidenode(4,12);
		 setsolidenode(3,12);
		 setsolidenode(2,12);
		 setsolidenode(1,12);
		 setsolidenode(2,11);

		 setsolidenode(7,0);
		 setsolidenode(7,1);
		 setsolidenode(7,2);
		 setsolidenode(7,3);
		 setsolidenode(7,4);

		 setsolidenode(7,5);
		 setsolidenode(7,6);

		 setsolidenode(7,7);
		 setsolidenode(7,9);
		 setsolidenode(7,10);

		 setsolidenode(7,8);
		 setcostonnode();
		 search();
	}
	private void setstartingnode(int row,int col) {
		Node[col][row].setastar();
		startnode=Node[col][row];
		currentnode=startnode;  
	}

	private void setgoalnode(int row,int col) {
		Node[col][row].setagoal();;
		goalnode=Node[col][row];
	}
	private void setsolidenode(int row,int col) {

		Node[col][row].setasolide();
	}
	private void setcostonnode() {
		int col=0;
		int row=0;
		while(col<maxcol && row< maxrow) {
			getcost(Node[col][row]);
			col++;
			if(col==maxcol) {
				col=0;
				row++;
			}
		}
	}
		
		
	
	private void getcost(node Node) {
		int xDestance =Math.abs(Node.col-startnode.col);
		int yDestance =Math.abs(Node.row-startnode.row);
		Node.gcost=xDestance+yDestance;
		
		 xDestance =Math.abs(Node.col-goalnode.col);
		 yDestance =Math.abs(Node.row-goalnode.row);
		Node.hcost=xDestance+yDestance;
		Node.fcost=Node.gcost+Node.hcost;
		if(Node !=startnode && Node !=goalnode) {
			Node.setText("<html>F: "+Node.fcost+"<br>G:"+Node.gcost+"</html>");		
			}
	}
public void search() {
	while(goealreached==false && step<300) {
	int col=currentnode.col ;
	int row=currentnode.row;
	currentnode. setVisited();
	chekedlist.add(currentnode);
	openlist.remove(currentnode);
	
	
	if(row -1>=0) {
	opennode(Node[col][row-1]);
	}
	if(col -1>=0) {

	opennode(Node[col-1][row]);
	}
	if(row +1<maxrow) {
	opennode(Node[col][row+1]);
	}
	if(col+1 <maxcol) {

	opennode(Node[col+1][row]);
	}

	int bestnodeindex=0;
	int bestnodefcost=9999;
	for (int i=0;i<openlist.size();i++) {
		if (openlist.get(i).fcost<bestnodefcost) {
			bestnodeindex=i;
			bestnodefcost=openlist.get(i).fcost;
		}
		else if (openlist.get(i).fcost==bestnodefcost) {
			if(openlist.get(i).gcost< openlist.get(bestnodeindex).gcost) {
				bestnodeindex=i;
			}
		}
		currentnode=openlist.get(bestnodeindex);
		if(currentnode== goalnode) {
			goealreached=true;
			trackthepath();
		}
	}
	}
}
private void opennode( node Node) {
	if(Node.open== false && Node.visited== false && Node.solide==false) {
		Node.setasopen();
		Node.parent=currentnode;
		openlist.add(Node);
	}
}
private void trackthepath() {
	node current=goalnode;
	while (current !=startnode) {
		current=current.parent;
		if(current !=startnode) {
			current.setaspath();
		}
	}
	
	
}
}
