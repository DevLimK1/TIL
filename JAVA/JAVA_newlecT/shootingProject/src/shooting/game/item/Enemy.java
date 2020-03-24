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
			image=ImageIO.read(new File("res/images/alien.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Enemy() { //Enemy Constructor
		timeout=3;
		Random random=new Random();
		width=(image.getWidth(ShootingCanvas.getInstance()))/12; //ImageObserver(this)는 Canvas 클래스내에서 혹은 상속받은 상태에서 가능
		height=image.getHeight(ShootingCanvas.getInstance());
		
		height=34;
		
		x=random.nextInt(360)+1;
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
	
	public void move(double dx, double dy) {
		this.dx=dx; //목표점이 됨
		this.dy=dy;
//		vx=(dx-x)/15; //15step에 동일하게 해당 위치에 도착한다. 즉, 멀리에 클릭하면 빠르게 움직이고, 가까이서 클릭하면 느리게 움직인다.
//		vy=(dy-y)/15;
		
		double w=dx-x;
		double h=dy-y;
		double d=Math.sqrt(w*w+h*h);
		vx=w/d * speed;
		vy=h/d * speed;
	}
	
	public Bullet fire() {
		
		return null;
	}
	
	public void explode() {
		
	}
	@Override
	public void update() {
		
		// this.timeout=3;
		if (timeout-- == 0) {
			imgIndex++;
			imgIndex %= 12; // 0~11까지 -> 이미지 인덱스가 바뀌면서 ufo가 회전하게됨
			timeout=3;
		}
	}
	
}
