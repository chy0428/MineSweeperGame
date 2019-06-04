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
import java.awt.Font;
import java.awt.Color;

public class GUILevelSelectMenu extends JPanel implements ActionListener{
   JButton btnBeginner;
   JButton btnIntermediate;
   JButton btnAdvanced ;
   JPanel contentPane;
   JButton btnBack;
   GUIBoard BoardPanel;
   private JLabel label;
   public GUILevelSelectMenu(JPanel contentPane) {
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
      
      label = new JLabel("Select Level");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 34));
      label.setBounds(113, 61, 273, 49);
      add(label);
      
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
         CardLayout cardLayout = (CardLayout) contentPane.getLayout(); 
            cardLayout.show(contentPane, "Main");
       });

   }
}