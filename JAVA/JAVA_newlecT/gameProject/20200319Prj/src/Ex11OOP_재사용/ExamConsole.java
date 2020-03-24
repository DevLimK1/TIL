package Ex11OOP_재사용;

import java.util.Scanner;

public class ExamConsole {

	private Exam exam; // console이 다른 부품(exam)을 가졌다(상속을 받았다.). --> 결합됐다.-> has a 상속

	// 약속을 사용하는 쪽이고
	private 확장된과목을입출력하는약속 io약속;

	public void setIo약속(확장된과목을입출력하는약속 io약속) {
		this.io약속 = io약속;
	}
	
	
	public ExamConsole() {
		this.exam = new Exam();
	}

	public ExamConsole(Exam exam) {
		this.exam = exam;
	}

	public void input() {

		Scanner scan = new Scanner(System.in);
		System.out.print("kor:");
		exam.setKor(scan.nextInt());
		System.out.print("eng:");
		exam.setEng(scan.nextInt());
		System.out.print("math:");
		exam.setMath(scan.nextInt());
		
		
		if(io약속!=null)
			io약속.확장된과목입력(this.exam);
		
	}

	

	public void print() {
		int total = exam.total();
		float avg = exam.avg();

		System.out.printf("kor is %d\n", exam.getKor());
		System.out.printf("eng is %d\n", exam.getEng());
		System.out.printf("math is %d\n", exam.getMath());
		System.out.printf("total is %d\n", exam.total());
		System.out.printf("avg is %d\n", exam.avg());
		
		if(io약속 !=null) 
			io약속.확장된과목출력(this.exam);
		
	}

}