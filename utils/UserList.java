package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.icu.impl.StringRange.Adder;

import model.Course;
import model.Student;

//�����࣬���ڴ��ע��������������룬���ȳ�ʼ��һ��
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
		course.setName("����");
		course.setAddress("�ۺ�¥");
		course.setTime("������ һ����");
		course.setTeacher("����ʦ");
		courseList.add(course);
		student.setCourse(courseList);
		
		student.setGender("��");
		student.setId(1);
		student.setName("�ŷ�");
		student.setPassword("1");
		student.setAccount("1");
		list.add(student);
		
	}

	public List<Student> getList() {
		return list;
	}
	
	
	
	
}
