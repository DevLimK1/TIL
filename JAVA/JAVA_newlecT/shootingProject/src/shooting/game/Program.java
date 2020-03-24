package shooting.game;

import java.awt.Frame;
import java.awt.Graphics;

import shooting.game.ui.GameFrame;

//import puzzlegame.GameFrame;

public class Program {
	public static void main(String[] args) {
	
		// 비트 연산자 -> 정수단위가 커서 작은 단위의 데이터를 전송하거나 저장하거나 데이터와 관련된 메타데이타(데이터설명)를 사용할 때 
		// 비트 단위로 연산을 하는 연산자
		
		//차집합: 0,1가 차이가 있으면 참이다. 참이면 1 거짓이면 0
//		final int 방패 = 0b0000_0000_0000_0000_0000_0000_0000_0001;
//		final int 날개 = 0b0000_0000_0000_0000_0000_0000_0000_0010;
//		final int 신발 = 0b0000_0000_0000_0000_0000_0000_0000_0100;
//
//		int 보유아이템=0b0000_0000_0000_0000_0000_0000_0000_0000;
//
//		System.out.printf("보유아이템 현황:%n%032d%n",Integer.parseInt(Integer.toBinaryString(보유아이템)));
//		
//		보유아이템 |= 신발;
//		보유아이템 |= 날개;
//		
//		System.out.printf("보유아이템 현황:%n%032d%n",Integer.parseInt(Integer.toBinaryString(보유아이템)));
		
		//날개를 잃어버림
//		보유아이템 &=~날개;
//		System.out.printf("보유아이템 현황:%n%032d%n",Integer.parseInt(Integer.toBinaryString(보유아이템)));
//		보유아이템 <<=2;
//		System.out.printf("보유아이템 현황:%n%032d%n",Integer.parseInt(Integer.toBinaryString(보유아이템)));
//		보유아이템 >>=2;
//		System.out.printf("보유아이템 현황:%n%032d%n",Integer.parseInt(Integer.toBinaryString(보유아이템)));
		
//		int x = 0b0000_0000_0000_0000_0000_0000_0000_1111;
//		int y= 0x00000005;
//		int z=x|y;
//		System.out.printf("%d%n",x);
//		System.out.printf("%d%n",y);
//		System.out.printf("%d%n",z);
		
		
//		long pos=0;
//		//(7,5) -> pos  
//		pos=((7<<8)|5);
//		long temp=Long.parseLong(Long.toString(pos,2));
//		System.out.printf("pos:%016d%n",temp);
		
		
		Frame frame = new GameFrame();
		frame.setVisible(true);
		frame.setSize(700, 700);
	
	}
	
	public void draw(Graphics g) { //그림이 그려질 객체는 다 포함되어야 할 메소드
		
	}
}
