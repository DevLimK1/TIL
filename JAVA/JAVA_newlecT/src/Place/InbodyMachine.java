package Place;

import java.awt.Toolkit;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import Person.PTmember;

public class InbodyMachine {
	int height; // 키
	int weight; // 체중
	double skeletMuscleMass; // 골격근량
	int fatPercent; // 체지방률
	int chestMass; // 가슴근육량
	int shoulderMass; // 어깨근육량
	int lowerbodyMass; // 하체근육량
	int backMuscleMass; // 등근육량
	int armMass; // 팔근육량
	int abdominalMass; // 복근근육량
	int metabolicRate; // 신진대사량
	int basmetabolicRate; // 기초대사량
	int actmetabolicRate; // 활동대사량
	double digmetabolicRate; // 소화대사량
	float actRate; // 활동지수
	int selectAR; // 활동지수 선택변수
	int totalMuscleMass; // 총근육량(부위별 근육량 총합)
	int avgMuscleMass; // 근육량평균(부위별 근육량 총합/6)

	Random ranIB = new Random();
	Scanner sc = new Scanner(System.in);
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	
	public void exeInbodyMachine(PTmember mb) { // 인바디기계 작동 메소드
		System.out.println("<작동준비중>");
		System.out.println("<inbody 정보수집 진행합니다>");
		System.out.println("<양손으로 기구를 잡아주세요.>");
		
		for(int i=0;i<5;i++) {
			System.out.println(".");
			try { 
				Thread.sleep(500);
				
			}catch(Exception e) {
				
			}
		}
		
//		Random ranIB = new Random();
//		Scanner sc = new Scanner(System.in);

		// public void inbodyResult() {//인바디 측정결과 메소드
		System.out.print("키(cm):");
		
		  while (true){
	            //예외가 발생할지 아닐지 모르지만, 우선 실행해본다.
	            try { 
	                //예외가 발생할 가능성이 있는 코드를 입력
	            	this.height = sc.nextInt();
	                break;
	            }
	            
	            //try 내부의 코드가 InputMismatchException 을 던진다면, 예외를 받아온다.
	            //catch가 실행되는 동안은 Program 이 종료되지 않는다.
	            catch ( InputMismatchException ime) {
	                //스캐너의 버그를 해결하기 위한 코드
	            	
	                sc = new Scanner(System.in);
	                System.out.println("입력오류!! 정수로 입력해주세요.");
	                
//	                /**
//	                 * 쓰면 안되는 코드
//	                 * 예외의 구체적인 정보를 알고싶을때 쓴다.
//	                 * 구체적인 정보를 알고 난뒤에는 반드시 지워야한다.
//	                 */
//	                ime.printStackTrace();
	                
	                // 애용해야하는 코드
	                // 어떤 예외가 어떻게 발생했는지 간략히 알려준다
	                System.out.println(ime.getClass().getName() + " 예외가 " + ime.getMessage() + " 때문에 발생했습니다.");
	            }//~catch
	        }    //~while 예외처리
		System.out.print("몸무게(kg):");
		  while (true){
	            //예외가 발생할지 아닐지 모르지만, 우선 실행해본다.
	            try { 
	                //예외가 발생할 가능성이 있는 코드를 입력
	            	this.weight = sc.nextInt();
	                break;
	            }
	            
	            //try 내부의 코드가 InputMismatchException 을 던진다면, 예외를 받아온다.
	            //catch가 실행되는 동안은 Program 이 종료되지 않는다.
	            catch ( InputMismatchException ime) {
	                //스캐너의 버그를 해결하기 위한 코드
	            	
	                sc = new Scanner(System.in);
	                System.out.println("입력오류!! 정수로 입력해주세요.");
	                
//	                /**
//	                 * 쓰면 안되는 코드
//	                 * 예외의 구체적인 정보를 알고싶을때 쓴다.
//	                 * 구체적인 정보를 알고 난뒤에는 반드시 지워야한다.
//	                 */
//	                ime.printStackTrace();
	                
	                // 애용해야하는 코드
	                // 어떤 예외가 어떻게 발생했는지 간략히 알려준다
	                System.out.println(ime.getClass().getName() + " 예외가 " + ime.getMessage() + " 때문에 발생했습니다.");
	            }//~catch
	        }    //~while 예외처리
		System.out.println();
		System.out.println("=======인바디 측정중=======");
		for(int i=0;i<5;i++) {
			toolkit.beep();
			System.out.println(".");
			try { 
				Thread.sleep(500);
				
			}catch(Exception e) {
				
			}
		}
		
		System.out.println("<회원님의 인바디 측정결과>");
		// if (healthCareer >= 36) {// 헬스경력이 36개월 이상
		
		this.fatPercent = (int) (9 + 11 * Math.random()); // 체지방률 9~20사이의 난수값
		System.out.println("-체지방률:" + fatPercent + "%");
		this.skeletMuscleMass = (weight * ((100 - fatPercent) / 100.0) - 4) * 0.577;
		// 골격근량공식:(체중*((100-체지방률)/100)-뼈무게4kg가정)*0.577
		System.out.printf("-골격근량:%.2f (kg)", skeletMuscleMass);
		System.out.println();

		if (mb.getSex().equals("M")) { // 남성근육량, 신진대사량 구하기
			this.chestMass = (int) (30 + 20 * Math.random());
			System.out.println("-가슴 근육량:" + chestMass + "/100(kg)");
			this.shoulderMass = (int) (30 + 20 * Math.random());
			System.out.println("-어깨 근육량:" + shoulderMass + "/100(kg)");
			this.lowerbodyMass = (int) (30 + 20 * Math.random());
			System.out.println("-하체 근육량:" + lowerbodyMass + "/100(kg)");
			this.backMuscleMass = (int) (30 + 20 * Math.random());
			System.out.println("-등 근육량:" + backMuscleMass + "/100(kg)");
			this.armMass = (int) (30 + 20 * Math.random());
			System.out.println("-팔 근육량:" + armMass + "/100(kg)");
			this.abdominalMass = (int) (30 + 20 * Math.random());
			System.out.println("-복근 근육량:" + abdominalMass + "/100(kg)");
			totalMuscleMass = chestMass + shoulderMass + lowerbodyMass + backMuscleMass + armMass + abdominalMass;
			System.out.println("총 근육량(부위별 근육량 총합):" + totalMuscleMass + "kg");
			avgMuscleMass = totalMuscleMass / 6;
			System.out.println("근육량평균(부위별 근육량 총합/6):" + avgMuscleMass + "kg");

			System.out.println("=======================================");

			System.out.println();
			System.out.println("이번에는 다이어트 및 식단을 구성하는데 참고할 \'신진대사량\'을 구하려고합니다.");
			System.out.println("\'신진대사량\'은 기초대사량+활동대사량+소화대사량 해서 구해집니다.");
			System.out.println("\'기초대사량\'부터 구해보겠습니다.");
			System.out.println("회원님은 남성이시기 때문에 " + "\'기초대사량\'은 남성이라면 (자신의 체중X1.0X24)의 공식으로 구해집니다.");
			basmetabolicRate = (int) (weight * 1.0 * 24); // 기초대사량 공식
			System.out.println("그래서, 계산해보면 회원님의 \'기초대사량\'은" + basmetabolicRate + "kcal가 되겠습니다.");
			System.out.println();
			System.out.println("이번엔 \'활동대사량\'을 구해보겠습니다.");
			System.out.println("\'활동대사량\'은 (활동지수(%)X기초대사량)의 공식으로 구해집니다.");
			System.out.println("활동지수를 선택해주세요.(1,2,3,4 중 정수입력)");
			System.out.println("1번:20% 하루 중 거의 앉아있는 사람 \n2번:30% 좌식 생활자중 도보량이 1~3km인 사람"
					+ "\n3번:40% 2번상황에서 매일 운동하는 사람 \n4번:50% 운동선수,육체 노동자");
			selectAR = sc.nextInt();

			// 활동대사량 공식
			if (selectAR == 1) {// 20% 하루 중 거의 앉아있는 사람
				actRate = 0.2f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else if (selectAR == 2) { // 30% 좌식 생활자중 도보량이 1~3km인 사람
				actRate = 0.3f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else if (selectAR == 3) { // 40% 30%에서 매일 운동하는 사람
				actRate = 0.4f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else { // 50% 운동선수,육체 노동자
				actRate = 0.5f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} // 활동대사량 공식
			System.out.println("계산해서, 회원님의 \'활동대사량\'은" + actmetabolicRate + "kcal가 되겠습니다.");
			System.out.println();
			System.out.println("\'소화대사량\'은 [(기초대사량+활동대사량)/0.9X0.1]의 공식으로 구해집니다.");
			digmetabolicRate = (int) ((basmetabolicRate + actmetabolicRate) / 0.9) * 0.1;
			System.out.println("계산해서, 회원님의 \'소화대사량\'은" + digmetabolicRate + "kcal가 되겠습니다.");

			System.out.println();
			System.out.println("기초대사량+활동대사량+소화대사량해서");
			System.out.println(
					"회원님의 \'신진대사량\'은" + (basmetabolicRate + actmetabolicRate + digmetabolicRate) + "kcal가 되겠습니다.");
			metabolicRate=(int) (basmetabolicRate + actmetabolicRate + digmetabolicRate);
			System.out.println("다이어트를 위해서는 회원님의 \'신진대사량\'에서 4~500kcal 정도 줄이면 도움이 될 것입니다. ");
			System.out.println();
		} else {// 여성근육량, 여성 신진대사량구하기 // 여자는 남자보다 최소 기준점 -10으로 지정
			this.chestMass = (int) (10 + 20 * Math.random());
			System.out.println("-가슴 근육량:" + chestMass + "/100(kg)");
			this.shoulderMass = (int) (10 + 20 * Math.random());
			System.out.println("-어깨 근육량:" + shoulderMass + "/100(kg)");
			this.lowerbodyMass = (int) (10 + 20 * Math.random());
			System.out.println("-하체 근육량:" + lowerbodyMass + "/100(kg)");
			this.backMuscleMass = (int) (10 + 20 * Math.random());
			System.out.println("-등 근육량:" + backMuscleMass + "/100(kg)");
			this.armMass = (int) (10 + 20 * Math.random());
			System.out.println("-팔 근육량:" + armMass + "/100(kg)");
			this.abdominalMass = (int) (10 + 20 * Math.random());
			System.out.println("-복근 근육량:" + abdominalMass + "/100(kg)");
			totalMuscleMass = chestMass + shoulderMass + lowerbodyMass + backMuscleMass + armMass + abdominalMass;
			System.out.println("총 근육량(부위별 근육량 총합):" + totalMuscleMass + "kg");
			avgMuscleMass = totalMuscleMass / 6;
			System.out.println("근육량평균(부위별 근육량 총합/6):" + avgMuscleMass + "kg");
			System.out.println("=======================================");

			System.out.println();
			System.out.println("이번에는 다이어트 및 식단을 구성하는데 참고할 \'신진대사량\'을 구하려고합니다.");
			System.out.println("\'신진대사량\'은 기초대사량+활동대사량+소화대사량 해서 구해집니다.");
			System.out.println("\'기초대사량\'부터 구해보겠습니다.");
			System.out.println("회원님은 여성이시기 때문에 " + "\'기초대사량\'은 여성이라면 (자신의 체중X0.9X24)의 공식으로 구해집니다.");
			basmetabolicRate = (int) (weight * 0.9 * 24); // 기초대사량 공식
			System.out.println("그래서, 계산해보면 회원님의 \'기초대사량\'은" + basmetabolicRate + "kcal가 되겠습니다.");
			System.out.println();
			System.out.println("이번엔 \'활동대사량\'을 구해보겠습니다.");
			System.out.println("\'활동대사량\'은 (활동지수(%)X기초대사량)의 공식으로 구해집니다.");
			System.out.println("활동지수를 선택해주세요.(1,2,3,4 중 정수입력)");
			System.out.println("1번:20% 하루 중 거의 앉아있는 사람 \n2번:30% 좌식 생활자중 도보량이 1~3km인 사람"
					+ "\n3번:40% 2번상황에서 매일 운동하는 사람 \n4번:50% 운동선수,육체 노동자");
			selectAR = sc.nextInt();

			// 활동대사량 공식
			if (selectAR == 1) {// 20% 하루 중 거의 앉아있는 사람
				actRate = 0.2f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else if (selectAR == 2) { // 30% 좌식 생활자중 도보량이 1~3km인 사람
				actRate = 0.3f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else if (selectAR == 3) { // 40% 30%에서 매일 운동하는 사람
				actRate = 0.4f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else { // 50% 운동선수,육체 노동자
				actRate = 0.5f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} // 활동대사량 공식
			System.out.println("계산해서, 회원님의 \'활동대사량\'은" + actmetabolicRate + "kcal가 되겠습니다.");
			System.out.println();
			System.out.println("\'소화대사량\'은 [(기초대사량+활동대사량)/0.9X0.1]의 공식으로 구해집니다.");
			digmetabolicRate = (int) ((basmetabolicRate + actmetabolicRate) / 0.9) * 0.1;
			System.out.println("계산해서, 회원님의 \'소화대사량\'은" + digmetabolicRate + "kcal가 되겠습니다.");

			System.out.println();
			System.out.println("기초대사량+활동대사량+소화대사량해서");
			System.out.println(
					"회원님의 \'신진대사량\'은" + (basmetabolicRate + actmetabolicRate + digmetabolicRate) + "kcal가 되겠습니다.");
			metabolicRate=(int) (basmetabolicRate + actmetabolicRate + digmetabolicRate);
			System.out.println("다이어트를 위해서는 회원님의 \'신진대사량\'에서 4~500kcal 정도 줄이면 도움이 될 것입니다. ");
			System.out.println();
			
		}//~여자inbody
		mb.AddInbodyInfo(height,weight,skeletMuscleMass, //PTmember 변수에 인바디 정보를 옮기는 메소드
				fatPercent,chestMass,
				shoulderMass,lowerbodyMass,backMuscleMass,
				armMass,abdominalMass,metabolicRate,
				basmetabolicRate
				,actmetabolicRate,digmetabolicRate,
				totalMuscleMass
				,avgMuscleMass);
		mb.addInbodyCount();
		}//~public void exeInbodyMachine(PTmember mb)
}