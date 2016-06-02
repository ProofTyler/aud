package hu2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hu {
	
	public static void main(String[] args) {
		Matrix labyrinth = new Matrix(6, 6);
		labyrinth.erstelleWeg(1, 1);
		labyrinth.erstelleWeg(1, 2);
		labyrinth.erstelleEndWeg(2, 2);
		labyrinth.go();
	}

}


class Matrix {
	private int matrix[][];
	private int xLaenge;
	private int yLaenge;
	
	private static int start[];
	private static final int END_WEG = 4;
	private static final int GELAUFENER_WEG = 3;
	private static final int START_WEG = 2;
	private static final int NEUER_WEG = 1;
	private static final int GESPERRTER_WEG = 0;	
	private boolean startPunkt = false;
	private int s[] = new int[]{-1,0,0,-1,1,0,0,1};
	
	public Matrix(int x, int y) {
		this.xLaenge = x-1;
		this.yLaenge = y-1;
		this.matrix = new int[x][y];
	}
	
	public void go() {
	 int x= start[0], y = start[1];
	 int xt,yt;
	 while(this.matrix[x][y] != END_WEG){
		for(int i = 0; i < s.length;){
			xt = x + s[i++];
			yt = y + s[i++];
			if(isWeg(xt,yt) == END_WEG) break;
			if(isWeg(xt,yt) == NEUER_WEG){
				this.matrix[xt][yt] = GELAUFENER_WEG;
				x = xt;
				y = yt;
			}									
		}
	 }
	 System.out.println("Endweg ist : " + x +", " + y );
	}
	
	private int isWeg(int x, int y) {
		if(this.matrix[x][y] == NEUER_WEG) 
			return NEUER_WEG;
		if(this.matrix[x][y] == END_WEG)
			return END_WEG;
		else return 0;
	}

	public void erstelleWeg(int x, int y){
		if(!startPunkt){
			this.matrix[x][y] = START_WEG;
			start = new int[]{x,y};
			startPunkt = true;
		}else{
			this.matrix[x][y] = NEUER_WEG;
		}
	}
	
	public void erstelleEndWeg(int x, int y){
		if(startPunkt){
			this.matrix[x][y] = END_WEG;
		}
	}
	
	public void sperreWeg(int x, int y){
		if(this.matrix[x][y] == START_WEG) startPunkt = false;
		this.matrix[x][y] = GESPERRTER_WEG;
	}
}
