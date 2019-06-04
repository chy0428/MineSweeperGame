package JavaProject;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMainMenu extends JPanel implements ActionListener{
	
	JLabel lblNewLabel;
	JButton btnGameStart;
	JButton btnHowToPlay;
	JButton btnRanking;
	JButton btnExit;
	
	JPanel contentPane;
	
	public GUIMainMenu(JPanel contentPane) {
		this.contentPane = contentPane;
		initUI();
	}
	
	private void initUI() {
		
		setPreferredSize(new Dimension(500, 500));
		setLayout(null);
		
		lblNewLabel = new JLabel("Mine Sweeper");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(193, 60, 111, 30);
		add(lblNewLabel);
		
		btnGameStart = new JButton("Game Start");
		btnGameStart.setBounds(193, 140, 117, 29);
		add(btnGameStart);
		
		btnHowToPlay = new JButton("How To Play");
		btnHowToPlay.setBounds(193, 196, 117, 29);
		add(btnHowToPlay);
		
		btnRanking = new JButton("Ranking");
		btnRanking.setBounds(193, 258, 117, 29);
		add(btnRanking);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(193, 324, 117, 29);
		add(btnExit);
		
		btnGameStart.addActionListener(this);
		btnHowToPlay.addActionListener(this);
		btnRanking.addActionListener(this);
		btnExit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
	    Object src = evt.getSource();
	    if (src == btnGameStart) {
	    	
	    	CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "LevelSelect");
	      
	    } else if (src == btnHowToPlay) {
	    	CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "HowToPlay");
	    	System.out.println("HowToPlay!");
	    	
	    }else if (src == btnRanking) { //Ranking 프레임으로 변경
	    	
	    	CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Ranking");
	    	System.out.println("Ranking");
	    	
		}else if (src == btnExit) {
			System.exit(0);
		}
	    
	  }
}