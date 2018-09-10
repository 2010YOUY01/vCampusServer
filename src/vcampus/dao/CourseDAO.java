package vcampus.dao;

import java.util.ArrayList;

import vcampus.vo.Course;

public class CourseDAO {
	//ѡ��
	public boolean selectCourse(String username, int courseUID) {
		boolean selectSucceedFlag = false;
		//System.out.println(username + " select courseUID " + courseUID);
		return selectSucceedFlag;
	}
	
	//�˿�
	public boolean dropCourse(String username, int courseUID) {
		boolean dropSucceedFlag = false;
		//System.out.println(username + "drop courseUID " + courseUID);
		return dropSucceedFlag;
	}
	
	//�鿴һ����ѡ�������п�
	
	public ArrayList<Course> getSelectedCourses(String username){
		ArrayList<Course> courseList = new ArrayList<Course>();
		Course c1 = new Course(1, "�鿴����ѡ��", "rgl", Course.WEEKDAY.MON,
				Course.COURSETIME.MORNING12, 4,"301");
		Course c2 = new Course(2, "����", "��", Course.WEEKDAY.TUE, 
				Course.COURSETIME.AFTERNOON12, 3,"302");
		courseList.add(c1);
		courseList.add(c2);
		
		return courseList;
	}
	
	//��ȡ���еĿ�
	//������curriculum button
	public ArrayList<Course> getAllCourses(){
		ArrayList<Course> courseList = new ArrayList<Course>();
		Course c1 = new Course(1, "��������", "rgl", Course.WEEKDAY.MON,
				Course.COURSETIME.MORNING12, 4,"301");
		Course c2 = new Course(2, "����", "��", Course.WEEKDAY.TUE, 
				Course.COURSETIME.AFTERNOON12, 3,"302");
		courseList.add(c1);
		courseList.add(c2);
		
		return courseList;
	}
	
	//�鿴�Ƿ�ѡ�� 
	public boolean checkCourseSelected(String username, int uid) {
		boolean courseSelectedFlag = false;
		if(username.equals("09016321") && uid == 1) {
			courseSelectedFlag = true;
		}
		return courseSelectedFlag;
	}
}
