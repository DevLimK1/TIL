java  
 ↓  
연산자  
피연산자  
제어구조  
배열  
함수  


##### 각국의 문자코드 확장

ASCII + KR = EUC-KR  
ASCII + JP = EUC-JP  
ASCII + CN = EUC-CN  

--> 문제점: 예를들어, C8B00F 코드 를 치면 EUC-KR, EUC-JP , EUC-CN의 값들이 다 다르게 나옴  
해결: 유니코드 사용

##### 문자와 문자열
- 문자열은 "abcd" 라고 썼으면 "abcd\0" 으로 자동 \0이 추가되어 문자열의 끝나는 지점을 인식

```java
char x='A';
int y=((int)x)+1; //x의 형식변환을 해주려면 이와 같이 명시적으로 괄호를 묶어줘야함

```
```java
Integer.parseInt("23")->23   //문자열을 숫자로 변경
int x = 23;
String yString="23";
String x1=String.valueOf(x); //int x 를 String으로 형변환
int y1=Integer.parseInt(yString); //String yString을 int로 형변환
		
```

---

##### 자료형식(기본형)

정수 :  
	byte(1byte), short(2byte), int(4byte)->자바에서 기본형, long(8byte)

```java
byte x = 3(4byte); // -128 ~ 127 까지의 정수는 정상범위
byte x = 3L(8byte); //오류
byte bt=3; //묵시적으로 형식을 변환 int -> byte
byte bt1 = (byte)3L;
int y=bt1; //묵시적으로 형식을 변환 byte -> int
```
실수:  
	float(4byte), double(8byte)
```java
float x=3.4;
float fx=3.4; //오류 double -> float 데이터 손실되기 때문에 형변환 안됨
double dx=3.4f;
double dy = 3;
int ix=dy; //실수값이 손실되기 때문에 대입이 안됨
```
문자:  
	char(2byte);
```java
char x=34;
int y='A';
System.out.println(x); // 실행결과 : A
System.out.println(y); // 실행결과 : 65
System.out.println(x+y); // 실행결과 : 130
```

부울:  
	boolean(사이즈는 가변)   
	boolean은 형변환 자체가 안됨  

```java
boolean x =1; (X)
```

값은 변수(공간)에 담아서 사용할 수 있는 것.  
"값은 공간에 들어있다."  

정수 타입 : byte, short, int, long

부동 소수점 타입 : float, double

부울 데이터 타입 : boolean

문자 데이터 타입 : char    

참조형식 : 참조변수(주소(공간)를 참조), 참조형식으로 만들어진 객체

자바는 기본형식 제외 다 참조형식이다.

```
int x; //기본형식
String y; //참조형식
```

<형식변환>

```java
int x = (int)3.4;
String s=3.4; //-> "3.4"가 되어야 가능 : String.valueOf(3.4);
float f ="3.4";// -> 3.4가 되어야 가능 : Float.parseFloat("3.4");
int n ="3"; // -> 3이 되어야 가능 :Integer.parseInt("3");
boolean = "true"; // -> true :Boolean.parseBoolean("true");
double d = Double.parseDouble("34.2"); // -> 문자열을 double로 형식 변환
```

