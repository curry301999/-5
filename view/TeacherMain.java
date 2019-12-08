package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Course;
import model.Student;
import utils.Total;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class TeacherMain {

	private JFrame frame;
	private JTextField idText;
	private JTextField nameText;
	private JTextField teacherText;
	private JTextField addressText;
	private JTextField timeText;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherMain window = new TeacherMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeacherMain() {
		initialize();
		studentSelectTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setEnabled(true);
		frame.setBounds(100, 100, 715, 692);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置frame居中显示
	    frame.setLocationRelativeTo(null);
	    frame.getContentPane().setLayout(null);
	    
	    JPanel listPanel = new JPanel();
	    listPanel.setBounds(0, 0, 697, 645);
	    frame.getContentPane().add(listPanel);
	    listPanel.setLayout(null);
	    
	    JLabel lblNewLabel_5 = new JLabel("\u5B66\u751F\u9009\u8BFE\u5217\u8868");
	    lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 24));
	    lblNewLabel_5.setBounds(221, 83, 247, 34);
	    listPanel.add(lblNewLabel_5);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(83, 163, 550, 313);
	    listPanel.add(scrollPane);
	    
	    table = new JTable();
	    DefaultTableModel dfT = new DefaultTableModel(
		    	new Object[][] {
		    	},
		    	new String[] {
		    		"\u5B66\u751F\u59D3\u540D", "\u8BFE\u7A0B\u540D"
		    	}
		    );
	    table.setModel(dfT);
	    scrollPane.setViewportView(table);
	 
	    JPanel addCoursePanel = new JPanel();
	    addCoursePanel.setBounds(0, 0, 697, 645);
	    frame.getContentPane().add(addCoursePanel);
	    addCoursePanel.setLayout(null);
	    addCoursePanel.setVisible(false);
	    
	    JButton btnNewButton_2 = new JButton("\u65B0\u589E\u8BFE\u7A0B");
	    //关闭列表，显示新增课程
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		listPanel.setVisible(false);
	    		addCoursePanel.setVisible(true);
	    	}
	    });
	    btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
	    btnNewButton_2.setBounds(488, 541, 145, 27);
	    listPanel.add(btnNewButton_2);
	    
	    JButton btnNewButton_3 = new JButton("\u5237  \u65B0");
	    btnNewButton_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		studentSelectTable();
	    	}
	    });
	    btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));
	    btnNewButton_3.setBounds(83, 545, 106, 23);
	    listPanel.add(btnNewButton_3);
	    
	  
	    
	    JLabel lblNewLabel = new JLabel("\u7F16  \u53F7\uFF1A");
	    lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
	    lblNewLabel.setBounds(98, 167, 72, 18);
	    addCoursePanel.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
	    lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
	    lblNewLabel_1.setBounds(98, 222, 101, 18);
	    addCoursePanel.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
	    lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
	    lblNewLabel_2.setBounds(98, 279, 101, 18);
	    addCoursePanel.add(lblNewLabel_2);
	    
	    JLabel lblNewLabel_3 = new JLabel("\u5730  \u5740\uFF1A");
	    lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
	    lblNewLabel_3.setBounds(98, 346, 101, 18);
	    addCoursePanel.add(lblNewLabel_3);
	    
	    JLabel lblNewLabel_4 = new JLabel("\u65F6  \u95F4\uFF1A");
	    lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
	    lblNewLabel_4.setBounds(98, 422, 101, 18);
	    addCoursePanel.add(lblNewLabel_4);
	    
	    idText = new JTextField();
	    idText.setBounds(277, 166, 244, 24);
	    addCoursePanel.add(idText);
	    idText.setColumns(10);
	    
	    nameText = new JTextField();
	    nameText.setBounds(277, 221, 244, 24);
	    addCoursePanel.add(nameText);
	    nameText.setColumns(10);
	    
	    teacherText = new JTextField();
	    teacherText.setBounds(277, 278, 241, 24);
	    addCoursePanel.add(teacherText);
	    teacherText.setColumns(10);
	    
	    addressText = new JTextField();
	    addressText.setBounds(277, 345, 241, 24);
	    addCoursePanel.add(addressText);
	    addressText.setColumns(10);
	    
	    timeText = new JTextField();
	    timeText.setBounds(277, 421, 241, 24);
	    addCoursePanel.add(timeText);
	    timeText.setColumns(10);
	    
	    JButton btnNewButton = new JButton("\u786E  \u8BA4");
	    btnNewButton.addActionListener(new ActionListener() {
	    	//新增课程
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		String id =idText.getText(); 
	    		String name = nameText.getText();
	    		String teacher =teacherText.getText();
	    		String address = addressText.getText();
	    		String time = timeText.getText();
	    		
	    		Course course = new Course();
	    		course.setId(Integer.parseInt(id));
	    		course.setAddress(address);
	    		course.setName(name);
	    		course.setTeacher(teacher);
	    		course.setTime(time);
	    		Total.getCourseList().addMap(course);
//	    	    Student	student =new  Student();
//	    	    
//	    		StudentMain studentMain = new StudentMain(student);
//	    		studentMain.courseList.addMap(course);
	    	}
	    });
	    btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
	    btnNewButton.setBounds(79, 534, 113, 27);
	    addCoursePanel.add(btnNewButton);
	    
	    JButton btnNewButton_1 = new JButton("\u67E5\u770B\u9009\u8BFE\u5217\u8868");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		addCoursePanel.setVisible(false);
	    		listPanel.setVisible(true);
	    	}
	    });
	    btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
	    btnNewButton_1.setBounds(392, 534, 186, 27);
	    addCoursePanel.add(btnNewButton_1);
	   
	    frame.setVisible(true);
	}
	 //学生选课列表
    public void studentSelectTable() {
    	DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		java.util.List<Student> list =  Total.getStudentCourseList().list;
		
		dtm.setRowCount(0);
		for(int i = 0 ;i<list.size();i++) {
			List<Course> courses = list.get(i).getCourse();
			Vector vector = new Vector<>();
			vector.add(list.get(i).getName());
			vector.add(courses.get(i).getName());
			dtm.addRow(vector);
		}
		
		
	}
}
