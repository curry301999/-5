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
		course.setName("�ߵ���ѧ");
		course.setAddress("�ݷ�¥");
		course.setTime("������ һ����");
		course.setTeacher("����ʦ");
	
		Course course1 = new Course();
		course1.setId(2);
		course1.setName("��ѧ����");
		course1.setAddress("�ۺ�¥");
		course1.setTime("������ ���Ľ�");
		course1.setTeacher("����ʦ");
		
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
