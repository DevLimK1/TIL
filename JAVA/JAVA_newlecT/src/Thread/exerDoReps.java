package Thread;

import Main.Music;

public class exerDoReps extends Thread {
	int reps; // reps����
	int num = 0; // �ݺ�Ƚ��

	public exerDoReps(int reps) { // �ݺ�Ƚ�� �Է¹޴� ������
		this.reps = reps;
	}

	public void run() {

		// ��� Ƚ���� ǥ��

		if (reps == 11) {
			Music gymhana = new Music("�ϳ� �� ����α׸�.mp3", true);
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
			Music last = new Music("������ ���⼭ �������ҰԿ� �����ϼ̽��ϴ�.mp3", true);
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
	System.out.println("������ ���⼭ �������ҰԿ�~");
	System.out.println("�����ϼ̽��ϴ�~");
}

	public void showCount() {
		++num;

		if (num == 1) {
			System.out.println("\"�ϳ�\"");
		} else if (num == 2) {
			System.out.println("\"��\"");
		} else if (num == 3) {
			System.out.println("\"��\"");
		} else if (num == 4) {
			System.out.println("\"��\"");
		} else if (num == 5) {
			System.out.println("\"�ټ�\"");
		} else if (num == 6) {
			System.out.println("\"����\"");
		} else if (num == 7) {
			System.out.println("\"�ϰ�\"");
		} else if (num == 8) {
			System.out.println("\"����\"");
		} else if (num == 9) {
			System.out.println("\"��ȩ\"");
		} else if (num == 10) {
			System.out.println("\"��\"");
		} else {
			System.out.println("�׸�~");
		}

	}
}
