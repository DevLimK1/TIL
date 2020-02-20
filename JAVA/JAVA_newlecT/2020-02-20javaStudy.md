### 모든 언어의 필수요소(자바의 구성)

1.연산자

2.피연산자

3.제어구조

4.배열

+함수, 클래스, 컬렉션



### 형식명
34 -> 정수 -> int(4byte)  
34L -> Long 정수-> long(8byte)  
123.4 -> 2배 실수 -> double (8byte)  
123.4f -> 실수 -> float (4byte)  
byte : 1byte  
short : 2byte  
boolean : 가변  
char : 2 byte 

###### (명시적인 형 변환)
int x;
x=(int)3.2; 

### 출력 스트림(Output Stream)을 이용한 비동기 처리
출력 버퍼에 write() 한다. --> 출력스트림버퍼(OutputStream) 이용(출력 방향 버퍼의 느낌)
그냥 버퍼라고하면 방향성이 없음. 스트림은 단방향의 의미를 줌

출력 객체를 통해 write() 하게 됨
버퍼를 생성하려면 타입명이 필요함.

```java
                      new 개체(Entity) -> 객체(object)
FileOutputStream out= new FileOutputStream();
out.write();  // 출력버퍼객체명.write()
```

OutputStream : 출력 스트림 개체명(타입명)  
out : 출력 스트림 객체(실체화)  
비유) 자전거 다롱이   
자전거-> 타입명   
다롱이 -> 타입의 실체화  

예제)
```java
FileOutputStream fos = new FileOutputStream("C:\\workspace\\data.out2");
fos.write('H');
fos.write('e');
fos.write('l');
fos.write('l');
fos.write('o');
fos.close();
↓ (PrintStream을 써서 문자열을 출력해줄 수 있음)
FileOutputStream fos = new FileOutputStream("C:\\workspace\\data.out2");
PrintStream out = new PrintStream(fos); // fos를 인자로 꼭 넣어줘야 한다!
out.print("Hello");
```

---
### 파일입력 스트림(FileInputStream)


```java
   1: 		Scanner scan;
   2: 		FileInputStream fis;
   3: 		FileOutputStream fos;
   4: 		PrintStream out;
   5: 		int ch;
   6:       
   7: 		fis =new FileInputStream("C:\\workspace\\data.txt");
   8: 		scan= new Scanner(fis);
   9: 		ch= scan.nextInt();
  10: 		System.out.println(ch);
  11: 		ch= scan.nextInt();
  12: 		System.out.println(ch);
  13: 		
  14: 		
  15: 		fis.close();			
```

> 1~ 5 : 선언문 (수행되지는 않음)  
> 8: Scanner 클래스로 fis 변수(C:\\workspace\\data.txt) 읽어들임  
> 9: nextInt() : 다음 공백이 있을 때까지 정수를 읽어옴  

파일에서 문자 하나씩 읽어오는 도구 (자바에서 제공): FileInputStream   
FIleInputStream fis=new FileInputStream("");  
fis.read();

파일에서 문자 여러개씩(단어 또는 줄단위)로 읽어오는 도구  
Scanner scan= new Scanner(fis);   * 인자(버퍼)로 값을 넘겨줘야함  
int x= scan.nextInt();  
int y= scan.nextInt();  

---

추가예제)
1.파일 입력 버퍼(**FileInputStream**)를 객체 fis를 생성

- FileInputStream fis =new FileInputStream("C:\\workspace\\data.txt");

2.fis객체를 이용해서 단어로 읽어주는 Scanner 객체 scan을 생성

- Scanner scan= new Scanner(fis);

3.scan의 기능 nextInt 함수를 이용해서 첫 번째 정수 값을 읽어서 x 변수에 대입하고

- int x=scan.nextInt();

4.nextInt() 함수를 다시 호출해서 두번째 정수값을 읽어서 y 변수에 대입

- int y=scan.nextInt();

5.그 결과를 화면에 출력

- System.out.printf("%d %d",x,y);   



1.파일 출력을 위한 **FileOutputStream** 객체 fos를 생성

- FileOutputStream fos=new FileOutputStream("C:\\workspace\\data.txt");

2.문자열 출력을 쉽게 하기 위해서 PrintStream객체 out을 생성

- PrintStream out = new PrintStream(fos);

3.out객체의 println() 함수를 이용해서 result 값을 출력

- out.println(result);



##### (FileInputStream 사용하여 파일데이터를 읽어오고, FileOutputStream 사용하여 파일데이터를 출력하는 예제)

```java
   1:    	FileInputStream fis =new FileInputStream("C:\\workspace\\data.txt");
   2: 		Scanner scan= new Scanner(fis);
   3: 		int x = scan.nextInt();
   4: 		int y= scan.nextInt();
   5: 		int result = x+y;
   6: 		System.out.println(result);
   7: 		scan.close();
   8: 		fis.close();
   9: 	
  10: 		FileOutputStream fos=new FileOutputStream("C:\\workspace\\data.txt");
  11: 		PrintStream out = new PrintStream(fos);
  12: 		out.println(result);
```

> 1: FileInputStream 클래스를 사용하여 파일데이터를 읽은 fis 객체 생성   
> 2: fis 객체의 데이터를 읽어올 Scanner 클래스 scan 객체 생성  
> 3`~`4: scan.nextInt(); 를 사용하여 띄어쓰기를 구분하여 변수 x, y에 대입  
> 7~8: scan.close(); fis.close(); 를 하여 메모리 누수를 방지  
>
> 10: FileOutputStream 클래스를 사용하여 파일데이터를 출력할 fos 객체 생성  
> 11: PrintStream 클래스를 사용하여 fos 객체의 데이터에 출력할 out 객체 생성  
> 12: out.println(result); 의 결과로 data.txt 에 결과값 그대로 저장됨  





