package shooting.game;

import java.awt.Frame;
import java.awt.Graphics;

import shooting.game.ui.GameFrame;

//import puzzlegame.GameFrame;

public class Program {
	public static void main(String[] args) {
		Frame frame = new GameFrame();
		frame.setVisible(true);
		frame.setSize(700, 700);
	}
	
	public void draw(Graphics g) { //그림이 그려질 객체는 다 포함되어야 할 메소드
		
	}
}
