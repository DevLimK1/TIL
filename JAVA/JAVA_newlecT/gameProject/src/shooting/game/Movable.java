package shooting.game;

import java.awt.Graphics;

public interface Movable { //일괄 참조와 일괄 사용해야하는 클래스

	public abstract void update();

	public abstract void draw(Graphics g);

}
