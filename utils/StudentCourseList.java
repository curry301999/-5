package utils;

import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Student;
import model.Teacher;

//ѧ��ѡ���б�
public class StudentCourseList {

	public List<Student> list;
	
	public void addStudent(Student student){
			
			list.add(student);
		}
	
		public StudentCourseList() {
			//��ʼ����������
			list = new ArrayList<>();
			Student student = new Student();
			student.setId(1);
			student.setGender("��");
			student.setName("����");
			
			Course course = new Course();
			course.setId(4);
			course.setName("����");
			course.setAddress("S¥");
			course.setTime("������ �߰˽�");
			course.setTeacher("������");
		    List<Course> courses = new ArrayList<>();
		    courses.add(course);
			student.setCourse(courses);
			
//			Student student1 = new Student();
//			student1.setId(1);
//			student1.setGender("��");
//			student1.setName("����");
			
			list.add(student);
//			list.add(student1);
	}
}
