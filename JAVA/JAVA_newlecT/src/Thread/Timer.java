package Thread;

//Ÿ�̸Ӿ�����
//������� �� �ð� ���س��� ��ϴµ�, �����ϱ�!
public class Timer extends Thread {

	int clock;
	
	public Timer(int clock) {
		this.clock=clock;
	}
	public void run() {

		// ��� �ʸ� ǥ��
		while (true) {
			try {
				if(clock==0) {
					System.out.println("��PT�ð��� �������ϴ٢�");
					break;
				}
				showSec();
				sleep(500); //1000�� ������ ������ �帣�� �����ֱ�����
				
			} catch (InterruptedException e) {
				return;
				//e.printStackTrace();
				
			}
		}
		

	}

	
	// �޽��� ǥ��
	public void showSec() {
		
		if ((clock % 60) == 0) { //�и��� �˸�..
			System.out.println("��PT�ð� "+(clock/60)+ "�� ���ҽ��ϴ٢�");
		}
		if(clock==30) {
			System.out.println("��PT�ð� "+30+ "�� ���ҽ��ϴ٢�");
		}
		if(clock==10) {
			System.out.println("��PT�ð� "+10+ "�� ���ҽ��ϴ٢�");
		}
		if(clock<10) {
			System.out.println("��PT ����ð�"+clock+"��");	
		}

		clock--;
	}
}