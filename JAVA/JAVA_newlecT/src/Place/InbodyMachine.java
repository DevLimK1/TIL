package Place;

import java.awt.Toolkit;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import Person.PTmember;

public class InbodyMachine {
	int height; // Ű
	int weight; // ü��
	double skeletMuscleMass; // ��ݱٷ�
	int fatPercent; // ü�����
	int chestMass; // ����������
	int shoulderMass; // ���������
	int lowerbodyMass; // ��ü������
	int backMuscleMass; // �������
	int armMass; // �ȱ�����
	int abdominalMass; // ���ٱ�����
	int metabolicRate; // ������緮
	int basmetabolicRate; // ���ʴ�緮
	int actmetabolicRate; // Ȱ����緮
	double digmetabolicRate; // ��ȭ��緮
	float actRate; // Ȱ������
	int selectAR; // Ȱ������ ���ú���
	int totalMuscleMass; // �ѱ�����(������ ������ ����)
	int avgMuscleMass; // ���������(������ ������ ����/6)

	Random ranIB = new Random();
	Scanner sc = new Scanner(System.in);
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	
	public void exeInbodyMachine(PTmember mb) { // �ιٵ��� �۵� �޼ҵ�
		System.out.println("<�۵��غ���>");
		System.out.println("<inbody �������� �����մϴ�>");
		System.out.println("<������� �ⱸ�� ����ּ���.>");
		
		for(int i=0;i<5;i++) {
			System.out.println(".");
			try { 
				Thread.sleep(500);
				
			}catch(Exception e) {
				
			}
		}
		
//		Random ranIB = new Random();
//		Scanner sc = new Scanner(System.in);

		// public void inbodyResult() {//�ιٵ� ������� �޼ҵ�
		System.out.print("Ű(cm):");
		
		  while (true){
	            //���ܰ� �߻����� �ƴ��� ������, �켱 �����غ���.
	            try { 
	                //���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 �Է�
	            	this.height = sc.nextInt();
	                break;
	            }
	            
	            //try ������ �ڵ尡 InputMismatchException �� �����ٸ�, ���ܸ� �޾ƿ´�.
	            //catch�� ����Ǵ� ������ Program �� ������� �ʴ´�.
	            catch ( InputMismatchException ime) {
	                //��ĳ���� ���׸� �ذ��ϱ� ���� �ڵ�
	            	
	                sc = new Scanner(System.in);
	                System.out.println("�Է¿���!! ������ �Է����ּ���.");
	                
//	                /**
//	                 * ���� �ȵǴ� �ڵ�
//	                 * ������ ��ü���� ������ �˰������ ����.
//	                 * ��ü���� ������ �˰� ���ڿ��� �ݵ�� �������Ѵ�.
//	                 */
//	                ime.printStackTrace();
	                
	                // �ֿ��ؾ��ϴ� �ڵ�
	                // � ���ܰ� ��� �߻��ߴ��� ������ �˷��ش�
	                System.out.println(ime.getClass().getName() + " ���ܰ� " + ime.getMessage() + " ������ �߻��߽��ϴ�.");
	            }//~catch
	        }    //~while ����ó��
		System.out.print("������(kg):");
		  while (true){
	            //���ܰ� �߻����� �ƴ��� ������, �켱 �����غ���.
	            try { 
	                //���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 �Է�
	            	this.weight = sc.nextInt();
	                break;
	            }
	            
	            //try ������ �ڵ尡 InputMismatchException �� �����ٸ�, ���ܸ� �޾ƿ´�.
	            //catch�� ����Ǵ� ������ Program �� ������� �ʴ´�.
	            catch ( InputMismatchException ime) {
	                //��ĳ���� ���׸� �ذ��ϱ� ���� �ڵ�
	            	
	                sc = new Scanner(System.in);
	                System.out.println("�Է¿���!! ������ �Է����ּ���.");
	                
//	                /**
//	                 * ���� �ȵǴ� �ڵ�
//	                 * ������ ��ü���� ������ �˰������ ����.
//	                 * ��ü���� ������ �˰� ���ڿ��� �ݵ�� �������Ѵ�.
//	                 */
//	                ime.printStackTrace();
	                
	                // �ֿ��ؾ��ϴ� �ڵ�
	                // � ���ܰ� ��� �߻��ߴ��� ������ �˷��ش�
	                System.out.println(ime.getClass().getName() + " ���ܰ� " + ime.getMessage() + " ������ �߻��߽��ϴ�.");
	            }//~catch
	        }    //~while ����ó��
		System.out.println();
		System.out.println("=======�ιٵ� ������=======");
		for(int i=0;i<5;i++) {
			toolkit.beep();
			System.out.println(".");
			try { 
				Thread.sleep(500);
				
			}catch(Exception e) {
				
			}
		}
		
		System.out.println("<ȸ������ �ιٵ� �������>");
		// if (healthCareer >= 36) {// �ｺ����� 36���� �̻�
		
		this.fatPercent = (int) (9 + 11 * Math.random()); // ü����� 9~20������ ������
		System.out.println("-ü�����:" + fatPercent + "%");
		this.skeletMuscleMass = (weight * ((100 - fatPercent) / 100.0) - 4) * 0.577;
		// ��ݱٷ�����:(ü��*((100-ü�����)/100)-������4kg����)*0.577
		System.out.printf("-��ݱٷ�:%.2f (kg)", skeletMuscleMass);
		System.out.println();

		if (mb.getSex().equals("M")) { // ����������, ������緮 ���ϱ�
			this.chestMass = (int) (30 + 20 * Math.random());
			System.out.println("-���� ������:" + chestMass + "/100(kg)");
			this.shoulderMass = (int) (30 + 20 * Math.random());
			System.out.println("-��� ������:" + shoulderMass + "/100(kg)");
			this.lowerbodyMass = (int) (30 + 20 * Math.random());
			System.out.println("-��ü ������:" + lowerbodyMass + "/100(kg)");
			this.backMuscleMass = (int) (30 + 20 * Math.random());
			System.out.println("-�� ������:" + backMuscleMass + "/100(kg)");
			this.armMass = (int) (30 + 20 * Math.random());
			System.out.println("-�� ������:" + armMass + "/100(kg)");
			this.abdominalMass = (int) (30 + 20 * Math.random());
			System.out.println("-���� ������:" + abdominalMass + "/100(kg)");
			totalMuscleMass = chestMass + shoulderMass + lowerbodyMass + backMuscleMass + armMass + abdominalMass;
			System.out.println("�� ������(������ ������ ����):" + totalMuscleMass + "kg");
			avgMuscleMass = totalMuscleMass / 6;
			System.out.println("���������(������ ������ ����/6):" + avgMuscleMass + "kg");

			System.out.println("=======================================");

			System.out.println();
			System.out.println("�̹����� ���̾�Ʈ �� �Ĵ��� �����ϴµ� ������ \'������緮\'�� ���Ϸ����մϴ�.");
			System.out.println("\'������緮\'�� ���ʴ�緮+Ȱ����緮+��ȭ��緮 �ؼ� �������ϴ�.");
			System.out.println("\'���ʴ�緮\'���� ���غ��ڽ��ϴ�.");
			System.out.println("ȸ������ �����̽ñ� ������ " + "\'���ʴ�緮\'�� �����̶�� (�ڽ��� ü��X1.0X24)�� �������� �������ϴ�.");
			basmetabolicRate = (int) (weight * 1.0 * 24); // ���ʴ�緮 ����
			System.out.println("�׷���, ����غ��� ȸ������ \'���ʴ�緮\'��" + basmetabolicRate + "kcal�� �ǰڽ��ϴ�.");
			System.out.println();
			System.out.println("�̹��� \'Ȱ����緮\'�� ���غ��ڽ��ϴ�.");
			System.out.println("\'Ȱ����緮\'�� (Ȱ������(%)X���ʴ�緮)�� �������� �������ϴ�.");
			System.out.println("Ȱ�������� �������ּ���.(1,2,3,4 �� �����Է�)");
			System.out.println("1��:20% �Ϸ� �� ���� �ɾ��ִ� ��� \n2��:30% �½� ��Ȱ���� �������� 1~3km�� ���"
					+ "\n3��:40% 2����Ȳ���� ���� ��ϴ� ��� \n4��:50% �����,��ü �뵿��");
			selectAR = sc.nextInt();

			// Ȱ����緮 ����
			if (selectAR == 1) {// 20% �Ϸ� �� ���� �ɾ��ִ� ���
				actRate = 0.2f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else if (selectAR == 2) { // 30% �½� ��Ȱ���� �������� 1~3km�� ���
				actRate = 0.3f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else if (selectAR == 3) { // 40% 30%���� ���� ��ϴ� ���
				actRate = 0.4f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else { // 50% �����,��ü �뵿��
				actRate = 0.5f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} // Ȱ����緮 ����
			System.out.println("����ؼ�, ȸ������ \'Ȱ����緮\'��" + actmetabolicRate + "kcal�� �ǰڽ��ϴ�.");
			System.out.println();
			System.out.println("\'��ȭ��緮\'�� [(���ʴ�緮+Ȱ����緮)/0.9X0.1]�� �������� �������ϴ�.");
			digmetabolicRate = (int) ((basmetabolicRate + actmetabolicRate) / 0.9) * 0.1;
			System.out.println("����ؼ�, ȸ������ \'��ȭ��緮\'��" + digmetabolicRate + "kcal�� �ǰڽ��ϴ�.");

			System.out.println();
			System.out.println("���ʴ�緮+Ȱ����緮+��ȭ��緮�ؼ�");
			System.out.println(
					"ȸ������ \'������緮\'��" + (basmetabolicRate + actmetabolicRate + digmetabolicRate) + "kcal�� �ǰڽ��ϴ�.");
			metabolicRate=(int) (basmetabolicRate + actmetabolicRate + digmetabolicRate);
			System.out.println("���̾�Ʈ�� ���ؼ��� ȸ������ \'������緮\'���� 4~500kcal ���� ���̸� ������ �� ���Դϴ�. ");
			System.out.println();
		} else {// ����������, ���� ������緮���ϱ� // ���ڴ� ���ں��� �ּ� ������ -10���� ����
			this.chestMass = (int) (10 + 20 * Math.random());
			System.out.println("-���� ������:" + chestMass + "/100(kg)");
			this.shoulderMass = (int) (10 + 20 * Math.random());
			System.out.println("-��� ������:" + shoulderMass + "/100(kg)");
			this.lowerbodyMass = (int) (10 + 20 * Math.random());
			System.out.println("-��ü ������:" + lowerbodyMass + "/100(kg)");
			this.backMuscleMass = (int) (10 + 20 * Math.random());
			System.out.println("-�� ������:" + backMuscleMass + "/100(kg)");
			this.armMass = (int) (10 + 20 * Math.random());
			System.out.println("-�� ������:" + armMass + "/100(kg)");
			this.abdominalMass = (int) (10 + 20 * Math.random());
			System.out.println("-���� ������:" + abdominalMass + "/100(kg)");
			totalMuscleMass = chestMass + shoulderMass + lowerbodyMass + backMuscleMass + armMass + abdominalMass;
			System.out.println("�� ������(������ ������ ����):" + totalMuscleMass + "kg");
			avgMuscleMass = totalMuscleMass / 6;
			System.out.println("���������(������ ������ ����/6):" + avgMuscleMass + "kg");
			System.out.println("=======================================");

			System.out.println();
			System.out.println("�̹����� ���̾�Ʈ �� �Ĵ��� �����ϴµ� ������ \'������緮\'�� ���Ϸ����մϴ�.");
			System.out.println("\'������緮\'�� ���ʴ�緮+Ȱ����緮+��ȭ��緮 �ؼ� �������ϴ�.");
			System.out.println("\'���ʴ�緮\'���� ���غ��ڽ��ϴ�.");
			System.out.println("ȸ������ �����̽ñ� ������ " + "\'���ʴ�緮\'�� �����̶�� (�ڽ��� ü��X0.9X24)�� �������� �������ϴ�.");
			basmetabolicRate = (int) (weight * 0.9 * 24); // ���ʴ�緮 ����
			System.out.println("�׷���, ����غ��� ȸ������ \'���ʴ�緮\'��" + basmetabolicRate + "kcal�� �ǰڽ��ϴ�.");
			System.out.println();
			System.out.println("�̹��� \'Ȱ����緮\'�� ���غ��ڽ��ϴ�.");
			System.out.println("\'Ȱ����緮\'�� (Ȱ������(%)X���ʴ�緮)�� �������� �������ϴ�.");
			System.out.println("Ȱ�������� �������ּ���.(1,2,3,4 �� �����Է�)");
			System.out.println("1��:20% �Ϸ� �� ���� �ɾ��ִ� ��� \n2��:30% �½� ��Ȱ���� �������� 1~3km�� ���"
					+ "\n3��:40% 2����Ȳ���� ���� ��ϴ� ��� \n4��:50% �����,��ü �뵿��");
			selectAR = sc.nextInt();

			// Ȱ����緮 ����
			if (selectAR == 1) {// 20% �Ϸ� �� ���� �ɾ��ִ� ���
				actRate = 0.2f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else if (selectAR == 2) { // 30% �½� ��Ȱ���� �������� 1~3km�� ���
				actRate = 0.3f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else if (selectAR == 3) { // 40% 30%���� ���� ��ϴ� ���
				actRate = 0.4f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} else { // 50% �����,��ü �뵿��
				actRate = 0.5f;
				actmetabolicRate = (int) (basmetabolicRate * actRate);
			} // Ȱ����緮 ����
			System.out.println("����ؼ�, ȸ������ \'Ȱ����緮\'��" + actmetabolicRate + "kcal�� �ǰڽ��ϴ�.");
			System.out.println();
			System.out.println("\'��ȭ��緮\'�� [(���ʴ�緮+Ȱ����緮)/0.9X0.1]�� �������� �������ϴ�.");
			digmetabolicRate = (int) ((basmetabolicRate + actmetabolicRate) / 0.9) * 0.1;
			System.out.println("����ؼ�, ȸ������ \'��ȭ��緮\'��" + digmetabolicRate + "kcal�� �ǰڽ��ϴ�.");

			System.out.println();
			System.out.println("���ʴ�緮+Ȱ����緮+��ȭ��緮�ؼ�");
			System.out.println(
					"ȸ������ \'������緮\'��" + (basmetabolicRate + actmetabolicRate + digmetabolicRate) + "kcal�� �ǰڽ��ϴ�.");
			metabolicRate=(int) (basmetabolicRate + actmetabolicRate + digmetabolicRate);
			System.out.println("���̾�Ʈ�� ���ؼ��� ȸ������ \'������緮\'���� 4~500kcal ���� ���̸� ������ �� ���Դϴ�. ");
			System.out.println();
			
		}//~����inbody
		mb.AddInbodyInfo(height,weight,skeletMuscleMass, //PTmember ������ �ιٵ� ������ �ű�� �޼ҵ�
				fatPercent,chestMass,
				shoulderMass,lowerbodyMass,backMuscleMass,
				armMass,abdominalMass,metabolicRate,
				basmetabolicRate
				,actmetabolicRate,digmetabolicRate,
				totalMuscleMass
				,avgMuscleMass);
		mb.addInbodyCount();
		}//~public void exeInbodyMachine(PTmember mb)
}