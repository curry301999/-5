package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import model.Student;
import utils.UserList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField accountText;
	private JTextField pwsText;
	//����UserList
	UserList userList = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		//ʵ����
		userList = new UserList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//����frame������ʾ
	    frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u9009\u8BFE\u7CFB\u7EDF");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel.setBounds(187, 95, 296, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26  \u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(132, 266, 85, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(132, 389, 85, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		accountText = new JTextField();
		accountText.setBounds(251, 265, 249, 24);
		frame.getContentPane().add(accountText);
		accountText.setColumns(10);
		
		pwsText = new JTextField();
		pwsText.setBounds(251, 388, 249, 24);
		frame.getContentPane().add(pwsText);
		pwsText.setColumns(10);
		
		JButton loginBtn = new JButton("\u767B  \u5F55");
		loginBtn.addActionListener(new ActionListener() {
			//��¼�¼�
			public void actionPerformed(ActionEvent e) {
				
				String account = accountText.getText();
				String password = pwsText.getText();
				if(account.contains("1")) {
				//���û�������˺ź����������֤,ѭ������
				boolean flag = false;
				List<Student> list = userList.getList();
				for(int i = 0 ;i<list.size();i++) {
					    Student student =list.get(i);
				    	System.out.println(student.getAccount()+","+student.getPassword());
				    	if(student.getAccount().equals(account) && student.getPassword().equals(password)){
				    			new StudentMain(student);
				    		//˵���˺����붼��ȷ
				    		flag = true;
				    	}
				}
				if(!flag) {
					//��������ȷ,���׳��쳣
					//�˴����տ���Ҫ�󣬶��쳣���д���
//					try {
//						throw new Exception("�˺Ż������벻��");
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					//���ߵ�����ʾ
					JOptionPane.showMessageDialog(null, "�˺Ż������벻��");
				}
			}else {
				new TeacherMain();
			}
			}
		});
		loginBtn.setFont(new Font("����", Font.PLAIN, 20));
		loginBtn.setBounds(118, 499, 113, 27);
		frame.getContentPane().add(loginBtn);
		
		JButton registerBtn = new JButton("\u6CE8  \u518C");
		registerBtn.setFont(new Font("����", Font.PLAIN, 20));
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��������ע��ҳ��
				new Register(userList);
			}
		});
		registerBtn.setBounds(408, 499, 113, 27);
		frame.getContentPane().add(registerBtn);
	}
     
	
}
