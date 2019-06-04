package JavaProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIInputRanking extends JPanel implements ActionListener{
   JFrame frame = new JFrame("== Register Ranking ==");

   int levels;
   float scores;
   String users;
   JTextField userText;
   JButton btnNewButton;
   private JButton btnExit;
   private JPanel contentPane;
	
   public GUIInputRanking(int levels, float score) {
      this.scores = score;
      this.levels = levels;
      initUI();
      frame.setSize(500, 500);
      frame.setLocationRelativeTo(null);
   }
   
      
   public void initUI() {
      frame.getContentPane().setLayout(null);
   
      userText = new JTextField(16);
      userText.setBounds(80, 290, 199, 58);
      frame.getContentPane().add(userText);
      
      btnNewButton = new JButton("Register");
      btnNewButton.setBackground(SystemColor.textHighlight);
      btnNewButton.setBounds(281, 290, 117, 31);
      frame.getContentPane().add(btnNewButton);
      
      JLabel lblNewLabel = new JLabel("Winner!");
      lblNewLabel.setFont(new Font("Phosphate", Font.BOLD | Font.ITALIC, 96));
      lblNewLabel.setBounds(57, 70, 380, 110);
      frame.getContentPane().add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("Enter your ID to register for the rankings.");
      lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
      lblNewLabel_1.setBounds(92, 238, 325, 27);
      frame.getContentPane().add(lblNewLabel_1);
      
      btnExit = new JButton("Exit");
      btnExit.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Main");
      	}
      });
			
      btnExit.setBounds(281, 319, 117, 29);
      frame.getContentPane().add(btnExit);
      frame.setVisible(true);
      btnNewButton.addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent evt) {
      Object src = evt.getSource();
      if (src == btnNewButton) {
         users = userText.getText();
         GUIScoreIO sc = new GUIScoreIO(levels);
         sc.saveScore(sc.fileRead(), users, scores);
         frame.dispose();
      }
	if (src == btnExit) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	        cardLayout.show(contentPane, "Main");
		}
	}	
}