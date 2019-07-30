package team.shoot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Login extends JFrame {
	
	public JPanel pnluser;
	public JLabel lbluserLogin;
	public JLabel lbluserName;
	public JLabel lbluserPwd;
	public JTextField txtName;
	public JPasswordField pwdPwd;
	public JButton btnSub;  
	public JButton btnReset;


	public Login(){
		pnluser = new JPanel();
		lbluserLogin = new JLabel();
		lbluserName = new JLabel();
		lbluserPwd = new JLabel();
		txtName = new JTextField();
		pwdPwd = new JPasswordField();
		btnSub = new JButton();
		btnReset = new JButton();
		userInit();
			
	}
	
	public void userInit(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,300);
		this.setResizable(false);
		this.setTitle("欢迎来到飞机大战");
		this.pnluser.setLayout(null);
//		this.pnluser.setBackground(Color.cyan);
		this.lbluserLogin.setText("用户登陆界面");
		this.lbluserLogin.setFont(new Font("宋体",Font.BOLD| Font.ITALIC,28));
		this.lbluserLogin.setForeground(Color.RED);
		this.lbluserName.setText("用户名:");
		this.lbluserPwd.setText("密码:");
		this.btnSub.setText("登陆");
		this.btnReset.setText("注册");
		this.lbluserLogin.setBounds(150,65,220,40);
		this.lbluserName.setBounds(150,125,60,20);
		this.lbluserPwd.setBounds(150,155,60,20) ;
		this.txtName.setBounds(210,125,120,20);
		this.pwdPwd.setBounds(210,155,120,20) ;
		this.btnSub.setBounds(155,215,60,20);
		this.btnSub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					btnsub_ActionEvent(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		this.btnReset.setBounds(255,215,60,20);
		this.btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					btnreset_ActionEvent(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.pnluser.add(lbluserLogin);
		this.pnluser.add(lbluserName);
		this.pnluser.add(lbluserPwd);
		this.pnluser.add(txtName);
		this.pnluser.add(pwdPwd);
		this.pnluser.add(btnSub);
		this.pnluser.add(btnReset);
		
		this.add(pnluser);
		this.setVisible(true);
	}
	
	public void btnsub_ActionEvent(ActionEvent e) throws IOException{  
		String name = txtName.getText();
		String pwd = String.valueOf(pwdPwd.getPassword());
		//读取账号密码
		RandomAccessFile raf = new RandomAccessFile("user.txt","r");
		
		String username = null;
		String userpwd = null;
		boolean flag = false;
		
		for(int i=0;i<raf.length()/64;i++){
			//读用户名
			byte[] data = new byte[32];
			raf.read(data);
			username = new String(data,"UTF-8").trim();
			//读密码
			raf.read(data);
			userpwd = new String(data,"UTF-8").trim();

			if(name.equals("")){
				JOptionPane.showMessageDialog(null, "帐号不能为空","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}else if(pwd.equals("")){
				JOptionPane.showMessageDialog(null, "密码不能为空","错误",JOptionPane.ERROR_MESSAGE);
				return;
			
			}else if(!name.equals(username)||!pwd.equals(userpwd)){
				JOptionPane.showMessageDialog(null, "帐号或密码错误","错误",JOptionPane.ERROR_MESSAGE);
				return;
			}else if(name.equals(username) && pwd.equals(userpwd)) {
				flag = true;
				break;
			}
		}	
		raf.close();
		
			if(flag == true) {
				this.dispose();
				JFrame frame = new JFrame();
				World world = new World();
				frame.add(world);
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(400, 700);
				frame.setLocationRelativeTo(null); 
				frame.setVisible(true); 
				
				world.action();
				
			}
			
	}
	public void btnreset_ActionEvent(ActionEvent e) throws IOException{ 
		//用户注册
		
		RandomAccessFile raf = new RandomAccessFile("user.txt","rw");
		
		String name = txtName.getText();
		String pwd = String.valueOf(pwdPwd.getPassword());
		
		
		if(name.equals("")){
			JOptionPane.showMessageDialog(null, "帐号不能为空","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}else if(pwd.equals("")){
			JOptionPane.showMessageDialog(null, "密码不能为空","错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String username1 = null;
		String userpwd1 = null;
		
		for(int i=0;i<raf.length()/64;i++){
			//读用户名
			byte[] data1 = new byte[32];
			raf.read(data1);
			username1 = new String(data1,"UTF-8").trim();
			
			raf.read(data1);
			userpwd1 = new String(data1,"UTF-8").trim();
		}
		
		if(name.equals(username1)){
			JOptionPane.showMessageDialog(null, "该用户名已被注册","非常抱歉",JOptionPane.YES_NO_CANCEL_OPTION);
			txtName.setText("");
			pwdPwd.setText("");
			return;
		}else{
			byte[] data = name.getBytes("UTF-8");
			data = Arrays.copyOf(data, 32);
			raf.write(data);
			
			data = pwd.getBytes("UTF-8");
			data = Arrays.copyOf(data, 32);
			raf.write(data);
					
			JOptionPane.showMessageDialog(null, "注册成功","恭喜您，注册成功！",JOptionPane.YES_NO_CANCEL_OPTION);
			raf.seek(raf.length());
			txtName.setText("");
			pwdPwd.setText("");
			return;
			}
		
	}
	

	public static void main(String[] args) {
		new Login();	
		
	}

}
