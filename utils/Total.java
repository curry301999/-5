package utils;

public final class Total {
	
	
	private static CourseList courseList =null;
	private static StudentCourseList studentCourseList =null;
	
	static{
		//静态块优先执行
		courseList=new CourseList();//一个得到对象
		studentCourseList = new StudentCourseList();
		}
	public static CourseList getCourseList(){
		return courseList;//返回该对象
		}
	public static StudentCourseList getStudentCourseList(){
		return studentCourseList;//返回该对象
		}
}
