package shooting.game.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import shooting.game.ui.ShootingCanvas;

//랜덤으로 띄우기 구현하기

public class Enemy implements Movable{
	private static Image image;
	private int x;
	private int y;
	private int width;
	private int height;
	
	private int imgIndex;
	private int speed;
	
	
	static { //함수 호출과 상관없이 프로그램이 실행되면서 한번 초기화됨 
		try {
			image=ImageIO.read(new File("res/images/alien.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Enemy() { //Enemy Constructor
		
		width=(image.getWidth(ShootingCanvas.getInstance()))/12; //ImageObserver(this)는 Canvas 클래스내에서 혹은 상속받은 상태에서 가능
		height=image.getHeight(ShootingCanvas.getInstance());
		
		
		Random random=new Random();
		
		x=random.nextInt(200)+10;
		y=200;
		speed=1;
		imgIndex=0;
//		System.out.println("enemy width: "+ width);
//		System.out.println("enemy height: "+height);
		
		
	}
	
	public void draw(Graphics g) { //그림이 그려질 객체는 다 포함되어야 할 메소드
		int offsetX = width / 2; // 전투기이미지의 x축 중심점 이동위해서 선언
		int offsetY = height / 2; // 전투기이미지의 y축 중심점 이동위해서 선언
		int dx1 = (int) (x - offsetX);
		int dy1 = (int) (y - offsetY);
		int dx2 = (int) (x+width - offsetX);
		int dy2 = (int) (y + height - offsetY);
		
		
		
		g.drawImage(image, dx1, dy1, dx2, dy2, 
				imgIndex*width, 0, imgIndex*width+width, 0+height, ShootingCanvas.getInstance());
		
		
	}
	
	public void show() {
		
	}
	
	public void move() {
		
	}
	
	public Bullet fire() {
		
		return null;
	}
	
	public void explode() {
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
