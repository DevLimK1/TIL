package Thread;

import Main.Music;

public class exerDoReps extends Thread {
	int reps; // reps까지
	int num = 0; // 반복횟수

	public exerDoReps(int reps) { // 반복횟수 입력받는 생성자
		this.reps = reps;
	}

	public void run() {

		// 계속 횟수를 표시

		if (reps == 11) {
			Music gymhana = new Music("하나 열 제대로그만.mp3", true);
			gymhana.start();
			for (int i = 0; i < reps; i++) {
				try {
					showCount();
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} // ~for
			gymhana.close();
		} // ~ief reps==11
		else {
			Music last = new Music("오늘은 여기서 마무리할게요 수고하셨습니다.mp3", true);
			last.start();
			for (int i = 0; i < reps; i++) {
				try {
					showLast();
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} // ~for
			last.close();
		} // ~ief reps==1
	}

public void showLast() {
	System.out.println("오늘은 여기서 마무리할게요~");
	System.out.println("수고하셨습니다~");
}

	public void showCount() {
		++num;

		if (num == 1) {
			System.out.println("\"하나\"");
		} else if (num == 2) {
			System.out.println("\"둘\"");
		} else if (num == 3) {
			System.out.println("\"셋\"");
		} else if (num == 4) {
			System.out.println("\"넷\"");
		} else if (num == 5) {
			System.out.println("\"다섯\"");
		} else if (num == 6) {
			System.out.println("\"여섯\"");
		} else if (num == 7) {
			System.out.println("\"일곱\"");
		} else if (num == 8) {
			System.out.println("\"여덟\"");
		} else if (num == 9) {
			System.out.println("\"아홉\"");
		} else if (num == 10) {
			System.out.println("\"열\"");
		} else {
			System.out.println("그만~");
		}

	}
}
