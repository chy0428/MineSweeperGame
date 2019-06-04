package JavaProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIInputRanking implements ActionListener{
   JFrame frame = new JFrame("== Input Username ==");

   float scores;
   String users;
   int levels;
   JTextField userText;
   JButton btnNewButton;
   
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
      userText.setBounds(100, 150, 120, 30);
      frame.getContentPane().add(userText);
      
      btnNewButton = new JButton("Enter");
      btnNewButton.setBounds(250, 150, 70, 30);
      frame.getContentPane().add(btnNewButton);
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
   }
}