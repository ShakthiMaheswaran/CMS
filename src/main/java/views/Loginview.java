package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Loginview extends JFrame {
	
	public JButton btnLogin;
	public JTextField txtUsername;
	public JPasswordField txtPassword;
	
	public Loginview(){
		this.setSize(450,300);
		this.setLayout(null);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void addGui() {
		
		this.btnLogin = new JButton("Login");
		this.btnLogin.setBounds(175, 200, 100, 30);
		this.add(this.btnLogin);
		
		this.txtUsername = new JTextField();
		this.txtUsername.setBounds(150, 75, 150, 30);
		this.add(this.txtUsername);
		
		this.txtPassword = new JPasswordField();
		this.txtPassword.setBounds(150, 125, 150, 30);
		this.add(this.txtPassword);
		
		this.setLayout(null);
		this.repaint();
		
	}
	
	public void notifyInvaliedLogin() {

		
			javax.swing.JLabel lblInvalid = new javax.swing.JLabel("Invalid username or password");
			lblInvalid.setBounds(130, 160, 200, 25);
			this.add(lblInvalid);
			this.repaint();
			
		
	
	
	
	}
}
