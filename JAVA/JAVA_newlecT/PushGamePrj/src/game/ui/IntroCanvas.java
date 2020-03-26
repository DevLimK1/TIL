package game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import game.button.ExitButton;
import game.button.HelpButton;
import game.button.MultiButton;
import game.button.SingleButton;
import game.interFace.Movable;

public class IntroCanvas extends Canvas {
	private static IntroCanvas canvas;
	private StartView startView;

	private SingleButton singleButton;
	private MultiButton multiButton;
	private ExitButton exitButton;
	private HelpButton helpButton;

	private Movable[] items;
	private int unitIndex = 0;

	public IntroCanvas() {
//		Music gymMusic = new Music("introBGM.mp3", true);
//		gymMusic.start();
		items = new Movable[100];

		singleButton = new SingleButton();
		startView = new StartView();
		multiButton = new MultiButton();
		exitButton = new ExitButton();
		helpButton = new HelpButton();

		items[unitIndex++] = startView;
		items[unitIndex++] = singleButton;
		items[unitIndex++] = multiButton;
		items[unitIndex++] = exitButton;
		items[unitIndex++] = helpButton;

		this.addMouseListener(new MouseAdapter() { // 마우스클릭
			@Override
			public void mouseClicked(MouseEvent e) {
				if (singleButton.contatins(e.getX(), e.getY())) {
					singleButton.state(singleButton.STATE_CLICK);
					GameFrame.getInstance().changeCanvas(1);
				} else if (multiButton.contatins(e.getX(), e.getY())) {
					multiButton.state(multiButton.STATE_CLICK);
					GameFrame.getInstance().changeCanvas(2);
				} else if (exitButton.contatins(e.getX(), e.getY())) {
					exitButton.state(ExitButton.STATE_CLICK);
					System.exit(0);
				} else if (helpButton.contatins(e.getX(), e.getY())) {
					helpButton.state(HelpButton.STATE_CLICK);
					JOptionPane.showMessageDialog(IntroCanvas.this, " 　　　　　　　　♬♪ How to Play ♪♬\r\n" + " \n"
							+ "1. Start 버튼을 누르면 게임 시작을 합니다. \r\n" + "◆ 게임 조작 방법 \r\n"
							+ "   - Single 버튼 혹은 Multi 버튼을 누릅니다. \r\n" + "  ▶ Single Play \r\n"
							+ "   - 게임 시간은 45초 입니다.\r\n" + "   - 화살표 키를 이용하여 벽을 상대편 끝까지 밀면 게임을 승리합니다. \r\n"
							+ "   - 아이템은 랜덤으로 얻을 수 있으며, 즉시 사용됩니다. \r\n" + "   -  \r\n" + "  ▶ Multi Play\r\n"
							+ "   - 게임 시간은 45초 입니다.\r\n" + "   - Player 1 게임 작동 키는 키보드 화살표로 작동합니다.\r\n"
							+ "   - Player 2 게임 작동 키는 키보드 a(왼쪽), d(오른쪽)로 작동합니다.\r\n"
							+ "   - 아이템은 랜덤으로 얻을 수 있으며, 즉시 사용됩니다. \r\n" + "2. Record 버튼을 누르면 랭킹기록을 확인이 가능합니다.\r\n"
							+ "3. Exit 버튼 누르면 게임이 종료 됩니다.\r\n" + " \n" + "　　　　　　　　　　WISH TO LUCK ! \r\n");
					return;
				}

			}
		});

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (singleButton.contatins(e.getX(), e.getY())) {
					singleButton.state(singleButton.STATE_PRESS);
				} else if (multiButton.contatins(e.getX(), e.getY())) {
					multiButton.state(multiButton.STATE_PRESS);
				} else if (exitButton.contatins(e.getX(), e.getY())) {
					exitButton.state(ExitButton.STATE_PRESS);
				}
			}
		});

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (singleButton.contatins(e.getX(), e.getY())) {
					singleButton.state(singleButton.STATE_RELEASE);

				}
				if (multiButton.contatins(e.getX(), e.getY())) {
					multiButton.state(multiButton.STATE_RELEASE);
				}
				if (exitButton.contatins(e.getX(), e.getY())) {
					exitButton.state(ExitButton.STATE_RELEASE);
				}
			}

		});

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {

				System.out.printf("(%d, %d)\n", e.getX(), e.getY());// 마우스 움직이면 좌표 보여줌

				if (singleButton.contatins(e.getX(), e.getY())) // SingleButton
					singleButton.state(singleButton.STATE_ON);
				else if (!(singleButton.contatins(e.getX(), e.getY())))
					singleButton.state(singleButton.STATE_OFF);

				if (multiButton.contatins(e.getX(), e.getY())) // MultiButton
					multiButton.state(multiButton.STATE_ON);
				else if (!(multiButton.contatins(e.getX(), e.getY())))
					multiButton.state(multiButton.STATE_OFF);

				if (exitButton.contatins(e.getX(), e.getY())) // ExitButton
					exitButton.state(ExitButton.STATE_ON);
				else if (!(exitButton.contatins(e.getX(), e.getY())))
					exitButton.state(ExitButton.STATE_OFF);

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}

	public static IntroCanvas getInstance() {
		return canvas;
	}

	public void start() {
		Thread gameThread = new Thread(new Runnable() {

			@Override
			public void run() { // gameThread.start() 호출하면 실행됨
				while (true) {
					update(); // 단위벡터 단위의 움직임, 점진적인 업데이트
					repaint();

					try {
						Thread.sleep(17); // 60프레임 맞추기 위함 (1초에 60번 돌기)
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();

	}

	public void update() {
		for (int i = 0; i < unitIndex; i++)
			items[i].update();
	}

	@Override
	public void update(Graphics g) { // 화면 깜빡이지 않게 하기 위하여 부모의 update는 실행하지 않고 paint 바로 실행
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		Image buf = createImage(this.getWidth(), this.getHeight());
		Graphics gg = buf.getGraphics();

		// 모든 유닛은 이미지 버퍼에 그림을 그리게 하고
		for (int i = 0; i < unitIndex; i++)
			items[i].draw(gg);

		// 모든그림이 다그려지면 한번만 화면 버퍼에 그리자.
		g.drawImage(buf, 0, 0, this);
	}

}
