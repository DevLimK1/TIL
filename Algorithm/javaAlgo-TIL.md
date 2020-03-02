## [목록]

- [버블 정렬](#버블-정렬)

- [빈도수 구하기](#빈도수-구하기) : 배열에 저장되어 있는 요소의 빈도수 구하기

- [16진수 -> 2진수 변환](#16진수-`-`>-2진수-변환)

- [성적 출력 프로그램](#성적-출력-프로그램) : 유효성검사有

- [빙고](#빙고) : 빙고판을 만들고 입력받은 숫자를 빙고판에서 지운다. (실행결과에서는 지우는 것 대신 0으로 변환) (2차원배열)

- [모든 정수들 한칸씩 옆으로 Shift하기](#모든-정수들-한칸씩-옆으로-Shift하기) : n개의 정수를 입력받아 순서대로 배열에 저장한다. 그런 다음 모든 정수들을 한칸씩 오른쪽으로 shift한다. 마지막 정수는 배열의 첫 칸으로 이동한다.

---

## [문법]

- char[] chArr, String[] strArr 등의 배열의 길이는 chArr.length; --> [버블 정렬](#버블-정렬)
- String str 문자열의 길이는 str.length() --> String은 클래스라서 str.length(); 호출 --> [버블 정렬](#버블-정렬)

---

## [알고리즘]

### <버블 정렬>

```java
public class BubbleSort {
	public static void main(String[] args) {
		int[] numArr=new int[10];
		System.out.print("정렬 전: ");
		for(int i=0;i<numArr.length;i++) {
			System.out.print((numArr[i]=(int)(Math.random()*10))+" "); //0~9까지 랜덤 수 저장
		}
		System.out.println();

		for(int i=0;i<numArr.length;i++) {
			boolean changed=false; //자리바꿈 발생했는지 체크
			for(int j=0;j<numArr.length-1-i;j++) {
				if(numArr[j]>numArr[j+1]) { //numArr[j]가 크면 교환
					int temp=numArr[j+1];
					numArr[j+1]=numArr[j];
					numArr[j]=temp;
					changed=true; //자리 바꿈이 일어났으니 true
				}
			} //end for j
			if (!changed) //자리바꿈이 일어나지 않았으면 더 이상 교환 일어나지 않을테니 반복문 빠져나간다.
				break;

			for(int k=0;k<numArr.length;k++)
				System.out.print(numArr[k]+" ");
			System.out.println();
		} //end for i
	}
}

실행결과:
정렬 전: 3 1 7 3 0 4 0 5 7 9   //사용자마다 다르게 출력됨
1 3 3 0 4 0 5 7 7 9
1 3 0 3 0 4 5 7 7 9
1 0 3 0 3 4 5 7 7 9
0 1 0 3 3 4 5 7 7 9
0 0 1 3 3 4 5 7 7 9

```

> (문법 체크 √ )
>
> - char[] chArr, String[] strArr 등의 배열의 길이는 chArr.length;
> - String str 문자열의 길이는 str.length() --> String은 클래스라서 str.length(); 호출

<!--자바의 정석 3판 p.201 참조-->

### <빈도수 구하기>

```java
public class ArrayEx11_빈도수구하기 {
	public static void main(String[] args) {
		int[] numArr =new int[10];
		int[] count=new int[10];

		for(int i=0;i<numArr.length;i++) {
			numArr[i]=(int)(Math.random()*10); //0~9의 임의의 수를 배열에 저장
			System.out.print(numArr[i]+" ");
		}
		System.out.println();

		for(int i=0;i<numArr.length;i++) {
			count[numArr[i]]++; //
		}

		for(int i=0;i<numArr.length;i++) {
			System.out.println(i+"의 개수: "+count[i]);
		}
	}
}

실행결과:
5 2 1 7 0 6 4 8 0 3
0의 개수: 2
1의 개수: 1
2의 개수: 1
3의 개수: 1
4의 개수: 1
5의 개수: 1
6의 개수: 1
7의 개수: 1
8의 개수: 1
9의 개수: 0
```

<!--자바의 정석 3판 p.204 참조-->

### <16진수 -> 2진수 변환>

```java
   1: public class ArrayEx13_radix16to2 {
   2: 	public static void main(String[] args) {
   3: 		char[] hex= {'C','A','F','E'}; //16진수 0~9 A~F 까지 있음
   4:
   5: 		String[] binary= {"0000","0001","0010","0011" //2진수로 0~15까지
   6: 				,"0100","0101","0110","0111"
   7: 				,"1000","1001","1010","1011"
   8: 				,"1100","1101","1110","1111"};
   9: 		String resultString="";
  10:
  11: 		for(int i=0;i<hex.length;i++) {
  12: 			if(hex[i]>='0'&& hex[i]<='9') {
  13: 				resultString += binary[hex[i]-'0']; // '8'-'0'의 결과는 8이다.
  14: 			}
  15: 			else { //A~F이면
  16: 				resultString+=binary[hex[i]-'A'+10]; //'C'-'A'의 결과는 2, +10하면 12(16진수로는 C)
  17: 			}
  18: 		} //end for i
  19: 		System.out.println("hex: "+new String(hex)); //hex:CAFE 출력
  20: 		System.out.println("binary: "+resultString);
  21:
  22: 	}
  23: }
  24:

실행결과:
hex: CAFE
binary: 1100101011111110
```

```java
16: resultString+=binary[hex[i]-'A'+10];
    ->resultString+= binary['C'-'A'+10]; // 'C'-'A'->67-65 -> 2
    ->resultString+= binary[2+10];
    ->resultString+= binary[12];
    ->resultString+= "1100";
```

<!--java 정석 3판 p.208 참고-->

> 참고(Reference)
>
> - 자바의 정석(3판)

### <성적 출력 프로그램>

```java
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		/*
		 * 간단한 성적 출력 프로그램(switch-case 사용) 국어 점수, 영어 점수, 수학 점수를 입력받아 평균 점수에 따른 학점 출력 ※각
		 * 점수는 범위 검사 할 것(0점보다 작을 수 없고 100보다 클 수 없음)
		 *
		 * 90 ~ 100점 -> A 80 ~ 89점 -> B 70 ~ 79점 -> C 60 ~ 69점 -> D 그 이하는 F
		 */
		Scanner scn = new Scanner(System.in);
		int kor = -1, eng = -1, math = -1, total = 0;
		double avg = 0.0f;

		boolean check; // 유효성 검사하기 위함
		String strInput;

		do {
			System.out.print("국어: ");
			strInput = scn.nextLine(); // 문자열 입력

			if (strInput.equals("")) { // 빈 문자열이면 다시 입력받아야 함
				System.out.println("입력값이 없습니다.");
				continue;
			}

			check = checkInput(strInput); // 입력값 유효성검사

			if (!check) { // 입력값이 숫자가 아니면
				continue;
			}

			kor = Integer.parseInt(strInput); // 숫자로 변환
			if (kor < 0 || 100 < kor)
				System.out.print("Error:성적범위(0~100)를 벗어났습니다.\n");
		} while (kor < 0 || 100 < kor);

		do {
			System.out.print("영어: ");
			strInput = scn.nextLine();

			if (strInput.equals("")) { // 빈 문자열이면 다시 입력받아야 함
				System.out.println("입력값이 없습니다.");
				continue;
			}

			check = checkInput(strInput); // 입력값 유효성검사

			if (!check) { // 입력값이 숫자가 아니면
				continue;
			}

			eng = Integer.parseInt(strInput);
			if (eng < 0 || 100 < eng)
				System.out.print("Error:성적범위(0~100)를 벗어났습니다.\n");
		} while (eng < 0 || 100 < eng);

		do {
			System.out.print("수학: ");
			strInput = scn.nextLine();

			if (strInput.equals("")) { // 빈 문자열이면 다시 입력받아야 함
				System.out.println("입력값이 없습니다.");
				continue;
			}

			check = checkInput(strInput); // 입력값 유효성검사

			if (!check) { // 입력값이 숫자가 아니면
				continue;
			}

			math = Integer.parseInt(strInput);
			if (math < 0 || 100 < math)
				System.out.print("Error:성적범위(0~100)를 벗어났습니다.\n");
		} while (math < 0 || 100 < math);

		total = kor + eng + math;
		avg = total / (float) 3;
		System.out.printf("총점 : %d 점\n", total);
		System.out.printf("평균 : %.2f 점 \n", avg);

		int menu = (int) avg / 10;
		switch (menu) {
		case 10:
		case 9:
			System.out.print("학점 : A");
			break;
		case 8:
			System.out.print("학점 : B");
			break;
		case 7:
			System.out.print("학점 : C");
			break;
		case 6:
			System.out.print("학점 : D");
			break;
		default:
			System.out.print("학점 : F");

		}
	}

	private static boolean checkInput(String strInput) { //유효성 검사 메소드
		boolean check = true; //올바른 입력값이면 true

		for (int i = 0; i < strInput.length(); i++) {
			char ch = strInput.charAt(i); // 문자하나 추출
			if (ch < '0' || '9' < ch) { // 입력값이 숫자가 아니면 false
				System.out.println("0~100 숫자만 입력해주세요.");
				check = false;
				break;
			}
		}
		return check;
	}
}

실행결과:
국어: 77
영어: 85
수학: 88
총점 : 250 점
평균 : 83.33 점
학점 : B
```

### <빙고>

: 빙고판을 만들고 입력받은 숫자를 빙고판에서 지운다. (결과에서는 지우는 것 대신 0으로 변환)

```java
	final int SIZE = 5; // 빙고판 사이즈
		int x = 0, y = 0, num = 0;

		int[][] bingo = new int[SIZE][SIZE];
		Scanner scanner = new Scanner(System.in);

		// 배열의 모든 요소를 1부터 SIZE*SIZE까지의 숫자로 초기화
		// 1 2 3 4 5
		// 6 7 8 9 10
		// 11 12 13 14 15
		// 16 17 18 19 20
		// 21 22 23 24 25
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				bingo[i][j] = i * SIZE + j + 1;
			} // end for j
		} // end for i

		// 배열에 저장된 값을 뒤섞는다.
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				x = (int) (Math.random() * SIZE); //0~SIZE index 랜덤으로 저장
				y = (int) (Math.random() * SIZE); //0~SIZE index 랜덤으로 저장

				// bingo[i][j]와 임의로 선택된 값(bingo[x][y])을 바꾼다.
				int tmp = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = tmp;
			}
		}

		do {
			for (int i = 0; i < SIZE; i++) {  //빙고판 출력
				for (int j = 0; j < SIZE; j++) {
					System.out.printf("%2d ", bingo[i][j]);
				}
				System.out.println();
			} // end for i
			System.out.println();

			System.out.printf("1~%d의 숫자를 입력하세요.(종료:0)>", SIZE * SIZE);
			String tmpString = scanner.nextLine();// 화면 입력 내용
			num = Integer.parseInt(tmpString); // 숫자로 변환

			// 입력받은 숫자와 같은 숫자가 저장된 요소를 찾아서 0을 저장
			outer: for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (bingo[i][j] == num) {
						bingo[i][j] = 0;
						break outer; //2중 반복문을 벗어남
					} // end if bingo[i][j]==num

				} // end for j
			} // end for i

		} while (num!=0);

실행결과:
 8 12  3 23 13
15 24 21 19  6
 5 11 14 10  7
 9 17 16  2 18
 1 22  4 20 25

1~25의 숫자를 입력하세요.(종료:0)>8
 0 12  3 23 13
15 24 21 19  6
 5 11 14 10  7
 9 17 16  2 18
 1 22  4 20 25

1~25의 숫자를 입력하세요.(종료:0)>3
 0 12  0 23 13
15 24 21 19  6
 5 11 14 10  7
 9 17 16  2 18
 1 22  4 20 25
```

> 참고(Reference)
>
> - 자바의 정석(3판)

### <모든 정수들 한칸씩 옆으로 Shift하기>

: n개의 정수를 입력받아 순서대로 배열에 저장한다.  
그런 다음 모든 정수들을 한칸씩 오른쪽으로 shift한다.  
마지막 정수는 배열의 첫 칸으로 이동한다.

```java
   1: 	Scanner scanner = new Scanner(System.in);
   2: 		int size = scanner.nextInt(); // n개의 정수 입력받기
   3: 		int[] arr = new int[size];
   4:
   5: 		for (int i = 0; i < arr.length; i++)
   6: 			arr[i] = scanner.nextInt();
   7:
   8: 		scanner.close();
   9:
  10: 		int tmp = arr[size - 1]; //맨 마지막 index의 배열 요소를 임시변수에 저장
  11: 		for (int i = size - 2; i >= 0; i--)
  12: 			arr[i + 1] = arr[i]; //오른쪽으로 한칸씩 배열 요소 저장
  13: 		arr[0]=tmp; //배열 첫 칸에 맨 마지막 index의 배열 요소를 저장
  14:
  15: 		for (int i = 0; i < arr.length; i++)
  16: 			System.out.print(arr[i]+" ");

실행결과1)
10
1 2 3 4 5 6 7 8 9 10
10 1 2 3 4 5 6 7 8 9

실행결과2)
5
4 29 10 22 1
1 4 29 10 22
```

> 10`~` 13 : 코드의 핵심!  
> 맨 마지막 배열 요소를 임시 변수에 저장한 후, 나머지 배열 요소를 모두 오른쪽으로 이동시킨 후에
> 임시변수에 저장했던 요소를 맨 첫 칸에 저장시킨다.
