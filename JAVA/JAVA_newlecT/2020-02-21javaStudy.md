함수는 객체라는 것으로 묶여있는데, 객체는 함수기능을 구현하기 위한 재료(밑바탕) 

문자열 쪼개기, 문자열 합치기 등을 함수로 가지고 있는데, 문자의 기능으로 포함되어 있는게 있음 

변수 선언 : 컴파일러한테 키워드를 알려주는 것

---

##### (반복문)

```java
int x=0;
boolean end = false;
while(x<10) { //(괄호의 조건이 참인 동안 반복한다.)
	System.out.println("hello");
	//여기서 반복되는 과정에서 변화가 있어야 while문을 빠져나갈 수 있음
	System.out.println(x);
	//만약에 x가 10보다 크다면 while 종료
	x++;
	 
} 
```



문자를 숫자로 저장한다: 바이너리로 저장

PrintStream : 숫자를 써도 **문자열**로 변환해줌 

---

##### (Ex4BinProgram.java)

```java
	//1.숫자 97과 98를 문자가 아닌 숫자 그대로 파일에 쓰기를 하고
		FileOutputStream fos = new FileOutputStream("D:\\acorn\\workspace\\data-b.txt");
		//fos -> [00000000 00000000                           ] 8kb  버퍼 생성됨
		fos.write(97); //아스키코드로 읽어옴 , 1byte(8bit)씩 읽어옴 max:0~255, 256은 못한다.
		fos.write(98); // data-b.txt에 ab 로 값이 출력됨
		fos.flush();
		fos.close();
	//2.파일에서 숫자를 그대로 읽어서
		FileInputStream fis = new FileInputStream("D:\\acorn\\workspace\\data-b.txt");
		int x=fis.read();//아스키코드로 읽어옴 , 1byte(8bit)씩 읽어옴 max:0~255, 256은 못한다.
		int y=fis.read();
		fis.close();
	//3.그 결과를 콘솔에 출력한다.
		int result=x+y;
		
		System.out.println(result); //data-b.txt에는 ab로 되어있지만 한글자씩 읽어와서 97+98 해서 195 출력
```
---

##### (Ex5CopyProgram.java)

```java
	//1.이미지 파일을 읽기 위한 버퍼 객체 fis와 쓰기위한 버퍼객체 fos를 생성하고
		FileInputStream fis= new FileInputStream("D:\\acorn\\workspace\\image.png");
		FileOutputStream fos =new FileOutputStream("D:\\acorn\\workspace\\image-copy.png");
	//2.읽기 버퍼객체 fis에서 이미지 1byte를 읽어서 fos에 1byte를 쓰기한다. 이것을 끝까지 반복한다.
		int b;
		while((b=fis.read())!=-1) {
			fos.write(b);
		}
	//3.반복이 끝나면 fos와 fis의 자원을 반환한다.
		fis.close();
		fos.close();
```



숫자(또는 코드)를 출력하는 기능이 fos에는 하나씩만 할 수 있는 기능인 write 밖에 없다.

문자만 또는 문자열을 한번에 출력하게 하는 기능이 있다면 얼마나 좋을까?



----

플랫폼  <------> 자바 언어  
API                    1. 연산자  

​						  2.피연산자(표현방법, 값의형식, 변수선언)        
​					  	3.(while, if, ...)  
Console  
​      System.in  
​      System.out  
File  
​      FileInputStream -> String -> Scanner  
​      FileOutputStream -> String -> PrintStream  

---

```java
	 new PrintStream(new FileOutputStream())
	 System.out=new PrintStream(new ConsoleOutputStream()) -> 우리가 따로 손을 대지 못하게 함, 즉 내장객체

	System.out.print("23"); // ->입력된 내용이 숫자든 문자든 다 문자열로 바꿔서 출력해줌 "23"
	 문자열 출력:PrintStream
	 숫자 출력:OutputStream
```

##### (Ex6ConsoleCopyProgram.java)

```java
   1: 		int code= System.in.read(); //정수,문자 한글자씩 읽어옴
   2: 		System.out.println(code); //123입력하면 결과:49(1의 아스키코드) , a입력하면 결과:97 
   3: 		
-----------------------------------------------------------------------------------------
   4: 		Scanner scanner = new Scanner(System.in); //입력 버퍼객체 scanner 생성
   5: 		
   6: 		int x= scanner.nextInt(); // 띄어쓰기 전까지 정수 읽어옴 
   7: 		System.out.println(x); // 입력: 123 12 --> 출력: 123
   8: 		
   9: 		String nameString; //String(문자열) 객체 nameString 생성
  10: 		nameString=scanner.nextLine(); //엔터치기 전까지 문자열 읽어옴
  11: 		System.out.println(nameString); //입력:abc de --> 출력:abc de
  12: 		
  13: 		nameString=scanner.next(); // 띄어쓰기 전까지 문자열 읽어옴
  14: 		System.out.println(nameString); //입력:abc de --> 출력:abc
  15: 		
  16: 		nameString=scanner.next(); // 만약에 위에 동일한 코드가 있어서 입력을 abc de로 하면
  17: 		System.out.println(nameString); //위에서 abc가 출력되고 아래에 de가 출력됨
  18: 		
-----------------------------------------------------------------------------------------
  19: 		String fileNameString = scanner.nextLine(); //String 객체 생성
  20: 		System.out.println(fileNameString);
  21: 
  22: 		int length = fileNameString.length(); 
  23: 		System.out.println(length); //fileNameString 객체의 문자열 길이
  24: 		System.out.println("123".length()); //문자열 리터럴도 객체이다, 출력:3
  25: 		
  26: 		String filenameString2String = fileNameString.toUpperCase();//소문자->대문자로 변경해서 출력
  27: 		System.out.println(filenameString2String);
  28: 
```


```

```