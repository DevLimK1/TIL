package Exercise;

public class WeightWorkoutInfo extends ExerciseInfo { // 웨이트운동 (최상위 클래스)
	double muscleMass; // 근육량

//	public void bodyfatMinus(double muscleMass) { // 체지방 감소 메소드
//		System.out.println("근육량이 " + muscleMass + " 감소했습니다.");
//	}
	
	public void showKindOfExer() { //웨이트 운동 종류들만 보여주기 =>메소드 오버라이딩
		System.out.println("*****웨이트운동의 종류*****");
		System.out.println("(복근 운동)\n-크런치 \n-레그레이즈\n-행잉레그레이즈");
		System.out.println("(팔 운동)\n-덤벨컬 \n-바벨컬\n-덤벨킥백");
		System.out.println("(등 운동)\n-렛풀다운\n-풀업\n-바벨로우");
		System.out.println("(가슴 운동)\n-벤치프레스\n-푸쉬업\n-케이블플라이");
		System.out.println("(하체 운동)\n-레그프레스\n-레그익스텐션\n-스쿼트");
		System.out.println("(어깨 운동)\n-바벨 오버헤드프레스 \n-덤벨 프론트레이즈\n-덤벨 사이트레터럴레이즈");
	}
	
	
}