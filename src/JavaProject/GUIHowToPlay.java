package JavaProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIHowToPlay extends JPanel implements ActionListener{
	JLabel lblNewLabel;
	JButton btnNewButton;
	private JPanel contentPane;
	public GUIHowToPlay(JPanel contentPane) {
		this.contentPane = contentPane;
		setBackground(Color.LIGHT_GRAY);
		initUI();
	}
	
	public void initUI() {
		setPreferredSize(new Dimension(500, 500));
		setLayout(null);
			
		JLabel lblNewLabel = new JLabel("How To Play");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(61, 25, 375, 50);
		add(lblNewLabel);
		setLayout(null);
		
		JTextArea txtrMinesweeperProgramHas = new JTextArea();
		txtrMinesweeperProgramHas.setBackground(Color.LIGHT_GRAY);
		txtrMinesweeperProgramHas.setFont(new Font("Nanum Gothic", Font.PLAIN, 15));
		txtrMinesweeperProgramHas.setText("Minesweeper program has 3 steps, Beginner, Intermediate, Advanced. \nEach box can contain numbers, spaces, and mines. \nWhen you choose a mine, the game ends with your lose. \nThe goal is to click on the rest except for land mines, \nand if you think you have a land mine, you can flag it up. \nSince there are a number of land mines in the remaining blanks \nsurrounding the numbers displayed above the boxes you clicked on, \nyou have to guess them along with the surrounding numbers. \nIf you find all the blanks except mines, the game ends with your wins.");
		txtrMinesweeperProgramHas.setBounds(18, 98, 476, 176);
		add(txtrMinesweeperProgramHas);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/hayeong/Documents/imagen-minesweeper-0thumb.png"));
		lblNewLabel_1.setBounds(277, 275, 197, 200);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setBounds(29, 406, 138, 42);
		add(btnNewButton);
		btnNewButton.addActionListener(this);
	}

		public void actionPerformed(ActionEvent evt) {
			Object src = evt.getSource();
			if (src == btnNewButton) {
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	            cardLayout.show(contentPane, "Main");
		 	}       	
		}
	
}