package Exercise;

public class CardioWorkoutInfo extends ExerciseInfo { // ����ҿ(�ֻ��� Ŭ����)
//	double bf; //ü����
	 
//	public void bodyfatMinus(double bf) { //ü���� ���� �޼ҵ�
//		System.out.println("ü������ "+bf+" �����߽��ϴ�.");
//	}
	
	public void showKindOfExer() { //����� � �����鸸 �����ֱ�=>�޼ҵ� �������̵�
		//super.showKindOfExer(); ->�θ� �޼ҵ� ȣ��
		System.out.println("*****����ҿ�� ����*****");
		System.out.println("Ʈ�����(����)");
		System.out.println("����Ŭ");
		System.out.println("�����׽�Ʈ");
		System.out.println("����ƾŬ���̸�");
	}
}
