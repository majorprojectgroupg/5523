package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AdminFrameBasicDemo extends JFrame {
	
	public AdminFrameBasicDemo() {
		super("Medical Survey Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		
		addWidgets();		
		this.setLocationRelativeTo(null);
	}
	
	private void addWidgets() {
		JMenuBar jmbAdmin = new JMenuBar();
		JMenu jmQuest = new JMenu("Questionnaire");
		JMenu jmRes = new JMenu("Results");
		
		JPanel jpEditor = new JPanel();		
		
		jmQuest.add(new JMenuItem("New"));
		jmQuest.add(new JMenuItem("Open"));
		jmQuest.add(new JMenuItem("Save"));
		jmQuest.add(new JMenuItem("Upload to tablet"));		
						
		jmRes.add(new JMenuItem("Open"));
		jmRes.add(new JMenuItem("Save as"));
		jmRes.add(new JMenuItem("Import"));		
		jmRes.add(new JMenuItem("Clear tablet"));
		
		jpEditor.setLayout(new BorderLayout());		
		jpEditor.add(new JLabel("File Name Here"), BorderLayout.NORTH);
		jpEditor.add(new JTextArea(), BorderLayout.CENTER);
		
		jmbAdmin.add(jmQuest);
		jmbAdmin.add(jmRes);
		jmbAdmin.add(new JMenuItem("Exit"));
		setJMenuBar(jmbAdmin);
		
		add(jpEditor);		
	}
	
}
