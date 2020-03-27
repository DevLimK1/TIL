package game.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.interFace.Movable;
import game.ui.FightCanvas;

public class Present implements Movable { //산타가 던지는 선물 아이템
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
	
	static { //함수 호출과 상관없이 프로그램이 실행되면서 한번 초기화됨 
		try {
			image=ImageIO.read(new File("res/images/present.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Present() {
		
		x=1430;
		y=71;
		
		vx=2;
		vy=2;
		
		speed=1;
		imgIndex=0;
		
	}

	public Present(double x) { //산타 있는 x좌표
		
		width=image.getWidth(FightCanvas.getInstacne()); //ImageObserver(this)는 Canvas 클래스내에서 혹은 상속받은 상태에서 가능
		height=image.getHeight(FightCanvas.getInstacne());
		
		
		this.x=x+50;
		y=71;
		
//		vx=2;
		vy=2;
		imgIndex=0;
	}

	@Override
	public void update() {
		if(y==565) { //빙하 필드위에 떨어지면 멈춤
			vy=0;
			vx=0;
		}
		
		this.x-=vx;
		this.y+=vy;
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
		
		g.drawImage(image, dx1, dy1, dx2-45, dy2-45, 
				imgIndex*width, 0, imgIndex*width+width, 0+height, FightCanvas.getInstacne());
				
	}
	
	
}
