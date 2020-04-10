
package ex01.basic;

import java.sql.SQLException;
import java.util.Scanner;

import ex01.basic.entity.Member;
import ex01.basic.entity.Notice;
import ex01.basic.service.MemberService;
import ex01.basic.service.NoticeService;

//사용자가 입력한 회원 한명의 정보를 가지고 온 것
public class Program {

	public static void main(String[] args) throws SQLException {
		//회원 이름을 입력창이 뜨고 회원 이름이 입력된게 뜨게 한다.
		
		//껍데기 ================================================
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("title 입력: ");
		String title=scanner.nextLine();

		//================================================
		
		//서비스==========================================
		NoticeService service=new NoticeService();
		Notice[] notice= service.getMemberById(title);
		
		for(int i=0;i<notice.length;i++) {
			if(notice[i]!=null)
				System.out.println(notice[i]);
		}
		
	}

}

//package ex01.basic;
//
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import ex01.basic.entity.Member;
//import ex01.basic.service.MemberService;
//
//public class Program {
//
//	public static void main(String[] args) throws SQLException {
//	//회원 이름을 입력창이 뜨고 회원 이름이 입력된게 뜨게 한다.
//		
//		//껍데기 ================================================
//		Scanner scanner=new Scanner(System.in);
//		
//		System.out.print("id 입력: ");
//		String id=scanner.nextLine();
//
//		//================================================
//		
//		//서비스==========================================
//		MemberService service=new MemberService();
//		Member member= service.getMemberById(id);
//		
//		System.out.println(member);
//
//	}
//
//}