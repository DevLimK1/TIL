package Person;

import java.util.ArrayList;

public class HealthTrainer extends Person{ //헬스트레이너
	int exerCareer;
	int lvCheck=0;
	int i=0;
	int coachCareer; //코칭경력
	int careerPerPrice=5000;//코칭경력 기본급
	int coachSucNum; //회원코칭 성공횟수
	int sucPerPrice=5000; // 회원코칭 성공 기본급
	int basicPTprice=10000; //기본 PT급여
	int totalPerPTprice; //트레이너 회당 PT가격
	int trainerFame; //트레이너 레벨->레벨에 따라 PT회원 받을 수 있는 수가 달라짐,레벨업 기준:PT성공횟수
	public int haveMoney;
	int fame; //명성
	String PTdate;
	String license; //취득 자격증
	
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
	
	public int getPTprice() { //회당 PT가격 반환 메소드
		return totalPerPTprice;
	}
	public void perPTprice() { //회당 PT가격
		System.out.println(name+" 트레이너의 회당 PT가격은"+totalPerPTprice+"원으로 책정된다.");
	}
	
	public int fameCheck() { // 트레이너 레벨체크
		System.out.println(name+" 트레이너님의 회원코칭 성공횟수는 "+coachSucNum+"회이기 때문에");
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
	
	public void sumMoney(int ptPrice) { //회원이 지불한 금액+수중에 있는돈
		haveMoney+=ptPrice;
	}
	public void minusMoney(PTmember mb) { //수중에 있는 돈-회원이 지불한 금액
		haveMoney-=mb.ptPrice;
	}
	
	public void schedulePT(int mbIndex,String name,String PTdate,int PThour) { //회원들 PT일정 적어놓기
		list.add(mbIndex,PTdate); //회원 index, 회원 pT일정
		System.out.println("★"+name+"트레이너 스케쥴표에 "+list.get(mbIndex)+" "+PThour+"시 저장★");
		
	}

//	public void trainerPTsuc() { //트레이너 레벨+1 업
//		coachSucNum++; //성공횟수+1
//		if(coachSucNum>4) {
//			trainerLV++;
//		}
//	}
	


}
