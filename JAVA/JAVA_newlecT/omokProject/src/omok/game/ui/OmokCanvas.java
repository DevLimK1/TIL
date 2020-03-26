package omok.game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import omok.game.item.Omok;

public class OmokCanvas extends Canvas{
	
	private static Image image;
	private static OmokCanvas omokCanvas;
	
	private int width;
	private int height;
	private int top; //오목알 마지막에 있는 알을 가리킴
	
	private Omok[] omoks;
	
	private int omokIndex; //오목을 추가할 위치를 기억하기 위한 변수
	
	public OmokCanvas() {
		omokCanvas=this;
		omoks=new Omok[100];
		omokIndex=0;
		top=-1;
		
		Random random = new Random();
		for (int i = 0; i < 5; i++) { // 5개 돌을 미리 만들어놓음
			int x = random.nextInt(20)+10;
			int y = random.nextInt(20)+10;

			omoks[omokIndex++] = new Omok(x, y);
			top++;
		}
		
		try {
			image=ImageIO.read(new File("res/images/omokmap.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		width=image.getWidth(this);
		height=image.getHeight(this);
//		System.out.println("omokCanvas width: "+width);
//		System.out.println("omokCanvas height: "+height);
		this.setSize(width, height);
		
		
		//MouseListener 대신 Adapter를 상속받는 익명클래스 구현
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				
				x = (int) (Math.floor(x / 40) * 40) + 20;
				y = (int) (Math.floor(y / 40) * 40) +20;
				
				try {
					Omok omok=omoks[top]; //오목알 놓음
//					omok.setX(x);
//					omok.setY(y);
				
					omok.move(x,y);
					
					top--;
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(OmokCanvas.this, "오목알이 없습니다.");
				}
				
				//repaint(); //-> update(g);->paint(g);로 호출이 됨 --> gameThread가 repaint하기 때문에 개별적으로 repaint 하지 않아도 됨
				
			}
			
		});
		
		
		
	}
	

	public void start() {  //무한루프가 돌면서 1초에 60번정도 회전하는걸로 
		
		Thread gameThread=new Thread(new Runnable() {
			
			@Override
			public void run() { //다른 흐름을 갖게 된다.

				while(true) {
					
					//점진적인 업데이트
					moveUpdate();
					repaint();
					
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

	protected void moveUpdate() { //오목알이 이동할 때 점진적인 업데이트
		for(int i=0;i<omokIndex;i++)
			omoks[i].update();
		
	}

	
	@Override
	public void update(Graphics g) {
//		super.update(g); 부모의 update를 호출되는 것을 막음으로써 깜빡임의 원인을 없앤다. 
		paint(g); //부모의 update가 없으면 paint도 호출이 안되니 paint(g)를 해준다.
	}
	
	
	//paint를 다시 호출되어야 마우스 클릭할 때마다 오목알이 생김!->ouseClicked
	@Override
	public void paint(Graphics g) { //그림(이미지) 그리는 메소드

		Image buf = createImage(this.getWidth(), this.getHeight()); // 새로운 이미지 버퍼 만든다.
		Graphics bufGraphics = buf.getGraphics();
		
		//		g.drawImage(image, 0, 0, this);

		bufGraphics.drawImage(image, 0, 0, width, height-20, //새로만든 그래픽스에 오목판 화면 그리기
				0, 0, width,height, this);
		
		//오목을 그리기
		//omoks의 항목들을 반복적으로 꺼내서
		// i 번째 오목에게 draw(g)를 요청한다.
//		for (int i = 0; i < omokIndex; i++) {
//			omoks[i].draw(g);
//		}
		
		//더블 버퍼링 -->깜빡임을 없애는 기능!
		for (int i = 0; i < omokIndex; i++) {
			omoks[i].draw(bufGraphics);
		}

		g.drawImage(buf, 0, 0, width, height-20, //기존 그래픽스에 buf에 그린 오목판 화면 그리기
				0, 0, width,height, this); //더블버퍼링에 그린 이미지를 한번에 그린다. -->
	}
	
	public static OmokCanvas getInstance() {
		return omokCanvas;
	}
	
	
}
