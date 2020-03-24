package JavaPrjVer2;

import java.util.Scanner;

import Ex11OOP_재사용.Exam;
import Ex11OOP_재사용.ExamConsole;
import Ex11OOP_재사용.확장된과목을입출력하는약속;

public class Program {

	public static void main(String[] args) {
		AcornExam acornExam=new AcornExam();
		
		ExamConsole console= new ExamConsole(acornExam);
		//약속을 구현해서 꽂아 줘야 하는 쪽
		
		console.setIo약속(new 확장된과목을입출력하는약속() {
			
			@Override
			public void 확장된과목출력(Exam exam) {
				AcornExam acExam=(AcornExam) exam;
				System.out.printf("com is %d\n", acExam.getCom());
			}
			
			@Override
			public void 확장된과목입력(Exam exam) {
				AcornExam acExam=(AcornExam) exam;
				Scanner scanner=new Scanner(System.in);
				System.out.print("com:" );
				acExam.setCom(scanner.nextInt());
			}
		});
		console.input();
		console.print();
		
		
		
	}
}
		




//		acornExam.setKor(1);
//		acornExam.setEng(1);
//		acornExam.setMath(1);
//		acornExam.setCom(1);
//
//		System.out.println(acornExam.total());
//		System.out.printf("avg is %f ",acornExam.avg());
		
		//		Exam exam = new Exam(1,2,3);
//		ExamConsole examConsole=new ExamConsole();
		
//		examConsole.input();
//		examConsole.print();
