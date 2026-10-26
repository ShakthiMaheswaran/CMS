import controler.MainController;
import views.Loginview;

import javax.swing.*;

public class App {

	public static void main(String arg[]) {




		SwingUtilities.invokeLater(() -> {
			Loginview lv = new Loginview();
			MainController mc = new MainController(lv);
		});
		
	}
}
