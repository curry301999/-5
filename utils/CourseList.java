package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Course;
import model.Teacher;

public class CourseList {
	
	public List<Course> list;
	

	public void addMap(Course course){
		
		list.add(course);
	}

	public CourseList() {
		list = new ArrayList<>();
		Course course = new Course();
		course.setId(10);
		course.setName("高等数学");
		course.setAddress("逸夫楼");
		course.setTime("星期三 一二节");
		course.setTeacher("王老师");
	
		Course course1 = new Course();
		course1.setId(2);
		course1.setName("大学物理");
		course1.setAddress("综合楼");
		course1.setTime("星期四 三四节");
		course1.setTeacher("李老师");
		
		list.add(course);
		list.add(course1);
	}

	public List<Course> getList() {
		return list;
	}

	public void setList(List<Course> list) {
		this.list = list;
	}
   
}
