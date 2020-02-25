입/출력 도구(Console,File)

```java
System.in; // Console "InputStream"
System.out; //PrintStream

System.out.print(); // 문자로 출력해주는 도구
```

System.out.print(); 는 숫자 그대로 출력해줄 수는 없음, 문자로 출력해주는 도구이기때문에



```java
Scanner scan = new Scanner(System.in);
scan.next(); //띄어쓰기전까지 문자열로 읽어옴
scan.nextLine(); //엔터치기 전까지 한 줄을 문자열로 읽어옴
```



---

#### <가장 큰 수 구하기, 두번째 큰 수 구하기>  

```
(ex07data2.txt)

6 10 257 54 48 257
```



```java
FileInputStream fisFileInputStream = new FileInputStream("res/ex07data2.txt");
Scanner scanner = new Scanner(fisFileInputStream);

String string;

//문제1)가장 큰 수를 구하시오
int max=-1;
while(scanner.hasNext()) {
    int num;
    string=scanner.next(); //scanner객체가 참조하고 있는 text파일의 데이터 읽어옴
    num=Integer.parseInt(string); //정수로 형변환
    if(max<num) { //가장 큰 수보다 읽어온 데이터 수가 크다면 
        max=num; //max 변수에 num 변수 대입
    }

}
System.out.println("가장 큰 수: " + max);

//문제2-2)텍스트 데이터 중에 두번째 큰 수를 구하시오
int max = -1, max2 = -1;
int temp = -1;

while (scanner.hasNext()) {
    int num;
    string = scanner.next(); // 데이터 읽어옴
    num = Integer.parseInt(string); // 정수로 형변환

    if (max2 < num) {
        if(num!=max) //가장 큰 수와 중복되지 않으면
            max2 = num; // 두번째 큰 수에 읽어 온 데이터 대입

        if (max < max2 ) { //가장 큰 수보다 두번째 수가 크면
            temp = max2; //가장 큰 수와 두번째 수 교환
            max2 = max;
            max = temp;
        }
    }
}
System.out.println("두번째 큰 수: " + max2);
```

