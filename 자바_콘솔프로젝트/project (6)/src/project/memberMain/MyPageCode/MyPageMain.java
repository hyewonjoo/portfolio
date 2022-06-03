package project.memberMain.MyPageCode;

import java.util.Calendar;
import java.util.Scanner;

import project.login.userLogin;

public class MyPageMain {
	
	private static String userId;
	
	
	public MyPageMain(String userId) {

		this.userId = userId; // 일단은 이렇게 설정...
	}


	public static void  myPageMain(String userId) {
		
		Calendar c = Calendar.getInstance();
		
			
		MyInfomation myInfomation = new MyInfomation(userId);
		MyGenre myGenre = new MyGenre(userId);
		
		boolean loop = true;
		
		while(loop) {
			
			System.out.println();
			Title.mypageTitle();
			
			Scanner scan = new Scanner(System.in);
			
			String input = scan.nextLine();	
			
			
			if(input.equals("1")) {		
				myInfomation.myInfo();
				//scan.close();
				
			} else if (input.equals("2")) {
			
				myGenre.favGenre();
				//scan.close();
				
			} else if (input.equals("3")) {   	
				//탈퇴
				new DeleteID(userId).quit();
				
			} else if(input.equals("4")) {
				
				//회원메뉴로 나가기
				new userLogin().LoginCategory(userId);

				
			} 
		
		}
		
		
		
	}
	
	
}
