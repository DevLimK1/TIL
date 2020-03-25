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
		player=new Player(bis); //�Է� ��Ʈ���� �޾Ƽ� ���� ã�� ����� ��ġ�� ���ڵ��� MP3 ������ ����ϴ� ��
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
				fis=new FileInputStream(file); //FileInputStream Ŭ������ 
				//InputStream Ŭ������ ��ӹ��� �ļ� Ŭ������ �ϵ� ��ũ�� �����ϴ� ���Ϸκ��� 
				//����Ʈ ������ �Է��� �޴� Ŭ�����̴�. 
				//�� Ŭ������ ��� ������ ���� ������ �����ϴ� ���, �� ��Ʈ���� �����ϴ� Ŭ�����̴�.
				bis=new BufferedInputStream(fis);
				//���ϴ� �ڷḦ 1����Ʈ ������ �д� read() �޼ҵ带 �����ϸ� �ý��� ���������� 
				//���۸� �غ��ϰ� �� ���۸� �̿��Ͽ� ������ ���Ϸκ��� ������ ũ�⸸ŭ �Ѳ����� ���� �����͸� �����´�.
				player=new Player(bis);
			}while(isLoop);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
