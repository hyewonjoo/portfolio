package project.memberMain.MyPageCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import project.login.User;
import project.login.main;

public class DeleteID { //탈퇴하기 클래스
	
	 private static String userId;
	 private static ArrayList<User> userList = new ArrayList<User>();
	 private static Scanner scan;
	 

	public DeleteID(String userId) {
		
		this.userId = userId;	
		this.scan = new Scanner(System.in);
		
		
	}
	
	
	public static void quit() {
		
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("                회원 탈퇴하기");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(" ⦿  정말 탈퇴하시겠습니까?");
		System.out.println(" 1. 탈퇴하기");
		System.out.println(" 2. 이전 페이지로");
		System.out.print  (" ⦿  선택 : ");
		String input = scan.nextLine();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		boolean loop = true; 
		
		while (loop == true) {
			
			if(input.equals("1")) {
				
				
				delete();
				loop = false;
				
				
				
			} else if (input.equals("2")) {
				
				loop = false;
				
				System.out.println();
				System.out.println(" **이전 페이지로 돌아갑니다**");
				
				MyPageMain.myPageMain(userId);
				scan.close();
				
			} else {
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println(" ** 1과 2 중에 입력하세요 ** ");
				System.out.print  (" ⦿  선택 : ");
				input = scan.nextLine();
				loop = true;
			}
			
		
			
		}//while
		
		
		
		
	}//quit
	
	
	
	private static void delete() {
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(" **회원탈퇴를 진행합니다** ");
		
		System.out.println();
		System.out.print(" ⦿  비밀번호를 입력하세요 : ");
		String password = scan.nextLine();
		
		System.out.println();
		System.out.print(" ⦿  기입하신 본인확인 질문을 입력하세요 (졸업초등학교) : ");
		String school = scan.nextLine();
		
		
		
//		new MakeList(userId).makeUserList(userList); //arraylist 받아오기
		
		userList = MakeList.makeUserList(userList);
		
		int index = 0;
		
		for(User u : userList) {	
			if(u.getPassword().equals(password) && u.getSchool().equals(school)) {
				
				index ++;
		
			}
		} //for
		
		
		if(index == 1) {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println(" ⦿  아이디를 삭제합니다.");
			System.out.println(" ⦿  엔터를 누르시면 아이디 삭제 후 로그인 화면으로 돌아갑니다.");
			
			scan.nextLine();
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			
			File infofile = new File(String.format("data\\마이페이지\\%s\\info.txt", userId));
			infofile.delete();
			
			File reviewfile = new File(String.format("data\\마이페이지\\%s\\reviews.txt", userId));
			reviewfile.delete();
			
			File followfile = new File(String.format("data\\마이페이지\\%s\\following.txt", userId));
			if(followfile.exists()) {
				followfile.delete();
				
			}
			
			
			File userFolder = new File(String.format("data\\마이페이지\\%s", userId));
			userFolder.delete();
			
			deleteUserFile(); //회원명단에서 지우기
			
			
			//TODO 로그인화면 호출	
			main.loginMenu();
			
			
		} else {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println(" 일치하는 정보가 없습니다! 다시확인해주세요");
			System.out.println(" 엔터를 누르시면 탈퇴하기 화면으로 돌아갑니다.");
			
			
			scan.nextLine();			
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			quit();
			scan.close();
		}
				

	}		
		



	private static void deleteUserFile() {
		
//		ArrayList<UserReview> list = new ArrayList<UserReview>();
//		MakeList.makeReviewArray(list, userId);
		
		StringBuilder users = new StringBuilder("");
		
		
		for(User u : userList) {
			
			if(u.getId().equals(userId)) {
				users.append("");
			
			} else {
				users.append(String.format("%s■%s■%s■%s■%s■%s■%s■%s■%s\n"
												, u.getId()
												, u.getPassword()
												, u.getName()
												, u.getBirth()
												, u.getGender()
												, u.getTel()
												, u.getFollow()
												, u.getGenre()
												, u.getSchool()));
				
			}
		}//for
		
		
		File userFile = new File("data\\마이페이지\\user.txt");
		userFile.delete();
		
		try {
		
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\마이페이지\\user.txt"));
			writer.write(users.toString());
			writer.close();		
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	} //deleteUSerFile
	
	
	
	
	

	
	 
	 
	

}

