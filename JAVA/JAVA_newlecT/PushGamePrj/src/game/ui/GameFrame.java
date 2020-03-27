package game.ui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import game.button.BackButton;
import game.interFace.Movable;

public class GameFrame extends Frame { // 라이브러리클래스에 저장된 frame.
	private static GameFrame gameFrame;

	private FightCanvas fightCanvas;
	private IntroCanvas introCanvas;
	private MultiCanvas multiCanvas;
	private StartView startView;
	private BackButton backButton;
	private SingleCanvas singleCanvas;
	private Frame fram;
	private Movable[] items;
	private int unitIndex = 0;
	private int count = 0;

	public GameFrame() {
		gameFrame = this;
		introCanvas = new IntroCanvas();
		fightCanvas = new FightCanvas();
//		singleCanvas=new SingleCanvas();
		backButton = new BackButton();
		
		items = new Movable[100];

		items[unitIndex++] = backButton;
		this.add(introCanvas); // 캔버스를 프레임에 생성해서 붙이는 작업
		introCanvas.setFocusable(true); // 캔버스에 포커스를 맞추어서 게임 시작하면 바로 키보드로 실행 가능.
		introCanvas.start();

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(GameFrame.this, "종료?"); // Yes or No가 뜸
				// GameFrame.this, "종료?" 라고 하면, 게임 프레임 정중앙에 종료 물어보는 창이뜸.

				if (result == 0) { // yes를 누르면. 임.
					System.exit(0); // 화면 x 누르면 닫힘.
				}

			}
		});
	} // end public GameFrame()

	public static GameFrame getInstance() { // 전역변수의 의미
		return gameFrame;
	}

	public void changeCanvas(int canvasId) {
		 //메인에서 1번 버튼 선택시 싱글 플레이
		if (canvasId == 1) {    
			if (count == 0) {
				introCanvas.setVisible(false);
				singleCanvas = new SingleCanvas();
				this.add(singleCanvas);
				singleCanvas.start();
				singleCanvas.setFocusable(true);
				singleCanvas.requestFocus(); // 키보드 입력을 위함.
				this.revalidate(); //
				count++;
			} else {
				this.remove(introCanvas);
				FightCanvas fightCanvas = new FightCanvas();
				this.add(fightCanvas);
				fightCanvas.start();
				fightCanvas.setFocusable(true);
				fightCanvas.requestFocus(); // 키보드 입력을 위함.
				this.revalidate(); //
			}
			// introCanvas -> fightCanvas
//			this.remove(introCanvas);
//			FightCanvas fightCanvas = new FightCanvas();
//			introCanvas.setVisible(false);
//			this.add(fightCanvas);
//			fightCanvas.start();
//			fightCanvas.setFocusable(true);
//			fightCanvas.requestFocus(); // 키보드 입력을 위함.
//			this.revalidate(); //
		} else if (canvasId == 2) {
			this.remove(introCanvas);
			FightCanvas multiCanvas = new FightCanvas();
			this.add(multiCanvas);
			multiCanvas.start();
			multiCanvas.setFocusable(true);
			multiCanvas.requestFocus(); // 키보드 입력을 위함.
			this.revalidate(); //
		} else if (canvasId == 3) {
//			IntroCanvas introCanvas = new IntroCanvas();
//			.add(introCanvas);
//			introCanvas.start();
			this.remove(fightCanvas);
			introCanvas.setVisible(true);
			introCanvas.setFocusable(true);
			introCanvas.requestFocus(); // 키보드 입력을 위함.
			fram.revalidate(); //
		}

	}
}