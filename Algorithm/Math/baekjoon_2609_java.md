# [백준 2609번 문제- 최대공약수와 최소공배수](https://www.acmicpc.net/problem/2609)

두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램

# 최대공약수

- 최대공약수는 줄여서 GCD라고 쓴다.
- 두 수 A와 B의 최대공약수 G는 A와 B의 공통된 약수 중에서 가장 큰 정수
- 최대공약수를 구하는 가장 쉬운 방법은 2부터 min(A,B)까지 모든 정수로 나누어 보는 방법
- 최대공약수가 1인 두 수를 서로소(Coprime)라고 한다.

```JAVA
    int GCD=1;
    for(int i=2; i<=min(a,b);i++){
        if(A%i==0&&B%i==0){
            GCD=i;
        }
    }


> N=max(A,B) 라면,
> 시간 복잡도는 O(N) 이다.
```

위 보다 빠른 방법은 **유클리드 호제법**을 사용

- A를 B로 나눈 나머지를 r이라고 했을 때
  GCD(A,B)=GCD(B,r) 과 같음
- r이 0이면 그 때 B가 최대 공약수임
- GCD(24,16)=GCD(16,8)=GCD(8,0)=8
- 시간복잡도는 O(logN)

# 최소공배수

- 최소공배수는 줄여서 LCM이라고 쓴다.
- 두 수의 최소공배수는 두 수의 공통된 배수 중에서 가장 작은 정수
- 최소공배수는 GCD를 응용해서 구할 수 있음
- G=GCD(A,B)라면, <br>
  AxB = GCD x LCM 이기 때문에 <br>
  LCM= AxB/G 라는 식을 이용

# 구현 소스(JAVA)

> 예제 입력 1<br>
> 24 18 <br>
> 예제 출력1<br>
> 6 <br>
> 72 <br>

<재귀함수를 사용해서 구현한 유클리드 호제법>

```JAVA
   1:   public static int gcd(int x,int y){ //최대공약수 메소드
   2:         if(y==0)
   3:             return x;
   4:         else
   5:             return gcd(y,x%y);//재귀함수
   6:     }

   7:     public static void main(String[] args) {
   8:         Scanner sc=new Scanner(System.in);
   9:         int inputA=sc.nextInt();
  10:         int inputB=sc.nextInt();
  11:         int GCD,LCM;
  12:
  13:         System.out.println(GCD=gcd(inputA,inputB)); //최대공약수
  14:         System.out.println(LCM=(inputA*inputB)/GCD); //최소공배수
  15:
  16:     }
```

<재귀함수를 사용하지 않고 구현한 유클리드 호제법>

```JAVA
   1:   public static int gcd(int x,int y){
   2:         while(y!=0){
   3:             int r=x%y;
   4:             x=y;
   5:             y=r;
   6:         }
   7:         return x;
   8:     }
```

# 참고(Reference)

> [code.plus 코드플러스 알고리즘](https://code.plus/course/41)
