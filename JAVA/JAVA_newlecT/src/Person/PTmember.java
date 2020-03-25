package Person;

public class PTmember extends HealthMember{ //PT받는 멤버
	int inbodyCount;
	int ptPrice; //PT 지불한가격
	int ptNum; //PT 받는 횟수
	int PThour; //PT 받는 시간
	String PTdate; //PT 받는 날짜
	String trainerName;//배정된 트레이너 이름
	
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
		System.out.println(name+"의 inbodyCount:"+inbodyCount);
	}
	public void getPTmbprofile() {
		System.out.println("=====회원 프로필=====");
		 System.out.println("이름:"+name);
		 System.out.println("성별:"+sex);
		 System.out.println("나이:"+age);
		 System.out.println("PT 등록 횟수:"+ptNum+"회");
		 System.out.println("PT 지출 비용:"+ptPrice+"원");
		 System.out.println("PT받는 날짜:"+PTdate);
		 System.out.println("PT받는 시간:"+PThour+"시");
		 System.out.println("====================");
	}
	
	public void setPTdateNhour(String PTdate,int PThour) { //수정된 PT날짜,시간 수정 메소드
		this.PTdate=PTdate;
		this.PThour=PThour;
	}
	
	public void setPTnum(WeightTrainer wt,int ptNum) {
		ptPrice=(wt.totalPerPTprice)*ptNum;
		this.ptNum=ptNum;
	}
	
	
	public void doPTnum() { //pt받은 후 기존 PT횟수 줄이기 메소드
		System.out.println(name+"님 기존 등록 PT횟수"+ptNum+"회 ->"+(ptNum-1)+"회로 감소");
		ptNum--;
	}
	
	public int spendPTprice(HealthTrainer trainer){ //PT 지불해야할 가격
		ptPrice=(trainer.totalPerPTprice)*ptNum;
		return ptPrice;
	}
	public int getPTprice() {
		return ptPrice;
	}
	public String getName() { //회원 이름 반환 메소드
		return name;
	}
	
	public int getAge() { //회원 생년월일 반환 메소드
		return age; //생년월일!!!!!!!!
	}
	
	public String getSex() { //회원 성별 반환 메소드
		return sex; 
	}
//	public int getExerCareer() { //회원 성별 반환 메소드
//		return exerCareer; 
//	}
	public int getRegistMonth() { //회원 헬스 등록개월 수 반환 메소드
		return registMonth; 
	}
	public String getTrainerName() { //회원 배정트레이너 이름 반환 메소드
		return trainerName; 
	}
	public int getPTnum() { //회원 PT횟수 반환 메소드
		return ptNum; 
	}
	public String getPTdate() { //회원 PT받는 날짜 반환 메소드
		return PTdate; 
	}
	
	public int getPThour() { //PT 받는 시간 반환 메소드
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
	//////////////////복근운동////////////////////////////
	public void doCrunch(int reps) { //reps:운동 수행반복횟수
		System.out.println("T:복근운동 \'크런치\' 시작!");
		abdominalMass+=2;
	}
	
	public void doLegraise(int reps) { //reps:운동 수행반복횟수
		System.out.println("T:복근운동 \'레그레이즈\' 시작!");
		abdominalMass+=2;
	}
	
	public void doSitup(int reps) { //reps:운동 수행반복횟수
		System.out.println("T:복근운동 \'윗몸일으키기\' 시작!");
		abdominalMass+=2;
	}
	
	/////////////////////////////////////////////////////
	
//////////////////팔운동////////////////////////////
public void doDBcurl(int reps) { //reps:운동 수행반복횟수
System.out.println("T:팔운동 \'덤벨컬\' 시작!");
armMass+=2;
}

public void doBBcurl(int reps) { //reps:운동 수행반복횟수
System.out.println("T:팔운동 \'바벨컬\' 시작!");
armMass+=2;
}

public void doDBkickback(int reps) { //reps:운동 수행반복횟수
System.out.println("T:팔운동 \'덤벨킥백\' 시작!");
armMass+=2;
}

/////////////////////////////////////////////////////

//////////////////등운동////////////////////////////
public void doDeadlift(int reps) { //reps:운동 수행반복횟수
System.out.println("T:등운동 \'데드리프트\' 시작!");
backMuscleMass+=2;
}

public void doBBlow(int reps) { //reps:운동 수행반복횟수
System.out.println("T:등운동 \'바벨로우\' 시작!");
backMuscleMass+=2;
}

public void doPullup(int reps) { //reps:운동 수행반복횟수
System.out.println("T:등운동 \'풀업\' 시작!");
backMuscleMass+=2;
}

/////////////////////////////////////////////////////

//////////////////가슴운동////////////////////////////
public void doBenchpress(int reps) { //reps:운동 수행반복횟수
System.out.println("T:가슴 운동 \'벤치프레스\' 시작!");
chestMass+=2;
}

public void doPushup(int reps) { //reps:운동 수행반복횟수
System.out.println("T:가슴 운동 \'팔굽혀펴기\' 시작!");
chestMass+=2;
}

public void doCablefly(int reps) { //reps:운동 수행반복횟수
System.out.println("T:가슴 운동 \'케이블플라이\' 시작!");
chestMass+=2;
}

/////////////////////////////////////////////////////

//////////////////하체운동////////////////////////////
public void doLegpress(int reps) { //reps:운동 수행반복횟수
System.out.println("T:하체 운동 \'레그프레스\' 시작!");
lowerbodyMass+=2;
}

public void doLegextension(int reps) { //reps:운동 수행반복횟수
System.out.println("T:하체 운동 \'레그익스텐션\' 시작!");
lowerbodyMass+=2;
}

public void doSquat(int reps) { //reps:운동 수행반복횟수
System.out.println("T:하체 운동 \'스쿼트\' 시작!");
lowerbodyMass+=2;
}

/////////////////////////////////////////////////////

//////////////////어깨운동////////////////////////////
public void doOHP(int reps) { //reps:운동 수행반복횟수
System.out.println("T:어깨 운동 \'오버헤드 바벨프레스\' 시작!");
shoulderMass+=2;
}

public void doSideRR(int reps) { //reps:운동 수행반복횟수
System.out.println("T:어깨 운동 \'사이드 레터럴레이즈\' 시작!");
shoulderMass+=2;
}

public void doDBfrontraise(int reps) { //reps:운동 수행반복횟수
System.out.println("T:어깨 운동 \'덤벨 프론트레이즈\' 시작!");
shoulderMass+=2;
}

/////////////////////////////////////////////////////
	
	public void AddInbodyInfo(int height, int weight, //인바디 정보들 변수에 옮기기
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
		System.out.println("=====회원님의 근육량=====");
		System.out.println("가슴 근육량:"+chestMass);
		System.out.println("어깨 근육량:"+shoulderMass);
		System.out.println("하체 근육량:"+lowerbodyMass);
		System.out.println("등 근육량:"+backMuscleMass);
		System.out.println("팔 근육량:"+armMass);
		System.out.println("복근 근육량:"+abdominalMass);
		
	}
	

	
//	public void PTsuccess() {//PT성공->회원코칭성공횟수++->trainerLV++
//	 System.out.println("제가 원하는 몸매로 PT시켜주셔서 감사했습니다.");
//	 
//	}
} //public class PTmember extends HealthMember
