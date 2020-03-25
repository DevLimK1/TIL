package Person;

public class HealthMember extends Person { //Çï½º µî·Ï ¸â¹ö
	
	static int registMonth; // Çï½ºµî·Ï °³¿ù ¼ö
	
	public HealthMember(String name, int age, String sex,int registMonth) {
		super(name, age, sex);
	this.registMonth=registMonth;
	
	}
	
	public HealthMember(int height, int weight, double skeletMuscleMass, 
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
}
