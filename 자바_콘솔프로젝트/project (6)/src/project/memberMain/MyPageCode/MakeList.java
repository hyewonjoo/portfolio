package project.memberMain.MyPageCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import project.login.User;

public class MakeList {
	
	private static String userId;
	private static ArrayList<User> userList;
	
	public MakeList(String userId) {
		
		this.userId = userId;
		this.userList = new ArrayList<User>();
	}



	public String[] infoList() {
		
		String path = String.format("%s\\info.txt",userId);	
		
		String[] temp = new String[9];
		try {
			BufferedReader reader  //TODO 상대경로로 바꿀 것!!
				= new BufferedReader(new FileReader("data\\마이페이지\\" + path));
			
			String info = reader.readLine();
			temp =  info.split("■");
			//System.out.println(Arrays.toString(temp));
			reader.close();
			
		} catch (Exception e) {
			System.out.println("UserInfo.main");
			e.printStackTrace();
		}
		return temp;
	}//infolist
	
	
	
	public void saveList(String[] temp) { 
		String changedInfo = temp[0] + "■" 
							+ temp[1] + "■"
							+ temp[2] + "■"
							+ temp[3] + "■"
							+ temp[4] + "■"
							+ temp[5] + "■"
							+ temp[6] + "■"
							+ temp[7] + "■"
							+ temp[8] ;
		
		String path = String.format("%s\\info.txt",userId);	
		
		
		try {
		
			File file = new File("data\\마이페이지\\" + path);
			file.delete();
			
			BufferedWriter writer 
			= new BufferedWriter(new FileWriter("data\\마이페이지\\" + path));
			
			writer.write(changedInfo);
			writer.close();
			
			
			
		} catch (Exception e) {
			System.out.println("MyPage.saveInfo");
			e.printStackTrace();
		}
		
	
	} //save
	
	
	public static void makeReviewArray(ArrayList<UserReview> list, String userId) {
		
		String path = String.format("data\\마이페이지\\%s",userId);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path + "\\reviews.txt"));
			
			String line = null;
			
			while((line = reader.readLine())!= null) {
				
				String[] temp = line.split("■");
				String[] ctemp = temp[0].split("-");
				
				UserReview reviews 
					= new UserReview(ctemp[0], ctemp[1], ctemp[2], temp[1], temp[2], temp[3]);
				
				list.add(reviews);
				
			}
			
			
		} catch (Exception e) {
			System.out.println("MakeList.makeReviewArray");
			e.printStackTrace();
		}
		
		
	}//makeReviewArray
	
	public static ArrayList<User> makeUserList(ArrayList<User> userlist) {
		
		try {
			
			
			BufferedReader reader = new BufferedReader(new FileReader("data\\마이페이지\\user.txt")); 		
			
			
			String line = null;
			
			while((line = reader.readLine()) != null){
								
				String temp[] = line.split("■"); 
				
				userList.add(new User(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]));
				
				
			}	
			reader.close();
			return userList;
			
			
		} catch (Exception e) {
			
			System.out.println("MakeList.makeUserList");
			e.printStackTrace();
		}
		return null;
		
	} //makeUserList

	public static void changeUserList(String changedInfo) {
		
		makeUserList(userList);
		
		
		StringBuilder loginInfo = new StringBuilder("");
		
		for(User u : userList) {
			
			if(u.getId().equals(userId)){
				
				loginInfo.append(changedInfo + "\n");
				
			} else {
				
				loginInfo.append(String.format("%s■%s■%s■%s■%s■%s■%s■%s■%s\n"
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
			writer.write(loginInfo.toString());
			writer.close();		
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}//changeUserList
	
}//class
