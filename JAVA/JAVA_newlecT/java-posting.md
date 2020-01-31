## 자바 강의 20강- 형식지정자 옵션

```java
System.out.printf("%3$d %2$d %1$d\n",10,20,30);
```

> 매개변수로 넘겨지는 값(10,20,30)의 인덱스로 출력<br>
> Ex) %3$d:30 %2$d:20 %1\$d:10<br>
> 출력: 30 20 10<br>

```java
System.out.printf("%1$d %1$d %1$d\n",10);
```

> 인덱스 1인 10을 3개의 형식지정자가 참조해서 출력됨 <br>
> 출력 : 10 10 10 <br>

---

## 자바 강의 32강 switch와 break 라벨문

```java
   1: bye:
   2: while(true){
   3:     switch(true){
   4:         case 1:
   5:             break;
   6:         case 2:
   7:             break;
   8:         .
   9:         .
  10:         .
  11:         default:
  12:             break bye;
  13:     }
  14: }
```

> switch문 스코프 case,default 안에서 사용하는 break는 switch문만 빠져나가게 된다. <br>
> while문까지 종료시키려면 label문을 사용해야한다. <br>
> 12번 줄에 break bye; 가 1번줄의 같은 bye: 라는 라벨을 만나면 while문이 종료된다.
