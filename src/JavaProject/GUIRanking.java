package JavaProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIRanking extends JPanel implements ActionListener{
	JLabel lblNewLabel;
	JButton btnBeginner;
	JButton btnIntermediate;
	JButton btnAdvanced ;
	JPanel contentPane;
	JButton btnBack;
	
	private GUIShowRanking showRnk;
	
	public GUIRanking(JPanel contentPane) {
		this.contentPane = contentPane;
		initUI();
	}
	
	private void initUI() {
		setPreferredSize(new Dimension(500, 500));
		setLayout(null);
		
		lblNewLabel = new JLabel("Select Level");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(189, 119, 117, 16);
		add(lblNewLabel);
		
		btnBeginner = new JButton("Beginner");
		btnBeginner.setBounds(189, 166, 117, 29);
		add(btnBeginner);
		
		btnIntermediate = new JButton("Intermediate");
		btnIntermediate.setBounds(189, 221, 117, 29);
		add(btnIntermediate);
		
		btnAdvanced = new JButton("Advanced");
		btnAdvanced.setBounds(189, 272, 117, 29);
		add(btnAdvanced);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(189, 321, 117, 29);
		add(btnBack);
		
		btnBeginner.addActionListener(this);
		btnIntermediate.addActionListener(this);
		btnAdvanced.addActionListener(this);
		btnBack.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		int level =0;
			    
	    if (src == btnBeginner) {
	    	level = 1;
	    	listup(level);
	    	System.out.println("Beginner!");
	 
	    } else if (src == btnIntermediate) {
	    	level = 2;
	    	listup(level);
	    	System.out.println("Intermediate!");
	    	
	    }else if (src == btnAdvanced) {
	    	level = 3;
	    	listup(level);
	    	System.out.println("Advanced");
	    	
	 	}else if (src == btnBack) {
	 		CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Main");
	 	}	
	}
	
	public void listup(int lv) {
		showRnk = new GUIShowRanking(contentPane,lv);
	    contentPane.add(showRnk, "list");
	    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        cardLayout.show(contentPane, "list");
	}
}
