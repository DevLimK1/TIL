package ex01.basic;

import java.sql.SQLException;
import java.util.Scanner;

import ex01.basic.entity.Member;
import ex01.basic.service.MemberService;

public class Program {

	public static void main(String[] args) throws SQLException {
	//회원 이름을 입력창이 뜨고 회원 이름이 입력된게 뜨게 한다.
		
		//껍데기 ================================================
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("id 입력: ");
		String id=scanner.nextLine();

		//================================================
		
		//서비스==========================================
		MemberService service=new MemberService();
		Member member= service.getMemberById(id);
		
		System.out.println(member);

	}

}