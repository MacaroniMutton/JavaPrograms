package bank.management.system;

import javax.swing.*;

public class Login extends JFrame {
	
	Login() {
		
		setTitle("AUTOMATED TELLER MACHINE");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/icons/logo.jpg"));
		JLabel label = new JLabel(i1);
		add(label);
		
		setSize(800, 480);
		setVisible(true);
		setLocation(350, 200);
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
