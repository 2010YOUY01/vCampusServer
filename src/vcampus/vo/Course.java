package vcampus.vo;

import java.io.Serializable;

public class Course implements Serializable{
	public enum WEEKDAY{
		MON, TUE, WED, THR, FRI, SAT, SUN
	}
	public enum COURSETIME{
		MORNING12, MORNING34, AFTERNOON12, AFTERNOON34, NIGHT
	}
	
	private int uID;
	private String className;
	private String teacher;
	private WEEKDAY timeInWeek;
	private COURSETIME timeInDay;
	private double credit;
	private String loc;
	public Course(int uID, String className, String teacher, 
			WEEKDAY timeInWeek, COURSETIME timeInDay, double credit, String loc) {
		this.uID = uID;
		this.className = className;
		this.teacher = teacher;
		this.timeInWeek = timeInWeek;
		this.timeInDay = timeInDay;
		this.credit = credit;
		this.loc = loc;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public WEEKDAY getTimeInWeek() {
		return timeInWeek;
	}
	public void setTimeInWeek(WEEKDAY timeInWeek) {
		this.timeInWeek = timeInWeek;
	}
	public COURSETIME getTimeInDay() {
		return timeInDay;
	}
	public void setTimeInDay(COURSETIME timeInDay) {
		this.timeInDay = timeInDay;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
