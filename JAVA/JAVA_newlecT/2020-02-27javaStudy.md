메뉴를 만들어야하면 if문이 아닌 Switch 문을 떠올리자

<자바의 정석> p.149 포스팅하기


```java
Random rand = new Random();//
rand.nextInt(5) // 0~4까지 랜덤

try {
    Thread.sleep(1000); //1초쉬고
} catch (InterruptedException e) {
    e.printStackTrace();
}
//1부터 width까지니깐
ox=rand.nextInt(width)+1;
oy=rand.nextInt(height)+1;
```

### <이름 5명 입력받고, 5명 이름 랜덤하게 출력>

```java
//이름 5명 쓰고, 랜덤하게 출력되는 코드소스
		Scanner scanner=new Scanner(System.in);
		Random random=new Random();
		
		String[] nameArr=new String[5];
		String[] randNameArr=new String[5];

		String nameString;
		int index=0;
		
		for(int i=0;i<5;i++) { //이름 입력받음
			nameString=scanner.next();
			nameArr[i]=nameString;
		}
		
		for(int i=0;i<5;i++) { //랜덤으로 이름 출력
			index=random.nextInt(5); //랜덤 0~4
			randNameArr[i]=nameArr[index]; //배열에 랜덤인덱스 이름 대입
			for(int j=0;j<i;j++) { //중복검사
				if(randNameArr[i].equals(randNameArr[j])) {
					i--;
					break;
				}
			}
		}

		for(int i=0;i<5;i++)
			System.out.println(randNameArr[i]);

```

### <로또 번호 중복 제거하고 출력하기>

```java
for (int i = 0; i < 6; i++) {
			lottos[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) { // 중복 제거
				if (lottos[i] == lottos[j]) {
					i--;
					break;
				}
			}
			System.out.println(lottos[i]);
		}
 
```

