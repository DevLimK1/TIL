package Person;

public class DietTrainer extends HealthTrainer{ //���̾�Ʈ ���� Ʈ���̳� 
	int dtAwardNum; //���̾�Ʈ ���� ��ȸ ����Ƚ��
	String dtAwardName; //���̾�Ʈ ���� ���� ��ȸ �̸�
	
	public DietTrainer(String name,int age,String sex,int exerCareer
			,int coachCareer,int coachSucNum,int haveMoney,int dtAwardNum){
		super(name,age,sex,exerCareer
				,coachCareer,coachSucNum,haveMoney);
		this.dtAwardNum=dtAwardNum;
		totalPerPTprice=(coachCareer*careerPerPrice)+(coachSucNum*sucPerPrice)
				+basicPTprice+dtAwardNum*10000;
	}
	
	
}
