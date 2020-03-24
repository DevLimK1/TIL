package shooting.game.item;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.color.ColorSpace;

import shooting.game.ui.IntroCanvas;

public class StartButton implements Movable{
	
	public static final int STATE_CLICK = 2;
	public static final int STATE_ON = 1; //(원래는 X, 지금은 컴파일러가 알아서 생성자에 적절하게 값을 넣어준다.)
	public static final int  STATE_OFF = 0;

	public static final Color COLOR_ON=new Color(255,255,0);
	public static final Color COLOR_OFF=new Color(255,55,0);
	public static final Color COLOR_CLICK=new Color(0,0,20);
	
	
//	static { //원래는 이렇게 static 초기화를 해주는거다. 
//	지금은 버전이 올라가서 컴파일러에서 위에 초기화가 가능함!
//		colorOn=new Color(rgb)
//	}
	private double x;
	private double y;
	private int width;
	private int height;
	
	private int stateValue;
	

	public StartButton() {
		x=130;
		y=600;
		width=100;
		height=50;
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics g) {
		int x=(int)this.x;
		int y=(int)this.y;
		
		Color buttonColor;
		//g.색변경도 가능!
		
		if(stateValue==STATE_ON){
//			buttonColor=new Color(255,0,0);
//			g.setColor(Color.blue);
//			buttonColor=COLOR_ON;
			buttonColor=COLOR_ON;
		}else if(stateValue==STATE_CLICK) {
			buttonColor=COLOR_CLICK;
		}
		else {
//			g.setColor(Color.red);
//			buttonColor=new Color(255,255,0);
//			buttonColor=COLOR_OFF;
			buttonColor=COLOR_OFF;
		}
		
		g.setColor(buttonColor);
		g.fillRoundRect(x, y, 50, 50, 10,10);
		Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
		IntroCanvas.getInstance().setCursor(cursor);
		g.setColor(Color.white);
		g.drawString("눌러봐~", x,y+28 );
//		g.fillRect(x, y, width, height);
//		g.fillOval(x, y, width, height);
	}

	

	public boolean contains(int x2, int y2) {
		if ((x <= x2 && x2 <= x + 50) && (y <= y2 && y2 <= y + 50)) // 범위에 들어오면
			return true;
		return false;
	}

	public void state(int value) {
		this.stateValue=value;
	}
	
}
