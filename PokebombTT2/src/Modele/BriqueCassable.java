package Modele;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import Controller.GameController;


public class BriqueCassable extends Entity {
	static Random rand = new Random();
	
	public BriqueCassable(int x, int y) {
		super(x, y);
	}
	
	public void update(){
	}
	
	
	public Image getImg(){
		ImageIcon ic = new ImageIcon("petit_arbre.png");
		return ic.getImage();
	}
	
	public Rectangle getBounds(){
		int intX = (int) Math.ceil(600/15);
		int intY = (int) Math .ceil(600/15);
		return new Rectangle(x,y,intX,intY);
	}
	
	public void interact(Player p){			// dit au joueur ce qu'il doit faire en cas de collision
		p.setCanGo(1);
	
	}
	public void interact(Bomb b){			// dit au joueur ce qu'il doit faire en cas de collision
		b.setCanGoBomb(1);
	
	}

}

