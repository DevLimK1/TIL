package Person;

public class Person { //���Ŭ����(�ֻ��� Ŭ����)
	int age; // �������
	String name; // �̸�
	String sex; // ���� M:male F:female
	int height; // Ű
	int weight; // ü��
	double skeletMuscleMass; // ��ݱٷ�
	int fatPercent; // ü�����
	int chestMass; // ����������
	int shoulderMass; // ���������
	int lowerbodyMass; // ��ü������
	int backMuscleMass; // �������
	int armMass; // �ȱ�����
	int abdominalMass; // ���ٱ�����
	int metabolicRate; // ������緮
	int basmetabolicRate; // ���ʴ�緮
	int actmetabolicRate; // Ȱ����緮
	double digmetabolicRate; // ��ȭ��緮
	float actRate; // Ȱ������
	//int selectAR; // Ȱ������ ���ú���
	int totalMuscleMass; // �ѱ�����(������ ������ ����)
	int avgMuscleMass; // ���������(������ ������ ����/6)
	
	
	public Person(String name,int age,String sex) {
		this.name=name;
		this.age=age;
		this.sex=sex;
		
	}
	
	public Person(int height, int weight, double skeletMuscleMass, 
			int fatPercent, int chestMass, int shoulderMass,
			int lowerbodyMass, int backMuscleMass, int armMass,
			int abdominalMass, int metabolicRate,
			int basmetabolicRate, int actmetabolicRate, 
			double digmetabolicRate,
			int totalMuscleMass, int avgMuscleMass) {
		this.height=height;
		this.weight=weight;
		this.skeletMuscleMass=skeletMuscleMass;
		this.fatPercent=fatPercent;
		this.chestMass=chestMass;
		this.shoulderMass=shoulderMass;
		this.lowerbodyMass=lowerbodyMass;
		this.backMuscleMass=backMuscleMass;
		this. armMass= armMass;
		this.abdominalMass=abdominalMass;
		this. metabolicRate= metabolicRate;
		this.basmetabolicRate=basmetabolicRate;
		this. actmetabolicRate= actmetabolicRate;
		this.digmetabolicRate=digmetabolicRate;
		this.totalMuscleMass=totalMuscleMass;
		this.avgMuscleMass=avgMuscleMass;

	}
}
