import java.util.Scanner;

public class 성적관리프로그램 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Exam[] exams = new Exam[3]; // 학생 시험 점수

		String menuString = ""; // 메뉴 입력 받을 때 임시변수로 사용
		String scoreString = ""; // 성적 점수 입력받을 때 임시변수로 사용
		boolean existFlag = false; // 프로그램 종료할 때 사용
		int temp = 0; //학생 성적 입력받았을 때 임시변수
		int menu = 0; //
		final int INPUT=1;
		final int PRINT=2;
		final int END=3;

		while (true) {
			while (true) { //menu 입력
				System.out.println("1.성적입력");
				System.out.println("2.성적출력");
				System.out.println("3.종료");
				System.out.print(">");

				boolean check = false; //1~3번 입력 검사
				menuString = scanner.nextLine(); // 성적 메뉴번호 입력

				if(menuString.equals("")) { //아무것도 입력하지 않았을 때
					System.out.println("아무것도 입력하지 않으셨습니다. 1~3번 중에 입력해주세요.");
					continue;
				}
					
				for (int i = 0; i < menuString.length(); i++) { // 유효성 검사
					if (!('1' <= menuString.charAt(i) && menuString.charAt(i) <= '3')) {
						System.out.println("1~3번 중에 입력해주세요.");
						check = true;
						break;
					}
				} // end for i
				if (!check) // 숫자로 입력되었으면
					break;
			} // end while 2

			menu = Integer.parseInt(menuString);

			switch (menu) {
			case INPUT: // 성적입력
				for (int i = 0; i < exams.length; i++) {
					exams[i] = new Exam();
					System.out.printf("<%d번째 학생의 성적을 입력하세요>%n", i + 1);

					while (true) { // 국어성적
						System.out.print("국어성적: ");
						boolean check = false;
						scoreString = scanner.nextLine(); // 성적입력
						
						if(scoreString.equals("")) { //아무것도 입력하지 않았을 때
							System.out.println("아무것도 입력하지 않으셨습니다. 0~100점 중에 입력해주세요.");
							continue;
						}
						
						for (int j = 0; j < scoreString.length(); j++) { // 유효성 검사
							if (!('0' <= scoreString.charAt(j) && scoreString.charAt(j) <= '9')) { // 0~9입력이 아니면
								System.out.println("양수의 숫자만 입력해주세요.");
								check = true;
								break;
							}
						} // end for i

						if (!check) {// 숫자로 입력받았으면
							temp = Integer.parseInt(scoreString);
							if ((temp < 0 || 100 < temp) || check) { // 0~100 사이에 입력이 아니면
								System.out.println("0점~100점까지만 입력해주세요.");
								continue;
							}
						} else // 기호로 입력받았으면
							continue;

						exams[i].kor = Integer.parseInt(scoreString); // 국어성적 저장
						break;
					} // end while

					while (true) { // 영어성적
						System.out.print("영어성적: ");
						boolean check = false;
						scoreString = scanner.nextLine(); // 성적입력
						
						if(scoreString.equals("")) { //아무것도 입력하지 않았을 때
							System.out.println("아무것도 입력하지 않으셨습니다. 0~100점 중에 입력해주세요.");
							continue;
						}
						
						for (int j = 0; j < scoreString.length(); j++) { // 유효성 검사
							if (!('0' <= scoreString.charAt(j) && scoreString.charAt(j) <= '9')) { // 0~9입력이 아니면
								System.out.println("양수의 숫자만 입력해주세요.");
								check = true;
								break;
							}
						} // end for i

						if (!check) {// 숫자로 입력받았으면
							temp = Integer.parseInt(scoreString);
							if ((temp < 0 || 100 < temp) || check) { // 0~100 사이에 입력이 아니면
								System.out.println("0점~100점까지만 입력해주세요.");
								continue;
							}
						} else // 기호로 입력받았으면
							continue;

						exams[i].eng = Integer.parseInt(scoreString); // 영어성적 저장
						break;
					} // end while

					while (true) { // 수학성적
						System.out.print("수학성적: ");
						boolean check = false;
						scoreString = scanner.nextLine(); // 성적입력
						
						if(scoreString.equals("")) { //아무것도 입력하지 않았을 때
							System.out.println("아무것도 입력하지 않으셨습니다. 0~100점 중에 입력해주세요.");
							continue;
						}
						
						for (int j = 0; j < scoreString.length(); j++) { // 유효성 검사
							if (!('0' <= scoreString.charAt(j) && scoreString.charAt(j) <= '9')) { // 0~9입력이 아니면
								System.out.println("양수의 숫자만 입력해주세요.");
								check = true;
								break;
							}
						} // end for i

						if (!check) {// 숫자로 입력받았으면
							temp = Integer.parseInt(scoreString);
							if ((temp < 0 || 100 < temp) || check) { // 0~100 사이에 입력이 아니면
								System.out.println("0점~100점까지만 입력해주세요.");
								continue;
							}
						} else // 기호로 입력받았으면
							continue;

						exams[i].math = Integer.parseInt(scoreString); // 수학성적 저장
						break;
					} // end while

					exams[i].sum = exams[i].kor + exams[i].eng + exams[i].math; // i번 학생의 총점
					exams[i].avg = exams[i].sum / 3.0f; // i번 학생의 평균
					System.out.println();
				}
				System.out.println();
				break; 
				
			case PRINT: // 성적출력
				int korSum = 0, engSum = 0, mathSum = 0;
				float korAvg = 0.0f, engAvg = 0.0f, mathAvg = 0.0f;
				boolean inputFlag = false; //성적입력되어 있는지 검사
				for (int i = 0; i < exams.length; i++) {
					if (exams[i] == null) { //학생 성적이 입력되어있지 않으면
						System.out.println("학생 성적이 입력되지 않았습니다. 성적입력부터 해주세요.");
						inputFlag = true;
						break;
					}
					System.out.printf("%d번 째 학생 점수 - 국어:%3d점   영어:%3d점   수학:%3d점   총점:%3d점   평균:%.2f %n", i + 1,
							exams[i].kor, exams[i].eng, exams[i].math, exams[i].sum, exams[i].avg);
					korSum += exams[i].kor; // 국어점수 누적
					engSum += exams[i].eng; // 영어점수 누적
					mathSum += exams[i].math; // 수학점수 누적
				}
				
				if (inputFlag)// 성적 입력이 없으면
					break;
				
				korAvg = korSum / 3.0f;
				engAvg = engSum / 3.0f;
				mathAvg = mathSum / 3.0f;
				System.out.printf("과목별 전체 평균 - 국어:%.2f점, 영어:%.2f점, 수학:%.2f점", korAvg, engAvg, mathAvg);
				System.out.println();
				System.out.println();
				break;
				
			case END: // 종료
				existFlag = true;
				System.out.println("프로그램을 종료합니다.");
			default:
				break;
			}// end switch

			if (existFlag) { // 3번을 입력하면 종료
				break;
			}
		} // end while 1
	} //end main
} //end public class

		/*
		 * 성적관리 프로그램 ver 0.1
		 * 
		 *  1.성적입력
		 *  2.성적출력
		 *  3.종료
		 *  >_1
		 *  
		 *  //1번 메뉴를 눌렀을 때
		 * <1 번째 학생의 성적을 입력하세요>
		 * 국어성적:
		 * 영어성적:
		 * 수학성적:
		 * 
		 * <2 번째 학생의 성적을 입력하세요>
		 * 국어성적:
		 * 영어성적:
		 * 수학성적:
		 * 
		 * <3번째 학생의 성적을 입력하세요>
		 * 국어성적:
		 * 영어성적:
		 * 수학성적:
		 * 
		 * 2번 메뉴 선택시
		 *1 - 국어:30, 영어:40, 수학:80, 총점: , 평균:
		 *2 - 국어:50, 영어:60, 수학:100, 총점:  , 평균:
		 *3 - 국어:90, 영어:80, 수학:95, 총점: , 평균:
		 *과목별 전체 평균: 국어:40.33, 영어:55.55, 수학:60.35 
		 */
		

