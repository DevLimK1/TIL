package Person;

public class WeightTrainer extends HealthTrainer{ //웨이트 전문 트레이너
	int wtAwardNum; //웨이트 관련 대회 수상횟수
	String wtAwardName; //웨이트 관련 수상 이름
	
	
	public WeightTrainer(String name,int age,String sex,int exerCareer
			,int coachCareer,int coachSucNum,int fame,int haveMoney,int wtAwardNum){
		super(name,age,sex,exerCareer
				,coachCareer,coachSucNum,fame,haveMoney);
		this.wtAwardNum=wtAwardNum;
		totalPerPTprice=(coachCareer*careerPerPrice)+(coachSucNum*sucPerPrice)
				+basicPTprice+wtAwardNum*50000;
	}
	
	public String getName() {
		return name;
	}

	public void getTrainerProfile() { //트레이너 프로필 보기
		System.out.println("=====트레이너 프로필=====");
		 System.out.println("이름:"+name);
		 System.out.println("성별:"+sex);
		 System.out.println("생년월일:"+age);
		 System.out.println("운동경력:"+exerCareer+"개월");
		 System.out.println("코칭경력:"+coachCareer+"개월");
		 System.out.println("코칭성공 횟수:"+coachSucNum+"회");
		 System.out.println("명성도:"+fame);
		 System.out.println("웨이트 대회 수상횟수:"+wtAwardNum+"회");
		 System.out.println("PT 회당 레슨비:"+totalPerPTprice+"원");
		 System.out.println("수중에 있는 돈:"+haveMoney+"원");
		 System.out.println("====================");
	}
	
	

}
