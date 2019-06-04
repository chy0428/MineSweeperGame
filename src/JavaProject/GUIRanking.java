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
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel_1;
	
	public GUIRanking(JPanel contentPane) {
		setBackground(Color.LIGHT_GRAY);
		this.contentPane = contentPane;
		initUI();
	}
	
	private void initUI() {
		setPreferredSize(new Dimension(500, 500));
		setLayout(null);
		
		btnBeginner = new JButton("Beginner");
		btnBeginner.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		btnBeginner.setBounds(169, 154, 153, 49);
		add(btnBeginner);
		
		btnIntermediate = new JButton("Intermediate");
		btnIntermediate.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		btnIntermediate.setBounds(169, 225, 153, 49);
		add(btnIntermediate);
		
		btnAdvanced = new JButton("Advanced");
		btnAdvanced.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		btnAdvanced.setBounds(169, 297, 153, 49);
		add(btnAdvanced);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		btnBack.setBounds(169, 368, 153, 49);
		add(btnBack);
		
		btnBeginner.addActionListener(this);
		btnIntermediate.addActionListener(this);
		btnAdvanced.addActionListener(this);
		btnBack.addActionListener(this);
		
		lblNewLabel = new JLabel("Select Ranking");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 502, 141);
		add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 39));
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 500, 500);
		add(layeredPane);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/hayeong/eclipse-workspace/JavaProject/MineSweeper.jpeg"));
		lblNewLabel_1.setBounds(-115, -99, 649, 616);
		layeredPane.add(lblNewLabel_1);
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
