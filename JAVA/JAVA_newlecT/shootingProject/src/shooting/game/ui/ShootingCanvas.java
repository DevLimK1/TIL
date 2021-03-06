package shooting.game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import shooting.game.item.Enemy;
import shooting.game.item.Fighter;
import shooting.game.item.Missile;
import shooting.game.item.Movable;
import shooting.game.item.Space;

//그림 그리는 로직 짜는 클래스
public class ShootingCanvas extends Canvas {

	
	private Space space;
	private Fighter fighter;
	private Enemy enemy;
	private Movable[] items; // space,fighter,enemy의
	// moving하는 것에 대해 일괄 관리할 수 있는 추상화클래스(Movable 클래스)로 관리한다.

	private int max;
	private int unitIndex = 0;
	private int countdown; //적기 랜덤 출현

	private static final int N=1;
	private static final int E=2;
	private static final int S=4;
	private static final int W=8;
	
	private int d=0;
	
	//게임을 구성하는 속성은 아님.. 다만 효율성을 위한 꼼수?
	private Random random;
	
	private static ShootingCanvas shootingCanvas;

	public ShootingCanvas() {

		shootingCanvas = this;
		
		random=new Random();
		countdown=random.nextInt(120)+60;
		
		fighter = new Fighter();
		space = new Space();
		enemy=new Enemy();
		
		max=100;
		items = new Movable[max];

		// 나타내는 순서가 중요함(계층별로 보인다고 생각)
		items[unitIndex++] = space;
		items[unitIndex++] = fighter;
		items[unitIndex++] = enemy;
		

		this.addMouseListener(new MouseAdapter() { // MouseAdapter:더미 클래스

			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.printf("(x,y) : (%d,%d)\n", e.getX(), e.getY());
				fighter.move(e.getX(), e.getY());
				ShootingCanvas.this.repaint();
			}

		});

		this.addKeyListener(new KeyAdapter() { // Keyboard Listener
			// 눌리고 떼질 때 구분이 없을 때 keyTyped

			// 캔버스를 한번 눌러주고 키보드 입력이 되는 것은
			// 윈도우가 여러창이어서 해당 캔버스를 클릭해주는 작업이 필요한거임
			// 나중에 캔버스 자체 인식해주는 기능을 구현할거임

			@Override
			public void keyPressed(KeyEvent e) {
//				e.getKeyChar(); //소문자인지 대문자인지 값을 줌, 화살표는 문자가 아님
//				e.getKeyCode(); //키를 식별할 때만 필요할 때(화살표 포함)

				System.out.printf("pressed %d\n", e.getKeyCode());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					d|=W;
					break;
				case KeyEvent.VK_UP:
					d|=N;
					break;
				case KeyEvent.VK_RIGHT:
					d|=E;
					break;
				case KeyEvent.VK_DOWN:
					d|=S;
					break;
				case KeyEvent.VK_SPACE:
					Missile msMissile = fighter.fire();
					items[unitIndex++] = msMissile;
					break;
				default:
					break;
				}
				fighter.move(d);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					d&=~W;
					break;
				case KeyEvent.VK_UP:
					d&=~N;
					break;
				case KeyEvent.VK_RIGHT:
					d&=~E;
					break;
				case KeyEvent.VK_DOWN:
					d&=~S;
					break;
				}
				
				fighter.move(d);
				fighter.standardImage();
			}

		});
	}

	public static ShootingCanvas getInstance() {
		return shootingCanvas;
	}
	
	

	public void start() {

		Thread gameThread = new Thread(new Runnable() { // 새로운 쓰레드 돌아가는 메인함수

			@Override
			public void run() {
				while (true) {
					moveUpdate(); // 단위벡터 단위의 움직임
					ShootingCanvas.this.repaint(); // 그냥 repaint(); 라고 써도 된다. 알아서 this 객체를 찾아줌
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		
//		System.out.println(countdown);
		
		if(--countdown == 0) {
			
			enemy=new Enemy();
			
			// items 개수 늘려주는 코드 추가
//			if(items의 개수가 모자라다면) {
//				늘려주고
//			}
			
			if(unitIndex>=max) {
				Movable[] temp=new Movable[max+50];
//				temp<-items;
				for(int i=0;i<unitIndex;i++) 
				{
					temp[i]=items[i];
				}
				
				items=temp;
				max+=50;
			}
			
			items[unitIndex++]=enemy;
			random=new Random();
			countdown=random.nextInt(120)+60;
		}
		
		
	}

	
	//update-> 밑에 있는 paint 메소드 호출 같이 됨
	@Override
	public void update(Graphics g) { // 화면 지우는 걸 막고자 Canvas 메소드를 오버라이드
		paint(g);
//		super.update(g); //부모를 지우고 paint를 호출하게 되어있다. 지워주면 paint도 호출이 안됨
	}

	// repaint -> update -> paint 그래서 반짝이는거임
	// repaint -> paint 호출하게 됨
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
