package KindOfWeight;

import Person.*;


public class ABSweight { //���ٿ
	int crunch; //ũ��ġ
	int legRaise; //���׷�����
	int sitUp;//��������Ű��
	int kneeUp;//�Ͼ�
	
	double ABSmuscleMass ; //���ٱ�����
	 
//	public void ABSmusclePlus(double ABSmuscleMass) { // ���� ����������
//		System.out.println("���� �������� " + ABSmuscleMass + " �����߽��ϴ�.");
//		System.out.println("�� ���� �������� "+Inbodyinfo.totalABSmuscleMass+"�� �Ǿ����ϴ�.");
//	}
//	//��� ����� �Ѵ�!! 
	public int doCrunch() {//ũ��ġ � ����
		System.out.println("=>���ٿ: ũ��ġ ����");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("=>���� ������+3");
		return +3;
	}
	public int doLegraise() {//���׷����� � ����
		System.out.println("=>���ٿ: ���׷����� ����");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("=>���� ������+2");
		return +2;
	}
	public int doSitUp() {//��������Ű�� � ����
		System.out.println("=>���ٿ: ��������Ű�� ����");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("=>���� ������+1");
		return +1;
	}
}
