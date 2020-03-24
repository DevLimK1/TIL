package shooting.game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import shooting.game.item.Movable;
import shooting.game.item.StartButton;

//맵을 여러개 만들려면 canvas를 새로 만들어줘야한다! 
public class IntroCanvas extends Canvas {
	private StartButton startButton;
	private Movable[] items=new Movable[100];
	
	private int unitIndex=0;
	
	private static IntroCanvas introCanvas;
	
	public IntroCanvas() {
		introCanvas=this;
		startButton = new StartButton();
		
		items[unitIndex++] = startButton;
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(startButton.contains(e.getX(), e.getY())){
					startButton.state(StartButton.STATE_CLICK);
					//shootingCanvas로 변경 ->게임프레임이 캔버스를 관리하는게 바람직하다!
					GameFrame.getInstatnce().changeCanvas(2); //클래스 정보를 담고있는 구조체(어떤 메소드,필드를 가지고 있는지 정보를 담고있음
				}
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {// 마우스 움직일 때 좌표
				System.out.printf("mouseMoved: (%d,%d)%n", e.getX(), e.getY());
				if (startButton.contains(e.getX(), e.getY()))
					startButton.state(StartButton.STATE_ON);
		
				else {
					startButton.state(StartButton.STATE_OFF);
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {

			}
		});
		
	}
	
	public static IntroCanvas getInstance() {
		return introCanvas;
	}

	public void start() {
		Thread gameThread = new Thread(new Runnable() { // 새로운 쓰레드 돌아가는 메인함수

			@Override
			public void run() {
				while (true) {
					moveUpdate(); // 단위벡터 단위의 움직임
					IntroCanvas.this.repaint(); // 그냥 repaint(); 라고 써도 된다. 알아서 this 객체를 찾아줌
//					try {
//						Thread.sleep(17);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}

			}
		});

		gameThread.start();
		
	}
	
	//쓰레드에서 돌아가는 update
	public void moveUpdate() { // update -> repaint -> update -> repaint 반복하다가 도착하면 고정->update ->고정 -> update
		for (int i = 0; i < unitIndex; i++) {
			items[i].update(); // 화면의 이동시 변경 후 업데이트 (쓰레드에서 호출됨)
		}
	}
	
	//update-> 밑에 있는 paint 메소드 호출 같이 됨
	@Override
	public void update(Graphics g) { // 화면 지우는 걸 막고자 Canvas 메소드를 오버라이드
		paint(g);
//		super.update(g); //부모를 지우고 paint를 호출하게 되어있다. 지워주면 paint도 호출이 안됨
	}

	
	@Override
	public void paint(Graphics g) { // 어떤게 먼저 draw 되냐가 중요
		//더블 버퍼링 구현!
		Image buf = createImage(this.getWidth(), getHeight()); // 빈 이미지를 만든거임
		Graphics gg = buf.getGraphics(); 

		// 모든 유닛은 이미지 버퍼에 그림을 그리게 하고
		for (int i = 0; i < unitIndex; i++) {
//			items[i].draw(g); //화면 버퍼 g를 넘겨준다.
			items[i].draw(gg);
		}

		// 모든 그림이 다 그려지면? 이제 한번만,,,화면 버퍼에 그리자
		g.drawImage(buf, 0, 0, this);

	}

}
