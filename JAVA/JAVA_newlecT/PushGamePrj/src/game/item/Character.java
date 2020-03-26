package game.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.interFace.Movable;
import game.ui.FightCanvas;
import game.ui.IntroCanvas;

public class Character implements Movable {
	private Image bearImg_left, bearImg_right, wallImg; // 곰, 빙산 이미지

	/* +++++++++++++좌측 곰 변수++++++++++++++ */
	private int bearImg_leftX, bearImg_leftY; // 좌측 곰 x,y좌표
	private int widthL, heightL; // 좌측 곰 너비, 높이
	private int imgIndexL; // 좌측 곰 이미지 인덱스

	/* +++++++++++++우측 곰 변수++++++++++++++ */
	private int bearImg_rightX, bearImg_rightY; // 우측 곰 x,y좌표
	private int widthR, heightR; // 우측 곰 너비, 높이
	private int imgIndexR; // 우측 곰 이미지 인덱스

	/* +++++++++++++빙산 변수++++++++++++++ */
	private int wallX, wallY; // 빙산 x,y좌표

	private double vx;// 이동할 단위 위치

	private static boolean pause;

	public Character() {

		try {
			bearImg_left = ImageIO.read(new File("res/BBear.png")); // 왼쪽 곰 이미지
			bearImg_right = ImageIO.read(new File("res/IBear.png")); // 오른쪽 곰 이미지
			wallImg = ImageIO.read(new File("res/ice.png")); // 빙산 이미지


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* +++++++++++++좌측 곰 초기화 설정++++++++++++++ */
		bearImg_leftX = 400; // 좌측 곰 시작점 x축
		bearImg_leftY = 480; // 좌측 곰 시작점 y축
		widthL = 166; // 좌측 곰 너비
		heightL = 256; // 좌측 곰 높이
		imgIndexL = 0; // 좌측 곰 이미지인덱스

		/* +++++++++++++우측 곰 초기화 설정++++++++++++++ */
		bearImg_rightX = 1050; // 우측 곰 시작점 x축
		bearImg_rightY = 480; // 우측 곰 시작점 y축
//		widthR = 150; // 우측 곰 너비
//		heightR = 256; // 우측 곰 높이
		widthR = (bearImg_right.getWidth(FightCanvas.getInstacne()))/ 7;
		heightR = bearImg_right.getHeight(FightCanvas.getInstacne());
		imgIndexR = 0; // 우측 곰 이미지인덱스

		/* +++++++++++++빙산 초기화 설정++++++++++++++ */
		wallX = 650; // 빙산 x축
		wallY = 330; // 빙산 y축

		vx = 10;
	}

	/* +++++++++++캐릭터 이동 메소드+++++++++++++ */
	// wall 183 , 261
	// bear 169,256
	public void bearL_moveLeft() { // 좌측곰 왼쪽 이동
		this.bearImg_leftX -= vx;

		// 빙하가 빙하 왼쪽 끝에 있거나 ,왼쪽곰이 왼쪽 낭떠러지로 떨어지거나
		if (wallX - 120 < 180 || bearImg_leftX < 160)
			vx = 0; // 멈춤

	}

	public void bearL_moveRight() { // 좌측곰 오른쪽 이동
		this.bearImg_leftX += vx;

		// 왼쪽 곰이 (왼쪽 빙하 경계선)빙하를 밀 때
		if (bearImg_leftX > wallX - 120) {
			this.wallX += vx;
			if (wallX + 120 >= bearImg_rightX) // 빙하 우 경계선이 우측 곰과 맞닿을때
				bearR_moveRight();// 우측곰이 뒤로 밀림
		}

		if (wallX + 60 > 1280) // 빙하가 오른쪽 끝으로 가면 멈춤
			vx = 0;

	}

	public void bearR_moveLeft() {// 우측곰 왼쪽 이동
		this.bearImg_rightX -= vx;

		if (bearImg_rightX < wallX + 130) {// 우측곰 손과 빙하 우 경계 비교해서 빙하를 민다.
			this.wallX -= vx; // 빙하가 좌측으로 이동
			if (bearImg_leftX >= wallX - 110)// 좌측곰이랑 빙하랑 닿으면
				bearL_moveLeft();// 좌측곰이 왼쪽으로 밀림
		}

		if (wallX < 160)// 혹은 빙하가 좌측 낭떠러지 끝으로 갈 때, 멈춤
			vx = 0;

	}

	public void bearR_moveRight() { // 우측곰 오른쪽 이동
		this.bearImg_rightX += vx;
	}

	/* +++++++++++캐릭터 이미지인덱스 변화 메소드+++++++++++++ */
	public void bearL_back() {// 좌측 곰이 뒤로 갈 때 이미지인덱스 변화
		if (imgIndexL == 0)
			imgIndexL = 7;
		imgIndexL--;
	}

	public void bearL_front() {// 좌측 곰이 앞으로 갈 때 이미지인덱스 변화
		imgIndexL++;
		imgIndexL %= 7;
	}

	public void bearR_back() { // 우측 곰이 뒤로갈 때 이미지인덱스 변화
		if (imgIndexR == 0)
			imgIndexR = 7;
		imgIndexR--;
	}

	public void bearR_front() {// 우측 곰이 앞으로 갈 때 이미지인덱스 변화
		imgIndexR++;
		imgIndexR %= 7;
	}

	public void draw(Graphics g) {
		int offsetWall = 100;
		int offsetX = widthL / 2; // 왼쪽 이미지의 x축 중심점 이동위해서 선언
		int offsetY = heightL / 2; // 왼쪽 이미지의 y축 중심점 이동위해서 선언
		int dx1 = (int) (bearImg_leftX - offsetX);
		int dy1 = (int) (bearImg_leftY - offsetY);
		int dx2 = (int) (bearImg_leftX + widthL - offsetX);
		int dy2 = (int) (bearImg_leftY + heightL - offsetY);

		g.drawImage(bearImg_left, dx1, dy1, dx2, dy2, 
				imgIndexL * widthL, 0, imgIndexL * widthL + widthL, heightL,
				IntroCanvas.getInstance());

		offsetX = widthR / 2; // 오른쪽 이미지의 x축 중심점 이동위해서 선언
		offsetY = heightR / 2; // 오른쪽 이미지의 y축 중심점 이동위해서 선언

		dx1 = (int) (bearImg_rightX - offsetX);
		dy1 = (int) (bearImg_rightY - offsetY);
		dx2 = (int) (bearImg_rightX + widthR - offsetX);
		dy2 = (int) (bearImg_rightY + heightR - offsetY);

		g.drawImage(bearImg_right, dx1, dy1, dx2, dy2,
				imgIndexR * widthR, 0, imgIndexR * widthR + widthR, heightR,
				IntroCanvas.getInstance());

		g.drawImage(wallImg, (int) wallX - offsetWall, (int) wallY, FightCanvas.getInstacne());

		if (wallX - 120 < 180 || bearImg_leftX < 160 || bearImg_leftX > 1350) {// 곰이 빙하밖으로 떨어지면
			bearImg_leftY++; // 화면 밑으로 사라짐
			vx = 0;
		}
		if (wallX - 120 < 180 || bearImg_rightX < 160 || bearImg_rightX > 1300) {// 곰이 빙하밖으로 떨어지면
			bearImg_rightY++; // 화면 밑으로 사라짐
			vx = 0;
		}
	}

	public void update() {
	}

//	public void pause() {// ESC클릭시 캐릭터 이동멈춤
//	pause = !pause;
//	if (pause == true)
//		vx = 10;
//	else
//		vx = 0;
//}

}