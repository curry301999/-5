package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.icu.impl.StringRange.Adder;

import model.Course;
import model.Student;

//工具类，用于存放注册的用于名和密码，并先初始化一个
public class UserList {

	
	public List<Student> list;
	
	public void addStudent(Student student){
		
		list.add(student);
	}

	public UserList() {
		list = new ArrayList<>();
		Student student = new Student();
		List<Course> courseList = new ArrayList<>();
		Course course = new Course();
		course.setId(1);
		course.setName("测试");
		course.setAddress("综合楼");
		course.setTime("星期五 一二节");
		course.setTeacher("张老师");
		courseList.add(course);
		student.setCourse(courseList);
		
		student.setGender("男");
		student.setId(1);
		student.setName("张飞");
		student.setPassword("1");
		student.setAccount("1");
		list.add(student);
		
	}

	public List<Student> getList() {
		return list;
	}
	
	
	
	
}
