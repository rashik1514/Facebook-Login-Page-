package loginPage;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SecondFrame {

	public static int count = 0;
	//String []information=new String[100];
	public static String [][]information2=new String[10][9];
	String columName[]={"firstName", "surname", "email", "loginPassword", "newEmail", "reEnteredEmail", "newPassword","Birthady","Age"};
	
	public void getSecondFrame(String[] str) {
		
		JFrame mainFrame = new JFrame();
		mainFrame.setSize( 800, 500);
		mainFrame.setLayout(new FlowLayout());
		JLabel firstName, surname, email, loginPassword, newEmail, reEnteredEmail, newPassword, day, month, year,
				gender, birthday,age;
		email = new JLabel(str[0]);
		loginPassword = new JLabel(str[1]);
		firstName = new JLabel(str[2]);
		surname = new JLabel( str[3]);
		newEmail = new JLabel(str[4]);
		reEnteredEmail = new JLabel(str[5]);
		newPassword = new JLabel(str[6]);
		birthday = new JLabel( str[7] + "/" + str[8] + "/" + str[9]);
		age=new JLabel(str[10]);
		
		
		information2 [count][0]=firstName.getText();
//		information2 [count][1]=loginPassword.getText();
		information2 [count][1]=surname.getText();
		information2 [count][2]=email.getText();
//		information2 [count][3]=surname.getText();
		information2 [count][3]=loginPassword.getText();  
		information2 [count][4]=newEmail.getText();
		information2 [count][5]=reEnteredEmail.getText();
		information2 [count][6]=newPassword.getText();
		information2 [count][7]=birthday.getText();
		information2 [count][8]=age.getText();
		count+=1;
		
		//mainFrame.add(sp);
		
		mainFrame.add(email);
		mainFrame.add(loginPassword);
		mainFrame.add(firstName);
		mainFrame.add(surname);
		mainFrame.add(newEmail);
		mainFrame.add(reEnteredEmail);
		mainFrame.add(newPassword);
		mainFrame.add(birthday);
		mainFrame.add(age);
		
		//mainFrame.add(t);

		mainFrame.setVisible(true);
		JButton clickButton = new JButton("Create a new account");
		JButton exitButton=new JButton("exit");
		clickButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				mainFrame.setVisible(false);
				FirstFrame f1 = new FirstFrame();
				//f1.getFirstFrame();
				

			}
		});
		
		
		
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable jt=new JTable(information2, columName);
				jt.setBounds(50,40,100,200);
				//jt.setBounds(30, 30, 300, 300);
				for(int i=0; i<count; i++){
					jt.addRowSelectionInterval(i, count);
					JScrollPane sp=new JScrollPane(jt);
					mainFrame.add(sp);
				}
							
				mainFrame.setVisible(true);
				
			}
		});
		mainFrame.add(clickButton);
		mainFrame.add(exitButton);
		

		// email.setText("Login email address is "+str[0]);
	}

}
