package part2.ex1.성적입력부분나누기;

import java.util.Scanner;

//구조적인 프로그래밍 코드
public class StructuredProgram {
	
 
	

	public static void main(String[] args) {
		
		/*
		 * 전역변수->지역변수
		 * 성적입력, 성적출력 함수의 매개변수로 넘겨줌
		 */
		int[] korList = new int[3]; 

		
		int menu;
		boolean keepLoop = true;

		while (keepLoop) {
			
			menu=inputMenu();
		
			switch (menu) {

			case 1:
				
				inputKors(korList);
				
				break;

			case 2:
				printKors(korList);
				break;

			case 3:
				System.out.println("Bye~");
				keepLoop = false;
				break;
			default:
				System.out.println("입력은 1~3번까지만 할 수 있습니다. 다시 입력해주세요~");
				break;
			}
		}
	} //~main
	
	
	static int inputMenu() {
		
		Scanner scan = new Scanner(System.in);
		// 메인 메뉴부분
		System.out.println("┌────────────────────┐");
		System.out.println("│      메인 메뉴     │");
		System.out.println("└────────────────────┘");
		System.out.println("\t1.성적입력");
		System.out.println("\t2.성적출력");
		System.out.println("\t3.종료");
		System.out.print("\t선택>");
		int menu = scan.nextInt();
		
		return menu;
	}
	
	/*
	 * switch 문 case 2에 있었던 코드를 함수로 분리시킴
	 */
	static void printKors(int[] kors) {
		// 성적 출력부분
		
		int total = 0;
		float avg; // 평균
		
		for (int i = 0; i < 3; i++)
			total += kors[i];

		avg = total / 3.0f;

		System.out.println("┌────────────────────┐");
		System.out.println("│      성적 출력     │");
		System.out.println("└────────────────────┘");
		System.out.println();

		for (int i = 0; i < 3; i++)
			System.out.printf("국어%d : %3d\n", 3 - i, kors[i]);

		System.out.printf("총점 :%3d\n", total);
		System.out.printf("평균 :%6.2f\n", avg);
		System.out.println("───────────────────────────────────────────────────────");

	}
	
	/*
	 * switch 문 case 1에 있었던 코드를 함수로 분리시킴
	 */
	static void inputKors(int[] kors) { 
		Scanner scan = new Scanner(System.in);
		int kor;
		
		System.out.println("┌────────────────────┐");
		System.out.println("│      성적 입력     │");
		System.out.println("└────────────────────┘");
		System.out.println();

		for (int i = 0; i < 3; i++) {
			do {
				System.out.printf("국어%d: ", i + 1);
				kor= scan.nextInt();

				if (kor< 0 || 100 < kor)
					System.out.println("국어 성적은 0~100까지 범위 입력만 가능합니다.");
			} while (kor < 0 || 100 < kor);
			
			kors[i]=kor;
		}
		System.out.println("───────────────────────────────────────────────────────");
	}
	
}
