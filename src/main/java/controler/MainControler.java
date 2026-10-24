package controler;

import models.Authenticator;
import models.User;
import views.Dashboardview;
import views.Loginview;

import javax.swing.*;

public class MainControler {

	private JFrame mainFrame;
	private Loginview loginview;
	private Dashboardview dashboardview;
	private User currentUser;
	private Authenticator authehnticator;
	
	public MainControler(Loginview loginview) {
		this.loginview = loginview;
		this.currentUser = new User();
		this.authehnticator = new Authenticator();

		this.loginview.addGui();
		this.loginview.btnLogin.addActionListener(e -> {
			currentUser.setUsername(this.loginview.txtUsername.getText());
			currentUser.setPassword(new String(this.loginview.txtPassword.getPassword()));
			System.out.println("Attempting login with username: " + currentUser.getUsername() + " and password: " + currentUser.getPassword());
			
//			if(authehnticator.authenticateLogin(currentUser)){
			if(true){
				this.loginview.dispose();
				initDashoard();
				method1();
			}
			else {
				this.loginview.notifyInvaliedLogin();
			}
		});
	}

	public void initDashoard(){
		dashboardview = new Dashboardview();
	}

	public void method1() {
		dashboardview.getManageStudents().addActionListener( e -> {

			System.out.println(e);

			dashboardview.manageView();
		});

		dashboardview.getMarkAttendance().addActionListener( e -> {

			System.out.println(e);

			dashboardview.attendanceView();
		});
	}
	
}
