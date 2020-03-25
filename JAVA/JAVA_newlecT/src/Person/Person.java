package Person;

public class Person { //사람클래스(최상위 클래스)
	int age; // 생년월일
	String name; // 이름
	String sex; // 성별 M:male F:female
	int height; // 키
	int weight; // 체중
	double skeletMuscleMass; // 골격근량
	int fatPercent; // 체지방률
	int chestMass; // 가슴근육량
	int shoulderMass; // 어깨근육량
	int lowerbodyMass; // 하체근육량
	int backMuscleMass; // 등근육량
	int armMass; // 팔근육량
	int abdominalMass; // 복근근육량
	int metabolicRate; // 신진대사량
	int basmetabolicRate; // 기초대사량
	int actmetabolicRate; // 활동대사량
	double digmetabolicRate; // 소화대사량
	float actRate; // 활동지수
	//int selectAR; // 활동지수 선택변수
	int totalMuscleMass; // 총근육량(부위별 근육량 총합)
	int avgMuscleMass; // 근육량평균(부위별 근육량 총합/6)
	
	
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
