package Ex12AutoBoxing;

public class Program {
	public static void main(String[] args) {
//		Object	object=new Integer(3); //아래 것과 똑같음
		Object	object2=Integer.valueOf(3); //Boxing=>Integer라는 박스에 3의 값을 넣어서 참조시킴
		Object y=3; //autoBoxing 자동으로 Boxing해줌 
		
		int a=3;
		Integer integer =3; //Integer는 기본값이 null이고 null을 담을 수 있음
		
		int z=a+integer; //unBoxing 언박싱 integer에서 자동으로 값(기본형으로)만 빼낸다.
		System.out.println(z);
		System.out.printf("object is %d%n",object2);
		System.out.printf("object is %d%n",y);
	}
}
