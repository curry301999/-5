package utils;

import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Student;
import model.Teacher;

//学生选课列表
public class StudentCourseList {

	public List<Student> list;
	
	public void addStudent(Student student){
			
			list.add(student);
		}
	
		public StudentCourseList() {
			//初始化几个例子
			list = new ArrayList<>();
			Student student = new Student();
			student.setId(1);
			student.setGender("男");
			student.setName("张三");
			
			Course course = new Course();
			course.setId(4);
			course.setName("大王");
			course.setAddress("S楼");
			course.setTime("星期三 七八节");
			course.setTeacher("忘啦是");
		    List<Course> courses = new ArrayList<>();
		    courses.add(course);
			student.setCourse(courses);
			
//			Student student1 = new Student();
//			student1.setId(1);
//			student1.setGender("男");
//			student1.setName("李四");
			
			list.add(student);
//			list.add(student1);
	}
}
