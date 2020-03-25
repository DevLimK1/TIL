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
	private int x,y;
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
		g.drawImage(tempImage,x-offset,y-offset,OmokCanvas.getInstance());
		//////////////////////////////////////////////////////////
	
	}
	
}
