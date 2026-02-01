package controler;

import views.Loginview;

public class MainControler {

	public Loginview loginview;
	public MainControler(Loginview loginview) {
		this.loginview = loginview;
		this.loginview.addGui();
		
		this.loginview.btnLogin.addActionListener(e -> {
			String username = this.loginview.txtUsername.getText();
			String password = new String(this.loginview.txtPassword.getPassword());
			System.out.println("Attempting login with username: " + username + " and password: " + password);
			if(authenticate(username, password)) {
				this.loginview.dispose();
			}
			else {
				this.loginview.notifyInvaliedLogin();
			}
		});
	}
	
	public boolean authenticate(String username, String password) {
		// Dummy authentication logic
		return "admin".equals(username) && "password".equals(password);
	}
}
