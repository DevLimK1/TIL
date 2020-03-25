package omok.game;

import java.awt.Frame;

import omok.game.ui.OmokFrame;

public class Program {
	public static void main(String[] args) {
		Frame frame=new OmokFrame();//Frame 범주안에서만 쓴다는 상황이라면 특정 OmokFrame 참조변수를 쓸 필요없음
//		frame.setVisible(true);
//		frame.setSize(760,760);
	}
}
