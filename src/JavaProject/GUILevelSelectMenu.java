package JavaProject;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GUILevelSelectMenu extends JPanel implements ActionListener{
	JLabel lblNewLabel;
	JButton btnBeginner;
	JButton btnIntermediate;
	JButton btnAdvanced ;
	JPanel contentPane;
	JButton btnBack;
	GUIBoard BoardPanel;
	public GUILevelSelectMenu(JPanel contentPane) {
		this.contentPane = contentPane;
		initUI();
	}
	
	private void initUI() {
		setPreferredSize(new Dimension(500, 500));
		setLayout(null);
		
		lblNewLabel = new JLabel("Select Level");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(194, 86, 117, 16);
		add(lblNewLabel);
		
		btnBeginner = new JButton("Beginner");
		btnBeginner.setBounds(194, 145, 117, 29);
		add(btnBeginner);
		
		btnIntermediate = new JButton("Intermediate");
		btnIntermediate.setBounds(194, 214, 117, 29);
		add(btnIntermediate);
		
		btnAdvanced = new JButton("Advanced");
		btnAdvanced.setBounds(194, 286, 117, 29);
		add(btnAdvanced);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(194, 369, 117, 29);
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
	    	play(level);   	
	    	System.out.println("Beginner!");
	      
	    } else if (src == btnIntermediate) {
	    	level = 2;
	    	play(level);
	    	System.out.println("Intermediate!");
	    	
	    }else if (src == btnAdvanced) {
	    	level = 3;
	    	play(level);
	    	System.out.println("Advanced");

	 	}else if (src == btnBack) {
        	CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Main");
	 	}       	
	}
	public void play(int level) {
		EventQueue.invokeLater(() -> {
	
	       GUIBoard board = new GUIBoard(level);
	       
	    });

	}
}




	