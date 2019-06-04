package JavaProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIInputRanking extends JPanel implements ActionListener{
	JPanel contentPane;
	JButton btnInput;
	float scores;
	String users;
	int levels;
	JTextField userText;
	
	public GUIInputRanking(JPanel contentpane, int levels, float score) {
		this.contentPane = contentpane;
		this.scores = score;
		this.levels = levels;
		initUI();
	}
	
	public void initUI() {
		
		setPreferredSize(new Dimension(500, 500));
		setLayout(null);
		
		userText = new JTextField(16);
		
		userText.setBounds(190,199,117,29);
		add(userText);
		
		btnInput = new JButton ("Test");
		btnInput.setBounds(190, 266, 117, 29);
		add(btnInput);
		
		btnInput.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		GUIRanking showBack = new GUIRanking(contentPane);
	    contentPane.add(showBack, "levels");
	    
		Object src = evt.getSource();
		
		if (src == btnInput) {
			users = userText.getText();
			GUIScoreIO sc = new GUIScoreIO(levels);
			sc.saveScore(sc.fileRead(), users, scores);
			
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	        cardLayout.show(contentPane, "levels");
		}
	}
}
