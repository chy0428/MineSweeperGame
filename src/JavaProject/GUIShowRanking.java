package JavaProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GUIShowRanking extends JPanel implements ActionListener {
   JLabel lblNewLabel;
   JLabel[] lblUsers;
   JPanel contentPane;
   JButton btnBack;
   JButton btnMenu;
   //JButton testIO;
   
   String levels;
   int level;
      
   public GUIShowRanking(JPanel contentpane , int level) {
   	setBackground(Color.LIGHT_GRAY);
      this.contentPane = contentpane;
      this.level = level;
      if (level == 1) {levels = "beginner";}
      else if (level == 2) {levels = "Intermediate";}
      else if (level == 3) {levels = "Advanced";}
      initUI();
      
   }
   
   public void initUI() {
      GUIScoreIO scorelist = new GUIScoreIO(level);
      HashMap<String, Float> hm = new HashMap<String,Float> (scorelist.fileRead());
      System.out.println("Open! with level " + levels);
      
      lblUsers = new JLabel[hm.size()];
      
      Iterator <String> usrscore = hm.keySet().iterator();
      int i = 0;
      
      while (usrscore.hasNext()) {
         String usrname = usrscore.next();
         float scores = hm.get(usrname);
         String line = i+1 + ". " + usrname + " " + scores;
         System.out.println(line);
         
         if (line != null) {
            i += 1;
            lblUsers[i-1] = new JLabel(line);
         }
         
      }
      
      lblNewLabel = new JLabel(levels + " Top 3 Score");
      lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 25));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(105, 131, 288, 72);
      add(lblNewLabel);
      
      for (int k = 0; k < i; k++) {
         lblUsers[k].setHorizontalAlignment(SwingConstants.CENTER);
         lblUsers[k].setBounds(65, 60 + (k*20),157,16);
         add(lblUsers[k]);
      }
      
      setPreferredSize(new Dimension(500, 500));
      setLayout(null);
     
      
      btnBack = new JButton("Back");
      btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
      btnBack.setBounds(177, 235, 137, 49);
      add(btnBack);
      
      btnMenu = new JButton("Menu");
      btnMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
      btnMenu.setBounds(177, 296, 137, 49);
      add(btnMenu);
      
      //testIO.addActionListener(this);
      btnBack.addActionListener(this);
      btnMenu.addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent evt) {
      GUIRanking showBack = new GUIRanking(contentPane);
       contentPane.add(showBack, "levels");
       
       //GUIInputRanking ipRank = new GUIInputRanking(contentPane,this.level ,(float)20.52);
       //contentPane.add(ipRank, "inputs");
       
      Object src = evt.getSource();
      /*
      if (src == testIO) {
         CardLayout cardLayout = (CardLayout) contentPane.getLayout();
           cardLayout.show(contentPane, "inputs");
      }*/
      if (src == btnBack) {
         CardLayout cardLayout = (CardLayout) contentPane.getLayout();
           cardLayout.show(contentPane, "levels");
      }
      else if (src == btnMenu) {
         CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Main");
      }
   }
   
   
}