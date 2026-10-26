package views;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Dashboardview extends JFrame {

	//Components
	private JLabel MyClass;
	private JButton ManageStudents;
	private JButton MarkAttendance;

	//attendance comp
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JTextField Dept;
	private JTextField year;
	private JButton Go;

	private JPanel panel1;
	private JPanel ManageStPanel;
	private JPanel AttendancePanel;


	public Dashboardview() {
		this.setSize(800, 600);
		this.setLayout(null);
		this.setTitle("Dashboard");
		this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/cms_icon.png"))).getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		this.setVisible(true);
	}

	public void initComponents() {

		//panel config
		panel1 = new JPanel();
		panel1.setBounds(10,10,770,550);
		panel1.setLayout(new FlowLayout());

		//components
		MyClass = new JLabel("MyClass :");
		ManageStudents = new JButton("Manage Students");
		MarkAttendance = new JButton("Mark Attendance");


		// Adding comp
		panel1.add(MyClass);
		panel1.add(ManageStudents);
		panel1.add(MarkAttendance);


		this.add(panel1);
	}

	public void showManageView(){
		this.remove(panel1);

		//Initialization manage view...
		ManageStPanel = new JPanel(new FlowLayout());
		ManageStPanel.setBounds(10,10,770,550);
		ManageStPanel.setBackground( Color.BLACK);




		this.add(ManageStPanel);
		this.repaint();
	}

	public void showAttendanceView(){
		this.remove(panel1);

		//Initialization attendance view...
		AttendancePanel = new JPanel();
		AttendancePanel.setBounds(10,10,770,550);
		AttendancePanel.setLayout(new FlowLayout());

		//Components for the attendance view
		l1 = new JLabel("Dept :");
		l2 = new JLabel("Year :");
		l3 = new JLabel("extra ");
		year = new JTextField(15);
		Dept = new JTextField(15);
		Go = new JButton("Go");

		AttendancePanel.add(l1);
		AttendancePanel.add(Dept);
		AttendancePanel.add(l2);
		AttendancePanel.add(year);
		AttendancePanel.add(l3);
		AttendancePanel.add(Go);


		this.add(AttendancePanel);
		this.revalidate();
		this.repaint();
	}


	public JLabel getMyClass() 				{ 	return MyClass;			}

	public JButton getManageStudents() 		{	return ManageStudents;	}

	public JButton getMarkAttendance() 		{	return MarkAttendance;	}

	public JPanel getPanel1() 				{	return panel1;			}

	public JPanel getManageStPanel() 		{	return ManageStPanel;	}

	public JPanel getAttendancePanel() 		{	return AttendancePanel;	}

	public JButton getGo() 					{	return Go;	}

	public String getDeptText()           { return Dept != null ? Dept.getText() : ""; }
	public String getYearText()           { return year != null ? year.getText() : ""; }

}
