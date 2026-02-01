import controler.MainControler;
import views.Loginview;

public class App {

	public static void main(String arg[]) {
		Loginview lv = new Loginview();
		MainControler mc = new MainControler(lv);
		
	}
}
