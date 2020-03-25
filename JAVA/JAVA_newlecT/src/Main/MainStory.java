package Main;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import Exercise.CardioWorkoutInfo;
import Exercise.ExerciseInfo;
import Exercise.WeightWorkoutInfo;
import Person.DietTrainer;
import Person.PTmember;
import Person.WeightTrainer;
import Place.GYM;
import Place.InbodyMachine;
import Thread.Timer;
import Thread.exerDoReps;

public class MainStory {
	public static void main(String[] args) {
		int PThour = 0; // �ð����ϱ�
		int trainerFame;// ����
		int afterPT = 0; // PT ���� ���ϴ� ����
		int ptNum = 0; // pt�޴� Ƚ��
		int registMonth = 0;// �ｺ��� ���� ��
		int select; // ���Ǽ��� ����
		int ranMemberNum; // ������ �����(��������)
		int age = 0; // �������
		int exerCareer; // ����
		int coachCareer; // ��Ī���
		int coachSucNum; // ȸ����Ī ����Ƚ��
		int perPTprice; // ȸ�� PT����
		int trainerLV; // Ʈ���̳� ����->������ ���� PTȸ�� ���� �� �ִ� ���� �޶���,������ ����:PT����Ƚ��
		int wtAwardNum = 0; // ����Ʈ ���� ��ȸ ����Ƚ��
		int dtAwardNum = 0;// ���̾�Ʈ ���� ��ȸ ����Ƚ��
		int haveMoney = 0;
		int lv; // �ｺƮ���̳� ����
		int i;
		int n = 0;
		int min; // �ð� ��������
		int num; // �ݺ��� ����
		int compAbdominalMass; // ��� ���ٱ����� ���� �ӽ�����
		int compChestMass; // ��� ���������� ���� �ӽ�����
		int compShoulderMass; // ��� ��������� ���� �ӽ�����
		int compLowerbodyMass; // ��� ��ü������ ���� �ӽ�����
		int compBackMuscleMass; // ��� ������� ���� �ӽ�����
		int compArmMass; // ��� �� ������ ���� �ӽ�����
		int ptPrice = 0; // ȸ���� �����ؾ��� PT����
		int purpose = 0; // ���ǥ
		int fame = 0; // ��
		int inbodyCount = 0;
		int newNum=0;
		String ment; // ��(Ʈ���̳�)�� ��Ʈ
		String PTdate;// PT�޴� ��¥
		String trainerName = null;// �ｺƮ���̳� �̸�
		String license; // ��� �ڰ���
		String sex; // ���� M:male F:female
		String name; // Ʈ���̳� �̸�

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		GYM teamNB = new GYM(); // GYM(�ｺ��) ��ü ����

		InbodyMachine im = new InbodyMachine();
		ExerciseInfo ex = new ExerciseInfo();
		CardioWorkoutInfo cw = new CardioWorkoutInfo();
		WeightWorkoutInfo ww = new WeightWorkoutInfo();

		Calendar cal = new GregorianCalendar(Locale.KOREA);

		cal.setTime(new Date()); // ����ð� ���ϱ�
		SimpleDateFormat fm = new SimpleDateFormat("yyyy��MM��dd��");
		String toDay = fm.format(cal.getTime()); // ���� ��¥
		System.out.print("���� ");
		System.out.println(toDay); // ���ó�¥ ���
		System.out.println("");

////////////////////////////�ｺŸ���� �������/////////////////////////////////////////
		System.out.println("���� ���۱� ���������� 'TNB ��Ʈ�Ͻ�\'�� �ִ�.");
		// System.out.println("����� ��Ʈ�Ͻ��� PT���ȸ���� �� �ڽ��� ��ǥ���ϴ� ���ŷ� Ʈ���̴� �����ִ� \n "
		// + "�ϸ� PersonalTraining 100%�� �ڶ��ϴ� �̰� ������,");
		System.out.print("TNB ��Ʈ�Ͻ��� ���� Ʈ���̳ʵ� �� �Ѹ��� " + "Personal Training ���� Ʈ���̳� \n�̸� �Է�:");
		name = sc.next();
		System.out.println("\'" + name + "\'�̴�.");
		System.out.println();
		System.out.println(name + " Ʈ���̳ʴ� ���� �ִ�.\n���� ȸ������ ���ϴ� ���� PT�� �����Ͽ�, ���� ���� ��� ");
		System.out.println("���� �ｺ���� �����ϴ� ���� �ｺƮ���̳ʷμ��� ���� ��ǥ�̴�.");
		System.out.println("���� �ｺ���� �����ϴµ� �Һ�Ǵ� ���� �� 10,000,000(õ��)���� �ʿ��ϴ�.");
		System.out.println();
		System.out.println("���� ���� ��������, \'ȸ���� ��Ī ����Ƚ��\'�� ������ \'Ʈ���̳� ����\'�� �ø���, �̿� ���� ���� ȸ������ �����ϴ� ���̴�.");
		System.out.println("Ʈ���̳� ����1,2,3..���� �ö� ������ (5*����)�� ����ŭ ȸ������ ������ �� �ִ�.");
		System.out.println("�������, ����1�̸� 5*1=5�̹Ƿ� ȸ���� 5������� �ִ� �����ο��� �Ǵ� ���̴�.");
		System.out.println();
		System.out.println("����, Ʈ���̳� PT �� ȸ�� ������ å���Ǵµ� å���Ǵ� ������");
		System.out.println("(��Ī���*��Ī��� �⺻��(500��))+(��Ī ����Ƚ��*��Ī �����⺻��(500��))"
				+ "\n+�⺻PT�޿�(10,000��)+(����Ʈ��ȸ ����Ƚ��*���� ����(10,000��)) �������� å���ȴ�.");
		System.out.println("PTȸ���� PT��� Ƚ���� ������ �߰������ �ؾ��Ѵ�.");
		System.out.println();
		//////////////////////////// �ｺŸ���Ｓ��/////////////////////////////////////////
		System.out.println("���� ���� ������ ��������, " + name + " Ʈ���̳ʿ� ���� �������� �Ұ����ڸ�");

		System.out.print("�������(ex001122):");
		age = sc.nextInt();
		int hundThousand = age / 100000; // 10���ڸ�
		int tenThousand = (age % 100000) / 10000;// ���ڸ�
		int thousand = (age % 10000) / 1000; // õ���ڸ�
		int hundred = (age % 1000) / 100; // �����ڸ�
		int ten = (age % 100) / 10; // ���� �ڸ�
		int one = (age % 100) % 10; // ���� �ڸ�

		while (true) { // ������� ����
			if (thousand > 1) { // õ���ڸ� �޷��� 12������
				System.out.println("������� �ٽ� �Է��Ͻʽÿ�.");
				age = sc.nextInt();
				hundThousand = age / 100000; // 10���ڸ�
				tenThousand = (age % 100000) / 10000;// ���ڸ�
				thousand = (age % 10000) / 1000; // õ���ڸ�
				hundred = (age % 1000) / 100; // �����ڸ�
				ten = (age % 100) / 10; // ���� �ڸ�
				one = (age % 100) % 10; // ���� �ڸ�
			} else if (ten > 3 || (ten >= 3 && one > 1)) { // �����ڸ� �޷��� �ִ� 31�ϱ�����
				System.out.println("������� �ٽ� �Է��Ͻʽÿ�.");
				age = sc.nextInt();
				hundThousand = age / 100000; // 10���ڸ�
				tenThousand = (age % 100000) / 10000;// ���ڸ�
				thousand = (age % 10000) / 1000; // õ���ڸ�
				hundred = (age % 1000) / 100; // �����ڸ�
				ten = (age % 100) / 10; // ���� �ڸ�
				one = (age % 100) % 10; // ���� �ڸ�
			} else if (hundThousand == 0) {
				System.out.println("������� �ٽ� �Է��Ͻʽÿ�.");
				age = sc.nextInt();
				hundThousand = age / 100000; // 10���ڸ�
				tenThousand = (age % 100000) / 10000;// ���ڸ�
				thousand = (age % 10000) / 1000; // õ���ڸ�
				hundred = (age % 1000) / 100; // �����ڸ�
				ten = (age % 100) / 10; // ���� �ڸ�
				one = (age % 100) % 10; // ���� �ڸ�
			} else { // �� ��������
				break;
			}
		} // ������� ����
		System.out.print("����(ex. m(male),f(female)) �ҹ��� �Է�:");
		sex = sc.next();
		while (true) { // ���� üũ
			if (sex.equals("m") || sex.equals("f")) {
				break;
			} else {
				System.out.println("���� �ٽ� M(male),F(female) �� ��Ȯ�� �ҹ��� �ѱ��ڷ� �Է����ּ���.");
				sex = sc.next();
			}
		}

		while (true) {
			// ���ܰ� �߻����� �ƴ��� ������, �켱 �����غ���.
			try {
				// ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 �Է�
				System.out.print("����(����) ���� �Է�:");
				exerCareer = sc.nextInt();
				break;
			}

			// try ������ �ڵ尡 InputMismatchException �� �����ٸ�, ���ܸ� �޾ƿ´�.
			// catch�� ����Ǵ� ������ Program �� ������� �ʴ´�.
			catch (InputMismatchException ime) {
				// ��ĳ���� ���׸� �ذ��ϱ� ���� �ڵ�

				sc = new Scanner(System.in);
				System.out.println("�Է¿���!! ������ �Է����ּ���.");

				// �ֿ��ؾ��ϴ� �ڵ�
				// � ���ܰ� ��� �߻��ߴ��� ������ �˷��ش�
				System.out.println(ime.getClass().getName() + " ���ܰ� " + ime.getMessage() + " ������ �߻��߽��ϴ�.");
			} // ~catch
		} // ~while ����ó��

		while (true) {
			// ���ܰ� �߻����� �ƴ��� ������, �켱 �����غ���.
			try {
				// ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 �Է�
				System.out.print("��Ī���(����) ���� �Է�:");
				coachCareer = sc.nextInt();
				break;
			}

			// try ������ �ڵ尡 InputMismatchException �� �����ٸ�, ���ܸ� �޾ƿ´�.
			// catch�� ����Ǵ� ������ Program �� ������� �ʴ´�.
			catch (InputMismatchException ime) {
				// ��ĳ���� ���׸� �ذ��ϱ� ���� �ڵ�

				sc = new Scanner(System.in);
				System.out.println("�Է¿���!! ������ �Է����ּ���.");

				// �ֿ��ؾ��ϴ� �ڵ�
				// � ���ܰ� ��� �߻��ߴ��� ������ �˷��ش�
				System.out.println(ime.getClass().getName() + " ���ܰ� " + ime.getMessage() + " ������ �߻��߽��ϴ�.");
			} // ~catch
		} // ~while ����ó��

		while (true) {
			// ���ܰ� �߻����� �ƴ��� ������, �켱 �����غ���.
			try {
				// ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 �Է�
				System.out.print("ȸ����Ī ����Ƚ��(ȸ) ���� �Է�:");
				coachSucNum = sc.nextInt();
				break;
			}

			// try ������ �ڵ尡 InputMismatchException �� �����ٸ�, ���ܸ� �޾ƿ´�.
			// catch�� ����Ǵ� ������ Program �� ������� �ʴ´�.
			catch (InputMismatchException ime) {
				// ��ĳ���� ���׸� �ذ��ϱ� ���� �ڵ�

				sc = new Scanner(System.in);
				System.out.println("�Է¿���!! ������ �Է����ּ���.");

				// �ֿ��ؾ��ϴ� �ڵ�
				// � ���ܰ� ��� �߻��ߴ��� ������ �˷��ش�
				System.out.println(ime.getClass().getName() + " ���ܰ� " + ime.getMessage() + " ������ �߻��߽��ϴ�.");
			} // ~catch
		} // ~while ����ó��

		///////////////////////////////// ��ü����////////////////////////////////////////

		while (true) {
			// ���ܰ� �߻����� �ƴ��� ������, �켱 �����غ���.
			try {
				// ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 �Է�
				System.out.println(name + "�� (1.����ƮƮ���̴�/2.���̾�ƮƮ���̴�) "); // �ӳ��� Mode ����
				select = sc.nextInt();
				break;
			}

			// try ������ �ڵ尡 InputMismatchException �� �����ٸ�, ���ܸ� �޾ƿ´�.
			// catch�� ����Ǵ� ������ Program �� ������� �ʴ´�.
			catch (InputMismatchException ime) {
				// ��ĳ���� ���׸� �ذ��ϱ� ���� �ڵ�

				sc = new Scanner(System.in);
				System.out.println("�Է¿���!! ������ �Է����ּ���.");

				// �ֿ��ؾ��ϴ� �ڵ�
				// � ���ܰ� ��� �߻��ߴ��� ������ �˷��ش�
				System.out.println(ime.getClass().getName() + " ���ܰ� " + ime.getMessage() + " ������ �߻��߽��ϴ�.");
			} // ~catch
		} // ~while ����ó��
			// while (true) {
//////////////////////////////����ƮƮ���̳� ���� ����////////////////////////////////////////////////////
		if (select == 1) {
			System.out.println("\"����ƮƮ���̴� ���� PTƮ���̳ʴ�.\"");
			System.out.print("����Ʈ ���� ��ȸ ���� Ƚ��(ȸ)���� �Է�:");
			wtAwardNum = sc.nextInt();
			// Ʈ���̳ʵ� ��ü����
			WeightTrainer lim = new WeightTrainer(name, age, sex, exerCareer, coachCareer, coachSucNum, fame, 0,
					wtAwardNum);
			lim.perPTprice(); // Ʈ���̳� ȸ�� PT����

			WeightTrainer kim = new WeightTrainer("ö��", 920505, "M", 24, 12, 10, 2, 10, 2);

			WeightTrainer lee = new WeightTrainer("����", 910606, "M", 32, 24, 20, 4, 100, 5);

			System.out.println();
			System.out.println("*******TNB Ʈ���̳� ������*******");
			// �ｺƮ���̳ʵ� ���� ����
			lim.getTrainerProfile();
			kim.getTrainerProfile();
			lee.getTrainerProfile();
			System.out.println("**************************");

			/////////////////////////////// ����ƮƮ���̳�
			/////////////////////////////// ��ü�����Ϸ�//////////////////////////////////////////

			System.out.println();
//				System.out.println(name+" Ʈ���̳ʴ� �ñ����� ��ǥ�� �ִ�.\n ȸ������ PT�Ͽ� ���� ���� �����Ͽ�");
//				System.out.println("���� �ｺ���� �����ϴ� ���� �ｺƮ���̳ʷμ��� ���� ��ǥ�̴�.");
//				System.out.println("���� �ｺ���� �����ϴµ� �Һ�Ǵ� ���� �� 10,000,000(õ��)���� �ʿ��ϴ�.");
			System.out.println("10,000,000(õ����)�� ������ ������!");
			System.out.println("");
			System.out.println("");
			////////////////////// õ���� �� ������ �ݺ�������///////////////////////////////////
			// while (lim.haveMoney < 100000) { // õ���� �ɶ����� ȸ���ޱ�
//					System.out.println(lim.haveMoney + "/10,000,000��");
//					System.out.println(" 10,000,000���� ����!!");
//					System.out.println();
			fame = lim.fameCheck();// Ʈ���̳ʸ� �����޼ҵ�

			System.out.println(name + "�� ���� Ʈ���̳� ������" + fame + "��, �Ϸ� PT������ �ִ�" + 5 * fame + "����� ���� �� �ִ�.");

			System.out.println("(1.�����ο� ���� ����  2.�����ο� ���� ����)");
			select = sc.nextInt();
			System.out.println("�����ο� �Է�:");
			if (select == 1) {
				select = sc.nextInt();
				ranMemberNum = select;
				System.out.println("���� PT���� �ο���" + ranMemberNum + "���� �����ߴ�."); // �����Լ��� �����ο� ��������
			} else {
				ranMemberNum = ran.nextInt(5 * fame) + 1;// ���� ���� ȸ�� ���� ����
				System.out.println("���� PT���� �ο���" + ranMemberNum + "���� �����ߴ�."); // �����Լ��� �����ο� ��������
			}

			ArrayList<PTmember> member = new ArrayList<PTmember>(); // arraylist ��ü ����

			for (i = 0; i < ranMemberNum; i++) { // ȸ�� ��ü ����=>arraylist �迭�� �����ϱ�,(���߿� �ߵ� �����ϴ� ����� �����ϱ� ����)
				// String name, int age, String sex, int exerCareer,int registMonth,String
				// trainerName,int ptNum
				System.out.println("(" + (i + 1) + "��° ȸ���� ������)");
				System.out.print("�̸� �Է�:");
				name = sc.next();
				System.out.print("����(ex. m(male),f(female)) �ҹ��� �Է�:");
				sex = sc.next();

				while (true) { // ���� üũ
					if (sex.equals("m") || sex.equals("f")) {
						break;
					} else {
						System.out.println("���� �ٽ� m(male),f(female) �� ��Ȯ�� �ҹ��� �ѱ��ڷ� �Է����ּ���.");
						sex = sc.next();
					}
				}
				age = ran.nextInt(20) + 20;
				System.out.println("����:" + age);
//						System.out.println();
				// ptNum =ran.nextInt(9)+1; //PT�޴� Ƚ�� ��������
				ptNum = 1;
				System.out.println("PT �޴� Ƚ�� �Է�:" + ptNum + "ȸ");

//						if (lim.getName().equals(trainerName)) { //�����ؾ��� PT����
//							ptPrice = (lim.getPTprice() * ptNum);
//						}
				ptPrice = (lim.getPTprice() * ptNum);
				System.out.printf("�����ؾ��� PT����:%d", ptPrice);

				// System.out.print("����(����) ���� �Է�:");
				// exerCareer=sc.nextInt();

				System.out.println();
				System.out.println();
				System.out.println("=======PT ���� ���======="); // d-day Ȱ��

				// System.out.println("T(trainer):�Բ�, ��� ������ ��¥�� ���غ��ô�."); // ȸ�� ��侲���� ���غ���?
				// int current = 0;
				// cal.add(Calendar.YEAR, 1); // 1���� ���Ѵ�.
				// cal.add(Calendar.MONTH, 1); // �Ѵ��� ���Ѵ�.
				// cal.add(Calendar.DAY_OF_YEAR, 1); // �Ϸ縦 ���Ѵ�.
				// cal.add(Calendar.HOUR, 1); // �ð��� ���Ѵ�
				// if (current == 0) {

				// int afterPT = ran.nextInt(7) + 1; // 1~7(������)���� �����Լ�
				System.out.println("��ĥ �Ŀ� PT���� ������ �Է��Ͻÿ�:");
				afterPT = sc.nextInt();
				// afterPT=ran.nextInt(7)+1; //��ĥ �Ŀ� PT���� �޴°� ������
				// System.out.println("afterPT:"+afterPT);

				cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT�ϼ��� ���Ѵ�.
				PTdate = fm.format(cal.getTime());
				System.out.println("PT����:" + PTdate);
				System.out.println(PTdate + "�� ��ÿ� PT�������� �Է��Ͻÿ�:");
				PThour = sc.nextInt();
				System.out.println("PT�ð�:" + PThour + "��");
				System.out.println();
				lim.schedulePT(i, lim.getName(), PTdate, PThour); // Ʈ���̳����� ȸ�� index�� PT���� ��¥ ����ֱ�
				cal.add(Calendar.DAY_OF_YEAR, afterPT);
				
				System.out.println();
				member.add(new PTmember(name, age, sex, ptNum, ptPrice, PTdate, PThour, inbodyCount)); // PTmember��ü�����Ϸ�

				if (member.get(i).getInbodyCount() == 0) { // ī��Ʈ��0�̸� inbody ����
					System.out.println("T:" + member.get(i).getName() + "�� ������ PT �������ٵ�,\n "
							+ "ȸ���� �� ���¸� ����� �����Կ�. \'�ιٵ�\' ���տ� ���ǰԿ�.");
					System.out.println("MB:�ιٵ� �����ΰ���?");
					System.out.println("\'�ιٵ�� �����̳ĸ�," + "��ü�� �̼��� ���� ������ ������� ����, ����, ���� �� ������ ����\n"
							+ "�ٸ� ���׵��� �̿��Ͽ� ��ü�� ���� ������ ���ϴ� ����̿���.");
					System.out.println();
					im.exeInbodyMachine(member.get(i)); // �ιٵ�ӽ��۵� �޼ҵ�
				}
				member.get(i).checkInbodyCount();

				System.out.println();
//						member.get(i).getInbodyMass();
//						member.get(i).getPTmbprofile(); //��� ������ ����

				lim.haveMoney += ptPrice;

				System.out.println();
				lim.getTrainerProfile();
				System.out.println("$$$���߿� �ִ� �� �߰��� �� Ȯ��$$$");
				cal.setTime(new Date()); // ����ð� ���ϱ�
				toDay = fm.format(cal.getTime()); // ���� ��¥ �ʱ�ȭ
				// }//~current==0 if��
				///////////////////// �ڵ����� �����Ȳ ����////////////////////////////
				System.out.println("�ܼ�Ȯ��");
				name = sc.next();
				///////////////////// �ڵ����� �����Ȳ ����///////////////////////////

			} // ~for(i=0;i<ranMemberNum;i++) { //ȸ�� ��ü ����=>arraylist�迭�� �����ϱ�,
				// (���߿� �ߵ� �����ϴ� ����� �����ϱ� ����)

			//////////////////////////// ȸ�������� ��/////////////////////////////////////

			int j; // �ݺ��� ��������
			int p; // �ݺ��� ��������
////////////////////////�Ϸ��Ϸ� �������鼭 ȸ��PT��¥ Ȯ�� �� ��������///////////////////////////////////////////////////////
			System.out.println("++++++��� ȸ�� ������ �ۼ��Ϸ�++++++");
			System.out.println();
			System.out.println("ȸ���鸶�� PT������ �� ������ ���� ����..");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.print("����: ");
			System.out.println(toDay); // ���ó�¥ ���
			try {
				for (j = 0; j < 3; j++) {
					System.out.println(".");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("->������ �����ϴ�.");
			System.out.println();
//			cal.add(Calendar.DAY_OF_YEAR, 1); // afterPT�ϼ��� ���Ѵ�.
//			toDay = fm.format(cal.getTime());
//			System.out.println("����:"+toDay+"�Դϴ�.");
			while (true) { // ��¥ �Ϸ� �������鼭 ����üũ
				
				if(lim.haveMoney<10000000) { //�Ϸ� ������ ȸ���������� �����Ǵ� ���ǹ�
					System.out.println("(1.�����ο� ���� ����  2.�����ο� ���� ����)");
					select = sc.nextInt();
					System.out.println("�����ο� �Է�:");
					if (select == 1) {
						select = sc.nextInt();
						ranMemberNum = select;
						System.out.println("���� PT���� �ο���" + ranMemberNum + "���� �����ߴ�."); // �����Լ��� �����ο� ��������
					} else {
						ranMemberNum = ran.nextInt(5 * fame) + 1;// ���� ���� ȸ�� ���� ����
						System.out.println("���� PT���� �ο���" + ranMemberNum + "���� �����ߴ�."); // �����Լ��� �����ο� ��������
					}
					/////////////////////////lim.haveMoney<100000 ���ο� ��� ��ü����/////////////////////////////////
					for (newNum =i ; newNum < i+ranMemberNum; newNum++) { // ȸ�� ��ü ����=>arraylist �迭�� �����ϱ�,(���߿� �ߵ� �����ϴ� ����� �����ϱ� ����)
						// String name, int age, String sex, int exerCareer,int registMonth,String
						// trainerName,int ptNum
						System.out.println("(" + (newNum + 1) + "��° ȸ���� ������)");
						System.out.print("�̸� �Է�:");
						name = sc.next();
						System.out.print("����(ex. m(male),f(female)) �ҹ��� �Է�:");
						sex = sc.next();

						while (true) { // ���� üũ
							if (sex.equals("m") || sex.equals("f")) {
								break;
							} else {
								System.out.println("���� �ٽ� m(male),f(female) �� ��Ȯ�� �ҹ��� �ѱ��ڷ� �Է����ּ���.");
								sex = sc.next();
							}
						}
						age = ran.nextInt(20) + 20;
						System.out.println("����:" + age);
//								System.out.println();
						// ptNum =ran.nextInt(9)+1; //PT�޴� Ƚ�� ��������
						ptNum = 1;
						System.out.println("PT �޴� Ƚ�� �Է�:" + ptNum + "ȸ");

//								if (lim.getName().equals(trainerName)) { //�����ؾ��� PT����
//									ptPrice = (lim.getPTprice() * ptNum);
//								}
						ptPrice = (lim.getPTprice() * ptNum);
						System.out.printf("�����ؾ��� PT����:%d", ptPrice);

						// System.out.print("����(����) ���� �Է�:");
						// exerCareer=sc.nextInt();

						System.out.println();
						System.out.println();
						System.out.println("=======PT ���� ���======="); // d-day Ȱ��

						// System.out.println("T(trainer):�Բ�, ��� ������ ��¥�� ���غ��ô�."); // ȸ�� ��侲���� ���غ���?
						// int current = 0;
						// cal.add(Calendar.YEAR, 1); // 1���� ���Ѵ�.
						// cal.add(Calendar.MONTH, 1); // �Ѵ��� ���Ѵ�.
						// cal.add(Calendar.DAY_OF_YEAR, 1); // �Ϸ縦 ���Ѵ�.
						// cal.add(Calendar.HOUR, 1); // �ð��� ���Ѵ�
						// if (current == 0) {

						// int afterPT = ran.nextInt(7) + 1; // 1~7(������)���� �����Լ�
						System.out.println("��ĥ �Ŀ� PT���� ������ �Է��Ͻÿ�:");
						afterPT = sc.nextInt();
						// afterPT=ran.nextInt(7)+1; //��ĥ �Ŀ� PT���� �޴°� ������
						// System.out.println("afterPT:"+afterPT);

						cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT�ϼ��� ���Ѵ�.
						PTdate = fm.format(cal.getTime());
						System.out.println("PT����:" + PTdate);
						System.out.println(PTdate + "�� ��ÿ� PT�������� �Է��Ͻÿ�:");
						PThour = sc.nextInt();
						System.out.println("PT�ð�:" + PThour + "��");
						System.out.println();
						lim.schedulePT(newNum, lim.getName(), PTdate, PThour); // Ʈ���̳����� ȸ�� index�� PT���� ��¥ ����ֱ�
						cal.add(Calendar.DAY_OF_YEAR, -afterPT);
						System.out.println();
						member.add(new PTmember(name, age, sex, ptNum, ptPrice, PTdate, PThour, inbodyCount)); // PTmember��ü�����Ϸ�

						if (member.get(newNum).getInbodyCount() == 0) { // ī��Ʈ��0�̸� inbody ����
							System.out.println("T:" + member.get(newNum).getName() + "�� ������ PT �������ٵ�,\n "
									+ "ȸ���� �� ���¸� ����� �����Կ�. \'�ιٵ�\' ���տ� ���ǰԿ�.");
							System.out.println("MB:�ιٵ� �����ΰ���?");
							System.out.println("\'�ιٵ�� �����̳ĸ�," + "��ü�� �̼��� ���� ������ ������� ����, ����, ���� �� ������ ����\n"
									+ "�ٸ� ���׵��� �̿��Ͽ� ��ü�� ���� ������ ���ϴ� ����̿���.");
							System.out.println();
							im.exeInbodyMachine(member.get(newNum)); // �ιٵ�ӽ��۵� �޼ҵ�
						}
						member.get(newNum).checkInbodyCount();

						System.out.println();
//								member.get(i).getInbodyMass();
//								member.get(i).getPTmbprofile(); //��� ������ ����

						lim.haveMoney += ptPrice;

						System.out.println();
						lim.getTrainerProfile();
						System.out.println("$$$���߿� �ִ� �� �߰��� �� Ȯ��$$$");
					}
					
				}//~ if 	if(lim.haveMoney<100000)�̸� ȸ�� �ޱ�
				else if(lim.haveMoney>10000000){ //havemoney>��ǥ�� �̸� ���� �ʱ�
					 System.out.println("���� ���� �� �׸��α⶧����,");
					 System.out.println("�� �̻� ȸ���� ���� �ʽ��ϴ�. �˼��մϴ�.");
				}
					
				try { // 3�� sleep
					cal.add(Calendar.DAY_OF_YEAR, 1); // afterPT�ϼ��� ���Ѵ�.

					toDay = fm.format(cal.getTime());
					System.out.print(toDay); // �Ϸ����� ��¥ ���
					System.out.println(" ���� üũ ��");
					for (j = 0; j < 3; j++) {
						System.out.println(".");
						Thread.sleep(1000);
					}

				}

				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int k = 0; // ���Ǻ���
				int PTday = 0; // ������ �ִ� ������ Ȯ��
				int PTcount = 0;// �Ϸ翡 PT ��� �޴��� for�� ����������
				int nTemp[] = new int[member.size()];
				for (p = 0; p < member.size(); p++) { // ȸ���� pt���� Ȯ��
					if (toDay.equals(member.get(p).getPTdate())) {
						System.out.println("->" + member.get(p).getName() + "�� " + member.get(p).getPThour() + "��");
						PTday++;
						PTcount++;
						nTemp[k] = member.get(p).getPThour();
						k++;
					}
				}
				if (PTday == 0) {
					System.out.println("->������ �����ϴ�.");
				} else {
					Music gymMusic = new Music("��Ҷ� ��� ����_��ڱؿ� ���� ���� 1�ð�(����,�ð� �� ����).mp3", true);
					gymMusic.start();

					System.out.println("PT ���� �� �Դϴ�.");
					System.out.println();
					/////////////////// �ð����� ���� ������� PT����////////////////////////////
					AscendFunc.lineUp(nTemp, PTcount);
					n = 0;
					for (k = 0; k < PTcount; k++) { // ���� PT ���� �ο� ��
						for (j = 0; j < member.size(); j++) {
							if (nTemp[n] == member.get(j).getPThour() && member.get(j).getPTdate().equals(toDay)) {// �迭�ð�����==PT�޴»��
																													// �ð��������
																													// &&
																													// ��¥��
																													// ���ÿ�
																													// ���ƾ���
								////////////////////////// PT����/////////////////////////////////
								System.out.println(
										"<" + member.get(j).getName() + "�� " + member.get(j).getPThour() + "�� PT����>");
//									
								if(n<member.size()) {
								n++; // nTemp[k] �ε����� �ö󰡾���..
								}
								// if (member.get(j).getSex().equals("M")) {// ����
								System.out.println("���� ��� ȸ������ �������� Ȯ���غ����� �ҰԿ�.");
								System.out.println();
								System.out.println("T:���� \'����\' ��������" + member.get(j).getAbdominalMass() + ",");
								compAbdominalMass = member.get(j).getAbdominalMass();
								System.out.println("T:\'��\' ��������" + member.get(j).getArmMass() + ",");
								compArmMass = member.get(j).getArmMass();
								System.out.println("T:\'��\' ��������" + member.get(j).getBackMuscleMass() + ",");
								compBackMuscleMass = member.get(j).getBackMuscleMass();
								System.out.println("T:\'����\' ��������" + member.get(j).getChestMass() + ",");
								compChestMass = member.get(j).getChestMass();
								System.out.println("T:\'��ü\' ��������" + member.get(j).getLowerbodyMass() + ",");
								compLowerbodyMass = member.get(j).getLowerbodyMass();
								System.out.println("T:\'���\' ��������" + member.get(j).getShoulderMass() + "�̳׿�.");
								compShoulderMass = member.get(j).getShoulderMass();

								System.out.println("============� ����============"); // ������ �ð� ���ѵּ�
																						// �..
								System.out.print("PT �� �� �����ϰڽ��ϱ�? ���� �Է�:");
								min = sc.nextInt();
								System.out.println("(PT�ð� " + min + "�� ����)");
								Timer t1 = new Timer(min * 60); // 120: 2�� 180: 3��...
								// t1.setDaemon(true); //���ξ����尡 ����Ǹ� timer������ ����
								t1.start(); // ������ ����
//											try { //join
//												t1.join();
//											} catch (InterruptedException e1) {
//												// TODO Auto-generated catch block
//												e1.printStackTrace();
//											}
								//gymMusic.close();

								while (true) { // ����� ��� ��ϱ�
									exerDoReps t2 = new exerDoReps(11);
									exerDoReps last = new exerDoReps(1);
									Music gymMusic2 = new Music("��Ҷ� ��� ����_��ڱؿ� ���� ���� 1�ð�(����,�ð� �� ����).mp3", true);
									gymMusic2.start();

									System.out.println("1.���� 2.�� 3.�� 4.���� 5.��ü 6.��� 7.�����");
									num = sc.nextInt();
									if (num == 1) { // ���� ����
										//gymMusic2.close();
										System.out.println("1.ũ��ġ 2.���׷����� 3.��������Ű��");
										num = sc.nextInt();
										if (num == 1) { // ũ��ġ ����
											member.get(j).doCrunch(10);
											t2.start();

											try {
												t2.join();
											} catch (Exception e) {
											}

										}

										else if (num == 2) { // 2.���׷�����
											member.get(j).doLegraise(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.��������Ű��
											member.get(j).doSitup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} // ~if ���ټ��� num==1
									else if (num == 2) { // 2.��
										//gymMusic2.close();
										System.out.println("1.������ 2.�ٺ��� 3.����ű��");
										num = sc.nextInt();
										if (num == 1) { // 1.������ ����
											member.get(j).doDBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.�ٺ���
											member.get(j).doBBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.����ű��
											member.get(j).doDBkickback(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 3) { // 3.��
										//gymMusic2.close();
										System.out.println("1.���帮��Ʈ 2.�ٺ��ο�3.�ΰ���");
										num = sc.nextInt();
										if (num == 1) { // 1.���帮��Ʈ ����
											member.get(j).doDeadlift(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.�ٺ��ο�
											member.get(j).doBBlow(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.�ΰ���
											member.get(j).doPullup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 4) { // 4.����
										//gymMusic2.close();
										System.out.println("1.��ġ������ 2.�ȱ������ 3.���̺��ö���");
										num = sc.nextInt();
										if (num == 1) { // 1.��ġ������ ����
											member.get(j).doDBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.�ȱ������
											member.get(j).doPushup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.���̺��ö���
											member.get(j).doCablefly(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 5) { // 5.��ü
										//gymMusic2.close();
										System.out.println("1.���������� 2.�����ͽ��ټ� 3.����Ʈ");
										num = sc.nextInt();
										if (num == 1) { // 1.���������� ����
											member.get(j).doLegpress(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.�����ͽ��ټ�
											member.get(j).doLegextension(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.����Ʈ
											member.get(j).doSquat(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 6) {// 6.���
										//gymMusic2.close();
										System.out.println("1.�������ٺ������� 2.���̵巹�ͷ�������" + "3.��������Ʈ������");
										num = sc.nextInt();
										if (num == 1) { // 1.OHP ����
											member.get(j).doOHP(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.�緹��
											member.get(j).doSideRR(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.��������Ʈ������
											member.get(j).doDBfrontraise(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else {
										//gymMusic2.close();
										last.start();
										try {
											last.join();
										} catch (Exception e) {
										}
										t1.interrupt();
										break;
									}

								}

								// ~while(true) ����� ��� ��ϱ�
								System.out.println();
								System.out.println("******� ���******");
								System.out.println(
										"-���� �:" + compAbdominalMass + "->" + member.get(j).getAbdominalMass());
								System.out.println("-���� �:" + compChestMass + "->" + member.get(j).getChestMass());
								System.out
										.println("-��� �:" + compShoulderMass + "->" + member.get(j).getShoulderMass());
								System.out.println(
										"-��ü �:" + compLowerbodyMass + "->" + member.get(j).getLowerbodyMass());
								System.out.println(
										"-�� �:" + compBackMuscleMass + "->" + member.get(j).getBackMuscleMass());
								System.out.println("-�� �:" + compArmMass + "->" + member.get(j).getArmMass());
								System.out.println();
								member.get(j).doPTnum(); // PT Ƚ�� �ϳ� ���̱�
								System.out.println();
								member.get(j).getPTmbprofile(); // ��� ������ Ȯ��
								///////////////////// �ڵ����� �����Ȳ ����////////////////////////////
								System.out.println("�ܼ�Ȯ��");
								name = sc.next();
								///////////////////// �ڵ����� �����Ȳ ����///////////////////////////
								if (member.get(j).getPTnum() == 0) { // PT ���Ƚ�� ����
									System.out.println("T:" + member.get(j).getName() + "��, " + "PT���� ����� �������ϴ�.");
									System.out.println("�߰� ����Ͻðڽ��ϱ�?(1.�׷��� / 2.�ƴϴ�. �׸� ���ڴ�.)");
									select = sc.nextInt();
									if (select == 1) {// �׷���
										System.out.println("T:PT ��ȸ �߰���� �ϰڽ��ϱ�?");
										ptNum = sc.nextInt();
										System.out.println("MB:" + ptNum + "ȸ �߰���� �ϰڽ��ϴ�.");
										member.get(j).setPTnum(lim, ptNum);
										lim.haveMoney += member.get(j).getPTprice();
										System.out.println();

										lim.getTrainerProfile();// ���߿� �ִ� �� Ȯ��
										System.out.println("$$$���߿� �ִ� �� �߰��� �� Ȯ��$$$");
									} // ~if ����ϰڴ�.
									else {
										System.out.println("�׵���, PT �������ּż� �����߽��ϴ�.");
										member.remove(j); // ȸ�� ��ü ����
										continue;
									}
								} // ~if (member.get(j).getPTnum()==0)PT��ϳ���
									// PT ��� �����Ȳ
								System.out.println("=======PT ���� ���======="); // d-day Ȱ��

								// System.out.println("T(trainer):�Բ�, ��� ������ ��¥�� ���غ��ô�."); // ȸ�� ��侲���� ���غ���?
								// int current = 0;
								// cal.add(Calendar.YEAR, 1); // 1���� ���Ѵ�.
								// cal.add(Calendar.MONTH, 1); // �Ѵ��� ���Ѵ�.
								// cal.add(Calendar.DAY_OF_YEAR, 1); // �Ϸ縦 ���Ѵ�.
								// cal.add(Calendar.HOUR, 1); // �ð��� ���Ѵ�
								// if (current == 0) {

								// int afterPT = ran.nextInt(7) + 1; // 1~7(������)���� �����Լ�
								System.out.println("��ĥ �Ŀ� PT���� ������ �Է��Ͻÿ�:");
								afterPT = sc.nextInt();
								// afterPT=ran.nextInt(7)+1; //��ĥ �Ŀ� PT���� �޴°� ������
								// System.out.println("afterPT:"+afterPT);

								cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT�ϼ��� ���Ѵ�.
								PTdate = fm.format(cal.getTime());
								System.out.println("PT����:" + PTdate);
								System.out.println(PTdate + "�� ��ÿ� PT�������� �Է��Ͻÿ�:");
								PThour = sc.nextInt();
								System.out.println("PT�ð�:" + PThour + "��");
								cal.add(Calendar.DAY_OF_YEAR, -afterPT);

								System.out.println();

								member.get(j).setPTdateNhour(PTdate, PThour);
								member.get(j).getPTmbprofile();
								// member.add(new
								// PTmember(name,age,sex,registMonth,trainerName,ptNum,PTdate,PThour,ptPrice));
								// //PTmember ��ü�����Ϸ�
								lim.schedulePT(j, lim.getName(), PTdate, PThour); // Ʈ���̳����� ȸ�� index�� PT���� ��¥
								// lim.sumMoney(member.get(j).getPTprice());// PT��� ����
								System.out.println();

								// } // if (member.get(j).getSex().equals("M")) {// ����
								//////////////////////////////////////////////////////////////
//										System.out.println("=======PT ���� ���======="); // d-day Ȱ��
//
//										System.out.println("=======PT ���� ���======="); // d-day Ȱ��
//
//										//		System.out.println("T(trainer):�Բ�, ��� ������ ��¥�� ���غ��ô�."); // ȸ�� ��侲���� ���غ���?
//												// int current = 0;
//												// cal.add(Calendar.YEAR, 1); // 1���� ���Ѵ�.
//												// cal.add(Calendar.MONTH, 1); // �Ѵ��� ���Ѵ�.
//												// cal.add(Calendar.DAY_OF_YEAR, 1); // �Ϸ縦 ���Ѵ�.
//												// cal.add(Calendar.HOUR, 1); // �ð��� ���Ѵ�
//												// if (current == 0) {
//
//												// int afterPT = ran.nextInt(7) + 1; // 1~7(������)���� �����Լ�
//												System.out.println("��ĥ �Ŀ� PT���� ������ �Է��Ͻÿ�:");
//												afterPT=sc.nextInt();
//												//afterPT=ran.nextInt(7)+1; //��ĥ �Ŀ� PT���� �޴°� ������
//												//System.out.println("afterPT:"+afterPT);
//												
//												cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT�ϼ��� ���Ѵ�.
//												PTdate = fm.format(cal.getTime());
//												System.out.println("PT����:"+PTdate);
//												System.out.println(PTdate+"�� ��ÿ� PT�������� �Է��Ͻÿ�:");
//												PThour=sc.nextInt();
//												System.out.println("PT�ð�:"+PThour+"��");
//												
//							
//												System.out.println();
//										
//										System.out.println();
//										member.get(j).setPTdateNhour(PTdate, PThour);
//										// member.add(new
//										// PTmember(name,age,sex,registMonth,trainerName,ptNum,PTdate,PThour,ptPrice));
//										// //PTmember ��ü�����Ϸ�
//										lim.schedulePT(j, lim.getName(), PTdate, PThour); // Ʈ���̳����� ȸ�� index�� PT���� ��¥
//										lim.sumMoney(member.get(j).getPTprice());// PT��� ����
								System.out.println();

								///////////////////////////////////////////////////////////////
								// break; // �ݺ���Ż��

								// }//~if (select == 1) 1.�ǻ�� ���� ������
//										else { // ����
//											System.out.println("good");
//										}//~else
							} // ~if(nTemp[k]==member.get(j).getPThour() �迭�ð�����==PT�޴½ð�

						} // ~for2 (j=0;j<PTcount;j++)
					} // ~for(k=0;k<PTcount;k++ ���� PT ���� �ο� ��
				} // ~else PT ���೯�̴�.

				System.out.println();
				if (member.size() == 0) { // ȸ���� �Ѹ� ������ break;
					break;
				}//~member size
				
			} // ~while ��¥ �Ϸ� �������鼭 ����üũ

			/////////////////////// ending////////////////////////////////////////
			// } // ~ while(lim.haveMoney<10000000)õ�����ɶ����� ȸ���ޱ�
			System.out.println("============================ending============================");
			System.out.println("TNB��Ʈ�Ͻ����� �� ���� "+lim.haveMoney+" ������!");
			System.out.println("���� ���� �ｺ���� �����ؼ� ���� ������ ��ư�����!!");
		} // ~if(select==1)����ƮƮ���̳� ��ü ����
			////////////////////////////// ����ƮƮ���̳� ����
			// ��////////////////////////////////////////////////////

//////////////////////////////���̾�Ʈ Ʈ���̳� ���� ���� ////////////////////////////////////////////////////
		else if (select == 2) {
			System.out.println("\"����ƮƮ���̴� ���� PTƮ���̳ʴ�.\"");
			System.out.print("����Ʈ ���� ��ȸ ���� Ƚ��(ȸ)���� �Է�:");
			wtAwardNum = sc.nextInt();
			// Ʈ���̳ʵ� ��ü����
			WeightTrainer lim = new WeightTrainer(name, age, sex, exerCareer, coachCareer, coachSucNum, fame, 0,
					wtAwardNum);
			lim.perPTprice(); // Ʈ���̳� ȸ�� PT����

			WeightTrainer kim = new WeightTrainer("ö��", 950505, "M", 24, 12, 10, 2, 10, 2);

			WeightTrainer lee = new WeightTrainer("����", 930606, "F", 32, 24, 20, 4, 100, 5);

			System.out.println();
			System.out.println("*******TNB Ʈ���̳� ������*******");
			// �ｺƮ���̳ʵ� ���� ����
			lim.getTrainerProfile();
			kim.getTrainerProfile();
			lee.getTrainerProfile();
			System.out.println("**************************");

			/////////////////////////////// ����ƮƮ���̳�
			/////////////////////////////// ��ü�����Ϸ�//////////////////////////////////////////

			System.out.println();
//				System.out.println(name+" Ʈ���̳ʴ� �ñ����� ��ǥ�� �ִ�.\n ȸ������ PT�Ͽ� ���� ���� �����Ͽ�");
//				System.out.println("���� �ｺ���� �����ϴ� ���� �ｺƮ���̳ʷμ��� ���� ��ǥ�̴�.");
//				System.out.println("���� �ｺ���� �����ϴµ� �Һ�Ǵ� ���� �� 10,000,000(õ��)���� �ʿ��ϴ�.");
			System.out.println("10,000,000(õ����)�� ������ ������!");
			System.out.println("");
			System.out.println("");
			////////////////////// õ���� �� ������ �ݺ�������///////////////////////////////////
			// while (lim.haveMoney < 100000) { // õ���� �ɶ����� ȸ���ޱ�
//					System.out.println(lim.haveMoney + "/10,000,000��");
//					System.out.println(" 10,000,000���� ����!!");
//					System.out.println();
			fame = lim.fameCheck();// Ʈ���̳ʸ� �����޼ҵ�

			System.out.println(name + "�� ���� Ʈ���̳� ������" + fame + "��, �Ϸ� PT������ �ִ�" + 5 * fame + "����� ���� �� �ִ�.");

			System.out.println("(1.�����ο� ���� ����  2.�����ο� ���� ����)");
			select = sc.nextInt();
			System.out.println("�����ο� �Է�:");
			if (select == 1) {
				select = sc.nextInt();
				ranMemberNum = select;
				System.out.println("���� PT���� �ο���" + ranMemberNum + "���� �����ߴ�."); // �����Լ��� �����ο� ��������
			} else {
				ranMemberNum = ran.nextInt(5 * fame) + 1;// ���� ���� ȸ�� ���� ����
				System.out.println("���� PT���� �ο���" + ranMemberNum + "���� �����ߴ�."); // �����Լ��� �����ο� ��������
			}

			ArrayList<PTmember> member = new ArrayList<PTmember>(); // arraylist ��ü ����

			for (i = 0; i < ranMemberNum; i++) { // ȸ�� ��ü ����=>arraylist �迭�� �����ϱ�,(���߿� �ߵ� �����ϴ� ����� �����ϱ� ����)
				// String name, int age, String sex, int exerCareer,int registMonth,String
				// trainerName,int ptNum
				System.out.println("(" + (i + 1) + "��° ȸ���� ������)");
				System.out.print("�̸� �Է�:");
				name = sc.next();
				System.out.print("����(ex. m(male),f(female)) �ҹ��� �Է�:");
				sex = sc.next();

				while (true) { // ���� üũ
					if (sex.equals("m") || sex.equals("f")) {
						break;
					} else {
						System.out.println("���� �ٽ� m(male),f(female) �� ��Ȯ�� �ҹ��� �ѱ��ڷ� �Է����ּ���.");
						sex = sc.next();
					}
				}
				age = ran.nextInt(20) + 20;
				System.out.println("����:" + age);
//						System.out.println();
				// ptNum =ran.nextInt(9)+1; //PT�޴� Ƚ�� ��������
				ptNum = 1;
				System.out.println("PT �޴� Ƚ�� �Է�:" + ptNum + "ȸ");

//						if (lim.getName().equals(trainerName)) { //�����ؾ��� PT����
//							ptPrice = (lim.getPTprice() * ptNum);
//						}
				ptPrice = (lim.getPTprice() * ptNum);
				System.out.printf("�����ؾ��� PT����:%d", ptPrice);

				// System.out.print("����(����) ���� �Է�:");
				// exerCareer=sc.nextInt();

				System.out.println();
				System.out.println();
				System.out.println("=======PT ���� ���======="); // d-day Ȱ��

				// System.out.println("T(trainer):�Բ�, ��� ������ ��¥�� ���غ��ô�."); // ȸ�� ��侲���� ���غ���?
				// int current = 0;
				// cal.add(Calendar.YEAR, 1); // 1���� ���Ѵ�.
				// cal.add(Calendar.MONTH, 1); // �Ѵ��� ���Ѵ�.
				// cal.add(Calendar.DAY_OF_YEAR, 1); // �Ϸ縦 ���Ѵ�.
				// cal.add(Calendar.HOUR, 1); // �ð��� ���Ѵ�
				// if (current == 0) {

				// int afterPT = ran.nextInt(7) + 1; // 1~7(������)���� �����Լ�
				System.out.println("��ĥ �Ŀ� PT���� ������ �Է��Ͻÿ�:");
				afterPT = sc.nextInt();
				// afterPT=ran.nextInt(7)+1; //��ĥ �Ŀ� PT���� �޴°� ������
				// System.out.println("afterPT:"+afterPT);

				cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT�ϼ��� ���Ѵ�.
				PTdate = fm.format(cal.getTime());
				System.out.println("PT����:" + PTdate);
				System.out.println(PTdate + "�� ��ÿ� PT�������� �Է��Ͻÿ�:");
				PThour = sc.nextInt();
				System.out.println("PT�ð�:" + PThour + "��");
				System.out.println();
				lim.schedulePT(i, lim.getName(), PTdate, PThour); // Ʈ���̳����� ȸ�� index�� PT���� ��¥ ����ֱ�
				cal.add(Calendar.DAY_OF_YEAR, afterPT);
				
				System.out.println();
				member.add(new PTmember(name, age, sex, ptNum, ptPrice, PTdate, PThour, inbodyCount)); // PTmember��ü�����Ϸ�

				if (member.get(i).getInbodyCount() == 0) { // ī��Ʈ��0�̸� inbody ����
					System.out.println("T:" + member.get(i).getName() + "�� ������ PT �������ٵ�,\n "
							+ "ȸ���� �� ���¸� ����� �����Կ�. \'�ιٵ�\' ���տ� ���ǰԿ�.");
					System.out.println("MB:�ιٵ� �����ΰ���?");
					System.out.println("\'�ιٵ�� �����̳ĸ�," + "��ü�� �̼��� ���� ������ ������� ����, ����, ���� �� ������ ����\n"
							+ "�ٸ� ���׵��� �̿��Ͽ� ��ü�� ���� ������ ���ϴ� ����̿���.");
					System.out.println();
					im.exeInbodyMachine(member.get(i)); // �ιٵ�ӽ��۵� �޼ҵ�
				}
				member.get(i).checkInbodyCount();

				System.out.println();
//						member.get(i).getInbodyMass();
//						member.get(i).getPTmbprofile(); //��� ������ ����

				lim.haveMoney += ptPrice;

				System.out.println();
				lim.getTrainerProfile();
				System.out.println("$$$���߿� �ִ� �� �߰��� �� Ȯ��$$$");
				cal.setTime(new Date()); // ����ð� ���ϱ�
				toDay = fm.format(cal.getTime()); // ���� ��¥ �ʱ�ȭ
				// }//~current==0 if��
				///////////////////// �ڵ����� �����Ȳ ����////////////////////////////
				System.out.println("�ܼ�Ȯ��");
				name = sc.next();
				///////////////////// �ڵ����� �����Ȳ ����///////////////////////////

			} // ~for(i=0;i<ranMemberNum;i++) { //ȸ�� ��ü ����=>arraylist�迭�� �����ϱ�,
				// (���߿� �ߵ� �����ϴ� ����� �����ϱ� ����)

			//////////////////////////// ȸ�������� ��/////////////////////////////////////

			int j; // �ݺ��� ��������
			int p; // �ݺ��� ��������
////////////////////////�Ϸ��Ϸ� �������鼭 ȸ��PT��¥ Ȯ�� �� ��������///////////////////////////////////////////////////////
			System.out.println("++++++��� ȸ�� ������ �ۼ��Ϸ�++++++");
			System.out.println();
			System.out.println("ȸ���鸶�� PT������ �� ������ ���� ����..");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.print("����: ");
			System.out.println(toDay); // ���ó�¥ ���
			try {
				for (j = 0; j < 3; j++) {
					System.out.println(".");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("->������ �����ϴ�.");
			System.out.println();
//			cal.add(Calendar.DAY_OF_YEAR, 1); // afterPT�ϼ��� ���Ѵ�.
//			toDay = fm.format(cal.getTime());
//			System.out.println("����:"+toDay+"�Դϴ�.");
			while (true) { // ��¥ �Ϸ� �������鼭 ����üũ
				
				if(lim.haveMoney<10000000) { //�Ϸ� ������ ȸ���������� �����Ǵ� ���ǹ�
					System.out.println("(1.�����ο� ���� ����  2.�����ο� ���� ����)");
					select = sc.nextInt();
					System.out.println("�����ο� �Է�:");
					if (select == 1) {
						select = sc.nextInt();
						ranMemberNum = select;
						System.out.println("���� PT���� �ο���" + ranMemberNum + "���� �����ߴ�."); // �����Լ��� �����ο� ��������
					} else {
						ranMemberNum = ran.nextInt(5 * fame) + 1;// ���� ���� ȸ�� ���� ����
						System.out.println("���� PT���� �ο���" + ranMemberNum + "���� �����ߴ�."); // �����Լ��� �����ο� ��������
					}
					/////////////////////////lim.haveMoney<100000 ���ο� ��� ��ü����/////////////////////////////////
					for (newNum =i ; newNum < i+ranMemberNum; newNum++) { // ȸ�� ��ü ����=>arraylist �迭�� �����ϱ�,(���߿� �ߵ� �����ϴ� ����� �����ϱ� ����)
						// String name, int age, String sex, int exerCareer,int registMonth,String
						// trainerName,int ptNum
						System.out.println("(" + (newNum + 1) + "��° ȸ���� ������)");
						System.out.print("�̸� �Է�:");
						name = sc.next();
						System.out.print("����(ex. m(male),f(female)) �ҹ��� �Է�:");
						sex = sc.next();

						while (true) { // ���� üũ
							if (sex.equals("m") || sex.equals("f")) {
								break;
							} else {
								System.out.println("���� �ٽ� m(male),f(female) �� ��Ȯ�� �ҹ��� �ѱ��ڷ� �Է����ּ���.");
								sex = sc.next();
							}
						}
						age = ran.nextInt(20) + 20;
						System.out.println("����:" + age);
//								System.out.println();
						// ptNum =ran.nextInt(9)+1; //PT�޴� Ƚ�� ��������
						ptNum = 1;
						System.out.println("PT �޴� Ƚ�� �Է�:" + ptNum + "ȸ");

//								if (lim.getName().equals(trainerName)) { //�����ؾ��� PT����
//									ptPrice = (lim.getPTprice() * ptNum);
//								}
						ptPrice = (lim.getPTprice() * ptNum);
						System.out.printf("�����ؾ��� PT����:%d", ptPrice);

						// System.out.print("����(����) ���� �Է�:");
						// exerCareer=sc.nextInt();

						System.out.println();
						System.out.println();
						System.out.println("=======PT ���� ���======="); // d-day Ȱ��

						// System.out.println("T(trainer):�Բ�, ��� ������ ��¥�� ���غ��ô�."); // ȸ�� ��侲���� ���غ���?
						// int current = 0;
						// cal.add(Calendar.YEAR, 1); // 1���� ���Ѵ�.
						// cal.add(Calendar.MONTH, 1); // �Ѵ��� ���Ѵ�.
						// cal.add(Calendar.DAY_OF_YEAR, 1); // �Ϸ縦 ���Ѵ�.
						// cal.add(Calendar.HOUR, 1); // �ð��� ���Ѵ�
						// if (current == 0) {

						// int afterPT = ran.nextInt(7) + 1; // 1~7(������)���� �����Լ�
						System.out.println("��ĥ �Ŀ� PT���� ������ �Է��Ͻÿ�:");
						afterPT = sc.nextInt();
						// afterPT=ran.nextInt(7)+1; //��ĥ �Ŀ� PT���� �޴°� ������
						// System.out.println("afterPT:"+afterPT);

						cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT�ϼ��� ���Ѵ�.
						PTdate = fm.format(cal.getTime());
						System.out.println("PT����:" + PTdate);
						System.out.println(PTdate + "�� ��ÿ� PT�������� �Է��Ͻÿ�:");
						PThour = sc.nextInt();
						System.out.println("PT�ð�:" + PThour + "��");
						System.out.println();
						lim.schedulePT(newNum, lim.getName(), PTdate, PThour); // Ʈ���̳����� ȸ�� index�� PT���� ��¥ ����ֱ�
						cal.add(Calendar.DAY_OF_YEAR, -afterPT);
						System.out.println();
						member.add(new PTmember(name, age, sex, ptNum, ptPrice, PTdate, PThour, inbodyCount)); // PTmember��ü�����Ϸ�

						if (member.get(newNum).getInbodyCount() == 0) { // ī��Ʈ��0�̸� inbody ����
							System.out.println("T:" + member.get(newNum).getName() + "�� ������ PT �������ٵ�,\n "
									+ "ȸ���� �� ���¸� ����� �����Կ�. \'�ιٵ�\' ���տ� ���ǰԿ�.");
							System.out.println("MB:�ιٵ� �����ΰ���?");
							System.out.println("\'�ιٵ�� �����̳ĸ�," + "��ü�� �̼��� ���� ������ ������� ����, ����, ���� �� ������ ����\n"
									+ "�ٸ� ���׵��� �̿��Ͽ� ��ü�� ���� ������ ���ϴ� ����̿���.");
							System.out.println();
							im.exeInbodyMachine(member.get(newNum)); // �ιٵ�ӽ��۵� �޼ҵ�
						}
						member.get(newNum).checkInbodyCount();

						System.out.println();
//								member.get(i).getInbodyMass();
//								member.get(i).getPTmbprofile(); //��� ������ ����

						lim.haveMoney += ptPrice;

						System.out.println();
						lim.getTrainerProfile();
						System.out.println("$$$���߿� �ִ� �� �߰��� �� Ȯ��$$$");
					}
					
				}//~ if 	if(lim.haveMoney<100000)�̸� ȸ�� �ޱ�
				else if(lim.haveMoney>10000000){ //havemoney>��ǥ�� �̸� ���� �ʱ�
					 System.out.println("���� ���� �� �׸��α⶧����,");
					 System.out.println("�� �̻� ȸ���� ���� �ʽ��ϴ�. �˼��մϴ�.");
				}
					
				try { // 3�� sleep
					cal.add(Calendar.DAY_OF_YEAR, 1); // afterPT�ϼ��� ���Ѵ�.

					toDay = fm.format(cal.getTime());
					System.out.print(toDay); // �Ϸ����� ��¥ ���
					System.out.println(" ���� üũ ��");
					for (j = 0; j < 3; j++) {
						System.out.println(".");
						Thread.sleep(1000);
					}

				}

				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int k = 0; // ���Ǻ���
				int PTday = 0; // ������ �ִ� ������ Ȯ��
				int PTcount = 0;// �Ϸ翡 PT ��� �޴��� for�� ����������
				int nTemp[] = new int[member.size()];
				for (p = 0; p < member.size(); p++) { // ȸ���� pt���� Ȯ��
					if (toDay.equals(member.get(p).getPTdate())) {
						System.out.println("->" + member.get(p).getName() + "�� " + member.get(p).getPThour() + "��");
						PTday++;
						PTcount++;
						nTemp[k] = member.get(p).getPThour();
						k++;
					}
				}
				if (PTday == 0) {
					System.out.println("->������ �����ϴ�.");
				} else {
					Music gymMusic = new Music("��Ҷ� ��� ����_��ڱؿ� ���� ���� 1�ð�(����,�ð� �� ����).mp3", true);
					gymMusic.start();

					System.out.println("PT ���� �� �Դϴ�.");
					System.out.println();
					/////////////////// �ð����� ���� ������� PT����////////////////////////////
					AscendFunc.lineUp(nTemp, PTcount);
					n = 0;
					for (k = 0; k < PTcount; k++) { // ���� PT ���� �ο� ��
						for (j = 0; j < member.size(); j++) {
							if (nTemp[n] == member.get(j).getPThour() && member.get(j).getPTdate().equals(toDay)) {// �迭�ð�����==PT�޴»��
																													// �ð��������
																													// &&
																													// ��¥��
																													// ���ÿ�
																													// ���ƾ���
								////////////////////////// PT����/////////////////////////////////
								System.out.println(
										"<" + member.get(j).getName() + "�� " + member.get(j).getPThour() + "�� PT����>");
//										
								n++; // nTemp[k] �ε����� �ö󰡾���..

								// if (member.get(j).getSex().equals("M")) {// ����
								System.out.println("���� ��� ȸ������ �������� Ȯ���غ����� �ҰԿ�.");
								System.out.println();
								System.out.println("T:���� \'����\' ��������" + member.get(j).getAbdominalMass() + ",");
								compAbdominalMass = member.get(j).getAbdominalMass();
								System.out.println("T:\'��\' ��������" + member.get(j).getArmMass() + ",");
								compArmMass = member.get(j).getArmMass();
								System.out.println("T:\'��\' ��������" + member.get(j).getBackMuscleMass() + ",");
								compBackMuscleMass = member.get(j).getBackMuscleMass();
								System.out.println("T:\'����\' ��������" + member.get(j).getChestMass() + ",");
								compChestMass = member.get(j).getChestMass();
								System.out.println("T:\'��ü\' ��������" + member.get(j).getLowerbodyMass() + ",");
								compLowerbodyMass = member.get(j).getLowerbodyMass();
								System.out.println("T:\'���\' ��������" + member.get(j).getShoulderMass() + "�̳׿�.");
								compShoulderMass = member.get(j).getShoulderMass();

								System.out.println("============� ����============"); // ������ �ð� ���ѵּ�
																						// �..
								System.out.print("PT �� �� �����ϰڽ��ϱ�? ���� �Է�:");
								min = sc.nextInt();
								System.out.println("(PT�ð� " + min + "�� ����)");
								Timer t1 = new Timer(min * 60); // 120: 2�� 180: 3��...
								// t1.setDaemon(true); //���ξ����尡 ����Ǹ� timer������ ����
								t1.start(); // ������ ����
//											try { //join
//												t1.join();
//											} catch (InterruptedException e1) {
//												// TODO Auto-generated catch block
//												e1.printStackTrace();
//											}
								//gymMusic.close();

								while (true) { // ����� ��� ��ϱ�
									exerDoReps t2 = new exerDoReps(11);
									exerDoReps last = new exerDoReps(1);
									Music gymMusic2 = new Music("��Ҷ� ��� ����_��ڱؿ� ���� ���� 1�ð�(����,�ð� �� ����).mp3", true);
									gymMusic2.start();

									System.out.println("1.���� 2.�� 3.�� 4.���� 5.��ü 6.��� 7.�����");
									num = sc.nextInt();
									if (num == 1) { // ���� ����
										//gymMusic2.close();
										System.out.println("1.ũ��ġ 2.���׷����� 3.��������Ű��");
										num = sc.nextInt();
										if (num == 1) { // ũ��ġ ����
											member.get(j).doCrunch(10);
											t2.start();

											try {
												t2.join();
											} catch (Exception e) {
											}

										}

										else if (num == 2) { // 2.���׷�����
											member.get(j).doLegraise(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.��������Ű��
											member.get(j).doSitup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} // ~if ���ټ��� num==1
									else if (num == 2) { // 2.��
										//gymMusic2.close();
										System.out.println("1.������ 2.�ٺ��� 3.����ű��");
										num = sc.nextInt();
										if (num == 1) { // 1.������ ����
											member.get(j).doDBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.�ٺ���
											member.get(j).doBBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.����ű��
											member.get(j).doDBkickback(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 3) { // 3.��
										//gymMusic2.close();
										System.out.println("1.���帮��Ʈ 2.�ٺ��ο�3.�ΰ���");
										num = sc.nextInt();
										if (num == 1) { // 1.���帮��Ʈ ����
											member.get(j).doDeadlift(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.�ٺ��ο�
											member.get(j).doBBlow(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.�ΰ���
											member.get(j).doPullup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 4) { // 4.����
										//gymMusic2.close();
										System.out.println("1.��ġ������ 2.�ȱ������ 3.���̺��ö���");
										num = sc.nextInt();
										if (num == 1) { // 1.��ġ������ ����
											member.get(j).doDBcurl(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.�ȱ������
											member.get(j).doPushup(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.���̺��ö���
											member.get(j).doCablefly(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 5) { // 5.��ü
										//gymMusic2.close();
										System.out.println("1.���������� 2.�����ͽ��ټ� 3.����Ʈ");
										num = sc.nextInt();
										if (num == 1) { // 1.���������� ����
											member.get(j).doLegpress(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.�����ͽ��ټ�
											member.get(j).doLegextension(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.����Ʈ
											member.get(j).doSquat(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else if (num == 6) {// 6.���
										//gymMusic2.close();
										System.out.println("1.�������ٺ������� 2.���̵巹�ͷ�������" + "3.��������Ʈ������");
										num = sc.nextInt();
										if (num == 1) { // 1.OHP ����
											member.get(j).doOHP(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else if (num == 2) { // 2.�緹��
											member.get(j).doSideRR(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										} else { // 3.��������Ʈ������
											member.get(j).doDBfrontraise(10);
											t2.start();
											try {
												t2.join();
											} catch (Exception e) {
											}
										}
									} else {
										//gymMusic2.close();
										last.start();
										try {
											last.join();
										} catch (Exception e) {
										}
										t1.interrupt();
										break;
									}

								}

								// ~while(true) ����� ��� ��ϱ�
								System.out.println();
								System.out.println("******� ���******");
								System.out.println(
										"-���� �:" + compAbdominalMass + "->" + member.get(j).getAbdominalMass());
								System.out.println("-���� �:" + compChestMass + "->" + member.get(j).getChestMass());
								System.out
										.println("-��� �:" + compShoulderMass + "->" + member.get(j).getShoulderMass());
								System.out.println(
										"-��ü �:" + compLowerbodyMass + "->" + member.get(j).getLowerbodyMass());
								System.out.println(
										"-�� �:" + compBackMuscleMass + "->" + member.get(j).getBackMuscleMass());
								System.out.println("-�� �:" + compArmMass + "->" + member.get(j).getArmMass());
								System.out.println();
								member.get(j).doPTnum(); // PT Ƚ�� �ϳ� ���̱�
								System.out.println();
								member.get(j).getPTmbprofile(); // ��� ������ Ȯ��
								///////////////////// �ڵ����� �����Ȳ ����////////////////////////////
								System.out.println("�ܼ�Ȯ��");
								name = sc.next();
								///////////////////// �ڵ����� �����Ȳ ����///////////////////////////
								if (member.get(j).getPTnum() == 0) { // PT ���Ƚ�� ����
									System.out.println("T:" + member.get(j).getName() + "��, " + "PT���� ����� �������ϴ�.");
									System.out.println("�߰� ����Ͻðڽ��ϱ�?(1.�׷��� / 2.�ƴϴ�. �׸� ���ڴ�.)");
									select = sc.nextInt();
									if (select == 1) {// �׷���
										System.out.println("T:PT ��ȸ �߰���� �ϰڽ��ϱ�?");
										ptNum = sc.nextInt();
										System.out.println("MB:" + ptNum + "ȸ �߰���� �ϰڽ��ϴ�.");
										member.get(j).setPTnum(lim, ptNum);
										lim.haveMoney += member.get(j).getPTprice();
										System.out.println();

										lim.getTrainerProfile();// ���߿� �ִ� �� Ȯ��
										System.out.println("$$$���߿� �ִ� �� �߰��� �� Ȯ��$$$");
									} // ~if ����ϰڴ�.
									else {
										System.out.println("�׵���, PT �������ּż� �����߽��ϴ�.");
										member.remove(j); // ȸ�� ��ü ����
										continue;
									}
								} // ~if (member.get(j).getPTnum()==0)PT��ϳ���
									// PT ��� �����Ȳ
								System.out.println("=======PT ���� ���======="); // d-day Ȱ��

								// System.out.println("T(trainer):�Բ�, ��� ������ ��¥�� ���غ��ô�."); // ȸ�� ��侲���� ���غ���?
								// int current = 0;
								// cal.add(Calendar.YEAR, 1); // 1���� ���Ѵ�.
								// cal.add(Calendar.MONTH, 1); // �Ѵ��� ���Ѵ�.
								// cal.add(Calendar.DAY_OF_YEAR, 1); // �Ϸ縦 ���Ѵ�.
								// cal.add(Calendar.HOUR, 1); // �ð��� ���Ѵ�
								// if (current == 0) {

								// int afterPT = ran.nextInt(7) + 1; // 1~7(������)���� �����Լ�
								System.out.println("��ĥ �Ŀ� PT���� ������ �Է��Ͻÿ�:");
								afterPT = sc.nextInt();
								// afterPT=ran.nextInt(7)+1; //��ĥ �Ŀ� PT���� �޴°� ������
								// System.out.println("afterPT:"+afterPT);

								cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT�ϼ��� ���Ѵ�.
								PTdate = fm.format(cal.getTime());
								System.out.println("PT����:" + PTdate);
								System.out.println(PTdate + "�� ��ÿ� PT�������� �Է��Ͻÿ�:");
								PThour = sc.nextInt();
								System.out.println("PT�ð�:" + PThour + "��");
								cal.add(Calendar.DAY_OF_YEAR, -afterPT);

								System.out.println();

								member.get(j).setPTdateNhour(PTdate, PThour);
								member.get(j).getPTmbprofile();
								// member.add(new
								// PTmember(name,age,sex,registMonth,trainerName,ptNum,PTdate,PThour,ptPrice));
								// //PTmember ��ü�����Ϸ�
								lim.schedulePT(j, lim.getName(), PTdate, PThour); // Ʈ���̳����� ȸ�� index�� PT���� ��¥
								// lim.sumMoney(member.get(j).getPTprice());// PT��� ����
								System.out.println();

								// } // if (member.get(j).getSex().equals("M")) {// ����
								//////////////////////////////////////////////////////////////
//										System.out.println("=======PT ���� ���======="); // d-day Ȱ��
//
//										System.out.println("=======PT ���� ���======="); // d-day Ȱ��
//
//										//		System.out.println("T(trainer):�Բ�, ��� ������ ��¥�� ���غ��ô�."); // ȸ�� ��侲���� ���غ���?
//												// int current = 0;
//												// cal.add(Calendar.YEAR, 1); // 1���� ���Ѵ�.
//												// cal.add(Calendar.MONTH, 1); // �Ѵ��� ���Ѵ�.
//												// cal.add(Calendar.DAY_OF_YEAR, 1); // �Ϸ縦 ���Ѵ�.
//												// cal.add(Calendar.HOUR, 1); // �ð��� ���Ѵ�
//												// if (current == 0) {
//
//												// int afterPT = ran.nextInt(7) + 1; // 1~7(������)���� �����Լ�
//												System.out.println("��ĥ �Ŀ� PT���� ������ �Է��Ͻÿ�:");
//												afterPT=sc.nextInt();
//												//afterPT=ran.nextInt(7)+1; //��ĥ �Ŀ� PT���� �޴°� ������
//												//System.out.println("afterPT:"+afterPT);
//												
//												cal.add(Calendar.DAY_OF_YEAR, afterPT); // afterPT�ϼ��� ���Ѵ�.
//												PTdate = fm.format(cal.getTime());
//												System.out.println("PT����:"+PTdate);
//												System.out.println(PTdate+"�� ��ÿ� PT�������� �Է��Ͻÿ�:");
//												PThour=sc.nextInt();
//												System.out.println("PT�ð�:"+PThour+"��");
//												
//							
//												System.out.println();
//										
//										System.out.println();
//										member.get(j).setPTdateNhour(PTdate, PThour);
//										// member.add(new
//										// PTmember(name,age,sex,registMonth,trainerName,ptNum,PTdate,PThour,ptPrice));
//										// //PTmember ��ü�����Ϸ�
//										lim.schedulePT(j, lim.getName(), PTdate, PThour); // Ʈ���̳����� ȸ�� index�� PT���� ��¥
//										lim.sumMoney(member.get(j).getPTprice());// PT��� ����
								System.out.println();

								///////////////////////////////////////////////////////////////
								// break; // �ݺ���Ż��

								// }//~if (select == 1) 1.�ǻ�� ���� ������
//										else { // ����
//											System.out.println("good");
//										}//~else
							} // ~if(nTemp[k]==member.get(j).getPThour() �迭�ð�����==PT�޴½ð�

						} // ~for2 (j=0;j<PTcount;j++)
					} // ~for(k=0;k<PTcount;k++ ���� PT ���� �ο� ��
				} // ~else PT ���೯�̴�.

				System.out.println();
				if (member.size() == 0) { // ȸ���� �Ѹ� ������ break;
					break;
				}//~member size
				
			} // ~while ��¥ �Ϸ� �������鼭 ����üũ

			/////////////////////// ending////////////////////////////////////////
			// } // ~ while(lim.haveMoney<10000000)õ�����ɶ����� ȸ���ޱ�
			System.out.println("============================ending============================");
			System.out.println("TNB��Ʈ�Ͻ����� �� ���� "+lim.haveMoney+" ������!");
			System.out.println("���� ���� �ｺ���� �����ؼ� ���� ������ ��ư�����!!");
		} // ~else if(select==2) ���̾�ƮƮ���̳� ��ü����
//////////////////////////////���̾�Ʈ Ʈ���̳� ���� �� ////////////////////////////////////////////////////
		else {
			System.out.println("�� �� �Է��ϼ̽��ϴ�. 1.����ƮƮ���̴�/2.���̾�ƮƮ���̴� �� �������ּ���!");
			select = sc.nextInt();
			// ���߿� ����ƮƮ���̴�, ���̾�Ʈ Ʈ���̴� �����ϱ�!
		} // ~else �� �� �Է��ϼ̽��ϴ�.1.����ƮƮ���̴�/2.���̾�ƮƮ���̴� �� �������ּ���!
		// } // main �߰�ȣ ~while(true)
	}
}
//	sc.close();
//	}//~public static void main
//}//~public class MainStory
