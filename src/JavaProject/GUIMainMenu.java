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
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;

public class GUIMainMenu extends JPanel implements ActionListener{
	
	JLabel lblNewLabel;
	JButton btnGameStart;
	JButton btnHowToPlay;
	JButton btnRanking;
	JButton btnExit;
	
	JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	
	public GUIMainMenu(JPanel contentPane) {
		this.contentPane = contentPane;
		initUI();
	}
	
	private void initUI() {
		
		setPreferredSize(new Dimension(500, 500));
		setLayout(null);
		
		btnGameStart = new JButton("Game Start");
		btnGameStart.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		btnGameStart.setBounds(169, 154, 153, 49);
		add(btnGameStart);
		
		btnHowToPlay = new JButton("How To Play");
		btnHowToPlay.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		btnHowToPlay.setBounds(169, 225, 153, 49);
		add(btnHowToPlay);
		
		btnRanking = new JButton("Ranking");
		btnRanking.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		btnRanking.setBounds(169, 297, 153, 49);
		add(btnRanking);
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setBounds(169, 368, 153, 49);
		add(btnExit);
		
		btnGameStart.addActionListener(this);
		btnHowToPlay.addActionListener(this);
		btnRanking.addActionListener(this);
		btnExit.addActionListener(this);
		
		lblNewLabel = new JLabel("Mine Sweeper Game");
		lblNewLabel.setBounds(0, 0, 500, 126);
		add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.setBounds(0, 0, 500, 500);
		add(layeredPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		setOpaque(true);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/hayeong/eclipse-workspace/JavaProject/MineSweeper.jpeg"));
		lblNewLabel_1.setBounds(-115, -99, 649, 616);
		layeredPane.add(lblNewLabel_1);
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