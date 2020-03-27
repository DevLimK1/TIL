package game.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.interFace.Movable;

public class StartView implements Movable {
	private Image img;
	private double y;

	public StartView() {
		try {

			img = ImageIO.read(new File("res/images/IntroBack.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, 0, (int) y, IntroCanvas.getInstance());

	}

}
