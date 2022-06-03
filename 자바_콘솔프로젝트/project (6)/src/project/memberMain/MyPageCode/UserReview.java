package project.memberMain.MyPageCode;
public class UserReview {
	private int year;
	private int month;
	private int date;
	private String type;
	private String title;
	private String review;
	
	public UserReview(String year, String month, String date, String type, String title, String review) {
		
		this.year = Integer.parseInt(year);
		this.month = Integer.parseInt(month);
		this.date = Integer.parseInt(date);
		this.type = type;
		this.title = title;
		this.review = review;
	}
	
	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	
	
	
}
