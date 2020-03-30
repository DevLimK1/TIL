package game.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import game.interFace.Movable;
import game.ui.FightCanvas;

public class Santa implements Movable{

	private static Image image;
	
	private Present present;
	
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
	
	
	static { //함수 호출과 상관없이 프로그램이 실행되면서 한번 초기화됨 
		try {
			image=ImageIO.read(new File("res/images/santaMove.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public Santa() {
		
		timeout=3;
		Random random=new Random();
		
//		width=(image.getWidth(FightCanvas.getInstacne()))/7; //ImageObserver(this)는 Canvas 클래스내에서 혹은 상속받은 상태에서 가능
		height=image.getHeight(FightCanvas.getInstacne());
		width=324;
		
		x=1300;
		y=100;
		
//		vy=random.nextInt(5)+1;
		vx=2;
		
		speed=1;
		imgIndex=0;
	}
	
	public Present throwPresent() { //선물 던지는 메소드
		return new Present(x);
	}

	public double getX() {
		return x;
	}
	
	@Override
	public void update() {
		this.x-=vx;
		
		if (timeout-- == 0) { //산타 출현 간격
			imgIndex++;
			imgIndex %= 7; // 0~11까지 -> 이미지 인덱스가 바뀌면서 ufo가 회전하게됨
			timeout=40;
		}
	}

	@Override
	public void draw(Graphics g) {//그림이 그려질 객체는 다 포함되어야 할 메소드
		int offsetX = width / 2; // 이미지의 x축 중심점 이동위해서 선언
		int offsetY = height / 2; // 이미지의 y축 중심점 이동위해서 선언
		int dx1 = (int) (x - offsetX);
		int dy1 = (int) (y - offsetY);
		int dx2 = (int) (x+width - offsetX);
		int dy2 = (int) (y + height - offsetY);
		
//		System.out.println(width);
//		System.out.println(height);
		
		g.drawImage(image, dx1, dy1, dx2, dy2, 
				imgIndex*width, 0, imgIndex*width+width, 0+height, FightCanvas.getInstacne());
		
	}
	
	
	
}
