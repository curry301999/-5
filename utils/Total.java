package utils;

public final class Total {
	
	
	private static CourseList courseList =null;
	private static StudentCourseList studentCourseList =null;
	
	static{
		//��̬������ִ��
		courseList=new CourseList();//һ���õ�����
		studentCourseList = new StudentCourseList();
		}
	public static CourseList getCourseList(){
		return courseList;//���ظö���
		}
	public static StudentCourseList getStudentCourseList(){
		return studentCourseList;//���ظö���
		}
}
