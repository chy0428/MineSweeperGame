package JavaProject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class GUIGameWindow extends JFrame{
	
	private JPanel contentPane = new JPanel();
	
	private GUILevelSelectMenu LSMPanel;
	private GUIMainMenu mainPanel;
	private GUIRanking rnkPanel;//Ranking 표시를 위한 선언 1
	private GUIHowToPlay manualPanel;//manual 보여줄것  
	
	private JLabel statusbar;
	
	//panel 
	public GUIGameWindow() {
		
		mainPanel = new GUIMainMenu(contentPane);
		mainPanel.setBackground(Color.DARK_GRAY);
		LSMPanel = new GUILevelSelectMenu(contentPane);
		manualPanel = new GUIHowToPlay(contentPane);
		
		contentPane.setLayout(new CardLayout());
		contentPane.add(mainPanel, "Main");
		contentPane.add(LSMPanel, "LevelSelect");
		contentPane.add(manualPanel, "HowToPlay");
		rnkPanel = new GUIRanking(contentPane);//Ranking 표시를 위한 선언 2
		contentPane.add(rnkPanel, "Ranking"); //Ranking 표시를 위한 선언 3
		
		initUI();
	}
	
	private void initUI() {
		setPreferredSize(new Dimension(500, 500));

        statusbar = new JLabel("");
        getContentPane().add(statusbar, BorderLayout.SOUTH);
        getContentPane().add(contentPane);

        setResizable(true);
        pack();

        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUIGameWindow ex = new GUIGameWindow();
            ex.setVisible(true);
        });
    }
}