package vcampus.dao;

import java.util.ArrayList;

import vcampus.vo.Course;

public class CourseDAO {
	//ѡ��
	public boolean selectCourse(String username, int courseUID) {
		boolean selectSucceedFlag = false;
		
		return selectSucceedFlag;
	}
	//�˿�
	public boolean dropCourse(String username, int courseUID) {
		boolean dropSucceedFlag = false;
		
		return dropSucceedFlag;
	}
	//�鿴һ����ѡ�������п�
	public ArrayList<Course> getSelectedCourses(String username){
		ArrayList<Course> courseList = null;
		
		return courseList;
	}
	
	//��ȡ���еĿ�
	public ArrayList<Course> getAllCourses(){
		ArrayList<Course> courseList = null;
		return courseList;
	}
	
}
