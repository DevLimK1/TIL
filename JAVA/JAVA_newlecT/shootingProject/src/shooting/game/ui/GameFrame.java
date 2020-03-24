package shooting.game.ui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class GameFrame extends Frame {
	private static GameFrame frame;

	private ShootingCanvas shootingCanvas = new ShootingCanvas(); // 퍼즐 캔버스
	private IntroCanvas introCanvas;
	
	public GameFrame() { //생성자
		frame=this;
		introCanvas = new IntroCanvas();
		this.add(introCanvas);// 캔버스를 프레임에 생성해서 붙이는 작업을 함 
		introCanvas.setFocusable(true); //캔버스가 포커스를 획득됨! 활성화 된다는 의미
		introCanvas.start();

		this.addWindowListener(new WindowAdapter() { //windowListener의 구현 클래스이므로 WindowAdapter에 있는 메소드를 오버라이드해서 사용 가능
			// WindowListener 인터페이스를 구현하는 클래스를 바로 생성!(new) ->익명클래스
			@Override
			public void windowClosing(WindowEvent e) {
				// JOptionPane.showMessageDialog(null, "진짜 끌꼬야?"); //화면에 경고창만 뜨게하는 것
				int result = JOptionPane.showConfirmDialog(GameFrame.this, "끌꼬야?ㅠㅠ"); // 화면 종료할건지 확인창

				if (result == 0)
					System.exit(0);
			}
		});

	}
	
	
	
	public static GameFrame getInstatnce() {
		return frame; //this를 쓸 수 없는 이유는 static 메소드이기 때문에 객체 자기 자신을 가리키는
		//this를 쓸 수 없음
	}
	
	public void changeCanvas(int canvasId) {
		this.remove(introCanvas);
		
		shootingCanvas.start();
		this.add(shootingCanvas);
		this.revalidate(); //윈도우를 다시 재배치 하는 작업(Canvas 변경 후 화면 다시 구성하기 이게 없으면 화면 전화해서 나오지가 않음)
	
		shootingCanvas.setFocusable(true);
		shootingCanvas.requestFocus(); //키보드 입력을 위한
	}

}

//JOptionPane.showMessageDialog(null, "진짜 끌꼬야?"); //화면에 경고창만 뜨게하는 것
//int result=JOptionPane.showConfirmDialog(GameFrame.this, "끌꼬야?ㅠㅠ"); //화면 종료할건지 확인창
//
// if(result==0)
//	 System.exit(0);