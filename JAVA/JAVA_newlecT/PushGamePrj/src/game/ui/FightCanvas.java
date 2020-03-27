package game.ui;

import java.awt.Canvas;
import java.awt.Frame;
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

import game.button.BackButton;
import game.interFace.Movable;
import game.item.Background;
import game.item.Character;
import game.item.Present;
import game.item.Santa;

public class FightCanvas extends Canvas {
	private Random random;

	private Image img;

	private GameFrame gameFrame;
	private Frame frame;

	private static FightCanvas fightCanvas;
	private static IntroCanvas introCanvas;
	
	private Character character; // 캐릭터(곰)
	private Background background; // 배경화면
	private Santa santa; // 산타클로스
	private Present present; // 선물
	private BackButton backButton; // 뒤로가기 버튼
	

	private Movable[] items;

	private final int P1PUSH = 83;
	private final int P2PUSH = 40;
	
	private int max;
	private int santaCnt;// 산타 랜덤 출현 카운트
	private int presentCnt;// 선물 랜덤 출현 카운트 
	private int unitIndex = 0;

	public FightCanvas() {
		random = new Random();
		
		try {
			img=ImageIO.read(new File("res/images/fallbear.png"));//(미완성)물에 빠진 곰 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fightCanvas = this;

		items = new Movable[100];

		max = 100;

		background = new Background();
		character = new Character();
		backButton = new BackButton();
		
		santaCnt = 200; // 산타 출현 카운트다운
 		presentCnt = random.nextInt(200) + 250;//선물 출현 카운트다운

		items[unitIndex++] = background;
		items[unitIndex++] = character;
		items[unitIndex++] = backButton;

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int result = e.getKeyCode();

				switch (result) {
				case KeyEvent.VK_ESCAPE: {// esc클릭시 게임 일시정지
//					character.pause();
					break;
				}
				case KeyEvent.VK_LEFT: {// 방향키 좌
					character.bearR_moveLeft();
					character.bearR_back();
					break;
				}
				case KeyEvent.VK_RIGHT: {// 방향키 우
					character.bearR_moveRight();
					character.bearR_front();
					break;
				}
				case 65: {// A키 p1 왼쪽이동
					character.bearL_moveLeft();
					character.bearL_back();
					break;
				}
				case 68: {// D키 p1 오른쪽 이동
					character.bearL_moveRight();
					character.bearL_front();
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
				} // end switch
			} // end keyPressed
		});

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if ((x > 1350 && x < 1416) && (y > 650 && y < 712))//뒤로가기 버튼
				{
					GameFrame.getInstance().changeCanvas(3);
				}
			}
			
			@Override
			public void mouseMoved(MouseEvent e) {
				
			}
		});

	} // end public FightCanvas()
	
	public void state(int stateValue) {
	}
	public static FightCanvas getInstacne() {
		return fightCanvas;
	}
	public static IntroCanvas getInstance() {
		return introCanvas;
	}

	public void start() {

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
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
		
		if (unitIndex >= max) {
			Movable[] temp = new Movable[max + 50];

			for (int i = 0; i < unitIndex; i++)
				temp[i] = items[i];

			items = temp;
			max += 50;
		}
		
		if (--santaCnt == 0) { //산타 카운트가 0이면 산타 생성

			santa = new Santa(); // 반복적으로 산타 생성
			
		
		
			items[unitIndex++] = santa;
		
			santaCnt = 1000;

		} // ~end if
		
		if (--presentCnt == 0) { //선물카운트가 0이면 선물 투척
			
			items[unitIndex++] = santa.throwPresent(); //산타가 선물 투척
			
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

}