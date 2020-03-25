package game.item;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.interFace.Movable;
import game.ui.FightCanvas;

public class Character implements Movable {
   private Image bearImg_left, bearImg_right, wallImg;
   private double vx = 10;// 이동할 단위 위치
   private int bearImg_leftX, bearImg_rightX;
   private int bearImg_leftY, bearImg_rightY;
   private int wallX, wallY;
   private static boolean pause;

   public Character() {

      try {
         bearImg_left = ImageIO.read(new File("res/bearleft.png"));
         bearImg_right = ImageIO.read(new File("res/pandaright.png"));
         wallImg = ImageIO.read(new File("res/ice.png"));
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      bearImg_leftX = 400;
      bearImg_leftY = 520;
      bearImg_rightX = 1050;
      bearImg_rightY = 350;
      wallX = 750;
      wallY = 330;

   }

   // wall 183 , 261
   // bear 169,256
   public void bearL_moveLeft() {
      this.bearImg_leftX -= vx;
   }

   public void bearL_moveRight() {
      this.bearImg_leftX += vx;
      if (bearImg_leftX > wallX - 40) {
         this.wallX += vx;
         if (wallX + 40 >= bearImg_rightX)
            bearR_moveRight();
      }
      if (wallX + 40 > 1250) {
         wallX = 1220;
         vx = 0;
      }
   }

   public void bearR_moveLeft() {
      this.bearImg_rightX -= vx;
      if (bearImg_rightX < wallX + 40) {
         this.wallX -= vx;
         if (bearImg_leftX >= wallX - 30)
            bearL_moveLeft();
      }
      if (wallX - 30 < 256) {
         wallX = 270;
         vx = 0;
      }

   }

   public void pause() {// ESC클릭시 캐릭터 이동멈춤
      pause = !pause;
      if (pause == true)
         vx = 10;
      else
         vx = 0;
   }

   public void bearR_moveRight() {
      this.bearImg_rightX += vx;
   }

   public void draw(Graphics g) {
      int offsetX = 169;
      int offsetWall = 100;
      g.drawImage(bearImg_left, (int) bearImg_leftX - offsetX, (int) bearImg_leftY - offsetX,
            FightCanvas.getInstacne());

      g.drawImage(bearImg_right, (int) bearImg_rightX, (int) bearImg_rightY, FightCanvas.getInstacne());
      g.drawImage(wallImg, (int) wallX - offsetWall, (int) wallY, FightCanvas.getInstacne());
   }

   public void update() {
//      this.x += vx;
//      this.y += vy;
   }

}