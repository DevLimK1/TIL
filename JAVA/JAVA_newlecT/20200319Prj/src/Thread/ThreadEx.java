package Thread;

public class ThreadEx {
	public static void main(String[] args) {
		ThreadEx_1 th1=new ThreadEx_1();
		ThreadEx_2 th2=new ThreadEx_2();
		
		th2.setPriority(7);
		
		System.out.println("th1 priority: "+th1.getPriority());
		System.out.println("th2 priority: "+th2.getPriority());
		
		th1.start();
		th2.start();
	}
}

class ThreadEx_1 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
			for(int x=0;x<10000000;x++);
		}
	}
}

class ThreadEx_2 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
			for(int x=0;x<10000000;x++);
			
		}
	}
}