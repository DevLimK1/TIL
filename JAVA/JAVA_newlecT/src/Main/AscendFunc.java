package Main;

public class AscendFunc {

	public static void lineUp(int temp[],int nCount) {//���������޼ҵ�
		int nTemp=0; //�ӽ� ����
		//nCount:�迭 ���Ұ� �ִ���
		
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
