package Exercise;

public class WeightWorkoutInfo extends ExerciseInfo { // ����Ʈ� (�ֻ��� Ŭ����)
	double muscleMass; // ������

//	public void bodyfatMinus(double muscleMass) { // ü���� ���� �޼ҵ�
//		System.out.println("�������� " + muscleMass + " �����߽��ϴ�.");
//	}
	
	public void showKindOfExer() { //����Ʈ � �����鸸 �����ֱ� =>�޼ҵ� �������̵�
		System.out.println("*****����Ʈ��� ����*****");
		System.out.println("(���� �)\n-ũ��ġ \n-���׷�����\n-���׷��׷�����");
		System.out.println("(�� �)\n-������ \n-�ٺ���\n-����ű��");
		System.out.println("(�� �)\n-��Ǯ�ٿ�\n-Ǯ��\n-�ٺ��ο�");
		System.out.println("(���� �)\n-��ġ������\n-Ǫ����\n-���̺��ö���");
		System.out.println("(��ü �)\n-����������\n-�����ͽ��ټ�\n-����Ʈ");
		System.out.println("(��� �)\n-�ٺ� ������������� \n-���� ����Ʈ������\n-���� ����Ʈ���ͷ�������");
	}
	
	
}