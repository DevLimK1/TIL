package Person;

import java.util.ArrayList;

public class HealthTrainer extends Person{ //�ｺƮ���̳�
	int exerCareer;
	int lvCheck=0;
	int i=0;
	int coachCareer; //��Ī���
	int careerPerPrice=5000;//��Ī��� �⺻��
	int coachSucNum; //ȸ����Ī ����Ƚ��
	int sucPerPrice=5000; // ȸ����Ī ���� �⺻��
	int basicPTprice=10000; //�⺻ PT�޿�
	int totalPerPTprice; //Ʈ���̳� ȸ�� PT����
	int trainerFame; //Ʈ���̳� ����->������ ���� PTȸ�� ���� �� �ִ� ���� �޶���,������ ����:PT����Ƚ��
	public int haveMoney;
	int fame; //��
	String PTdate;
	String license; //��� �ڰ���
	
	ArrayList<String> list=new ArrayList<String>();
	
	public HealthTrainer(String name,int age,String sex,int exerCareer
			,int coachCareer,int coachSucNum,int fame,int haveMoney) {
		super(name,age,sex);
		this.exerCareer=exerCareer;
		this.coachCareer=coachCareer;
		this.coachSucNum=coachSucNum;
		this.haveMoney=haveMoney;
		this.fame=fame;
	}
	
	public int getPTprice() { //ȸ�� PT���� ��ȯ �޼ҵ�
		return totalPerPTprice;
	}
	public void perPTprice() { //ȸ�� PT����
		System.out.println(name+" Ʈ���̳��� ȸ�� PT������"+totalPerPTprice+"������ å���ȴ�.");
	}
	
	public int fameCheck() { // Ʈ���̳� ����üũ
		System.out.println(name+" Ʈ���̳ʴ��� ȸ����Ī ����Ƚ���� "+coachSucNum+"ȸ�̱� ������");
		i=0;
		while (true) {
			i++;
			if (coachSucNum <= 5 * i) {
				return i;
			}
		}
	}
	
	public void printMoney() {
		System.out.println(haveMoney);
	} 
	
	public void sumMoney(int ptPrice) { //ȸ���� ������ �ݾ�+���߿� �ִµ�
		haveMoney+=ptPrice;
	}
	public void minusMoney(PTmember mb) { //���߿� �ִ� ��-ȸ���� ������ �ݾ�
		haveMoney-=mb.ptPrice;
	}
	
	public void schedulePT(int mbIndex,String name,String PTdate,int PThour) { //ȸ���� PT���� �������
		list.add(mbIndex,PTdate); //ȸ�� index, ȸ�� pT����
		System.out.println("��"+name+"Ʈ���̳� ������ǥ�� "+list.get(mbIndex)+" "+PThour+"�� �����");
		
	}

//	public void trainerPTsuc() { //Ʈ���̳� ����+1 ��
//		coachSucNum++; //����Ƚ��+1
//		if(coachSucNum>4) {
//			trainerLV++;
//		}
//	}
	


}
