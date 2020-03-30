package game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import game.interFace.Movable;
import game.item.Background;
import game.item.Character;
import game.item.Present;
import game.item.Santa;

public class SingleCanvas extends Canvas { // 싱글플레이 vs Ai
	private Random random;

	private Image img;

	private static SingleCanvas singleCanvas;

	private final int P1PUSH = 83;
	private final int P2PUSH = 40;

	private Character character; // 캐릭터(곰)
	private Background background; // 배경화면
	private Santa santa; // 산타클로스
	private Present present; // 선물

	private Movable[] items;
	private int randpush;
	private int max;
	private int santaCnt;// 산타 랜덤 출현 카운트
	private int presentCnt;// 선물 랜덤 출현 카운트
	private int unitIndex = 0;
	private int time1 = 4;
	private int time2 = 10;
	private Image[] numImg;

	public SingleCanvas() {
		numImg = new Image[10];
		try {
			numImg[0] = ImageIO.read(new File("res/images/0.png"));
			numImg[1] = ImageIO.read(new File("res/images/1.png"));
			numImg[2] = ImageIO.read(new File("res/images/2.png"));
			numImg[3] = ImageIO.read(new File("res/images/3.png"));
			numImg[4] = ImageIO.read(new File("res/images/4.png"));
			numImg[5] = ImageIO.read(new File("res/images/5.png"));
			numImg[6] = ImageIO.read(new File("res/images/6.png"));
			numImg[7] = ImageIO.read(new File("res/images/7.png"));
			numImg[8] = ImageIO.read(new File("res/images/8.png"));
			numImg[9] = ImageIO.read(new File("res/images/9.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		singleCanvas = this;

		items = new Movable[100];
		max = 100;
		random = new Random();

		background = new Background();
		character = new Character();
		santa = new Santa();
		present = new Present();

		randompush();
		santaCnt = 200; // 산타 출현 카운트다운
		presentCnt = random.nextInt(200) + 250;// 선물 출현 카운트다운

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

	public static SingleCanvas getInstacne() {
		return singleCanvas;
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
					singleCanvas.repaint();

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

		if (unitIndex >= max) {
			Movable[] temp = new Movable[max + 50];

			for (int i = 0; i < unitIndex; i++)
				temp[i] = items[i];

			items = temp;
			max += 50;
		}

//		System.out.println("santaCnt: "+ santaCnt);
		if (--santaCnt == 0) { // 산타 카운트가 0이면 산타 생성

			santa = new Santa(); // 반복적으로 산타 생성

			items[unitIndex++] = santa;

			santaCnt = 1000;

		} // ~end if

//		System.out.println("presentCnt: "+ presentCnt);
		if (--presentCnt == 0) { // 선물카운트가 0이면 선물 투척

			items[unitIndex++] = santa.throwPresent(); // 산타가 선물 투척

			presentCnt = random.nextInt(400) + 200;
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

	public void timer(Graphics g) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 4; i <= 0; i--) {
					for (int j = 9; j <= 0; j--)
						g.drawImage(numImg[j], 200, 200, SingleCanvas.getInstacne());
				}
			}
		}).start();
	}

}