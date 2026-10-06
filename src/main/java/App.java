import controler.MainControler;
import views.Loginview;

public class App {

	public static void main(String arg[]) {

		@SuppressWarnings("unused")
		MainControler mc = new MainControler(new Loginview());
		
	}
}
