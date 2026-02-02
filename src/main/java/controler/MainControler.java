package controler;

import models.Authenticator;
import models.User;
import views.Loginview;

public class MainControler {

	public Loginview loginview;
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
			
			if(authehnticator.authenticateLogin(currentUser)){
				this.loginview.dispose();
			}
			else {
				this.loginview.notifyInvaliedLogin();
			}
		});
	}
	
}
