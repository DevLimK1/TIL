package game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import game.interFace.Movable;
import game.item.Background;
import game.item.Character;
import game.item.Present;
import game.item.Santa;

public class RandomFight extends Canvas {
	private Random random;

	private Image img;

	private static RandomFight randomFight;

	private final int P1PUSH = 83;
	private final int P2PUSH = 40;

	private Character character; // 캐릭터(곰)
	private Background background; // 배경화면
	private Santa santa; // 산타클로스
	private Present present; // 선물

	private Movable[] items;
	private int randpush;
	private int max;
	private int countdown; // 산타 랜덤 출현 카운트
	private int unitIndex = 0;

	public RandomFight() {
		try {
			img = ImageIO.read(new File("res/fallbear.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		randomFight = this;

		items = new Movable[100];
		max = 100;
		random = new Random();

		background = new Background();
		character = new Character();
		santa = new Santa();
		present = new Present();

		randompush();
		countdown = 700; // 산타 출현 카운트다운
//		System.out.println(countdown);
//		countdown=random.nextInt(120)+60; 60초~180초 
		// 산타가 선물 던지는 거 구현해야함
		// present = new Present(santa.getX());

		items[unitIndex++] = background;
		items[unitIndex++] = character;
		items[unitIndex++] = santa;
		items[unitIndex++] = present;
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int result = e.getKeyCode();
				System.out.println(result);
				switch (result) {
				case 65: {// A키 p1 왼쪽이동
					character.bearL_moveLeft();
					character.bearL_back();
					break;
				}
				case KeyEvent.VK_SPACE: {// D키 p1 오른쪽 이동
					character.bearL_moveRight();
					character.bearL_front();
					break;
				}
//				case 107: {// D키 p1 오른쪽 이동
//					character.aiSpeedUp();
//					break;
//				}
//				case 109: {// D키 p1 오른쪽 이동
//					character.aiSpeedDown();
//					break;
//				}
//				case P1PUSH: {// 1p 밀기 보조키
//					character.bearL_moveRight();
//					break;
//				}
				} // end switch
			} // end keyPressed
		});

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println("x : " + x + "   y:  " + y);
			}
		});

	} // end public FightCanvas()

	public static RandomFight getInstacne() {
		return randomFight;
	}

	public void randompush() {
		Thread randth = new Thread(new Runnable() {
			Random rand = new Random();
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(120);
						character.aivx();
//						if(i>10) {
//							character.aiSpeedUp();
//						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		randth.start();
	}

	public void start() {

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					moveUpdate(); // 단위벡터 단위로 움직임
					randomFight.repaint();

//					character.bearR_moveLeft();
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

			santa = new Santa(); // 반복적으로 산타 생성
			present = new Present(santa.getX()); // 반복적으로 선물 생성

			if (unitIndex >= max) {
				Movable[] temp = new Movable[max + 50];

				for (int i = 0; i < unitIndex; i++)
					temp[i] = items[i];

				items = temp;
				max += 50;
			}

			items[unitIndex++] = santa;
//			items[unitIndex++] = present;
			random = new Random();
//			countdown = random.nextInt(120) + 60;
			countdown = 700;
		}
	}

	@Override
	public void update(Graphics g) { // 화면 지우기
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		Image buf = createImage(this.getWidth(), this.getHeight()); // 더블 버퍼링 구현
		Graphics gg = buf.getGraphics();

		for (int i = 0; i < unitIndex; i++) {
			items[i].draw(gg);
		}

		g.drawImage(buf, 0, 0, this);

	}

}