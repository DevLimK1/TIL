package part2.ex1.성적입력부분나누기;

import java.util.Scanner;

//절차지향적인 프로그래밍 코드
public class Program {
	public static void main(String[] args) {

		int[] kors = new int[3];
		int total = 0;
		float avg; // 평균
		int menu;
		boolean keepLoop = true;

		Scanner scan = new Scanner(System.in);

		while (keepLoop) {
			// 메인 메뉴부분
			System.out.println("┌────────────────────┐");
			System.out.println("│      메인 메뉴     │");
			System.out.println("└────────────────────┘");
			System.out.println("\t1.성적입력");
			System.out.println("\t2.성적출력");
			System.out.println("\t3.종료");
			System.out.print("\t선택>");
			menu = scan.nextInt();

			// 성적 입력부분
			switch (menu) {

			case 1:
				System.out.println("┌────────────────────┐");
				System.out.println("│      성적 입력     │");
				System.out.println("└────────────────────┘");
				System.out.println();

				for (int i = 0; i < 3; i++)
					do {
						System.out.printf("국어%d: ", i + 1);
						kors[i] = scan.nextInt();

						if (kors[i] < 0 || 100 < kors[i])
							System.out.println("국어 성적은 0~100까지 범위 입력만 가능합니다.");
					} while (kors[i] < 0 || 100 < kors[i]);
				System.out.println("───────────────────────────────────────────────────────");
				break;

			case 2:
				// 성적 출력부분
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
	}
}
