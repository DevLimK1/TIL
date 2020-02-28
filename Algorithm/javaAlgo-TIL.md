

---

##  [문법]

- char[] chArr, String[] strArr 등의 배열의 길이는 chArr.length; 
- String str 문자열의 길이는 str.length()  --> String은 클래스라서 str.length(); 호출



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