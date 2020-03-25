package shooting.game.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import shooting.game.ui.ShootingCanvas;

public class Fighter implements Movable{
	//부모(GameUnit)로부터 물려 받는 속성
	
	
	private static Image image;
	private double x; //이동 x좌표
	private double y; //이동 y좌표
	private double vx; //이동할 단위 위치
	private double vy;
	private double dx; //목적지 위치
	private double dy;
	
	private int d; //방향을 나타내는 변수
	
	private int speed;
	private int width;
	private int height;
	private int imgIndex;
	
	private static final int N=1;
	private static final int E=2;
	private static final int S=4;
	private static final int W=8;
	
	
	static { //함수 호출과 상관없이 프로그램이 실행되면서 한번 초기화됨 
		try {
			image=ImageIO.read(new File("res/images/fighter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Fighter() {
		
		
		width=(image.getWidth(ShootingCanvas.getInstance())/7); //ImageObserver(this)는 Canvas 클래스내에서 혹은 상속받은 상태에서 가능
		height=image.getHeight(ShootingCanvas.getInstance());
//		System.out.println("fighter width: "+width);
//		System.out.println("fighter height: "+height);
		x=300;
		y=500;
		imgIndex=3;
		speed=5;
		
	}
	
	public void draw(Graphics g) { //그림이 그려질 객체는 다 포함되어야 할 메소드
//		g.drawImage(image, 300, 600, 300+width, 600+height, 
//				0, 0, 64, 64, ShootingCanvas.getInstance());ㅇ
		
		if ((d & W) == W) { //왼쪽키가 눌림
			x-=speed;
			if(imgIndex>0)
				imgIndex--;
			if(x<0)
				x=0;
		}

		if ((d & E) == E) { //오른쪽키가 눌림
			x+=speed;
			if(imgIndex<6)
				imgIndex++;
			if(x>Space.getWidth())
				x=Space.getWidth();
		}

		if ((d & N) == N) { //위쪽키가 눌림
			y-=speed;
			if(y<0)
				y=0;
		}

		if ((d & S) == S) { //아래키가 눌림
			y+=speed;
			if(y>650)
				y=650;
			
		}
//		System.out.println(x);
//		System.out.println(y);
		int offsetX = width / 2; // 전투기이미지의 x축 중심점 이동위해서 선언
		int offsetY = height / 2; // 전투기이미지의 y축 중심점 이동위해서 선언
		int dx1 = (int) (x - offsetX);
		int dy1 = (int) (y - offsetY);
		int dx2 = (int) (x+width - offsetX);
		int dy2 = (int) (y + height - offsetY);
		
		g.drawImage(image,dx1,dy1, dx2,dy2, 
				imgIndex*width,0, imgIndex*width+width, 0+height, ShootingCanvas.getInstance());
		
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

	public void update() { // 애니매이션 필요한 애들은 있어야하는 메소드, update가 항상 바꾸는 역할을 한다
		//범위 블럭을 넘어서려면 벡터를 0으로 해야한다.(더이상 움직이지않게)
//		System.out.printf("(dx,x) : (%f,%f)",dx,x);
//		System.out.printf("(dy,y) : (%f,%f)\n",dy,y);
		
		if (
				(dx - speed <= x && x <= dx + speed) && 
				(dy - speed <= y && y <= dy + speed)) {
			vx = 0;
			vy = 0;
		}

		this.x += vx;
		this.y += vy;
	}
	
	
	public void show() {
		
	}
	
	
	
	public void explode() {
			
	}


	public Missile fire() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void standardImage() {
		imgIndex=3;
	}

	public void move(int d) { //8가지 방향 좌표(동서남북..)
		this.d=d;
	}
	
}

