package vcampus.dao;

import java.util.ArrayList;

import vcampus.vo.Course;

public class CourseDAO {
	//选课
	public boolean selectCourse(String username, int courseUID) {
		boolean selectSucceedFlag = false;
		
		return selectSucceedFlag;
	}
	//退课
	public boolean dropCourse(String username, int courseUID) {
		boolean dropSucceedFlag = false;
		
		return dropSucceedFlag;
	}
	//查看一个人选到的所有课
	public ArrayList<Course> getSelectedCourses(String username){
		ArrayList<Course> courseList = null;
		
		return courseList;
	}
	
	//获取所有的课
	public ArrayList<Course> getAllCourses(){
		ArrayList<Course> courseList = null;
		return courseList;
	}
	
}
