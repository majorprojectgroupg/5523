package ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDemo extends JFrame {

	JButton jpButton;
	
	public LoginDemo() {
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setMinimumSize(new Dimension(300, 300));
		setPreferredSize(new Dimension(300, 300));
		setLayout(new GridLayout(4, 1));
		
		addWidgets();
		addEvents();
		this.setLocationRelativeTo(null);
	}
	
	private void addWidgets() {
		JPanel jpTitle = new JPanel();
		JPanel jpName = new JPanel();
		JPanel jpPassword = new JPanel();
		JPanel jpButtons = new JPanel();
		
		jpButton = new JButton("Cancel");
		
		jpTitle.add(new JLabel("Medical Survey Generator"));
		jpName.add(new JLabel("Name"));
		jpName.add(new JTextField(10));
		jpPassword.add(new JLabel("Password"));
		jpPassword.add(new JPasswordField(10));
		jpButtons.add(jpButton);
		jpButtons.add(new JButton("OK"));
			
		add(jpTitle);
		add(jpName);
		add(jpPassword);
		add(jpButtons);
	}
	
	private void addEvents() {
		jpButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {				
				dispose();
			}
			
		});
	}
	
}
