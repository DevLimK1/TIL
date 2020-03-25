package game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import game.interFace.Movable;
import game.item.Background;
import game.item.Character;
import game.item.Santa;

public class FightCanvas extends Canvas {
	private static FightCanvas fightCanvas;
	private Character character;
	private Background background;
	private Santa santa;
	private Movable[] items;
	private final int P1PUSH = 83;
	private final int P2PUSH = 40;

	private Random random;

	private int max;
	private int countdown; // 산타 랜덤 출현
	private int unitIndex = 0;

	public FightCanvas() {
		fightCanvas = this;

		items = new Movable[100];

		max = 100;
		random = new Random();
//		countdown=random.nextInt(120)+60; 60초~180초 
		countdown = 500; // 산타 출현 카운트다운

		background = new Background();
		character = new Character();
		santa = new Santa();

		items[unitIndex++] = background;
		items[unitIndex++] = character;
		items[unitIndex++] = santa;

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int result = e.getKeyCode();

				switch (result) {
				case KeyEvent.VK_ESCAPE: {// esc클릭시 게임 일시정지
					character.pause();
					break;
				}
				case KeyEvent.VK_LEFT: {// 방향키 좌
					character.bearR_moveLeft();
					break;
				}
				case KeyEvent.VK_RIGHT: {// 방향키 우
					character.bearR_moveRight();
					break;
				}
				case 65: {// A키 p1 왼쪽이동
					character.bearL_moveLeft();
					break;
				}
				case 68: {// D키 p1 오른쪽 이동
					character.bearL_moveRight();
					break;
				}
				case P1PUSH: {// 1p 밀기 보조키
					character.bearL_moveRight();
					break;
				}
				case P2PUSH: {
					character.bearR_moveLeft();
					break;
				}
				}
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

	public static FightCanvas getInstacne() {
		return fightCanvas;
	}

	public void start() {

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					moveUpdate(); // 단위벡터 단위로 움직임
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

	public void moveUpdate() {// 단위 이동후업데이트
		for (int i = 0; i < unitIndex; i++) {
			items[i].update(); // 화면의 이동시 변경 후 업데이트 (쓰레드에서 호출됨)
		}

		if (--countdown == 0) {

			santa = new Santa();

			if (unitIndex >= max) {
				Movable[] temp = new Movable[max + 50];
//				temp<-items;
				for (int i = 0; i < unitIndex; i++) {
					temp[i] = items[i];
				}

				items = temp;
				max += 50;
			}

			items[unitIndex++] = santa;
			random = new Random();
//			countdown = random.nextInt(120) + 60;
			countdown = 500;
		}
	}

	@Override
	public void update(Graphics g) { // 화면 지우기
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		Image buf = createImage(this.getWidth(), this.getHeight());
		Graphics gg = buf.getGraphics();

		for (int i = 0; i < unitIndex; i++) {
			items[i].draw(gg);
		}

		g.drawImage(buf, 0, 0, this);

	}

}