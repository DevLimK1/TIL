package KindOfWeight;

public class ARMweight { //팔운동
	int dbCurl; // 이두운동 덤벨컬
	int bbCurl; // 이두 바벨컬
	int dbHammerCurl; // 이두 덤벨해머컬
	int cablePressDown; // 삼두 케블프레스다운
	int dbKickback; // 삼두 덤벨킥백

	public int doDBCurl() { //이두운동덤벨컬 실행메소드
		System.out.println("=>이두운동: 덤벨컬 수행");
		System.out.println("=>팔 근육량+2");
		return +2;
	}
	public int doBBCurl() { //이두바벨컬 실행메소드
		System.out.println("=>이두운동: 바벨컬 수행");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("=>팔 근육량+2");
		return +2;
	}
	public int doDBHammerCurl() {//이두 해머컬 실행메소드
		System.out.println("=>이두운동: 덤벨 해머컬 수행");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("=>팔 근육량+2");
		return +2;
	}
	public int doCablePressDown() { //삼두 케블프레스다운 실행메소드
		System.out.println("=>삼두운동: 케이블프레스다운 수행");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("=>팔 근육량+2");
		return +2;
	}
	public int doDBKickback() { //삼두 덤벨킥백 실행메소드
		System.out.println("=>삼두운동: 덤벨킥백 수행");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("=>팔 근육량+2");
		return +2;
	}
}
