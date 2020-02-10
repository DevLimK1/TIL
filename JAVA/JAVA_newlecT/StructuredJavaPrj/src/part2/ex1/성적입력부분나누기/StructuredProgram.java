package part2.ex1.�����Էºκг�����;

import java.util.Scanner;

//�������� ���α׷��� �ڵ�
public class StructuredProgram {
	
 
	

	public static void main(String[] args) {
		
		/*
		 * ��������->��������
		 * �����Է�, ������� �Լ��� �Ű������� �Ѱ���
		 */
		int[] korList = new int[3]; 

		
		int menu;
		boolean keepLoop = true;

		while (keepLoop) {
			
			menu=inputMenu();
		
			switch (menu) {

			case 1:
				
				inputKors(korList);
				
				break;

			case 2:
				printKors(korList);
				break;

			case 3:
				System.out.println("Bye~");
				keepLoop = false;
				break;
			default:
				System.out.println("�Է��� 1~3�������� �� �� �ֽ��ϴ�. �ٽ� �Է����ּ���~");
				break;
			}
		}
	} //~main
	
	
	static int inputMenu() {
		
		Scanner scan = new Scanner(System.in);
		// ���� �޴��κ�
		System.out.println("��������������������������������������������");
		System.out.println("��      ���� �޴�     ��");
		System.out.println("��������������������������������������������");
		System.out.println("\t1.�����Է�");
		System.out.println("\t2.�������");
		System.out.println("\t3.����");
		System.out.print("\t����>");
		int menu = scan.nextInt();
		
		return menu;
	}
	
	/*
	 * switch �� case 2�� �־��� �ڵ带 �Լ��� �и���Ŵ
	 */
	static void printKors(int[] kors) {
		// ���� ��ºκ�
		
		int total = 0;
		float avg; // ���
		
		for (int i = 0; i < 3; i++)
			total += kors[i];

		avg = total / 3.0f;

		System.out.println("��������������������������������������������");
		System.out.println("��      ���� ���     ��");
		System.out.println("��������������������������������������������");
		System.out.println();

		for (int i = 0; i < 3; i++)
			System.out.printf("����%d : %3d\n", 3 - i, kors[i]);

		System.out.printf("���� :%3d\n", total);
		System.out.printf("��� :%6.2f\n", avg);
		System.out.println("��������������������������������������������������������������������������������������������������������������");

	}
	
	/*
	 * switch �� case 1�� �־��� �ڵ带 �Լ��� �и���Ŵ
	 */
	static void inputKors(int[] kors) { 
		Scanner scan = new Scanner(System.in);
		int kor;
		
		System.out.println("��������������������������������������������");
		System.out.println("��      ���� �Է�     ��");
		System.out.println("��������������������������������������������");
		System.out.println();

		for (int i = 0; i < 3; i++) {
			do {
				System.out.printf("����%d: ", i + 1);
				kor= scan.nextInt();

				if (kor< 0 || 100 < kor)
					System.out.println("���� ������ 0~100���� ���� �Է¸� �����մϴ�.");
			} while (kor < 0 || 100 < kor);
			
			kors[i]=kor;
		}
		System.out.println("��������������������������������������������������������������������������������������������������������������");
	}
	
}
