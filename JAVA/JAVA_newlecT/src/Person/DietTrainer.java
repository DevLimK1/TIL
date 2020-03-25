package Person;

public class DietTrainer extends HealthTrainer{ //다이어트 전문 트레이너 
	int dtAwardNum; //다이어트 관련 대회 수상횟수
	String dtAwardName; //다이어트 관련 수상 대회 이름
	
	public DietTrainer(String name,int age,String sex,int exerCareer
			,int coachCareer,int coachSucNum,int haveMoney,int dtAwardNum){
		super(name,age,sex,exerCareer
				,coachCareer,coachSucNum,haveMoney);
		this.dtAwardNum=dtAwardNum;
		totalPerPTprice=(coachCareer*careerPerPrice)+(coachSucNum*sucPerPrice)
				+basicPTprice+dtAwardNum*10000;
	}
	
	
}
