package Person;

public class PTmember extends HealthMember{ //PT�޴� ���
	int inbodyCount;
	int ptPrice; //PT �����Ѱ���
	int ptNum; //PT �޴� Ƚ��
	int PThour; //PT �޴� �ð�
	String PTdate; //PT �޴� ��¥
	String trainerName;//������ Ʈ���̳� �̸�
	
//	public PTMember(String name, int age, String sex,int registMonth) {
//		super(name, age, sex,registMonth);
//	}
	public PTmember(String name, int age, String sex,
			int ptNum,int ptPrice,String PTdate,int PThour,int inbodyCount) {
		super(name, age, sex,registMonth);
		this.ptNum=ptNum;
		this.PTdate=PTdate;
		this.PThour=PThour;
		this.ptPrice=ptPrice;
		this.inbodyCount=inbodyCount;
		//this.trainerName=trainerName;
	}
	

	public PTmember(int height, int weight, double skeletMuscleMass, 
			int fatPercent, int chestMass, int shoulderMass,
			int lowerbodyMass, int backMuscleMass, int armMass,
			int abdominalMass, int metabolicRate,
			int basmetabolicRate, int actmetabolicRate, 
			double digmetabolicRate,
			int totalMuscleMass, int avgMuscleMass) {
		super(height,weight,skeletMuscleMass,fatPercent,chestMass,
				shoulderMass,lowerbodyMass,backMuscleMass,
				armMass,abdominalMass,metabolicRate,basmetabolicRate
				,actmetabolicRate,digmetabolicRate,totalMuscleMass
				,avgMuscleMass);
	}
	
	public int getInbodyCount() {
		return inbodyCount; 
	}
	public void addInbodyCount() {
		inbodyCount++;
	}
	public void checkInbodyCount() {
		System.out.println(name+"�� inbodyCount:"+inbodyCount);
	}
	public void getPTmbprofile() {
		System.out.println("=====ȸ�� ������=====");
		 System.out.println("�̸�:"+name);
		 System.out.println("����:"+sex);
		 System.out.println("����:"+age);
		 System.out.println("PT ��� Ƚ��:"+ptNum+"ȸ");
		 System.out.println("PT ���� ���:"+ptPrice+"��");
		 System.out.println("PT�޴� ��¥:"+PTdate);
		 System.out.println("PT�޴� �ð�:"+PThour+"��");
		 System.out.println("====================");
	}
	
	public void setPTdateNhour(String PTdate,int PThour) { //������ PT��¥,�ð� ���� �޼ҵ�
		this.PTdate=PTdate;
		this.PThour=PThour;
	}
	
	public void setPTnum(WeightTrainer wt,int ptNum) {
		ptPrice=(wt.totalPerPTprice)*ptNum;
		this.ptNum=ptNum;
	}
	
	
	public void doPTnum() { //pt���� �� ���� PTȽ�� ���̱� �޼ҵ�
		System.out.println(name+"�� ���� ��� PTȽ��"+ptNum+"ȸ ->"+(ptNum-1)+"ȸ�� ����");
		ptNum--;
	}
	
	public int spendPTprice(HealthTrainer trainer){ //PT �����ؾ��� ����
		ptPrice=(trainer.totalPerPTprice)*ptNum;
		return ptPrice;
	}
	public int getPTprice() {
		return ptPrice;
	}
	public String getName() { //ȸ�� �̸� ��ȯ �޼ҵ�
		return name;
	}
	
	public int getAge() { //ȸ�� ������� ��ȯ �޼ҵ�
		return age; //�������!!!!!!!!
	}
	
	public String getSex() { //ȸ�� ���� ��ȯ �޼ҵ�
		return sex; 
	}
//	public int getExerCareer() { //ȸ�� ���� ��ȯ �޼ҵ�
//		return exerCareer; 
//	}
	public int getRegistMonth() { //ȸ�� �ｺ ��ϰ��� �� ��ȯ �޼ҵ�
		return registMonth; 
	}
	public String getTrainerName() { //ȸ�� ����Ʈ���̳� �̸� ��ȯ �޼ҵ�
		return trainerName; 
	}
	public int getPTnum() { //ȸ�� PTȽ�� ��ȯ �޼ҵ�
		return ptNum; 
	}
	public String getPTdate() { //ȸ�� PT�޴� ��¥ ��ȯ �޼ҵ�
		return PTdate; 
	}
	
	public int getPThour() { //PT �޴� �ð� ��ȯ �޼ҵ�
		return PThour;
	}
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}
	
	public double getSkeletMuscleMass() {
		return skeletMuscleMass;
	} 
	public int getFatPercent() {
		return fatPercent;
	}
	public int getChestMass () {
		return chestMass;
	}
	public int getShoulderMass() {
		return shoulderMass;
	}
	public int getLowerbodyMass() {
		return lowerbodyMass;
	}
	public int getBackMuscleMass() {
		return backMuscleMass;
	}
	public int getArmMass() {
		return armMass;
	}
	public int getAbdominalMass() {
		return abdominalMass;
	}
	public int getMetabolicRate() {
		return metabolicRate;
	}
	public int getBasmetabolicRate() {
		return basmetabolicRate;
	}
	public int getActmetabolicRate() {
		return actmetabolicRate;
	} 
	public double getDigmetabolicRate() {
		return digmetabolicRate;
	}
	public int getTotalMuscleMass() {
		totalMuscleMass=chestMass+shoulderMass+lowerbodyMass+
				armMass+abdominalMass+backMuscleMass;
		return totalMuscleMass;
	}
	public int getAvgMuscleMass() {
		avgMuscleMass=totalMuscleMass/6;
		return avgMuscleMass;
	}
	//////////////////���ٿ////////////////////////////
	public void doCrunch(int reps) { //reps:� ����ݺ�Ƚ��
		System.out.println("T:���ٿ \'ũ��ġ\' ����!");
		abdominalMass+=2;
	}
	
	public void doLegraise(int reps) { //reps:� ����ݺ�Ƚ��
		System.out.println("T:���ٿ \'���׷�����\' ����!");
		abdominalMass+=2;
	}
	
	public void doSitup(int reps) { //reps:� ����ݺ�Ƚ��
		System.out.println("T:���ٿ \'��������Ű��\' ����!");
		abdominalMass+=2;
	}
	
	/////////////////////////////////////////////////////
	
//////////////////�ȿ////////////////////////////
public void doDBcurl(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:�ȿ \'������\' ����!");
armMass+=2;
}

public void doBBcurl(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:�ȿ \'�ٺ���\' ����!");
armMass+=2;
}

public void doDBkickback(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:�ȿ \'����ű��\' ����!");
armMass+=2;
}

/////////////////////////////////////////////////////

//////////////////��////////////////////////////
public void doDeadlift(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:�� \'���帮��Ʈ\' ����!");
backMuscleMass+=2;
}

public void doBBlow(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:�� \'�ٺ��ο�\' ����!");
backMuscleMass+=2;
}

public void doPullup(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:�� \'Ǯ��\' ����!");
backMuscleMass+=2;
}

/////////////////////////////////////////////////////

//////////////////�����////////////////////////////
public void doBenchpress(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:���� � \'��ġ������\' ����!");
chestMass+=2;
}

public void doPushup(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:���� � \'�ȱ������\' ����!");
chestMass+=2;
}

public void doCablefly(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:���� � \'���̺��ö���\' ����!");
chestMass+=2;
}

/////////////////////////////////////////////////////

//////////////////��ü�////////////////////////////
public void doLegpress(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:��ü � \'����������\' ����!");
lowerbodyMass+=2;
}

public void doLegextension(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:��ü � \'�����ͽ��ټ�\' ����!");
lowerbodyMass+=2;
}

public void doSquat(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:��ü � \'����Ʈ\' ����!");
lowerbodyMass+=2;
}

/////////////////////////////////////////////////////

//////////////////����////////////////////////////
public void doOHP(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:��� � \'������� �ٺ�������\' ����!");
shoulderMass+=2;
}

public void doSideRR(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:��� � \'���̵� ���ͷ�������\' ����!");
shoulderMass+=2;
}

public void doDBfrontraise(int reps) { //reps:� ����ݺ�Ƚ��
System.out.println("T:��� � \'���� ����Ʈ������\' ����!");
shoulderMass+=2;
}

/////////////////////////////////////////////////////
	
	public void AddInbodyInfo(int height, int weight, //�ιٵ� ������ ������ �ű��
			double skeletMuscleMass, 
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
		this.armMass= armMass;
		this.abdominalMass=abdominalMass;
		this.metabolicRate= metabolicRate;
		this.basmetabolicRate=basmetabolicRate;
		this.actmetabolicRate= actmetabolicRate;
		this.digmetabolicRate=digmetabolicRate;
		this.totalMuscleMass=totalMuscleMass;
		this.avgMuscleMass=avgMuscleMass;
	}
	
	public void getInbodyMass() {
		System.out.println("=====ȸ������ ������=====");
		System.out.println("���� ������:"+chestMass);
		System.out.println("��� ������:"+shoulderMass);
		System.out.println("��ü ������:"+lowerbodyMass);
		System.out.println("�� ������:"+backMuscleMass);
		System.out.println("�� ������:"+armMass);
		System.out.println("���� ������:"+abdominalMass);
		
	}
	

	
//	public void PTsuccess() {//PT����->ȸ����Ī����Ƚ��++->trainerLV++
//	 System.out.println("���� ���ϴ� ���ŷ� PT�����ּż� �����߽��ϴ�.");
//	 
//	}
} //public class PTmember extends HealthMember
