package Main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop=isLoop;
			file = new File(MainStory.class.getResource("../Music/"+name).toURI());
		fis=new FileInputStream(file);
		bis=new BufferedInputStream(fis);
		player=new Player(bis); //입력 스트림을 받아서 직접 찾은 오디오 장치에 디코딩한 MP3 내용을 출력하는 것
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		if(player==null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {
		isLoop=false;

		player.close();
		this.interrupt();
	}
	
	
	public void run() {
		try {
			do {
				player.play();
				fis=new FileInputStream(file); //FileInputStream 클래스는 
				//InputStream 클래스를 상속받은 후손 클래스로 하드 디스크상에 존재하는 파일로부터 
				//바이트 단위의 입력을 받는 클래스이다. 
				//이 클래스는 출발 지점과 도착 지점을 연결하는 통로, 즉 스트림을 생성하는 클래스이다.
				bis=new BufferedInputStream(fis);
				//원하는 자료를 1바이트 단위로 읽는 read() 메소드를 수행하면 시스템 내부적으로 
				//버퍼를 준비하고 이 버퍼를 이용하여 지정된 파일로부터 버퍼의 크기만큼 한꺼번에 많은 데이터를 가져온다.
				player=new Player(bis);
			}while(isLoop);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
