package loginPage;


import java.awt.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;

public class FirstFrame {
	
	public void getFirstFrame(FacebookDatabase fd){
		
		JFrame f = new JFrame("Facebook");
		f.setSize(1000, 600);
		//f.getContentPane().setBackground(Color.BLUE);
		f.setLayout(new BorderLayout());
		
		
		
		
		JLabel l1,l2,l3,l4,l5;
		JTextField t1,t2,t3,t4,t5,t6,t7;
		JComboBox cmb1,cmb2,cmb3;
		JPasswordField pass1,pass2;
		JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
		
		String []month = {"Month","January","February","March",
				"April","May","June","July","August","September","October","November","December"};
		
		String []day = {"Day","1","2","3","4","5","6","7","8","9","10",
				"11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		
		String []year = {"Year","1996","1997","1998","1999","2000","2001",
				"2002","2003","2004","2005","2006","2007","2008","2009","2010"};
		
		p1=new JPanel();
	    p2=new JPanel();
	    p3=new JPanel();
	    p4=new JPanel();
	    p5=new JPanel();
	    p6=new JPanel();
	    p7=new JPanel();
	    p8=new JPanel();
	    p9=new JPanel();
	    p10=new JPanel();
	    p11=new JPanel();
	    p12=new JPanel();
		

	    JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,1));
		top.setBackground(Color.BLUE);
		JLabel ff = new JLabel("facebook");
		ff.setFont(new Font("Thoma",Font.BOLD, 30));
	    ff.setForeground(Color.WHITE);
		top.add(ff);
		f.add(top, BorderLayout.NORTH);
		
	    
	    
		l1 = new JLabel("Email or Phone");
	    t1=new JTextField(15);    
	    l2 = new JLabel("Password");
	    pass1 = new JPasswordField(15);
	    JButton button=new JButton("Log in");
	    button.setBackground(Color.green);
	    p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(pass1);
		p1.add(button);
		p1.setBackground(Color.BLUE);
		top.add(p1);
		
	    
	    l3=new JLabel("Create a New Account");
	    l3.setFont(new Font("Serif",Font.BOLD, 30));
	    l3.setForeground(Color.BLUE);
	    p2.add(l3);
	    
	    t2=new JTextField("First Name",15);
	    t3=new JTextField("Surname", 15);
	    p3.add(t2);
		p3.add(t3);
	    
	    t4=new JTextField("Enter Email Address or Phone Number", 25);
	    p4.add(t4);
	    
	    t5=new JTextField("Re enter Email Address or Phone Number", 25);
	    p5.add(t5);
	    
	    pass2=new JPasswordField("Password",20);
	    p6.add(pass2);
	    
	    l4=new JLabel("Birthday");
	    l4.setFont(new Font("Serif",Font.BOLD, 30));
	    l4.setForeground(Color.BLACK);
	    p7.add(l4);
	    
	    cmb1= new JComboBox(day);
	    cmb2= new JComboBox(month);
	    cmb3= new JComboBox(year);
	    p8.add(cmb1);
		p8.add(cmb2);
		p8.add(cmb3);
		
	    
	    JRadioButton r1=new JRadioButton("Male");    
	    JRadioButton r2=new JRadioButton("Female"); 
	    p9.add(r1);
		p9.add(r2);
		
	    ButtonGroup bg=new ButtonGroup();    
	    bg.add(r1);
	    bg.add(r2);
	    
	    JButton button2=new JButton("Create Account");
	    button2.setFont(new Font("Serif",Font.BOLD, 12));
	    button2.setBackground(Color.green);
	    p10.add(button2);
	    
	    JButton clickButton = new JButton("Sign up");
	    p12.add(clickButton);
	    
	    JPanel rightFull = new JPanel();
	    rightFull.setLayout(new GridLayout(11,0));
	    rightFull.add(p1);
	    rightFull.add(p2);
	    rightFull.add(p3);
	    rightFull.add(p4);
	    rightFull.add(p5);
	    rightFull.add(p6);
	    rightFull.add(p7);
	    rightFull.add(p8);
	    rightFull.add(p9);
	    rightFull.add(p10);
	    rightFull.add(p12);
	    f.add(rightFull, BorderLayout.EAST);
	    
//	    BufferedImage myPicture = ImageIO.read(new File("fb_shortCut.PNG"));
//	    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//	    f.add(picLabel,BorderLayout.WEST);
//	    
	    
	    
	    
	    clickButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String []str=new String[20];
				str[0] = t1.getText();  											 //email
				str[1] = pass1.getText();										 	 // login password
				
				str[2] = checkName(t2.getText());  											 //firstName
				str[3] = checkName(t3.getText());    										 //Surname
				str[4] = checkMail(t4.getText());											 //new email or phone
				str[5] = checkMail(t5.getText());											 //re entersd email;
				str[6] = pass2.getText();  										 // new password
				str[7] = cmb1.getSelectedItem().toString();
				str[8] = cmb2.getSelectedItem().toString();
				str[9] = cmb3.getSelectedItem().toString();
				int day = Integer.parseInt(str[7]);
				int year = Integer.parseInt(str[9]);
				int m = 0;
				if(str[8] == "January")
					m=1;
				else if(str[8] == "February")
					m=2;
				else if(str[8] == "March")
					m=3;
				else if(str[8] == "April")
					m=4;
				else if(str[8] == "May")
					m=5;
				else if(str[8]=="June")
					m=6;
				else if(str[8]=="July")
					m=7;
				else if(str[8]=="August")
					m=8;
				else if(str[8]=="September")
					m=9;
				else if(str[8]=="October")
					m=10;
				else if(str[8]=="November")
					m=11;
				else if(str[8]=="December")
					m=12;
				try{
					str[10]=getAge(day,m, year);
				}catch(Exception e){
					System.out.println("Month must be selected.");
				}
				
				FacebookDatabase fd  = new FacebookDatabase();
				//fd.createNewDatabase();
				//fd.createNewTable();
				fd.insert(str[4], str[6], str[2], str[3], str[7]+ "/" + str[8]+ "/" +str[9],  str[10] );
				
				
				
				
				JOptionPane.showMessageDialog(null, "Login email address is  "+str[0]+"\n"+"Login password is  "+str[1]+"\n" + "First Name is  "+str[2]+"\n"+"Surname is  "+str[3]+"\n"+"New entered Email address  "+str[4]+"\n"+"Re-entered Email address  "+ str[5] + "\n" +"New entered password  "+str[6]+"\n" +"Birthday is  " + str[7]+ "/" + str[8] + "/" + str[9]+"Age is : "+str[10]);
				
				f.setVisible(false);
				SecondFrame f2=new SecondFrame();
				f2.getSecondFrame(str);
				
			}
		});


		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public String getAge(int day, int month, int year) {

		
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(year, month, day);
		Period p = Period.between(birthday, today);
		int d = p.getDays();
		int m = p.getMonths();
		int y = p.getYears();
		String dayString = Integer.toString(d);
		String monthString = Integer.toString(m);
		String yearString = Integer.toString(y);

		String res = yearString+" year "+monthString+" month "+dayString+" day ";
		return res;

	}

	public String checkName(String name) {

		String line = name;
		String pattern =  "^[A-Z][a-zA-Z ]*$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);

		if (m.matches())
			return name;

		else {
			JOptionPane.showMessageDialog(null, "Name is not valid");
			return null;
		}

	}
	public String checkMail(String mail) {

		String email = "^[a-z][a-z0-9_\\s.]*@[a-z]*.com$";
		String phone = "01[5-9]\\d{8}";
		Pattern r = Pattern.compile(email);
		Pattern r1 = Pattern.compile(phone);
		Matcher m = r.matcher(mail);
		Matcher m1 =  r1.matcher(mail);
		if (m.matches())
			return mail;
		else if(m1.matches())
			return mail;

		else {
			JOptionPane.showMessageDialog(null,"Email or phone Is Not Valid");
			return null;
		}

	}

}

