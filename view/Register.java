package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import org.eclipse.ui.internal.handlers.NewEditorHandler;

import model.Student;
import utils.UserList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

//注册界面
public class Register {

	private JFrame frame;
	private JTextField accountText;
	private JTextField pwdText;
	UserList userList = null;
	private JTextField nameText;
	private JTextField genderText;
	private JTextField idText;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Register window = new Register();
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
	public Register(UserList userList) {
		initialize();
		this.userList = userList;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		//设置frame居中显示
	    frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JLabel label = new JLabel("\u8D26  \u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(97, 92, 116, 29);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(97, 174, 96, 18);
		frame.getContentPane().add(lblNewLabel);
		
		accountText = new JTextField();
		accountText.setBounds(227, 95, 184, 24);
		frame.getContentPane().add(accountText);
		accountText.setColumns(10);
		
		pwdText = new JTextField();
		pwdText.setBounds(227, 172, 184, 24);
		frame.getContentPane().add(pwdText);
		pwdText.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6CE8  \u518C");
		btnNewButton.addActionListener(new ActionListener() {
			//注册事件
			public void actionPerformed(ActionEvent e) {
				String account = accountText.getText();
				String password = pwdText.getText();
				String name = nameText.getText();
				String gender = genderText.getText();
				Integer idInteger =Integer.parseInt( idText.getText());
				
				
				Student student = new Student();
				student.setAccount(account);
				student.setGender(gender);
				student.setId(idInteger);
				student.setName(name);
				student.setPassword(password);
				userList.addStudent(student);
				
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(80, 434, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6  \u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(318, 434, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3  \u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(97, 249, 72, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027  \u522B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(97, 314, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16  \u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(97, 376, 72, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		nameText = new JTextField();
		nameText.setBounds(227, 247, 184, 24);
		frame.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		genderText = new JTextField();
		genderText.setBounds(227, 312, 184, 24);
		frame.getContentPane().add(genderText);
		genderText.setColumns(10);
		
		idText = new JTextField();
		idText.setBounds(227, 374, 184, 24);
		frame.getContentPane().add(idText);
		idText.setColumns(10);
		frame.setBounds(100, 100, 586, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
