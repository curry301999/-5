姓名：张嘉诚 班级：大数据181 学号：2018310998
综合性实验  学生选课系统设计

实验目的
分析学生选课系统
使用GUI窗体及其组件设计窗体界面
完成学生选课过程业务逻辑编程
基于文件保存并读取数据
处理异常
实验要求
一、系统角色分析及类设计
例如：学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择课程。
定义每种角色人员的属性，及其操作方法。
属性示例：	人员（编号、姓名、性别……）
教师（编号、姓名、性别、所授课程、……）
			学生（编号、姓名、性别、所选课程、……）
			课程（编号、课程名称、上课地点、时间、授课教师、……）
以上属性仅为示例，同学们可以自行扩展。

二、要求:
1、设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
2、基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
3、针对操作过程中可能会出现的各种异常，做异常处理
4、基于输入/输出编程，支持学生、课程、教师等数据的读写操作。
5、基于Github.com提交实验，包括实验SRC源文件夹程序、README.MD实验报告文档。
6、本次实验是综合性实验，在40%的实验成绩中占比最大，望同学们认真对待。
7、提交截止时间：12月8日。


8、
解题思路：
建立三个包分别为modle代表了实体类，utils代表了工具类是我们这个项目中所要用到的工具，最后一个view类是视图，代表最后做出来的效果。设置一个登陆界面，由于要求需要老师和学生都要登陆，所以要登录两次分别代表老师和学生，其中在代码中设置账号首位有数字1代表学生登陆，完成学生选课和退课，该方法位于view包中的StudentMain类中，如果不含数字1则代表老师登陆用来增加课程和查看学生选课列表，其中该方法位于view包中的TeacherMain类中。其中最重要的是想办法在老师与学生中传递数据，这就需要一个方法，于是在utils包中新建了一个类Total,定义一个全局变量才能在老师和学生中传递数据。


9、
核心代码：
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import model.Course;
import model.Student;
import utils.CourseList;
import utils.StudentCourseList;
import utils.Total;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class StudentMain {

	private JFrame frame;
//    CourseList courseList = null;
    private JTable myTable;
    Student student = null;
    private JTable selectTable;
//    StudentCourseList studentCourseList =null;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StudentMain window = new StudentMain();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public StudentMain(Student student) {
		initialize();
		this.student = student;
//		courseList = new CourseList();
//	    studentCourseList = new StudentCourseList();
		fillTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//设置frame居中显示
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
		DefaultTableModel dfT = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u7F16\u53F7", "\u8BFE\u7A0B\u540D", "\u6388\u8BFE\u8001\u5E08", "\u65F6 \u95F4", "\u5730 \u70B9"
				}
			);
		DefaultTableModel selectdfT = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u7F16\u53F7", "\u8BFE\u7A0B\u540D", "\u6388\u8BFE\u8001\u5E08", "\u65F6 \u95F4", "\u5730 \u70B9"
				}
			);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 692, 613);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			panel.setVisible(false);
			
			
			JLabel label_1 = new JLabel("\u6211\u7684\u9009\u8BFE");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setFont(new Font("宋体", Font.PLAIN, 24));
			label_1.setBounds(239, 93, 226, 29);
			panel.add(label_1);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(65, 174, 568, 282);
			panel.add(scrollPane_1);
			
			myTable = new JTable();
			myTable.setModel(dfT);
			scrollPane_1.setViewportView(myTable);
			
			JLabel label_2 = new JLabel("\u8BF7\u9009\u4E2D\u9700\u8981\u9000\u9009\u7684\uFF0C\u7136\u540E\u70B9\u786E\u8BA4");
			label_2.setFont(new Font("宋体", Font.PLAIN, 20));
			label_2.setBounds(65, 56, 305, 18);
			panel.add(label_2);
			
			JButton quitBtn = new JButton("\u786E  \u8BA4");
			quitBtn.setFont(new Font("宋体", Font.PLAIN, 20));
			quitBtn.addActionListener(new ActionListener() {
				//退选事件
				public void actionPerformed(ActionEvent e) {
					int selectRow = selectTable.getSelectedRow();
					String id = selectTable.getValueAt(selectRow, 0).toString();
					List<Course> strList = student.getCourse();
					for(int i=0 ;i<strList.size();i++) {
						Course course = strList.get(i);
						if(course.getId() == Integer.parseInt(id)) {
							 student.getCourse().remove(i);
							 System.out.println(22);
						}
					}
					System.out.println(333);
					myCourseTable();
				}
			});
			quitBtn.setBounds(483, 510, 113, 27);
			panel.add(quitBtn);
			
			JPanel selectPanel = new JPanel();
			selectPanel.setBounds(0, 0, 692, 613);
			frame.getContentPane().add(selectPanel);
			selectPanel.setLayout(null);
			
			JButton button_1 = new JButton("\u7EE7\u7EED\u9009\u8BFE");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					panel.setVisible(false);
                    selectPanel.setVisible(true);
				}
			});
			button_1.setFont(new Font("宋体", Font.PLAIN, 20));
			button_1.setBounds(92, 510, 142, 27);
			panel.add(button_1);
			
			
			
			
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(74, 179, 549, 268);
					selectPanel.add(scrollPane);
					
					selectTable = new JTable();
					selectTable.setModel(selectdfT);
					scrollPane.setViewportView(selectTable);
					
					JButton button = new JButton("\u786E   \u8BA4");
					button.addActionListener(new ActionListener() {
					
						//添加选课
						public void actionPerformed(ActionEvent e) {
							
							int selectRow = selectTable.getSelectedRow();
	
							String id = selectTable.getValueAt(selectRow, 0).toString();
							String courseName = selectTable.getValueAt(selectRow, 1).toString();
							String courseTeacher = selectTable.getValueAt(selectRow,2).toString();
							String courseTime= selectTable.getValueAt(selectRow, 3).toString();
							String courseAddress = selectTable.getValueAt(selectRow, 4).toString();
							
							Course course = new Course();
							course.setId(Integer.parseInt(id));
							course.setName(courseName);
							course.setAddress(courseAddress);
							course.setTime(courseTime);
							course.setTeacher(courseTeacher);
						    
							student.getCourse().add(course);
							Total.getStudentCourseList().addStudent(student);
						
						}
					});
					button.setFont(new Font("宋体", Font.PLAIN, 20));
					button.setBounds(478, 518, 113, 27);
					selectPanel.add(button);
					
						JButton btnNewButton = new JButton("\u67E5\u770B\u9009\u8BFE");
						btnNewButton.addActionListener(new ActionListener() {
							//显示我的课程
							public void actionPerformed(ActionEvent e) {
								selectPanel.setVisible(false);
								panel.setVisible(true);
								myCourseTable();
							}
						});
						btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
						btnNewButton.setBounds(98, 518, 140, 27);
						selectPanel.add(btnNewButton);
						
						JButton button_2 = new JButton("\u5237  \u65B0");
						button_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								fillTable();
							}
						});
						button_2.setFont(new Font("宋体", Font.PLAIN, 20));
						button_2.setBounds(302, 520, 113, 27);
						selectPanel.add(button_2);
		frame.setVisible(true);
		//设置frame居中显示
	    frame.setLocationRelativeTo(null);
	}
	//显示所有课程
    public void fillTable() {
    	DefaultTableModel dtm = (DefaultTableModel) selectTable.getModel();
		java.util.List<Course> list =  Total.getCourseList().getList();
		dtm.setRowCount(0);
		for(Course course : list) {
			Vector vector = new Vector<>();
			vector.add(course.getId());
			vector.add(course.getName());
			vector.add(course.getTeacher());
			vector.add(course.getTime());
			vector.add(course.getAddress());
			dtm.addRow(vector);
		}
	}
    //已选课程列表
    public void myCourseTable() {
    	DefaultTableModel dtm = (DefaultTableModel) myTable.getModel();
		java.util.List<Course> list =  student.getCourse();
		dtm.setRowCount(0);
		for(Course course : list) {
			Vector vector = new Vector<>();
			vector.add(course.getId());
			vector.add(course.getName());
			vector.add(course.getTeacher());
			vector.add(course.getTime());
			vector.add(course.getAddress());
			dtm.addRow(vector);
		} 
		
	}
}



运行截图：

![imag](https://github.com/curry301999/-5/blob/master/182d1f587b0e272e35e82f6cdc533f6.png)
![imag](https://github.com/curry301999/-5/blob/master/27896030dae4447ad77cc8386e52c0e.png)
![imag](https://github.com/curry301999/-5/blob/master/4d154051fb98dd8734332527f616a04.png)
![imag](https://github.com/curry301999/-5/blob/master/53fb3bf0d17003b7d9c6ae0012e767b.png)
![imag](https://github.com/curry301999/-5/blob/master/89946f44ea4235eb9ca2af6dbe79e47.png)
![imag](https://github.com/curry301999/-5/blob/master/d35e5b12d4dd98925b709b6bd0841c3.png)
![imag](https://github.com/curry301999/-5/blob/master/fdff6380935c1cc5b66073226a60aba.png)


