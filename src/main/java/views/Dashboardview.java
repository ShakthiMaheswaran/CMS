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
	private JTextField t1;
	private JTextField t2;
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

	public void manageView(){
		this.remove(panel1);

		//inilizision manage view...
		ManageStPanel = new JPanel(new FlowLayout());
		ManageStPanel.setBounds(10,10,770,550);
		ManageStPanel.setBackground( Color.BLACK);




		this.add(ManageStPanel);
		this.repaint();
	}

	public void attendanceView(){
		this.remove(panel1);

		//inilizision manage view...
		AttendancePanel = new JPanel(new FlowLayout());
		AttendancePanel.setBounds(10,10,770,550);
		AttendancePanel.setBackground( Color.blue);




		this.add(AttendancePanel);
		this.repaint();
	}


	public JLabel getMyClass() 				{ 	return MyClass;			}

	public JButton getManageStudents() 		{	return ManageStudents;	}

	public JButton getMarkAttendance() 		{	return MarkAttendance;	}

	public JPanel getPanel1() 				{	return panel1;			}

	public JPanel getManageStPanel() 		{	return ManageStPanel;	}
}
