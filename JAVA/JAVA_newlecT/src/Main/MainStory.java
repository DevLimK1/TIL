package Main;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import Exercise.CardioWorkoutInfo;
import Exercise.ExerciseInfo;
import Exercise.WeightWorkoutInfo;
import Person.DietTrainer;
import Person.PTmember;
import Person.WeightTrainer;
import Place.GYM;
import Place.InbodyMachine;
import Thread.Timer;
import Thread.exerDoReps;

public class MainStory {
	public static void main(String[] args) {
		int PThour = 0; // 시간정하기
		int trainerFame;// 명성도
		int afterPT = 0; // PT 일정 정하는 변수
		int ptNum = 0; // pt받는 횟수
		int registMonth = 0;// 헬스등록 개월 수
		int select; // 조건선택 변수
		int ranMemberNum; // 예약한 멤버수(랜덤변수)
		int age = 0; // 생년월일
		int exerCareer; // 운동경력
		int coachCareer; // 코칭경력
		int coachSucNum; // 회원코칭 성공횟수
		int perPTprice; // 회당 PT가격
		int trainerLV; // 트레이너 레벨->레벨에 따라 PT회원 받을 수 있는 수가 달라짐,레벨업 기준:PT성공횟수
		int wtAwardNum = 0; // 웨이트 관련 대회 수상횟수
		int dtAwardNum = 0;// 다이어트 관련 대회 수상횟수
		int haveMoney = 0;
		int lv; // 헬스트레이너 레벨
		int i;
		int n = 0;
		int min; // 시간 변수조건
		int num; // 반복문 조건
		int compAbdominalMass; // 운동전 복근근육량 변수 임시저장
		int compChestMass; // 운동전 가슴근육량 변수 임시저장
		int compShoulderMass; // 운동전 어깨근육량 변수 임시저장
		int compLowerbodyMass; // 운동전 하체근육량 변수 임시저장
		int compBackMuscleMass; // 운동전 등근육량 변수 임시저장
		int compArmMass; // 운동전 팔 근육량 변수 임시저장
		int ptPrice = 0; // 회원이 지불해야할 PT가격
		int purpose = 0; // 운동목표
		int fame = 0; // 명성
		int inbodyCount = 0;
		int newNum=0;
		String ment; // 나(트레이너)의 멘트
		String PTdate;// PT받는 날짜
		String trainerName = null;// 헬스트레이너 이름
		String license; // 취득 자격증
		String sex; // 성별 M:male F:female
		String name; // 트레이너 이름

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		GYM teamNB = new GYM(); // GYM(헬스장) 객체 생성

		InbodyMachine im = new InbodyMachine();
		ExerciseInfo ex = new ExerciseInfo();
		CardioWorkoutInfo cw = new CardioWorkoutInfo();
		WeightWorkoutInfo ww = new WeightWorkoutInfo();

		Calendar cal = new GregorianCalendar(Locale.KOREA);

		cal.setTime(new Date()); // 현재시간 구하기
		SimpleDateFormat fm = new SimpleDateFormat("yyyy년MM월dd일");
		String toDay = fm.format(cal.getTime()); // 오늘 날짜
		System.out.print("현재 ");
		System.out.println(toDay); // 오늘날짜 출력
		System.out.println("");

////////////////////////////헬스타이쿤 설명시작/////////////////////////////////////////
		System.out.println("서울 동작구 남성역에는 'TNB 휘트니스\'가 있다.");
		// System.out.println("팀노바 휘트니스에 PT등록회원들 중 자신이 목표로하는 몸매로 트레이닝 시켜주는 \n "
		// + "일명 PersonalTraining 100%를 자랑하는 이가 있으니,");
		System.out.print("TNB 휘트니스에 여러 트레이너들 중 한명인 " + "Personal Training 전문 트레이너 \n이름 입력:");
		name = sc.next();
		System.out.println("\'" + name + "\'이다.");
		System.out.println();
		System.out.println(name + " 트레이너는 꿈이 있다.\n많은 회원들의 원하는 몸매 PT를 성공하여, 돈을 많이 벌어서 ");
		System.out.println("개인 헬스장을 개업하는 것이 헬스트레이너로서의 최종 목표이다.");
		System.out.println("개인 헬스장을 개업하는데 소비되는 돈은 약 10,000,000(천만)원이 필요하다.");
		System.out.println();
		System.out.println("돈을 빨리 모으려면, \'회원들 코칭 성공횟수\'를 높여서 \'트레이너 레벨\'을 올리고, 이에 따라 많은 회원들을 모집하는 것이다.");
		System.out.println("트레이너 레벨1,2,3..으로 올라갈 때마다 (5*레벨)의 값만큼 회원들을 모집할 수 있다.");
		System.out.println("예를들어, 레벨1이면 5*1=5이므로 회원수 5명까지가 최대 모집인원이 되는 것이다.");
		System.out.println();
		System.out.println("또한, 트레이너 PT 한 회당 가격이 책정되는데 책정되는 기준은");
		System.out.println("(코칭경력*코칭경력 기본급(500원))+(코칭 성공횟수*코칭 성공기본급(500원))"
				+ "\n+기본PT급여(10,000원)+(웨이트대회 수상횟수*수상 수당(10,000원)) 기준으로 책정된다.");
		System.out.println("PT회원은 PT등록 횟수가 끝나면 추가등록을 해야한다.");
		System.out.println();
		//////////////////////////// 헬스타이쿤설명끝/////////////////////////////////////////
		System.out.println("위와 같은 조건을 기준으로, " + name + " 트레이너에 대한 프로필을 소개하자면");

		System.out.print("생년월일(ex001122):");
		age = sc.nextInt();
		int hundThousand = age / 100000; // 10만자리
		int tenThousand = (age % 100000) / 10000;// 만자리
		int thousand = (age % 10000) / 1000; // 천의자리
		int hundred = (age % 1000) / 100; // 백의자리
		int ten = (age % 100) / 10; // 십의 자리
		int one = (age % 100) % 10; // 일의 자리

		while (true) { // 생년월일 점검
			if (thousand > 1) { // 천의자리 달력은 12월까지
				System.out.println("생년월일 다시 입력하십시오.");
				age = sc.nextInt();
				hundThousand = age / 100000; // 10만자리
				tenThousand = (age % 100000) / 10000;// 만자리
				thousand = (age % 10000) / 1000; // 천의자리
				hundred = (age % 1000) / 100; // 백의자리
				ten = (age % 100) / 10; // 십의 자리
				one = (age % 100) % 10; // 일의 자리
			} else if (ten > 3 || (ten >= 3 && one > 1)) { // 십의자리 달력은 최대 31일까지임
				System.out.println("생년월일 다시 입력하십시오.");
				age = sc.nextInt();
				hundThousand = age / 100000; // 10만자리
				tenThousand = (age % 100000) / 10000;// 만자리
				thousand = (age % 10000) / 1000; // 천의자리
				hundred = (age % 1000) / 100; // 백의자리
				ten = (age % 100) / 10; // 십의 자리
				one = (age % 100) % 10; // 일의 자리
			} else if (hundThousand == 0) {
				System.out.println("생년월일 다시 입력하십시오.");
				age = sc.nextInt();
				hundThousand = age / 100000; // 10만자리
				tenThousand = (age % 100000) / 10000;// 만자리
				thousand = (age % 10000) / 1000; // 천의자리
				hundred = (age % 1000) / 100; // 백의자리
				ten = (age % 100) / 10; // 십의 자리
				one = (age % 100) % 10; // 일의 자리
			} else { // 다 괜찮으면
				break;
			}
		} // 생년월일 루프
		System.out.print("성별(ex. m(male),f(female)) 소문자 입력:");
		sex = sc.next();
		while (true) { // 성별 체크
			if (sex.equals("m") || sex.equals("f")) {
				break;
			} else {
				System.out.println("성별 다시 M(male),F(female) 중 정확히 소문자 한글자로 입력해주세요.");
				sex = sc.next();
			}
		}

		while (true) {
			// 예외가 발생할지 아닐지 모르지만, 우선 실행해본다.
			try {
				// 예외가 발생할 가능성이 있는 코드를 입력
				System.out.print("운동경력(개월) 정수 입력:");
				exerCareer = sc.nextInt();
				break;
			}

			// try 내부의 코드가 InputMismatchException 을 던진다면, 예외를 받아온다.
			// catch가 실행되는 동안은 Program 이 종료되지 않는다.
			catch (InputMismatchException ime) {
				// 스캐너의 버그를 해결하기 위한 코드

				sc = new Scanner(System.in);
				System.out.println("입력오류!! 정수로 입력해주세요.");

				// 애용해야하는 코드
				// 어떤 예외가 어떻게 발생했는지 간략히 알려준다
				System.out.println(ime.getClass().getName() + " 예외가 " + ime.getMessage() + " 때문에 발생했습니다.");
			} // ~catch
		} // ~while 예외처리

		while (true) {
			// 예외가 발생할지 아닐지 모르지만, 우선 실행해본다.
			try {
				// 예외가 발생할 가능성이 있는 코드를 입력
				System.out.print("코칭경력(개월) 정수 입력:");
				coachCareer = sc.nextInt();
				break;
			}

			// try 내부의 코드가 InputMismatchException 을 던진다면, 예외를 받아온다.
			// catch가 실행되는 동안은 Program 이 종료되지 않는다.
			catch (InputMismatchException ime) {
				// 스캐너의 버그를 해결하기 위한 코드

				sc = new Scanner(System.in);
				System.out.println("입력오류!! 정수로 입력해주세요.");

				// 애용해야하는 코드
				// 어떤 예외가 어떻게 발생했는지 간략히 알려준다
				System.out.println(ime.getClass().getName() + " 예외가 " + ime.getMessage() + " 때문에 발생했습니다.");
			} // ~catch
		} // ~while 예외처리

		while (true) {
			// 예외가 발생할지 아닐지 모르지만, 우선 실행해본다.
			try {
				// 예외가 발생할 가능성이 있는 코드를 입력
				System.out.print("회원코칭 성공횟수(회) 정수 입력:");
				coachSucNum = sc.nextInt();
				break;
			}

			// try 내부의 코드가 InputMismatchException 을 던진다면, 예외를 받아온다.
			// catch가 실행되는 동안은 Program 이 종료되지 않는다.
			catch (InputMismatchException ime) {
				// 스캐너의 버그를 해결하기 위한 코드

				sc = new Scanner(System.in);
				System.out.println("입력오류!! 정수로 입력해주세요.");

				// 애용해야하는 코드
				// 어떤 예외가 어떻게 발생했는지 간략히 알려준다
				System.out.println(ime.getClass().getName() + " 예외가 " + ime.getMessage() + " 때문에 발생했습니다.");
			} // ~catch
		} // ~while 예외처리

		///////////////////////////////// 객체생성////////////////////////////////////////

		while (true) {
			// 예외가 발생할지 아닐지 모르지만, 우선 실행해본다.
			try {
				// 예외가 발생할 가능성이 있는 코드를 입력
				System.out.println(name + "는 (1.웨이트트레이닝/2.다이어트트레이닝) "); // 임노프 Mode 선택
				select = sc.nextInt();
				break;
			}

			// try 내부의 코드가 InputMismatchException 을 던진다면, 예외를 받아온다.
			// catch가 실행되는 동안은 Program 이 종료되지 않는다.
			catch (InputMismatchException ime) {
				// 스캐너의 버그를 해결하기 위한 코드

				sc = new Scanner(System.in);
				System.out.println("입력오류!! 정수로 입력해주세요.");

				// 애용해야하는 코드
				// 어떤 예외가 어떻게 발생했는지 간략히 알려준다
				System.out.println(ime.getClass().getName() + " 예외가 " + ime.getMessage() + " 때문에 발생했습니다.");
			} // ~catch
		} // ~while 예외처리
			// while (true) {
//////////////////////////////웨이트트레이너 내용 시작////////////////////////////////////////////////////
		if (select == 1) {
			System.out.println("\"웨이트트레이닝 전문 PT트레이너다.\"");
			System.out.print("웨이트 관련 대회 수상 횟수(회)정수 입력:");
			wtAwardNum = sc.nextInt();
			// 트레이너들 객체생성
			WeightTrainer lim = new WeightTrainer(name, age, sex, exerCareer, coachCareer, coachSucNum, fame, 0,
					wtAwardNum);
			lim.perPTprice(); // 트레이너 회당 PT가격

			WeightTrainer kim = new WeightTrainer("철수", 920505, "M", 24, 12, 10, 2, 10, 2);

			WeightTrainer lee = new WeightTrainer("영희", 910606, "M", 32, 24, 20, 4, 100, 5);

			System.out.println();
			System.out.println("*******TNB 트레이너 프로필*******");
			// 헬스트레이너들 정보 보기
			lim.getTrainerProfile();
			kim.getTrainerProfile();
			lee.getTrainerProfile();
			System.out.println("**************************");

			/////////////////////////////// 웨이트트레이너
			/////////////////////////////// 객체생성완료//////////////////////////////////////////

			System.out.println();
//				System.out.println(name+" 트레이너는 궁극적인 목표가 있다.\n 회원들을 PT하여 모은 돈을 저축하여");
//				System.out.println("개인 헬스장을 개업하는 것이 헬스트레이너로서의 최종 목표이다.");
//				System.out.println("개인 헬스장을 개업하는데 소비되는 돈은 약 10,000,000(천만)원이 필요하다.");
			System.out.println("10,000,000(천만원)을 열심히 모으자!");
			System.out.println("");
			System.out.println("");
			////////////////////// 천만원 될 때가지 반복문시작///////////////////////////////////
			// while (lim.haveMoney < 100000) { // 천만원 될때까지 회원받기
//					System.out.println(lim.haveMoney + "/10,000,000원");
//					System.out.println(" 10,000,000원을 향해!!");
//					System.out.println();
			fame = lim.fameCheck();// 트레이너명성 측정메소드

			System.out.println(name + "는 현재 트레이너 명성도가" + fame + "로, 하루 PT예약을 최대" + 5 * fame + "명까지 받을 수 있다.");

			System.out.println("(1.예약인원 임의 지정  2.예약인원 랜덤 지정)");
			select = sc.nextInt();
			System.out.println("예약인원 입력:");
			if (select == 1) {
				select = sc.nextInt();
				ranMemberNum = select;
				System.out.println("오늘 PT예약 인원은" + ranMemberNum + "명이 예약했다."); // 랜덤함수로 예약인원 랜덤설정
			} else {
				ranMemberNum = ran.nextInt(5 * fame) + 1;// 명성에 따라 회원 랜덤 받음
				System.out.println("오늘 PT예약 인원은" + ranMemberNum + "명이 예약했다."); // 랜덤함수로 예약인원 랜덤설정
			}

			ArrayList<PTmember> member = new ArrayList<PTmember>(); // arraylist 객체 생성

			for (i = 0; i < ranMemberNum; i++) { // 회원 객체 생성=>arraylist 배열로 생성하기,(나중에 중도 포기하는 사람들 삭제하기 위해)
				// String name, int age, String sex, int exerCareer,int registMonth,String
				// trainerName,int ptNum
				System.out.println("(" + (i + 1) + "번째 회원님 프로필)");
				System.out.print("이름 입력:");
				name = sc.next();
				System.out.print("성별(ex. m(male),f(female)) 소문자 입력:");
				sex = sc.next();

				while (true) { // 성별 체크
					if (sex.equals("m") || sex.equals("f")) {
						break;
					} else {
						System.out.println("성별 다시 m(male),f(female) 중 정확히 소문자 한글자로 입력해주세요.");
						sex = sc.next();
					}
				}
				age = ran.nextInt(20) + 20;
				System.out.println("나이:" + age);
//						System.out.println();
				// ptNum =ran.nextInt(9)+1; //PT받는 횟수 랜덤받음
				ptNum = 1;
				System.out.println("PT 받는 횟수 입력:" + ptNum + "회");

//						if (lim.getName().equals(trainerName)) { //지불해야할 PT가격
//							ptPrice = (lim.getPTprice() * ptNum);
//						}
				ptPrice = (lim.getPTprice() * ptNum);
				System.out.printf("지불해야할 PT가격:%d", ptPrice);

				// System.out.print("운동경력(개월) 정수 입력:");
				// exerCareer=sc.nextInt();

				System.out.println();
				System.out.println();
				System.out.println("=======PT 일정 잡기======="); // d-day 활용

				// System.out.println("T(trainer):함께, 상담 진행할 날짜를 정해봅시다."); // 회원 대답쓰레드 정해보기?
				// int current = 0;
				// cal.add(Calendar.YEAR, 1); // 1년을 더한다.
				// cal.add(Calendar.MONTH, 1); // 한달을 더한다.
				// cal.add(Calendar.DAY_OF_YEAR, 1); // 하루를 더한다.
				// cal.add(Calendar.HOUR, 1); // 시간을 더한다
				// if (current == 0) {

				// int afterPT = ran.nextInt(7) + 1; // 1~7(일주일)내로 랜덤함수
				System.out.println("며칠 후에 PT일정 잡을지 입력하시오:");
				afterPT = sc.nextInt();
				// afterPT=ran.nextInt(7)+1; //며칠 후에 PT일정 받는게 좋은지
				// System.out.println("afterPT:"+afterPT);

				cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT일수를 더한다.
				PTdate = fm.format(cal.getTime());
				System.out.println("PT일정:" + PTdate);
				System.out.println(PTdate + "에 몇시에 PT진행할지 입력하시오:");
				PThour = sc.nextInt();
				System.out.println("PT시간:" + PThour + "시");
				System.out.println();
				lim.schedulePT(i, lim.getName(), PTdate, PThour); // 트레이너한테 회원 index와 PT잡은 날짜 집어넣기
				cal.add(Calendar.DAY_OF_YEAR, afterPT);
				
				System.out.println();
				member.add(new PTmember(name, age, sex, ptNum, ptPrice, PTdate, PThour, inbodyCount)); // PTmember객체생성완료

				if (member.get(i).getInbodyCount() == 0) { // 카운트가0이면 inbody 실행
					System.out.println("T:" + member.get(i).getName() + "님 앞으로 PT 받으실텐데,\n "
							+ "회원님 몸 상태를 기록해 놓을게요. \'인바디\' 기계앞에 서실게요.");
					System.out.println("MB:인바디가 무엇인가요?");
					System.out.println("\'인바디란 무엇이냐면," + "신체에 미세한 교류 전압을 통과시켜 수분, 지방, 근육 등 조직에 따라\n"
							+ "다른 저항도를 이용하여 인체의 구성 성분을 평가하는 방법이에요.");
					System.out.println();
					im.exeInbodyMachine(member.get(i)); // 인바디머신작동 메소드
				}
				member.get(i).checkInbodyCount();

				System.out.println();
//						member.get(i).getInbodyMass();
//						member.get(i).getPTmbprofile(); //멤버 프로필 보기

				lim.haveMoney += ptPrice;

				System.out.println();
				lim.getTrainerProfile();
				System.out.println("$$$수중에 있는 돈 추가된 것 확인$$$");
				cal.setTime(new Date()); // 현재시간 구하기
				toDay = fm.format(cal.getTime()); // 오늘 날짜 초기화
				// }//~current==0 if절
				///////////////////// 코드현재 진행상황 보기////////////////////////////
				System.out.println("콘솔확인");
				name = sc.next();
				///////////////////// 코드현재 진행상황 보기///////////////////////////

			} // ~for(i=0;i<ranMemberNum;i++) { //회원 객체 생성=>arraylist배열로 생성하기,
				// (나중에 중도 포기하는 사람들 삭제하기 위해)

			//////////////////////////// 회원프로필 끝/////////////////////////////////////

			int j; // 반복문 변수조건
			int p; // 반복문 변수조건
////////////////////////하루하루 지나가면서 회원PT날짜 확인 후 일정진행///////////////////////////////////////////////////////
			System.out.println("++++++모든 회원 프로필 작성완료++++++");
			System.out.println();
			System.out.println("회원들마다 PT일정이 될 때까지 일정 진행..");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.print("금일: ");
			System.out.println(toDay); // 오늘날짜 출력
			try {
				for (j = 0; j < 3; j++) {
					System.out.println(".");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("->일정이 없습니다.");
			System.out.println();
//			cal.add(Calendar.DAY_OF_YEAR, 1); // afterPT일수를 더한다.
//			toDay = fm.format(cal.getTime());
//			System.out.println("금일:"+toDay+"입니다.");
			while (true) { // 날짜 하루 지나가면서 일정체크
				
				if(lim.haveMoney<10000000) { //하루 지나서 회원받을건지 결정되는 조건문
					System.out.println("(1.예약인원 임의 지정  2.예약인원 랜덤 지정)");
					select = sc.nextInt();
					System.out.println("예약인원 입력:");
					if (select == 1) {
						select = sc.nextInt();
						ranMemberNum = select;
						System.out.println("오늘 PT예약 인원은" + ranMemberNum + "명이 예약했다."); // 랜덤함수로 예약인원 랜덤설정
					} else {
						ranMemberNum = ran.nextInt(5 * fame) + 1;// 명성에 따라 회원 랜덤 받음
						System.out.println("오늘 PT예약 인원은" + ranMemberNum + "명이 예약했다."); // 랜덤함수로 예약인원 랜덤설정
					}
					/////////////////////////lim.haveMoney<100000 새로운 멤버 객체생성/////////////////////////////////
					for (newNum =i ; newNum < i+ranMemberNum; newNum++) { // 회원 객체 생성=>arraylist 배열로 생성하기,(나중에 중도 포기하는 사람들 삭제하기 위해)
						// String name, int age, String sex, int exerCareer,int registMonth,String
						// trainerName,int ptNum
						System.out.println("(" + (newNum + 1) + "번째 회원님 프로필)");
						System.out.print("이름 입력:");
						name = sc.next();
						System.out.print("성별(ex. m(male),f(female)) 소문자 입력:");
						sex = sc.next();

						while (true) { // 성별 체크
							if (sex.equals("m") || sex.equals("f")) {
								break;
							} else {
								System.out.println("성별 다시 m(male),f(female) 중 정확히 소문자 한글자로 입력해주세요.");
								sex = sc.next();
							}
						}
						age = ran.nextInt(20) + 20;
						System.out.println("나이:" + age);
//								System.out.println();
						// ptNum =ran.nextInt(9)+1; //PT받는 횟수 랜덤받음
						ptNum = 1;
						System.out.println("PT 받는 횟수 입력:" + ptNum + "회");

//								if (lim.getName().equals(trainerName)) { //지불해야할 PT가격
//									ptPrice = (lim.getPTprice() * ptNum);
//								}
						ptPrice = (lim.getPTprice() * ptNum);
						System.out.printf("지불해야할 PT가격:%d", ptPrice);

						// System.out.print("운동경력(개월) 정수 입력:");
						// exerCareer=sc.nextInt();

						System.out.println();
						System.out.println();
						System.out.println("=======PT 일정 잡기======="); // d-day 활용

						// System.out.println("T(trainer):함께, 상담 진행할 날짜를 정해봅시다."); // 회원 대답쓰레드 정해보기?
						// int current = 0;
						// cal.add(Calendar.YEAR, 1); // 1년을 더한다.
						// cal.add(Calendar.MONTH, 1); // 한달을 더한다.
						// cal.add(Calendar.DAY_OF_YEAR, 1); // 하루를 더한다.
						// cal.add(Calendar.HOUR, 1); // 시간을 더한다
						// if (current == 0) {

						// int afterPT = ran.nextInt(7) + 1; // 1~7(일주일)내로 랜덤함수
						System.out.println("며칠 후에 PT일정 잡을지 입력하시오:");
						afterPT = sc.nextInt();
						// afterPT=ran.nextInt(7)+1; //며칠 후에 PT일정 받는게 좋은지
						// System.out.println("afterPT:"+afterPT);

						cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT일수를 더한다.
						PTdate = fm.format(cal.getTime());
						System.out.println("PT일정:" + PTdate);
						System.out.println(PTdate + "에 몇시에 PT진행할지 입력하시오:");
						PThour = sc.nextInt();
						System.out.println("PT시간:" + PThour + "시");
						System.out.println();
						lim.schedulePT(newNum, lim.getName(), PTdate, PThour); // 트레이너한테 회원 index와 PT잡은 날짜 집어넣기
						cal.add(Calendar.DAY_OF_YEAR, -afterPT);
						System.out.println();
						member.add(new PTmember(name, age, sex, ptNum, ptPrice, PTdate, PThour, inbodyCount)); // PTmember객체생성완료

						if (member.get(newNum).getInbodyCount() == 0) { // 카운트가0이면 inbody 실행
							System.out.println("T:" + member.get(newNum).getName() + "님 앞으로 PT 받으실텐데,\n "
									+ "회원님 몸 상태를 기록해 놓을게요. \'인바디\' 기계앞에 서실게요.");
							System.out.println("MB:인바디가 무엇인가요?");
							System.out.println("\'인바디란 무엇이냐면," + "신체에 미세한 교류 전압을 통과시켜 수분, 지방, 근육 등 조직에 따라\n"
									+ "다른 저항도를 이용하여 인체의 구성 성분을 평가하는 방법이에요.");
							System.out.println();
							im.exeInbodyMachine(member.get(newNum)); // 인바디머신작동 메소드
						}
						member.get(newNum).checkInbodyCount();

						System.out.println();
//								member.get(i).getInbodyMass();
//								member.get(i).getPTmbprofile(); //멤버 프로필 보기

						lim.haveMoney += ptPrice;

						System.out.println();
						lim.getTrainerProfile();
						System.out.println("$$$수중에 있는 돈 추가된 것 확인$$$");
					}
					
				}//~ if 	if(lim.haveMoney<100000)이면 회원 받기
				else if(lim.haveMoney>10000000){ //havemoney>목표돈 이면 받지 않기
					 System.out.println("제가 이제 곧 그만두기때문에,");
					 System.out.println("더 이상 회원을 받지 않습니다. 죄송합니다.");
				}
					
				try { // 3초 sleep
					cal.add(Calendar.DAY_OF_YEAR, 1); // afterPT일수를 더한다.

					toDay = fm.format(cal.getTime());
					System.out.print(toDay); // 하루지난 날짜 출력
					System.out.println(" 일정 체크 중");
					for (j = 0; j < 3; j++) {
						System.out.println(".");
						Thread.sleep(1000);
					}

				}

				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int k = 0; // 조건변수
				int PTday = 0; // 일정이 있는 날인지 확인
				int PTcount = 0;// 하루에 PT 몇명 받는지 for문 돌리기위해
				int nTemp[] = new int[member.size()];
				for (p = 0; p < member.size(); p++) { // 회원들 pt일정 확인
					if (toDay.equals(member.get(p).getPTdate())) {
						System.out.println("->" + member.get(p).getName() + "님 " + member.get(p).getPThour() + "시");
						PTday++;
						PTcount++;
						nTemp[k] = member.get(p).getPThour();
						k++;
					}
				}
				if (PTday == 0) {
					System.out.println("->일정이 없습니다.");
				} else {
					Music gymMusic = new Music("운동할때 듣는 음악_운동자극용 음악 모음 1시간(제목,시간 다 있음).mp3", true);
					gymMusic.start();

					System.out.println("PT 진행 날 입니다.");
					System.out.println();
					/////////////////// 시간순서 빠른 사람부터 PT진행////////////////////////////
					AscendFunc.lineUp(nTemp, PTcount);
					n = 0;
					for (k = 0; k < PTcount; k++) { // 당일 PT 진행 인원 수
						for (j = 0; j < member.size(); j++) {
							if (nTemp[n] == member.get(j).getPThour() && member.get(j).getPTdate().equals(toDay)) {// 배열시간숫자==PT받는사람
																													// 시간같은사람
																													// &&
																													// 날짜도
																													// 동시에
																													// 같아야함
								////////////////////////// PT진행/////////////////////////////////
								System.out.println(
										"<" + member.get(j).getName() + "님 " + member.get(j).getPThour() + "시 PT진행>");
//									
								if(n<member.size()) {
								n++; // nTemp[k] 인덱스가 올라가야함..
								}
								// if (member.get(j).getSex().equals("M")) {// 남자
								System.out.println("먼저 운동전 회원님의 근육량을 확인해보도록 할게요.");
								System.out.println();
								System.out.println("T:현재 \'복근\' 근육량은" + member.get(j).getAbdominalMass() + ",");
								compAbdominalMass = member.get(j).getAbdominalMass();
								System.out.println("T:\'팔\' 근육량은" + member.get(j).getArmMass() + ",");
								compArmMass = member.get(j).getArmMass();
								System.out.println("T:\'등\' 근육량은" + member.get(j).getBackMuscleMass() + ",");
								compBackMuscleMass = member.get(j).getBackMuscleMass();
								System.out.println("T:\'가슴\' 근육량은" + member.get(j).getChestMass() + ",");
								compChestMass = member.get(j).getChestMass();
								System.out.println("T:\'하체\' 근육량은" + member.get(j).getLowerbodyMass() + ",");
								compLowerbodyMass = member.get(j).getLowerbodyMass();
								System.out.println("T:\'어깨\' 근육량은" + member.get(j).getShoulderMass() + "이네요.");
								compShoulderMass = member.get(j).getShoulderMass();

								System.out.println("============운동 시작============"); // 쓰레드 시간 제한둬서
																						// 운동..
								System.out.print("PT 몇 분 진행하겠습니까? 정수 입력:");
								min = sc.nextInt();
								System.out.println("(PT시간 " + min + "분 진행)");
								Timer t1 = new Timer(min * 60); // 120: 2분 180: 3분...
								// t1.setDaemon(true); //메인쓰레드가 종료되면 timer쓰레드 종료
								t1.start(); // 쓰레드 시작
//											try { //join
//												t1.join();
//											} catch (InterruptedException e1) {
//												// TODO Auto-generated catch block
//												e1.printStackTrace();
//											}
								//gymMusic.close();

								while (true) { // 운동종목 골라서 운동하기
									exerDoReps t2 = new exerDoReps(11);
									exerDoReps last = new exerDoReps(1);
									Music gymMusic2 = new Music("운동할때 듣는 음악_운동자극용 음악 모음 1시간(제목,시간 다 있음).mp3", true);
									gymMusic2.start();

									System.out.println("1.복근 2.팔 3.등 4.가슴 5.하체 6.어깨 7.운동종료");
									num = sc.nextInt();
									if (num == 1) { // 복근 선택
										//gymMusic2.close();
										System.out.println("1.크런치 2.레그레이즈 3.윗몸일으키기");
										num = sc.nextInt();
										if (num == 1) { // 크런치 수행
											member.get(j).doCrunch(10);
											t2.start();

											try {
												t2.join();
											} catch (Exception e) {
											}

										}

										else if (num == 2) { // 2.레그레이즈
											member.get(j).doLegraise(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.윗몸일으키기
											member.get(j).doSitup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} // ~if 복근선택 num==1
									else if (num == 2) { // 2.팔
										//gymMusic2.close();
										System.out.println("1.덤벨컬 2.바벨컬 3.덤벨킥백");
										num = sc.nextInt();
										if (num == 1) { // 1.덤벨컬 수행
											member.get(j).doDBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.바벨컬
											member.get(j).doBBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.덤벨킥백
											member.get(j).doDBkickback(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 3) { // 3.등
										//gymMusic2.close();
										System.out.println("1.데드리프트 2.바벨로우3.턱걸이");
										num = sc.nextInt();
										if (num == 1) { // 1.데드리프트 수행
											member.get(j).doDeadlift(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.바벨로우
											member.get(j).doBBlow(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.턱걸이
											member.get(j).doPullup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 4) { // 4.가슴
										//gymMusic2.close();
										System.out.println("1.벤치프레스 2.팔굽혀펴기 3.케이블플라이");
										num = sc.nextInt();
										if (num == 1) { // 1.벤치프레스 수행
											member.get(j).doDBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.팔굽혀펴기
											member.get(j).doPushup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.케이블플라이
											member.get(j).doCablefly(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 5) { // 5.하체
										//gymMusic2.close();
										System.out.println("1.레그프레스 2.레그익스텐션 3.스쿼트");
										num = sc.nextInt();
										if (num == 1) { // 1.레그프레스 수행
											member.get(j).doLegpress(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.레그익스텐션
											member.get(j).doLegextension(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.스쿼트
											member.get(j).doSquat(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 6) {// 6.어깨
										//gymMusic2.close();
										System.out.println("1.오버헤드바벨프레스 2.사이드레터럴레이즈" + "3.덤벨프론트레이즈");
										num = sc.nextInt();
										if (num == 1) { // 1.OHP 수행
											member.get(j).doOHP(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.사레레
											member.get(j).doSideRR(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.덤벨프론트레이즈
											member.get(j).doDBfrontraise(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else {
										//gymMusic2.close();
										last.start();
										try {
											last.join();
										} catch (Exception e) {
										}
										t1.interrupt();
										break;
									}

								}

								// ~while(true) 운동종목 골라서 운동하기
								System.out.println();
								System.out.println("******운동 결과******");
								System.out.println(
										"-복근 운동:" + compAbdominalMass + "->" + member.get(j).getAbdominalMass());
								System.out.println("-가슴 운동:" + compChestMass + "->" + member.get(j).getChestMass());
								System.out
										.println("-어깨 운동:" + compShoulderMass + "->" + member.get(j).getShoulderMass());
								System.out.println(
										"-하체 운동:" + compLowerbodyMass + "->" + member.get(j).getLowerbodyMass());
								System.out.println(
										"-등 운동:" + compBackMuscleMass + "->" + member.get(j).getBackMuscleMass());
								System.out.println("-팔 운동:" + compArmMass + "->" + member.get(j).getArmMass());
								System.out.println();
								member.get(j).doPTnum(); // PT 횟수 하나 줄이기
								System.out.println();
								member.get(j).getPTmbprofile(); // 멤버 프로필 확인
								///////////////////// 코드현재 진행상황 보기////////////////////////////
								System.out.println("콘솔확인");
								name = sc.next();
								///////////////////// 코드현재 진행상황 보기///////////////////////////
								if (member.get(j).getPTnum() == 0) { // PT 등록횟수 끝남
									System.out.println("T:" + member.get(j).getName() + "님, " + "PT레슨 등록이 끝났습니다.");
									System.out.println("추가 등록하시겠습니까?(1.그렇다 / 2.아니다. 그만 배우겠다.)");
									select = sc.nextInt();
									if (select == 1) {// 그렇다
										System.out.println("T:PT 몇회 추가등록 하겠습니까?");
										ptNum = sc.nextInt();
										System.out.println("MB:" + ptNum + "회 추가등록 하겠습니다.");
										member.get(j).setPTnum(lim, ptNum);
										lim.haveMoney += member.get(j).getPTprice();
										System.out.println();

										lim.getTrainerProfile();// 수중에 있는 돈 확인
										System.out.println("$$$수중에 있는 돈 추가된 것 확인$$$");
									} // ~if 등록하겠다.
									else {
										System.out.println("그동안, PT 지도해주셔서 감사했습니다.");
										member.remove(j); // 회원 객체 삭제
										continue;
									}
								} // ~if (member.get(j).getPTnum()==0)PT등록끝남
									// PT 계속 진행상황
								System.out.println("=======PT 일정 잡기======="); // d-day 활용

								// System.out.println("T(trainer):함께, 상담 진행할 날짜를 정해봅시다."); // 회원 대답쓰레드 정해보기?
								// int current = 0;
								// cal.add(Calendar.YEAR, 1); // 1년을 더한다.
								// cal.add(Calendar.MONTH, 1); // 한달을 더한다.
								// cal.add(Calendar.DAY_OF_YEAR, 1); // 하루를 더한다.
								// cal.add(Calendar.HOUR, 1); // 시간을 더한다
								// if (current == 0) {

								// int afterPT = ran.nextInt(7) + 1; // 1~7(일주일)내로 랜덤함수
								System.out.println("며칠 후에 PT일정 잡을지 입력하시오:");
								afterPT = sc.nextInt();
								// afterPT=ran.nextInt(7)+1; //며칠 후에 PT일정 받는게 좋은지
								// System.out.println("afterPT:"+afterPT);

								cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT일수를 더한다.
								PTdate = fm.format(cal.getTime());
								System.out.println("PT일정:" + PTdate);
								System.out.println(PTdate + "에 몇시에 PT진행할지 입력하시오:");
								PThour = sc.nextInt();
								System.out.println("PT시간:" + PThour + "시");
								cal.add(Calendar.DAY_OF_YEAR, -afterPT);

								System.out.println();

								member.get(j).setPTdateNhour(PTdate, PThour);
								member.get(j).getPTmbprofile();
								// member.add(new
								// PTmember(name,age,sex,registMonth,trainerName,ptNum,PTdate,PThour,ptPrice));
								// //PTmember 객체생성완료
								lim.schedulePT(j, lim.getName(), PTdate, PThour); // 트레이너한테 회원 index와 PT잡은 날짜
								// lim.sumMoney(member.get(j).getPTprice());// PT비용 수입
								System.out.println();

								// } // if (member.get(j).getSex().equals("M")) {// 남자
								//////////////////////////////////////////////////////////////
//										System.out.println("=======PT 일정 잡기======="); // d-day 활용
//
//										System.out.println("=======PT 일정 잡기======="); // d-day 활용
//
//										//		System.out.println("T(trainer):함께, 상담 진행할 날짜를 정해봅시다."); // 회원 대답쓰레드 정해보기?
//												// int current = 0;
//												// cal.add(Calendar.YEAR, 1); // 1년을 더한다.
//												// cal.add(Calendar.MONTH, 1); // 한달을 더한다.
//												// cal.add(Calendar.DAY_OF_YEAR, 1); // 하루를 더한다.
//												// cal.add(Calendar.HOUR, 1); // 시간을 더한다
//												// if (current == 0) {
//
//												// int afterPT = ran.nextInt(7) + 1; // 1~7(일주일)내로 랜덤함수
//												System.out.println("며칠 후에 PT일정 잡을지 입력하시오:");
//												afterPT=sc.nextInt();
//												//afterPT=ran.nextInt(7)+1; //며칠 후에 PT일정 받는게 좋은지
//												//System.out.println("afterPT:"+afterPT);
//												
//												cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT일수를 더한다.
//												PTdate = fm.format(cal.getTime());
//												System.out.println("PT일정:"+PTdate);
//												System.out.println(PTdate+"에 몇시에 PT진행할지 입력하시오:");
//												PThour=sc.nextInt();
//												System.out.println("PT시간:"+PThour+"시");
//												
//							
//												System.out.println();
//										
//										System.out.println();
//										member.get(j).setPTdateNhour(PTdate, PThour);
//										// member.add(new
//										// PTmember(name,age,sex,registMonth,trainerName,ptNum,PTdate,PThour,ptPrice));
//										// //PTmember 객체생성완료
//										lim.schedulePT(j, lim.getName(), PTdate, PThour); // 트레이너한테 회원 index와 PT잡은 날짜
//										lim.sumMoney(member.get(j).getPTprice());// PT비용 수입
								System.out.println();

								///////////////////////////////////////////////////////////////
								// break; // 반복문탈출

								// }//~if (select == 1) 1.권상우 같은 근육질
//										else { // 여자
//											System.out.println("good");
//										}//~else
							} // ~if(nTemp[k]==member.get(j).getPThour() 배열시간숫자==PT받는시간

						} // ~for2 (j=0;j<PTcount;j++)
					} // ~for(k=0;k<PTcount;k++ 당일 PT 진행 인원 수
				} // ~else PT 진행날이다.

				System.out.println();
				if (member.size() == 0) { // 회원이 한명도 없으면 break;
					break;
				}//~member size
				
			} // ~while 날짜 하루 지나가면서 일정체크

			/////////////////////// ending////////////////////////////////////////
			// } // ~ while(lim.haveMoney<10000000)천만원될때까지 회원받기
			System.out.println("============================ending============================");
			System.out.println("TNB휘트니스에서 번 돈이 "+lim.haveMoney+" 벌었어!");
			System.out.println("이제 개인 헬스장을 개업해서 더욱 멋지게 살아가야지!!");
		} // ~if(select==1)웨이트트레이너 객체 생성
			////////////////////////////// 웨이트트레이너 내용
			// 끝////////////////////////////////////////////////////

//////////////////////////////다이어트 트레이너 내용 시작 ////////////////////////////////////////////////////
		else if (select == 2) {
			System.out.println("\"웨이트트레이닝 전문 PT트레이너다.\"");
			System.out.print("웨이트 관련 대회 수상 횟수(회)정수 입력:");
			wtAwardNum = sc.nextInt();
			// 트레이너들 객체생성
			WeightTrainer lim = new WeightTrainer(name, age, sex, exerCareer, coachCareer, coachSucNum, fame, 0,
					wtAwardNum);
			lim.perPTprice(); // 트레이너 회당 PT가격

			WeightTrainer kim = new WeightTrainer("철수", 950505, "M", 24, 12, 10, 2, 10, 2);

			WeightTrainer lee = new WeightTrainer("영희", 930606, "F", 32, 24, 20, 4, 100, 5);

			System.out.println();
			System.out.println("*******TNB 트레이너 프로필*******");
			// 헬스트레이너들 정보 보기
			lim.getTrainerProfile();
			kim.getTrainerProfile();
			lee.getTrainerProfile();
			System.out.println("**************************");

			/////////////////////////////// 웨이트트레이너
			/////////////////////////////// 객체생성완료//////////////////////////////////////////

			System.out.println();
//				System.out.println(name+" 트레이너는 궁극적인 목표가 있다.\n 회원들을 PT하여 모은 돈을 저축하여");
//				System.out.println("개인 헬스장을 개업하는 것이 헬스트레이너로서의 최종 목표이다.");
//				System.out.println("개인 헬스장을 개업하는데 소비되는 돈은 약 10,000,000(천만)원이 필요하다.");
			System.out.println("10,000,000(천만원)을 열심히 모으자!");
			System.out.println("");
			System.out.println("");
			////////////////////// 천만원 될 때가지 반복문시작///////////////////////////////////
			// while (lim.haveMoney < 100000) { // 천만원 될때까지 회원받기
//					System.out.println(lim.haveMoney + "/10,000,000원");
//					System.out.println(" 10,000,000원을 향해!!");
//					System.out.println();
			fame = lim.fameCheck();// 트레이너명성 측정메소드

			System.out.println(name + "는 현재 트레이너 명성도가" + fame + "로, 하루 PT예약을 최대" + 5 * fame + "명까지 받을 수 있다.");

			System.out.println("(1.예약인원 임의 지정  2.예약인원 랜덤 지정)");
			select = sc.nextInt();
			System.out.println("예약인원 입력:");
			if (select == 1) {
				select = sc.nextInt();
				ranMemberNum = select;
				System.out.println("오늘 PT예약 인원은" + ranMemberNum + "명이 예약했다."); // 랜덤함수로 예약인원 랜덤설정
			} else {
				ranMemberNum = ran.nextInt(5 * fame) + 1;// 명성에 따라 회원 랜덤 받음
				System.out.println("오늘 PT예약 인원은" + ranMemberNum + "명이 예약했다."); // 랜덤함수로 예약인원 랜덤설정
			}

			ArrayList<PTmember> member = new ArrayList<PTmember>(); // arraylist 객체 생성

			for (i = 0; i < ranMemberNum; i++) { // 회원 객체 생성=>arraylist 배열로 생성하기,(나중에 중도 포기하는 사람들 삭제하기 위해)
				// String name, int age, String sex, int exerCareer,int registMonth,String
				// trainerName,int ptNum
				System.out.println("(" + (i + 1) + "번째 회원님 프로필)");
				System.out.print("이름 입력:");
				name = sc.next();
				System.out.print("성별(ex. m(male),f(female)) 소문자 입력:");
				sex = sc.next();

				while (true) { // 성별 체크
					if (sex.equals("m") || sex.equals("f")) {
						break;
					} else {
						System.out.println("성별 다시 m(male),f(female) 중 정확히 소문자 한글자로 입력해주세요.");
						sex = sc.next();
					}
				}
				age = ran.nextInt(20) + 20;
				System.out.println("나이:" + age);
//						System.out.println();
				// ptNum =ran.nextInt(9)+1; //PT받는 횟수 랜덤받음
				ptNum = 1;
				System.out.println("PT 받는 횟수 입력:" + ptNum + "회");

//						if (lim.getName().equals(trainerName)) { //지불해야할 PT가격
//							ptPrice = (lim.getPTprice() * ptNum);
//						}
				ptPrice = (lim.getPTprice() * ptNum);
				System.out.printf("지불해야할 PT가격:%d", ptPrice);

				// System.out.print("운동경력(개월) 정수 입력:");
				// exerCareer=sc.nextInt();

				System.out.println();
				System.out.println();
				System.out.println("=======PT 일정 잡기======="); // d-day 활용

				// System.out.println("T(trainer):함께, 상담 진행할 날짜를 정해봅시다."); // 회원 대답쓰레드 정해보기?
				// int current = 0;
				// cal.add(Calendar.YEAR, 1); // 1년을 더한다.
				// cal.add(Calendar.MONTH, 1); // 한달을 더한다.
				// cal.add(Calendar.DAY_OF_YEAR, 1); // 하루를 더한다.
				// cal.add(Calendar.HOUR, 1); // 시간을 더한다
				// if (current == 0) {

				// int afterPT = ran.nextInt(7) + 1; // 1~7(일주일)내로 랜덤함수
				System.out.println("며칠 후에 PT일정 잡을지 입력하시오:");
				afterPT = sc.nextInt();
				// afterPT=ran.nextInt(7)+1; //며칠 후에 PT일정 받는게 좋은지
				// System.out.println("afterPT:"+afterPT);

				cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT일수를 더한다.
				PTdate = fm.format(cal.getTime());
				System.out.println("PT일정:" + PTdate);
				System.out.println(PTdate + "에 몇시에 PT진행할지 입력하시오:");
				PThour = sc.nextInt();
				System.out.println("PT시간:" + PThour + "시");
				System.out.println();
				lim.schedulePT(i, lim.getName(), PTdate, PThour); // 트레이너한테 회원 index와 PT잡은 날짜 집어넣기
				cal.add(Calendar.DAY_OF_YEAR, afterPT);
				
				System.out.println();
				member.add(new PTmember(name, age, sex, ptNum, ptPrice, PTdate, PThour, inbodyCount)); // PTmember객체생성완료

				if (member.get(i).getInbodyCount() == 0) { // 카운트가0이면 inbody 실행
					System.out.println("T:" + member.get(i).getName() + "님 앞으로 PT 받으실텐데,\n "
							+ "회원님 몸 상태를 기록해 놓을게요. \'인바디\' 기계앞에 서실게요.");
					System.out.println("MB:인바디가 무엇인가요?");
					System.out.println("\'인바디란 무엇이냐면," + "신체에 미세한 교류 전압을 통과시켜 수분, 지방, 근육 등 조직에 따라\n"
							+ "다른 저항도를 이용하여 인체의 구성 성분을 평가하는 방법이에요.");
					System.out.println();
					im.exeInbodyMachine(member.get(i)); // 인바디머신작동 메소드
				}
				member.get(i).checkInbodyCount();

				System.out.println();
//						member.get(i).getInbodyMass();
//						member.get(i).getPTmbprofile(); //멤버 프로필 보기

				lim.haveMoney += ptPrice;

				System.out.println();
				lim.getTrainerProfile();
				System.out.println("$$$수중에 있는 돈 추가된 것 확인$$$");
				cal.setTime(new Date()); // 현재시간 구하기
				toDay = fm.format(cal.getTime()); // 오늘 날짜 초기화
				// }//~current==0 if절
				///////////////////// 코드현재 진행상황 보기////////////////////////////
				System.out.println("콘솔확인");
				name = sc.next();
				///////////////////// 코드현재 진행상황 보기///////////////////////////

			} // ~for(i=0;i<ranMemberNum;i++) { //회원 객체 생성=>arraylist배열로 생성하기,
				// (나중에 중도 포기하는 사람들 삭제하기 위해)

			//////////////////////////// 회원프로필 끝/////////////////////////////////////

			int j; // 반복문 변수조건
			int p; // 반복문 변수조건
////////////////////////하루하루 지나가면서 회원PT날짜 확인 후 일정진행///////////////////////////////////////////////////////
			System.out.println("++++++모든 회원 프로필 작성완료++++++");
			System.out.println();
			System.out.println("회원들마다 PT일정이 될 때까지 일정 진행..");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.print("금일: ");
			System.out.println(toDay); // 오늘날짜 출력
			try {
				for (j = 0; j < 3; j++) {
					System.out.println(".");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("->일정이 없습니다.");
			System.out.println();
//			cal.add(Calendar.DAY_OF_YEAR, 1); // afterPT일수를 더한다.
//			toDay = fm.format(cal.getTime());
//			System.out.println("금일:"+toDay+"입니다.");
			while (true) { // 날짜 하루 지나가면서 일정체크
				
				if(lim.haveMoney<10000000) { //하루 지나서 회원받을건지 결정되는 조건문
					System.out.println("(1.예약인원 임의 지정  2.예약인원 랜덤 지정)");
					select = sc.nextInt();
					System.out.println("예약인원 입력:");
					if (select == 1) {
						select = sc.nextInt();
						ranMemberNum = select;
						System.out.println("오늘 PT예약 인원은" + ranMemberNum + "명이 예약했다."); // 랜덤함수로 예약인원 랜덤설정
					} else {
						ranMemberNum = ran.nextInt(5 * fame) + 1;// 명성에 따라 회원 랜덤 받음
						System.out.println("오늘 PT예약 인원은" + ranMemberNum + "명이 예약했다."); // 랜덤함수로 예약인원 랜덤설정
					}
					/////////////////////////lim.haveMoney<100000 새로운 멤버 객체생성/////////////////////////////////
					for (newNum =i ; newNum < i+ranMemberNum; newNum++) { // 회원 객체 생성=>arraylist 배열로 생성하기,(나중에 중도 포기하는 사람들 삭제하기 위해)
						// String name, int age, String sex, int exerCareer,int registMonth,String
						// trainerName,int ptNum
						System.out.println("(" + (newNum + 1) + "번째 회원님 프로필)");
						System.out.print("이름 입력:");
						name = sc.next();
						System.out.print("성별(ex. m(male),f(female)) 소문자 입력:");
						sex = sc.next();

						while (true) { // 성별 체크
							if (sex.equals("m") || sex.equals("f")) {
								break;
							} else {
								System.out.println("성별 다시 m(male),f(female) 중 정확히 소문자 한글자로 입력해주세요.");
								sex = sc.next();
							}
						}
						age = ran.nextInt(20) + 20;
						System.out.println("나이:" + age);
//								System.out.println();
						// ptNum =ran.nextInt(9)+1; //PT받는 횟수 랜덤받음
						ptNum = 1;
						System.out.println("PT 받는 횟수 입력:" + ptNum + "회");

//								if (lim.getName().equals(trainerName)) { //지불해야할 PT가격
//									ptPrice = (lim.getPTprice() * ptNum);
//								}
						ptPrice = (lim.getPTprice() * ptNum);
						System.out.printf("지불해야할 PT가격:%d", ptPrice);

						// System.out.print("운동경력(개월) 정수 입력:");
						// exerCareer=sc.nextInt();

						System.out.println();
						System.out.println();
						System.out.println("=======PT 일정 잡기======="); // d-day 활용

						// System.out.println("T(trainer):함께, 상담 진행할 날짜를 정해봅시다."); // 회원 대답쓰레드 정해보기?
						// int current = 0;
						// cal.add(Calendar.YEAR, 1); // 1년을 더한다.
						// cal.add(Calendar.MONTH, 1); // 한달을 더한다.
						// cal.add(Calendar.DAY_OF_YEAR, 1); // 하루를 더한다.
						// cal.add(Calendar.HOUR, 1); // 시간을 더한다
						// if (current == 0) {

						// int afterPT = ran.nextInt(7) + 1; // 1~7(일주일)내로 랜덤함수
						System.out.println("며칠 후에 PT일정 잡을지 입력하시오:");
						afterPT = sc.nextInt();
						// afterPT=ran.nextInt(7)+1; //며칠 후에 PT일정 받는게 좋은지
						// System.out.println("afterPT:"+afterPT);

						cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT일수를 더한다.
						PTdate = fm.format(cal.getTime());
						System.out.println("PT일정:" + PTdate);
						System.out.println(PTdate + "에 몇시에 PT진행할지 입력하시오:");
						PThour = sc.nextInt();
						System.out.println("PT시간:" + PThour + "시");
						System.out.println();
						lim.schedulePT(newNum, lim.getName(), PTdate, PThour); // 트레이너한테 회원 index와 PT잡은 날짜 집어넣기
						cal.add(Calendar.DAY_OF_YEAR, -afterPT);
						System.out.println();
						member.add(new PTmember(name, age, sex, ptNum, ptPrice, PTdate, PThour, inbodyCount)); // PTmember객체생성완료

						if (member.get(newNum).getInbodyCount() == 0) { // 카운트가0이면 inbody 실행
							System.out.println("T:" + member.get(newNum).getName() + "님 앞으로 PT 받으실텐데,\n "
									+ "회원님 몸 상태를 기록해 놓을게요. \'인바디\' 기계앞에 서실게요.");
							System.out.println("MB:인바디가 무엇인가요?");
							System.out.println("\'인바디란 무엇이냐면," + "신체에 미세한 교류 전압을 통과시켜 수분, 지방, 근육 등 조직에 따라\n"
									+ "다른 저항도를 이용하여 인체의 구성 성분을 평가하는 방법이에요.");
							System.out.println();
							im.exeInbodyMachine(member.get(newNum)); // 인바디머신작동 메소드
						}
						member.get(newNum).checkInbodyCount();

						System.out.println();
//								member.get(i).getInbodyMass();
//								member.get(i).getPTmbprofile(); //멤버 프로필 보기

						lim.haveMoney += ptPrice;

						System.out.println();
						lim.getTrainerProfile();
						System.out.println("$$$수중에 있는 돈 추가된 것 확인$$$");
					}
					
				}//~ if 	if(lim.haveMoney<100000)이면 회원 받기
				else if(lim.haveMoney>10000000){ //havemoney>목표돈 이면 받지 않기
					 System.out.println("제가 이제 곧 그만두기때문에,");
					 System.out.println("더 이상 회원을 받지 않습니다. 죄송합니다.");
				}
					
				try { // 3초 sleep
					cal.add(Calendar.DAY_OF_YEAR, 1); // afterPT일수를 더한다.

					toDay = fm.format(cal.getTime());
					System.out.print(toDay); // 하루지난 날짜 출력
					System.out.println(" 일정 체크 중");
					for (j = 0; j < 3; j++) {
						System.out.println(".");
						Thread.sleep(1000);
					}

				}

				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int k = 0; // 조건변수
				int PTday = 0; // 일정이 있는 날인지 확인
				int PTcount = 0;// 하루에 PT 몇명 받는지 for문 돌리기위해
				int nTemp[] = new int[member.size()];
				for (p = 0; p < member.size(); p++) { // 회원들 pt일정 확인
					if (toDay.equals(member.get(p).getPTdate())) {
						System.out.println("->" + member.get(p).getName() + "님 " + member.get(p).getPThour() + "시");
						PTday++;
						PTcount++;
						nTemp[k] = member.get(p).getPThour();
						k++;
					}
				}
				if (PTday == 0) {
					System.out.println("->일정이 없습니다.");
				} else {
					Music gymMusic = new Music("운동할때 듣는 음악_운동자극용 음악 모음 1시간(제목,시간 다 있음).mp3", true);
					gymMusic.start();

					System.out.println("PT 진행 날 입니다.");
					System.out.println();
					/////////////////// 시간순서 빠른 사람부터 PT진행////////////////////////////
					AscendFunc.lineUp(nTemp, PTcount);
					n = 0;
					for (k = 0; k < PTcount; k++) { // 당일 PT 진행 인원 수
						for (j = 0; j < member.size(); j++) {
							if (nTemp[n] == member.get(j).getPThour() && member.get(j).getPTdate().equals(toDay)) {// 배열시간숫자==PT받는사람
																													// 시간같은사람
																													// &&
																													// 날짜도
																													// 동시에
																													// 같아야함
								////////////////////////// PT진행/////////////////////////////////
								System.out.println(
										"<" + member.get(j).getName() + "님 " + member.get(j).getPThour() + "시 PT진행>");
//										
								n++; // nTemp[k] 인덱스가 올라가야함..

								// if (member.get(j).getSex().equals("M")) {// 남자
								System.out.println("먼저 운동전 회원님의 근육량을 확인해보도록 할게요.");
								System.out.println();
								System.out.println("T:현재 \'복근\' 근육량은" + member.get(j).getAbdominalMass() + ",");
								compAbdominalMass = member.get(j).getAbdominalMass();
								System.out.println("T:\'팔\' 근육량은" + member.get(j).getArmMass() + ",");
								compArmMass = member.get(j).getArmMass();
								System.out.println("T:\'등\' 근육량은" + member.get(j).getBackMuscleMass() + ",");
								compBackMuscleMass = member.get(j).getBackMuscleMass();
								System.out.println("T:\'가슴\' 근육량은" + member.get(j).getChestMass() + ",");
								compChestMass = member.get(j).getChestMass();
								System.out.println("T:\'하체\' 근육량은" + member.get(j).getLowerbodyMass() + ",");
								compLowerbodyMass = member.get(j).getLowerbodyMass();
								System.out.println("T:\'어깨\' 근육량은" + member.get(j).getShoulderMass() + "이네요.");
								compShoulderMass = member.get(j).getShoulderMass();

								System.out.println("============운동 시작============"); // 쓰레드 시간 제한둬서
																						// 운동..
								System.out.print("PT 몇 분 진행하겠습니까? 정수 입력:");
								min = sc.nextInt();
								System.out.println("(PT시간 " + min + "분 진행)");
								Timer t1 = new Timer(min * 60); // 120: 2분 180: 3분...
								// t1.setDaemon(true); //메인쓰레드가 종료되면 timer쓰레드 종료
								t1.start(); // 쓰레드 시작
//											try { //join
//												t1.join();
//											} catch (InterruptedException e1) {
//												// TODO Auto-generated catch block
//												e1.printStackTrace();
//											}
								//gymMusic.close();

								while (true) { // 운동종목 골라서 운동하기
									exerDoReps t2 = new exerDoReps(11);
									exerDoReps last = new exerDoReps(1);
									Music gymMusic2 = new Music("운동할때 듣는 음악_운동자극용 음악 모음 1시간(제목,시간 다 있음).mp3", true);
									gymMusic2.start();

									System.out.println("1.복근 2.팔 3.등 4.가슴 5.하체 6.어깨 7.운동종료");
									num = sc.nextInt();
									if (num == 1) { // 복근 선택
										//gymMusic2.close();
										System.out.println("1.크런치 2.레그레이즈 3.윗몸일으키기");
										num = sc.nextInt();
										if (num == 1) { // 크런치 수행
											member.get(j).doCrunch(10);
											t2.start();

											try {
												t2.join();
											} catch (Exception e) {
											}

										}

										else if (num == 2) { // 2.레그레이즈
											member.get(j).doLegraise(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.윗몸일으키기
											member.get(j).doSitup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} // ~if 복근선택 num==1
									else if (num == 2) { // 2.팔
										//gymMusic2.close();
										System.out.println("1.덤벨컬 2.바벨컬 3.덤벨킥백");
										num = sc.nextInt();
										if (num == 1) { // 1.덤벨컬 수행
											member.get(j).doDBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.바벨컬
											member.get(j).doBBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.덤벨킥백
											member.get(j).doDBkickback(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 3) { // 3.등
										//gymMusic2.close();
										System.out.println("1.데드리프트 2.바벨로우3.턱걸이");
										num = sc.nextInt();
										if (num == 1) { // 1.데드리프트 수행
											member.get(j).doDeadlift(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.바벨로우
											member.get(j).doBBlow(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.턱걸이
											member.get(j).doPullup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 4) { // 4.가슴
										//gymMusic2.close();
										System.out.println("1.벤치프레스 2.팔굽혀펴기 3.케이블플라이");
										num = sc.nextInt();
										if (num == 1) { // 1.벤치프레스 수행
											member.get(j).doDBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.팔굽혀펴기
											member.get(j).doPushup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.케이블플라이
											member.get(j).doCablefly(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 5) { // 5.하체
										//gymMusic2.close();
										System.out.println("1.레그프레스 2.레그익스텐션 3.스쿼트");
										num = sc.nextInt();
										if (num == 1) { // 1.레그프레스 수행
											member.get(j).doLegpress(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.레그익스텐션
											member.get(j).doLegextension(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.스쿼트
											member.get(j).doSquat(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 6) {// 6.어깨
										//gymMusic2.close();
										System.out.println("1.오버헤드바벨프레스 2.사이드레터럴레이즈" + "3.덤벨프론트레이즈");
										num = sc.nextInt();
										if (num == 1) { // 1.OHP 수행
											member.get(j).doOHP(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.사레레
											member.get(j).doSideRR(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.덤벨프론트레이즈
											member.get(j).doDBfrontraise(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else {
										//gymMusic2.close();
										last.start();
										try {
											last.join();
										} catch (Exception e) {
										}
										t1.interrupt();
										break;
									}

								}

								// ~while(true) 운동종목 골라서 운동하기
								System.out.println();
								System.out.println("******운동 결과******");
								System.out.println(
										"-복근 운동:" + compAbdominalMass + "->" + member.get(j).getAbdominalMass());
								System.out.println("-가슴 운동:" + compChestMass + "->" + member.get(j).getChestMass());
								System.out
										.println("-어깨 운동:" + compShoulderMass + "->" + member.get(j).getShoulderMass());
								System.out.println(
										"-하체 운동:" + compLowerbodyMass + "->" + member.get(j).getLowerbodyMass());
								System.out.println(
										"-등 운동:" + compBackMuscleMass + "->" + member.get(j).getBackMuscleMass());
								System.out.println("-팔 운동:" + compArmMass + "->" + member.get(j).getArmMass());
								System.out.println();
								member.get(j).doPTnum(); // PT 횟수 하나 줄이기
								System.out.println();
								member.get(j).getPTmbprofile(); // 멤버 프로필 확인
								///////////////////// 코드현재 진행상황 보기////////////////////////////
								System.out.println("콘솔확인");
								name = sc.next();
								///////////////////// 코드현재 진행상황 보기///////////////////////////
								if (member.get(j).getPTnum() == 0) { // PT 등록횟수 끝남
									System.out.println("T:" + member.get(j).getName() + "님, " + "PT레슨 등록이 끝났습니다.");
									System.out.println("추가 등록하시겠습니까?(1.그렇다 / 2.아니다. 그만 배우겠다.)");
									select = sc.nextInt();
									if (select == 1) {// 그렇다
										System.out.println("T:PT 몇회 추가등록 하겠습니까?");
										ptNum = sc.nextInt();
										System.out.println("MB:" + ptNum + "회 추가등록 하겠습니다.");
										member.get(j).setPTnum(lim, ptNum);
										lim.haveMoney += member.get(j).getPTprice();
										System.out.println();

										lim.getTrainerProfile();// 수중에 있는 돈 확인
										System.out.println("$$$수중에 있는 돈 추가된 것 확인$$$");
									} // ~if 등록하겠다.
									else {
										System.out.println("그동안, PT 지도해주셔서 감사했습니다.");
										member.remove(j); // 회원 객체 삭제
										continue;
									}
								} // ~if (member.get(j).getPTnum()==0)PT등록끝남
									// PT 계속 진행상황
								System.out.println("=======PT 일정 잡기======="); // d-day 활용

								// System.out.println("T(trainer):함께, 상담 진행할 날짜를 정해봅시다."); // 회원 대답쓰레드 정해보기?
								// int current = 0;
								// cal.add(Calendar.YEAR, 1); // 1년을 더한다.
								// cal.add(Calendar.MONTH, 1); // 한달을 더한다.
								// cal.add(Calendar.DAY_OF_YEAR, 1); // 하루를 더한다.
								// cal.add(Calendar.HOUR, 1); // 시간을 더한다
								// if (current == 0) {

								// int afterPT = ran.nextInt(7) + 1; // 1~7(일주일)내로 랜덤함수
								System.out.println("며칠 후에 PT일정 잡을지 입력하시오:");
								afterPT = sc.nextInt();
								// afterPT=ran.nextInt(7)+1; //며칠 후에 PT일정 받는게 좋은지
								// System.out.println("afterPT:"+afterPT);

								cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT일수를 더한다.
								PTdate = fm.format(cal.getTime());
								System.out.println("PT일정:" + PTdate);
								System.out.println(PTdate + "에 몇시에 PT진행할지 입력하시오:");
								PThour = sc.nextInt();
								System.out.println("PT시간:" + PThour + "시");
								cal.add(Calendar.DAY_OF_YEAR, -afterPT);

								System.out.println();

								member.get(j).setPTdateNhour(PTdate, PThour);
								member.get(j).getPTmbprofile();
								// member.add(new
								// PTmember(name,age,sex,registMonth,trainerName,ptNum,PTdate,PThour,ptPrice));
								// //PTmember 객체생성완료
								lim.schedulePT(j, lim.getName(), PTdate, PThour); // 트레이너한테 회원 index와 PT잡은 날짜
								// lim.sumMoney(member.get(j).getPTprice());// PT비용 수입
								System.out.println();

								// } // if (member.get(j).getSex().equals("M")) {// 남자
								//////////////////////////////////////////////////////////////
//										System.out.println("=======PT 일정 잡기======="); // d-day 활용
//
//										System.out.println("=======PT 일정 잡기======="); // d-day 활용
//
//										//		System.out.println("T(trainer):함께, 상담 진행할 날짜를 정해봅시다."); // 회원 대답쓰레드 정해보기?
//												// int current = 0;
//												// cal.add(Calendar.YEAR, 1); // 1년을 더한다.
//												// cal.add(Calendar.MONTH, 1); // 한달을 더한다.
//												// cal.add(Calendar.DAY_OF_YEAR, 1); // 하루를 더한다.
//												// cal.add(Calendar.HOUR, 1); // 시간을 더한다
//												// if (current == 0) {
//
//												// int afterPT = ran.nextInt(7) + 1; // 1~7(일주일)내로 랜덤함수
//												System.out.println("며칠 후에 PT일정 잡을지 입력하시오:");
//												afterPT=sc.nextInt();
//												//afterPT=ran.nextInt(7)+1; //며칠 후에 PT일정 받는게 좋은지
//												//System.out.println("afterPT:"+afterPT);
//												
//												cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT일수를 더한다.
//												PTdate = fm.format(cal.getTime());
//												System.out.println("PT일정:"+PTdate);
//												System.out.println(PTdate+"에 몇시에 PT진행할지 입력하시오:");
//												PThour=sc.nextInt();
//												System.out.println("PT시간:"+PThour+"시");
//												
//							
//												System.out.println();
//										
//										System.out.println();
//										member.get(j).setPTdateNhour(PTdate, PThour);
//										// member.add(new
//										// PTmember(name,age,sex,registMonth,trainerName,ptNum,PTdate,PThour,ptPrice));
//										// //PTmember 객체생성완료
//										lim.schedulePT(j, lim.getName(), PTdate, PThour); // 트레이너한테 회원 index와 PT잡은 날짜
//										lim.sumMoney(member.get(j).getPTprice());// PT비용 수입
								System.out.println();

								///////////////////////////////////////////////////////////////
								// break; // 반복문탈출

								// }//~if (select == 1) 1.권상우 같은 근육질
//										else { // 여자
//											System.out.println("good");
//										}//~else
							} // ~if(nTemp[k]==member.get(j).getPThour() 배열시간숫자==PT받는시간

						} // ~for2 (j=0;j<PTcount;j++)
					} // ~for(k=0;k<PTcount;k++ 당일 PT 진행 인원 수
				} // ~else PT 진행날이다.

				System.out.println();
				if (member.size() == 0) { // 회원이 한명도 없으면 break;
					break;
				}//~member size
				
			} // ~while 날짜 하루 지나가면서 일정체크

			/////////////////////// ending////////////////////////////////////////
			// } // ~ while(lim.haveMoney<10000000)천만원될때까지 회원받기
			System.out.println("============================ending============================");
			System.out.println("TNB휘트니스에서 번 돈이 "+lim.haveMoney+" 벌었어!");
			System.out.println("이제 개인 헬스장을 개업해서 더욱 멋지게 살아가야지!!");
		} // ~else if(select==2) 다이어트트레이너 객체생성
//////////////////////////////다이어트 트레이너 내용 끝 ////////////////////////////////////////////////////
		else {
			System.out.println("잘 못 입력하셨습니다. 1.웨이트트레이닝/2.다이어트트레이닝 중 선택해주세요!");
			select = sc.nextInt();
			// 나중에 웨이트트레이닝, 다이어트 트레이닝 복붙하기!
		} // ~else 잘 못 입력하셨습니다.1.웨이트트레이닝/2.다이어트트레이닝 중 선택해주세요!
		// } // main 중괄호 ~while(true)
	}
}
//	sc.close();
//	}//~public static void main
//}//~public class MainStory
