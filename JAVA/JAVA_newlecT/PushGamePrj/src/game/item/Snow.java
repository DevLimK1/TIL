package game.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.interFace.Movable;
import game.ui.FightCanvas;

public class Snow implements Movable {
	private static Image image;
	private double x;
	private double y;
	private double vx; //이동할 단위 위치
	private double vy;
	private double dx; //목적지 위치
	private double dy;
	private int width;
	private int height;
	
	private int timeout;
	private int imgIndex;
	private int speed;
	
	private boolean visible=true;
	
	static { //함수 호출과 상관없이 프로그램이 실행되면서 한번 초기화됨 
		try {
			image=ImageIO.read(new File("res/images/snow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Snow(double x) { //올라프 있는 x좌표
		width=(image.getWidth(FightCanvas.getInstacne()))/6; //ImageObserver(this)는 Canvas 클래스내에서 혹은 상속받은 상태에서 가능
		height=image.getHeight(FightCanvas.getInstacne());
		
		
		this.x=x-50;
		y=71;
		
//		vx=2;
		vy=2;
		imgIndex=0;
	}

	@Override
	public void update() {
		this.x-=vx;
		this.y+=vy;
		
		if (timeout-- == 0) { //산타 출현 간격
			imgIndex++;
			imgIndex %= 6; // 0~11까지 -> 이미지 인덱스가 바뀌면서 ufo가 회전하게됨
			timeout=40;
		}
	}

	@Override
	public void draw(Graphics g) {
		int offsetX = width / 2; // 이미지의 x축 중심점 이동위해서 선언
		int offsetY = height / 2; // 이미지의 y축 중심점 이동위해서 선언
		int dx1 = (int) (x - offsetX);
		int dy1 = (int) (y - offsetY);
		int dx2 = (int) (x+width - offsetX);
		int dy2 = (int) (y + height - offsetY);
		
//		System.out.println(width);
//		System.out.println(height);
//		System.out.println("Present dy2: "+dy2);
		
//		System.out.println("Present dx2: "+dx2);
//		System.out.println("getBearImg_leftDx2 : "+ Character.getBearImg_leftDx2());
		//좌측 곰 아이템 획득
		if(((Character.getBearImg_leftDx2()-50<dx2&&dx2<Character.getBearImg_leftDx2()))&&
				(Character.getBearImg_leftDy1()+45<dy2&&dy2<615)) { //좌측 곰 머리~발 아이템 닿으면
			visible=false;
			
			//아이템 사라짐
			g.drawImage(image, 0, 0, 0, 0,  
					imgIndex*width, 0, imgIndex*width+width, 0+height, FightCanvas.getInstacne());
		}else if(visible) 
			g.drawImage(image, dx1, dy1, dx2-45, dy2-45, 
				imgIndex*width, 0, imgIndex*width+width, 0+height, FightCanvas.getInstacne());	
		
		//우측 곰 아이템 획득
		if(((Character.getBearImg_rightDx2()-50<dx2&&dx2<Character.getBearImg_rightDx2()))&&
				(Character.getBearImg_rightDy1()+45<dy2&&dy2<615)) { //우측 곰 머리~발 아이템 닿으면
			visible=false;
			
			//아이템 사라짐
			g.drawImage(image, 0, 0, 0, 0, 
					imgIndex*width, 0, imgIndex*width+width, 0+height, FightCanvas.getInstacne());
		}else if(visible) 
			g.drawImage(image, dx1, dy1, dx2-45, dy2-45, 
				imgIndex*width, 0, imgIndex*width+width, 0+height, FightCanvas.getInstacne());	
		
		
	}
	
}
