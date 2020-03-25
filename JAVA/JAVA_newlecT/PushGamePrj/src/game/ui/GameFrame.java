package game.ui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;


public class GameFrame extends Frame { // 라이브러리클래스에 저장된 frame.
	private static GameFrame gameFrame;

	private FightCanvas fightCanvas;
	private IntroCanvas introCanvas;
	private StartView startView;

	public GameFrame() {
		gameFrame = this;
		introCanvas = new IntroCanvas();
		this.add(introCanvas); // 캔버스를 프레임에 생성해서 붙이는 작업
		introCanvas.setFocusable(true); // 캔버스에 포커스를 둠 겜하면 바로 키보드 먹힘.
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

//	private GameFrame frame; // 인스턴스. 변수가 아니여서 아래에서 사용불가.
//	private static GameFrame frame; // static써서 변수로 사용. 위에서 선언해서 주석처리함.

	public static GameFrame getInstance() { // 전역변수의 의미
		return gameFrame;
	}

	public void changeCanvas(int canvasId) {
		if (canvasId == 1) {
			this.remove(introCanvas);
			FightCanvas canvas = new FightCanvas();
			this.add(canvas);
			canvas.start();
			canvas.setFocusable(true);
			canvas.requestFocus(); // 키보드 입력을 위함.
			this.revalidate(); //
		}
	}

}// end public Gameframe