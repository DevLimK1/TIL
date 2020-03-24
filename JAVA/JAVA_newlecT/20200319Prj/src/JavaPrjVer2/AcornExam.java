package JavaPrjVer2;
import Ex11OOP_재사용.Exam;

public class AcornExam extends Exam{
//private Exam exam=new Exam();
	private int com;

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {
		return super.total()+this.com;
	}

	@Override
	public float avg() {
		return total()/4.0f;
	}
	
	
}
