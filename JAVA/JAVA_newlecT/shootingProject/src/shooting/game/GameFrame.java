package shooting.game;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class GameFrame extends Frame {
	private ShootingCanvas canvas; // 퍼즐 캔버스

	
	public GameFrame() {
		canvas = new ShootingCanvas();
		this.add(canvas);// 캔버스를 프레임에 생성해서 붙이는 작업을 함 
		canvas.setFocusable(true); //캔버스가 포커스를 획득됨! 활성화 된다는 의미
		canvas.start();

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

}

//JOptionPane.showMessageDialog(null, "진짜 끌꼬야?"); //화면에 경고창만 뜨게하는 것
//int result=JOptionPane.showConfirmDialog(GameFrame.this, "끌꼬야?ㅠㅠ"); //화면 종료할건지 확인창
//
// if(result==0)
//	 System.exit(0);