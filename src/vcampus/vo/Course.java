package vcampus.vo;

public class Course {
	enum WEEKDAY{
		MON, TUE, WED, THR, FRI, SAT, SUN
	}
	enum COURSETIME{
		MORNING12, MORNING34, AFTERNOON12, AFTERNOON34, NIGHT
	}
	
	private int uID;
	private String className;
	private String teacher;
	private WEEKDAY timeInWeek;
	private COURSETIME timeInDay;
	public Course(int uID, String className, String teacher, WEEKDAY timeInWeek, COURSETIME timeInDay) {
		super();
		this.uID = uID;
		this.className = className;
		this.teacher = teacher;
		this.timeInWeek = timeInWeek;
		this.timeInDay = timeInDay;
	}
	
	
}
