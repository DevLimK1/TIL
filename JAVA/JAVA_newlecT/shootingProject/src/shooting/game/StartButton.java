package shooting.game;

import java.awt.Color;
import java.awt.Graphics;

public class StartButton implements Movable{
	
	private double x;
	private double y;
	private int width;
	private int height;

	public StartButton() {
		x=100;
		y=100;
		width=150;
		height=50;
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics g) {
		int x=(int)this.x;
		int y=(int)this.y;
		//g.색변경도 가능!
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		
	}
	
}
