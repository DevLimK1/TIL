package Person;

public class WeightTrainer extends HealthTrainer{ //����Ʈ ���� Ʈ���̳�
	int wtAwardNum; //����Ʈ ���� ��ȸ ����Ƚ��
	String wtAwardName; //����Ʈ ���� ���� �̸�
	
	
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

	public void getTrainerProfile() { //Ʈ���̳� ������ ����
		System.out.println("=====Ʈ���̳� ������=====");
		 System.out.println("�̸�:"+name);
		 System.out.println("����:"+sex);
		 System.out.println("�������:"+age);
		 System.out.println("����:"+exerCareer+"����");
		 System.out.println("��Ī���:"+coachCareer+"����");
		 System.out.println("��Ī���� Ƚ��:"+coachSucNum+"ȸ");
		 System.out.println("����:"+fame);
		 System.out.println("����Ʈ ��ȸ ����Ƚ��:"+wtAwardNum+"ȸ");
		 System.out.println("PT ȸ�� ������:"+totalPerPTprice+"��");
		 System.out.println("���߿� �ִ� ��:"+haveMoney+"��");
		 System.out.println("====================");
	}
	
	

}
