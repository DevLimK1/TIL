package omok.game.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import omok.game.ui.OmokCanvas;


public class Omok {
	//흰 오목알 ,검은 오목알은 boolean으로 하는 것 보다(참 거짓이 아니기 때문)는
	//정수형으로 구분하는게 좋다.
	private static final int WHITE;
	private static final int BLACK;
	
	private int color=BLACK;
	private double x,y;
	
	private double dx; //목적지
	private double dy;
	private double vx; //벡터, 이동단위 변화랑
	private double vy;
	
	private static int width;
	private static int height;
	
	private static boolean isBlackTurn; //흰돌 검은돌 상태변화 sol1
	private static int turn;//흰돌 검은돌 상태변화 sol2
	
	private static Image imgWhite; //흰돌 이미지
	private static Image imgBlack; //검은돌 이미지
	
	
	//전역변수들만 초기화
	static {
		isBlackTurn=true;
		turn =0; //0이면 BLACK , 1이면 WHITE 
		try {
			imgWhite=ImageIO.read(new File("res/images/white.png"));
			imgBlack=ImageIO.read(new File("res/images/black.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		width=imgWhite.getWidth(OmokCanvas.getInstance()); //ImageObserver(this)는 Canvas 클래스내에서 혹은 상속받은 상태에서 가능
		height=imgBlack.getHeight(OmokCanvas.getInstance());
//		System.out.println("omok width:"+width);
//		System.out.println("omok height:"+height);
		WHITE=1;
		BLACK=2;
	}
	
	public Omok() {
		this(0,0);
//		color=BLACK;
	}

	public Omok(int x, int y) {
		
		
		/////////////////////////////////
		//Sol1)검은돌, 흰돌 색상교환
		Omok.turn++;
		Omok.turn%=2;
		
		//Sol2)
		isBlackTurn=!isBlackTurn; 
		
		/////////////////////////////////
		
		this.x=x;
		this.y=y;
		System.out.println("오목 클릭 x:"+x);
		System.out.println("오목 클릭 y:"+y);
		
		if(isBlackTurn)
			this.color=BLACK;
		else 
			this.color=WHITE;
		
	}

	public void draw(Graphics g) {
		
		/////////////////////////////////////////////////
		//오목알 중심점을 가운데로 옮기게 offset을 둔다
		//Sol1)
//		int offsetX = width / 2; // 오목알이미지의 x축 중심점 이동위해서 선언
//		int offsetY = height / 2; // 오목알이미지의 y축 중심점 이동위해서 선언
//		int dx1 = (int) (x - offsetX);
//		int dy1 = (int) (y - offsetY);
//		int dx2 = (int) (x+width - offsetX);
//		int dy2 = (int) (y + height - offsetY);
//		
//		g.drawImage(imgBlack,dx1,dy1, dx2,dy2, 
//				0,0, width, height, OmokCanvas.getInstance());
		
		
		//Sol2)
		int offset = width/2;
		Image tempImage=imgBlack;
		
		if(color==WHITE) {
			tempImage=imgWhite;
		}
		
		int x= (int)(this.x-offset);
		int y= (int)(this.y-offset);
		
		g.drawImage(tempImage,x,y,OmokCanvas.getInstance());
		//////////////////////////////////////////////////////////
	
	}

	public void setX(int x) {
		this.x=x;
	}

	public void setY(int y) {
		this.y=y;
	}

	public void update() {
		if(dx==x&&dy==y) {
			vx=0;
			vy=0;
		}
		this.x+=vx;
		this.y+=vy;
	}

	public void move(int x, int y) {
		this.dx=x; //클릭한 목적지 정해줌
		this.dy=y;//클릭한 목적지 정해줌
		
		//빗변의 길이를 구하기 위해서는 너비와 높이를 알아야한다. 피타고라스 정리 이용
		
		double width=dx-this.x;
		double height=dy-this.y;
		double distance = Math.sqrt(width*width+height*height); //빗변
		
		vx=width/distance; //1배속
		vy=height/distance;
		
	}
	
}
