package vcampus.dao;

import java.sql.Date;

import vcampus.vo.PersonInfo;
import vcampus.vo.User;

public class InfoDAO {
	//通过username查找一个用户的详细资料
	//User 中 username与PersonInfo中username都是学号，唯一确定一个用户身份
	public PersonInfo getPersonInfo(String username) {
		Date birthday = new Date(1997, 8, 18);
		PersonInfo personInfo = new PersonInfo(username, 
				"张三", 19, PersonInfo.GENDER.MAlE ,PersonInfo.SCHOOL.交通 
				,birthday , "江苏南京","here");
		return personInfo;
	}
	
	
}
