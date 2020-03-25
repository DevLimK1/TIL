package Thread;

//타이머쓰레드
//운동진행할 때 시간 정해놓고 운동하는데, 감소하기!
public class Timer extends Thread {

	int clock;
	
	public Timer(int clock) {
		this.clock=clock;
	}
	public void run() {

		// 계속 초를 표시
		while (true) {
			try {
				if(clock==0) {
					System.out.println("♨PT시간이 끝났습니다♨");
					break;
				}
				showSec();
				sleep(500); //1000이 맞으니 빠르게 흐르게 보여주기위해
				
			} catch (InterruptedException e) {
				return;
				//e.printStackTrace();
				
			}
		}
		

	}

	
	// 메시지 표시
	public void showSec() {
		
		if ((clock % 60) == 0) { //분마다 알림..
			System.out.println("♨PT시간 "+(clock/60)+ "분 남았습니다♨");
		}
		if(clock==30) {
			System.out.println("♨PT시간 "+30+ "초 남았습니다♨");
		}
		if(clock==10) {
			System.out.println("♨PT시간 "+10+ "초 남았습니다♨");
		}
		if(clock<10) {
			System.out.println("♨PT 종료시간"+clock+"초");	
		}

		clock--;
	}
}