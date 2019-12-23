# [백준 10430번 문제- 나머지](https://www.acmicpc.net/problem/10430)

(A+B)%C는 (A%C + B%C)%C 와 같을까?

(A×B)%C는 (A%C × B%C)%C 와 같을까?

--> 같음

<!-- # 문제의 구현 (JAVA) -->

# 구현 소스(JAVA)

> 예제 입력 1<br>
> 5 8 4 <br>
> 예제 출력1<br>
> 1 <br>
> 1 <br>
> 0 <br>
> 0 <br>

```JAVA
   1:     Scanner sc=new Scanner(System.in);
   2:
   3:         int inputA=sc.nextInt();
   4:         int inputB=sc.nextInt();
   5:         int inputC=sc.nextInt();
   6:
   7:         System.out.println((inputA+inputB)%inputC);
   8:         System.out.println((inputA%inputC+inputB%inputC)%inputC);
   9:         System.out.println((inputA*inputB)%inputC);
  10:         System.out.println((inputA%inputC*inputB%inputC)%inputC);
```

# 참고(Reference)

> [code.plus 코드플러스 알고리즘](https://code.plus/course/41)
