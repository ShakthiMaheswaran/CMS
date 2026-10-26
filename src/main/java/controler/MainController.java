package controler;

import models.Authehnticator;
import models.User;
import views.Dashboardview;
import views.Loginview;

public class MainController {

	private final Loginview loginview;
	private Dashboardview dashboardview;
	private final User currentUser;
	private Authehnticator authehnticator;
	
	public MainController(Loginview loginview) {
		this.loginview = loginview;
		this.currentUser = new User();
		this.authehnticator = new Authehnticator();

		this.loginview.addGui();
		this.loginview.btnLogin.addActionListener(e -> login() );

	}

	private void login(){
		currentUser.setUsername(this.loginview.txtUsername.getText());
		currentUser.setPassword(new String(this.loginview.txtPassword.getPassword()));
		System.out.println("Attempting login with username: "
				+ currentUser.getUsername() + " and password: " + currentUser.getPassword());

//		if(authehnticator.authenticateLogin(currentUser)){
		if(true){
			this.loginview.dispose();
			initDashboard();
		}
		else {
			this.loginview.notifyInvaliedLogin();
		}
	}

	public void initDashboard(){
		dashboardview = new Dashboardview();
		dashboardview.getManageStudents().addActionListener( e -> handleManageStudentsClick());
		dashboardview.getMarkAttendance().addActionListener( e -> handleMarkAttendanceClick());
	}

	private void handleManageStudentsClick() {
		dashboardview.showManageView();
	}

	private void handleMarkAttendanceClick() {
		dashboardview.showAttendanceView();
		dashboardview.getGo().addActionListener(e -> handleGoClick());
	}

	private void handleGoClick() {
		String t1 = dashboardview.getDeptText();
		String t2 = dashboardview.getYearText();

		System.out.println("T1 :"+t1+" T2 :"+t2);
	}

}
