package vcampus.vo;

import java.io.Serializable;
import java.util.Date;

public class PersonInfo implements Serializable{
	private String username;//09017314
	private String name;//王旭明
	private int age;//21
	public enum GENDER{
		MAlE, FEMALE, OTHER;
	}
	private GENDER gender;//MALE
	public enum SCHOOL{
		计算机, 材料, 信息, 电子, 土木, 交通, 自动化;
	}
	private SCHOOL school;//计算机
	//Date class useage:
	//Date brithday = new Date(1998, 8, 18);
	//birthday.getYear();.....
	private Date birthday; //1998 8 18
	private String City;// 江苏南京
	private String loc;
	
	public static void main(String[] args) {
		Date date = new Date();
		date.setDate(21);
		date.setYear(1997);
		date.setMonth(8);
		System.out.println(date.getYear() + " " + date.getMonth() +" "+date.getDate());
		
	}

	

	public PersonInfo(String username, String name, int age, GENDER gender, SCHOOL school, Date birthday, String city,
			String loc) {
		super();
		this.username = username;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.school = school;
		this.birthday = birthday;
		City = city;
		this.loc = loc;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public SCHOOL getSchool() {
		return school;
	}

	public void setSchool(SCHOOL school) {
		this.school = school;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}



	public String getLoc() {
		return loc;
	}



	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
