package KindOfWeight;

import Person.*;


public class ABSweight { //복근운동
	int crunch; //크런치
	int legRaise; //레그레이즈
	int sitUp;//윗몸일으키기
	int kneeUp;//니업
	
	double ABSmuscleMass ; //복근근육량
	 
//	public void ABSmusclePlus(double ABSmuscleMass) { // 복근 근육량증가
//		System.out.println("복근 근육량이 " + ABSmuscleMass + " 증가했습니다.");
//		System.out.println("총 복근 근육량이 "+Inbodyinfo.totalABSmuscleMass+"가 되었습니다.");
//	}
//	//운동은 사람이 한다!! 
	public int doCrunch() {//크런치 운동 수행
		System.out.println("=>복근운동: 크런치 수행");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("=>복근 근육량+3");
		return +3;
	}
	public int doLegraise() {//레그레이즈 운동 수행
		System.out.println("=>복근운동: 레그레이즈 수행");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("=>복근 근육량+2");
		return +2;
	}
	public int doSitUp() {//윗몸일으키기 운동 수행
		System.out.println("=>복근운동: 윗몸일으키기 수행");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println("=>복근 근육량+1");
		return +1;
	}
}
