package game.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.interFace.Movable;
import game.item.Present;
import game.ui.FightCanvas;

public class BackButton implements Movable {
//	public static final int STATE_OFF = 0;
//	public static final int STATE_ON = 1; // 약속된 변수로 public사용.
//	public static final int STATE_CLICK = 2;
//	public static final int STATE_PRESS = 3;
//	public static final int STATE_RELEASE = 4;
//
//	public static final Color COLOR_ON = new Color(115, 180, 235);
//	public static final Color COLOR_OFF = new Color(145, 175, 215);
//	public static final Color COLOR_CLICK = new Color(0, 255, 0);
//	public static final Color COLOR_PRESS = new Color(185, 130, 230);
//	public static final Color COLOR_RELEASE = new Color(185, 130, 230);

	private BackButton backButton;
	private static Image image;	//back
	private static Image image2; //pause
	
	private double x;
	private double y;
	
	private int width;
	private int height;
	private int stateValue;
	

	
	public BackButton() {
		try {
			image= ImageIO.read(new File("res/images/back.png")); // 설정 이미지
			image2= ImageIO.read(new File("res/images/pause.png")); // 설정 이미지
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update() {
		x = 1270;
		y = 650;
		width = 100;
		height = 100;
	}

	@Override
	public void draw(Graphics g) {
		int x = (int)this.x;
		int y = (int)this.y;
		g.drawImage(image, x+80, y, FightCanvas.getInstacne());
		g.drawImage(image2, x, y, FightCanvas.getInstacne());
		
//		Color buttonColor;
//		if (stateValue == STATE_ON) {
//			buttonColor = COLOR_ON;
//		} else if (stateValue == STATE_OFF) {
//			buttonColor = COLOR_OFF;
//		} else if (stateValue == STATE_PRESS) {
//			buttonColor = COLOR_PRESS;
//		} else if (stateValue == STATE_RELEASE) {
//			buttonColor = COLOR_RELEASE;
//		} else {
//			buttonColor = COLOR_CLICK;
//		}
	}

//	public boolean contatins(int x, int y) {
//		if ((this.x < x && x < this.x + width) && (this.y < y && y < this.y + height)) {
//			return true;
//		} else {
//			return false;
//		}
//	}

//	public void state(int stateValue) {
////		this.stateValue = stateValue;
//	}
}
