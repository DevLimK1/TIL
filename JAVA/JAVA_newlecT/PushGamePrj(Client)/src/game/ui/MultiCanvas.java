package game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import game.interFace.Movable;
import game.item.Background;
import game.item.Character;

public class MultiCanvas extends Canvas {

	private static MultiCanvas multicanvas;

	private Character character;
	private Background background;
	private int result = 0;
	private Movable[] items;
	private int unitIndex = 0;
	private Socket clientSocket;

	public MultiCanvas() {
		multicanvas = this;

		items = new Movable[100];

		character = new Character();
		background = new Background();

		items[unitIndex++] = background;
		items[unitIndex++] = character;

		new Thread(new Runnable() {
			public void run() {
				try {
					clientSocket = new Socket("221.207.129.245", 8888);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new Thread(new Runnable() {

					@Override
					public void run() {
						// Client player2
						while (true) {
							int value;
							try {
								value = clientSocket.getInputStream().read();
								if (value == 32) {
									character.bearL_moveRight();
									character.bearL_front();
								} else if (value == 37) {
									character.bearL_moveLeft();
									character.bearL_back();
								}

							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		}).start();

		// enemyMove();
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				result = e.getKeyCode();

				try {
					clientSocket.getOutputStream().write(result);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				;

				System.out.println(result);
				switch (result) {
				case KeyEvent.VK_SPACE: { // 좌측 곰 오른쪽 이동
					character.bearR_moveLeft();
					character.bearR_front();
					break;
				}
				case KeyEvent.VK_RIGHT: { // 좌측 곰 왼쪽 이동
					character.bearR_moveRight();
					character.bearR_back();
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
		return multicanvas;
	}

	public void start() {

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					update(); // 단위벡터 단위로 움직임
					multicanvas.repaint();

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