package part2.ex1.�����Էºκг�����;

import java.util.Scanner;

//������������ ���α׷��� �ڵ�
public class Program {
	public static void main(String[] args) {

		int[] kors = new int[3];
		int total = 0;
		float avg; // ���
		int menu;
		boolean keepLoop = true;

		Scanner scan = new Scanner(System.in);

		while (keepLoop) {
			// ���� �޴��κ�
			System.out.println("��������������������������������������������");
			System.out.println("��      ���� �޴�     ��");
			System.out.println("��������������������������������������������");
			System.out.println("\t1.�����Է�");
			System.out.println("\t2.�������");
			System.out.println("\t3.����");
			System.out.print("\t����>");
			menu = scan.nextInt();

			// ���� �Էºκ�
			switch (menu) {

			case 1:
				System.out.println("��������������������������������������������");
				System.out.println("��      ���� �Է�     ��");
				System.out.println("��������������������������������������������");
				System.out.println();

				for (int i = 0; i < 3; i++)
					do {
						System.out.printf("����%d: ", i + 1);
						kors[i] = scan.nextInt();

						if (kors[i] < 0 || 100 < kors[i])
							System.out.println("���� ������ 0~100���� ���� �Է¸� �����մϴ�.");
					} while (kors[i] < 0 || 100 < kors[i]);
				System.out.println("��������������������������������������������������������������������������������������������������������������");
				break;

			case 2:
				// ���� ��ºκ�
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
	}
}
