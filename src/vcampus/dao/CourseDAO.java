package vcampus.dao;

import java.util.ArrayList;

import vcampus.vo.Course;

public class CourseDAO {
	//选课
	public boolean selectCourse(String username, int courseUID) {
		boolean selectSucceedFlag = false;
		//System.out.println(username + " select courseUID " + courseUID);
		return selectSucceedFlag;
	}
	
	//退课
	public boolean dropCourse(String username, int courseUID) {
		boolean dropSucceedFlag = false;
		//System.out.println(username + "drop courseUID " + courseUID);
		return dropSucceedFlag;
	}
	
	//查看一个人选到的所有课
	
	public ArrayList<Course> getSelectedCourses(String username){
		ArrayList<Course> courseList = new ArrayList<Course>();
		Course c1 = new Course(1, "查看个人选课", "rgl", Course.WEEKDAY.MON,
				Course.COURSETIME.MORNING12, 4,"301");
		Course c2 = new Course(2, "高数", "张", Course.WEEKDAY.TUE, 
				Course.COURSETIME.AFTERNOON12, 3,"302");
		courseList.add(c1);
		courseList.add(c2);
		
		return courseList;
	}
	
	//获取所有的课
	//点击左侧curriculum button
	public ArrayList<Course> getAllCourses(){
		ArrayList<Course> courseList = new ArrayList<Course>();
		Course c1 = new Course(1, "计算机组成", "rgl", Course.WEEKDAY.MON,
				Course.COURSETIME.MORNING12, 4,"301");
		Course c2 = new Course(2, "高数", "张", Course.WEEKDAY.TUE, 
				Course.COURSETIME.AFTERNOON12, 3,"302");
		courseList.add(c1);
		courseList.add(c2);
		
		return courseList;
	}
	
	//查看是否选课 
	public boolean checkCourseSelected(String username, int uid) {
		boolean courseSelectedFlag = false;
		if(username.equals("09016321") && uid == 1) {
			courseSelectedFlag = true;
		}
		return courseSelectedFlag;
	}
}
