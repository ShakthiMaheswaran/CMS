package views;

import javax.swing.*;
import java.awt.*;

public class Dashboardview extends JFrame {

	//Components
	private JTextField MyClass;
	private JTextField Classes;
	private JTextField allClasses;
	private JTextField WelcomeTxt;
	private JTextField totalStudent;
	private JTextField Presentstudent;

	private JPanel panel;


	public Dashboardview() {
		this.setSize(800, 600);
		this.setLayout(null);
		this.setTitle("Dashboard");
		this.setIconImage(new ImageIcon(getClass().getResource("/cms_icon.png")).getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		this.setVisible(true);
	}
	
	public void initComponents() {

		//panel config
		panel = new JPanel();
		panel.setBounds(10,10,780,580);
		panel.setLayout(new GridLayout());

		//components
		MyClass = new JTextField("MyClass");
//		MyClass.setLocation(0,0);
//		MyClass.setSize(100,100);




		// Adding comp
		panel.add(MyClass);





		this.add(panel);
	}

}
