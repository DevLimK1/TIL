package game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game.interFace.Movable;
import game.item.Character;
import game.item.Background;

public class MultiCanvas extends Canvas {

	private static MultiCanvas fightCanvas;

	private Character character;
	private Background background;

	private Movable[] items;
	private int unitIndex = 0;

	public MultiCanvas() {
		fightCanvas = this;

		items = new Movable[100];

		character = new Character();
		background = new Background();

		items[unitIndex++] = background;
		items[unitIndex++] = character;

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int result = e.getKeyCode();

				switch (result) {
				case KeyEvent.VK_LEFT: { // 우측 곰 왼쪽 이동
					character.bearR_moveLeft();
					character.bearR_back();
					break;
				}
				case KeyEvent.VK_RIGHT: { // 우측 곰 오른쪽 이동
					character.bearR_moveRight();
					character.bearR_front();
					break;
				}
				case 65: { // 좌측 곰 왼쪽 이동
					character.bearL_moveLeft();
					character.bearL_back();
					break;
				}
				case 68: { // 좌측 곰 오른쪽 이동
					character.bearL_moveRight();
					character.bearL_front();
					break;
				}

				}// end switch
			}
		});

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println("x : " + x + "   y:  " + y);
			}
		});
	}

	public static MultiCanvas getInstacne() {
		return fightCanvas;
	}

	public void start() {

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					update(); // 단위벡터 단위로 움직임
					fightCanvas.repaint();
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		th.start();
	}

	public void update() {// 단위 이동후업데이트
		for (int i = 0; i < unitIndex; i++)
			items[i].update();
	}

	@Override
	public void update(Graphics g) {
		paint(g);

	}

	@Override
	public void paint(Graphics g) {
		Image buf = createImage(this.getWidth(), this.getHeight());
		Graphics gg = buf.getGraphics();

		for (int i = 0; i < unitIndex; i++)
			items[i].draw(gg);

		g.drawImage(buf, 0, 0, this);

	}

}