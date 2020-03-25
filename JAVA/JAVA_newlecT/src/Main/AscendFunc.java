package Main;

public class AscendFunc {

	public static void lineUp(int temp[],int nCount) {//오름차순메소드
		int nTemp=0; //임시 저장
		//nCount:배열 몇개요소가 있는지
		
		for(int i=0;i<nCount-1;i++) {
			for(int j=i+1;j<nCount;j++) {
				if(temp[i]>temp[j]) {
					nTemp=temp[i];
					temp[i]=temp[j];
					temp[j]=nTemp;
				}
			}
		}
		
	} //~void lineUp
}
