package shooting.game.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import shooting.game.ui.ShootingCanvas;

public class Space implements Movable {
	private static Image image;
	private double y; //이동 y좌표
	private double vy;
	private double dy;
	private double y2;
	
	private int width;
	private int height;
	private int imgIndex;
	
	public Space() {
		try {
			image=ImageIO.read(new File("res/images/space.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		y=-1200;
		vy=1;
		
		
		width=image.getWidth(ShootingCanvas.getInstance()); //ImageObserver(this)는 Canvas 클래스내에서 혹은 상속받은 상태에서 가능
		height=image.getHeight(ShootingCanvas.getInstance());
		System.out.println("fighter width: "+width);
		System.out.println("fighter height: "+height);
		
		
	}
	
	public void draw(Graphics g) { //그림이 그려질 객체는 다 포함되어야 할 메소드, 화면 갱신
//		g.drawImage(image, 300, 600, 300+width, 600+height, 
//				0, 0, 64, 64, ShootingCanvas.getInstance());ㅇ
		g.drawImage(image,0,(int)y, 
				ShootingCanvas.getInstance());
		g.drawImage(image,0,(int)y+1200, 
				ShootingCanvas.getInstance());
		if(y==0) {
			y=-1200;
		}
//		System.out.println("y="+y);
//		System.out.println("y+1200="+(y+1200));
	}
	
	@Override
	public void update() {
		this.y+=vy;
//		if(y==0) {
//			y=-500;
//		}
//		System.out.println(y);
	}

	
	
	public void show() {
		
	}
	
	
	
	public void explode() {
			
	}
	
	public static int getWidth() {
		return image.getWidth(ShootingCanvas.getInstance()); //ImageObserver(this)는 Canvas 클래스내에서 혹은 상속받은 상태에서 가능
		
	}
	public static int getHeight() {
		return image.getHeight(ShootingCanvas.getInstance());
	}
	
	
	
}
