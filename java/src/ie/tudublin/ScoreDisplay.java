package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	ArrayList<Note> notes = new ArrayList<>();
	float cX;
	float cY;
	float borderW;
	float borderH;
	float beatWidth = 20;

	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);

		cY = height/2;
		borderW = width * .1f;
		borderH = height * .1f;
		cX = width/2;
	}

	public void setup() 
	{
		colorMode(RGB);
		loadScores();
		printScores();

		
	}


	public void draw()
	{
		background(255);
		fill(0,0,0);
		stroke(0,0,0);
		drawStaves();
		drawNotes();
		
	}

	void drawNotes()
	{
		int i = 0;
		int t = 'D';
		int t2 = 'a';
		int position = 0;

		ellipseMode(CENTER);

		for(Note n : notes){
			fill(0,0,0);

			char c = n.getNote();
			float x = map(i,0, notes.size(), width*.1f, width- width*.1f);

			if(c < t){
				position = c + 7;
			}else if(c>=t2){
				position = c - 25; 
			}else{
				position = c;
			}

			float y = map(position, t, t2 + 4 - 25, cY + borderH,  cY - borderH);

			checkMouse(x+10,y+10,n);
			text(c, x+10, height*.1f);

			stroke(n.getC(), 0, 0);
			fill(n.getC(), 0, 0);

			ellipse(x+beatWidth/2, y+beatWidth/2, beatWidth, beatWidth);
			line(x+beatWidth,y+beatWidth/2,x+beatWidth,y-50);
			i++;
		}
	}

	void loadScores(){
		int d;
		for(int i = 0; i < score.length(); i++){
			char c = score.charAt(i);
			if(!(i==score.length()-1)){
				if(Character.isLetter(c)){
					if(Character.isDigit(score.charAt(i+1))){
						d = score.charAt(i+1) - '0';
					}else{
						d = 1;
					}

					Note n = new Note(c,d);
					notes.add(n);
				}
			}else if(Character.isLetter(c)){
				d = 1;
				Note n = new Note(c,d);
				notes.add(n);
			}
		}

	}

	void checkMouse(float x, float y, Note n){
		if(dist(mouseX, mouseY, x , y) < beatWidth/2){
			n.setC(255);
		}else{
			n.setC(0);
		}
	}



	void printScores(){

		for(Note n : notes){
			println(n);
		}

		for(Note n : notes){
			print(n.getNote() + "\t" + n.getDuration() + "\t");
			if(n.getDuration() == 1){
				println("Quaver");
			}else{
				println("Crotchet");
			}

		}

	}

	void drawStaves(){
		//stroke(0, 0, 0);
		for(int i = 0; i < 5; i++){
			float y = map(i, 0, 4, cY - borderH,  cY + borderH);
			line(width*.1f, y, width-width*.1f, y);
			//println("Y LINE" + y);

		}

	}
}
