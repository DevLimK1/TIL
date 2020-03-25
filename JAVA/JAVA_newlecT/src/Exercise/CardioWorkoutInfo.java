package Exercise;

public class CardioWorkoutInfo extends ExerciseInfo { // 유산소운동(최상위 클래스)
//	double bf; //체지방
	 
//	public void bodyfatMinus(double bf) { //체지방 감소 메소드
//		System.out.println("체지방이 "+bf+" 감소했습니다.");
//	}
	
	public void showKindOfExer() { //유산소 운동 종류들만 보여주기=>메소드 오버라이딩
		//super.showKindOfExer(); ->부모 메소드 호출
		System.out.println("*****유산소운동의 종류*****");
		System.out.println("트레드밀(런닝)");
		System.out.println("싸이클");
		System.out.println("버피테스트");
		System.out.println("마운틴클라이머");
	}
}
