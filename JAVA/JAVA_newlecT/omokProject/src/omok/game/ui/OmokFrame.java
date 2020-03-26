package omok.game.ui;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class OmokFrame extends Frame {
	private OmokCanvas omokCanvas; //오목 캔버스의 확장된 기능을 쓸거임, Has a 상속

	public OmokFrame() { 
		omokCanvas=new OmokCanvas();
		this.add(omokCanvas); //이걸 안하면 캔버스가 화면에 보이지가 않음
//		setSize(760,760);
		pack(); //이미지 사이즈에 맞게 setSize 됨
		omokCanvas.start(); //start() 메소드의 gameThread run() 시켜주기 위함
		
		setVisible(true);
		
		//한번쓰고 사용안하니 익명객체로 생성
		//WindowListener인터페이스를 빈 메소드로 구현하고 있는 클래스가 Adapter 클래스다.
		addWindowListener(new WindowAdapter() {
			
			//종료할 때 확인버튼
			@Override
			public void windowClosing(WindowEvent e) {
				int result=JOptionPane.showConfirmDialog(OmokFrame.this, "끌꺼니??");
				
				if(result==0)
					System.exit(0);
			}
			
		});
	}
	
	
}
