package JavaProject;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.*;

public class GUIBoard implements ActionListener { 

    JFrame frame = new JFrame("== Mine Sweeper Game =="); //프레임 위에 표시  
   // JButton reset = new JButton("> REPLAY <");
    JButton reset = new JButton("> REPLAY <"); 	//리플레이 가능   
    JButton[][] buttons ; 
    JButton[] flags;
    int[][] counts;
    Container grid = new Container(); 
    int MineNum = 0;
    int level = 0;
    final int MINE = 10;
    int num =0;
    
    private long start_time;
    private long end_time;

    public GUIBoard(int level) { 
     
     MineLevel(level);
     frame.setSize(500, 500); 
     frame.setLayout(new BorderLayout()); 
     frame.setLocationRelativeTo(null);
     
     frame.add(reset, BorderLayout.NORTH); 
     reset.addActionListener(this); 
     start_time = System.currentTimeMillis(); 
     
     //Grid of Buttons 
     
     for (int a = 0; a<buttons.length; a++) { 
    	 for (int b = 0; b < buttons[0].length; b++) { 
    		 buttons[a][b] = new JButton("▩"); //처음에 보여지는 지뢰 (이미지로 바꾸면 좋을듯 )  
    		 buttons[a][b].addActionListener(this); 
    		 buttons[a][b].addMouseListener(new MouseAdapter() { 
    		@Override 
        
        public void mousePressed(MouseEvent e) { 
         if (e.getButton() == MouseEvent.BUTTON3) { //오른쪽 마우스 버튼 
          mineFlagger(true); 
         } 
        } 
       }); 
       grid.add(buttons[a][b]); 
      } 
     } 
     frame.add(grid, BorderLayout.CENTER); 
     makeRandomMines(); 
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
     frame.setVisible(true); 
    } 
    
    public void MineLevel(int level) { // 새로 추가
    	if(level ==1) {
    		num = 10;
    		MineNum = 10;
    		grid.setLayout(new GridLayout(10,10)); 
    	}else if(level == 2) {
    		num = 15;
    		MineNum = 25;
    		grid.setLayout(new GridLayout(15,15)); 
    	}else if(level == 3) {
    		num = 20;
    		MineNum = 40;
    		grid.setLayout(new GridLayout(20,20)); 
    	}
    	buttons = new JButton[num][num];
		flags = new JButton[num]; 
		counts = new int[num][num]; 
    }
    
    public void setCount(int num) { // 새로 추가
    	counts = new int[num][num]; 
    }
        
    public void mineFlagger (boolean flag){ 
     for (int i = 0; i < buttons.length; i++) { 
      for (int j = 0; j < buttons[0].length; j++) { 
       if(flag == true) { 
        buttons[i][j].setText("F"); 
       } 
      } 
     } 
    } 

    public void makeRandomMines() { 
     //initializes list of random pairs 
     ArrayList<Integer> list = new ArrayList<Integer>(); 
     for (int x = 0; x < counts.length; x++) { 
      for (int y = 0; y < counts[0].length; y++) { 
       list.add(x * 100 + y);//changed y to x 
      } 
     } 
     //resets the counts in case reset button is pressed & picks random mines 
     setCount(num);
     for (int i = 0; i < MineNum; i++) { 
      int choice = (int) (Math.random() * list.size()); 
      counts[list.get(choice)/100][list.get(choice) % 100] = MINE; 
      list.remove(choice); 
     } 
     //neighbor counts(how many mines are touching this square.) 
     for (int x = 0; x < counts.length; x++) { 
      for (int y = 0; y < counts[0].length; y++) { 
       int neighborCount = 0; 
       if (counts[x][y] != MINE) { 
        if(x > 0 && y > 0 && counts[x - 1][y - 1] == MINE) { //a mine is up & left 
         neighborCount++;
        } 
        if(y > 0 && counts[x][y - 1] == MINE) { //a mine is up 
         neighborCount++; 
        } 
        if(x < counts.length - 1 && y > 0 && counts[x + 1][y - 1] == MINE) { // a mine is left 
         neighborCount++; 
        } 
        if(x > 0 && counts[x - 1][y] == MINE) { //left 
         neighborCount++; 
        } 
        if(x < counts.length - 1 && counts[x + 1][y] == MINE) { //mine is right 
         neighborCount++; 
        } 
        if(x > 0 && y < counts[0].length - 1 && counts[x - 1][y + 1] == MINE) { //mine is down 
         neighborCount++; 
        } 
        if(y < counts[0].length - 1 && counts[x][y + 1]== MINE) {//mine is up right 
         neighborCount++; 
        } 
        if(x < counts[0].length - 1 && y < counts[0].length - 1 && counts[x + 1][y + 1]== MINE) {//mine is down left 
         neighborCount++; 
        } 
        counts[x][y] = neighborCount; 
       } 
      } 
     } 
    } 

    public void lostGame() { 
     for (int x = 0; x < buttons.length; x++) { 
      for (int y = 0; y < buttons[0].length; y++) { 
       if (buttons[x][y].isEnabled()) { 
        if (counts[x][y] != MINE) { 
         buttons[x][y].setText(counts[x][y] + ""); 
         buttons[x][y].setEnabled(false); 
        } 
        else { 
         buttons[x][y].setText("X"); 
         buttons[x][y].setEnabled(false); 
        } 
       } 
      } 
     } 
     JOptionPane.showMessageDialog(null, "You Lose!\n" + "You clicked on a mine!", "BOOM!", JOptionPane.INFORMATION_MESSAGE); 
     end_time = System.currentTimeMillis();
     System.out.println((float)(end_time - start_time)/1000);
    } 

    public void checkWin() { 
     boolean winner = true; 

     for (int x = 0; x < counts.length; x++) { 
      for (int y = 0; y < counts[0].length; y++) { 
       if (counts[x][y] != MINE && buttons[x][y].isEnabled()) { 
        winner = false; 
       } 
      } 
     } 
     if (winner == true) { 
      JOptionPane.showMessageDialog(frame, "You win!"); 
      end_time = System.currentTimeMillis();
      System.out.println((float)(end_time - start_time)/1000);
     } 
    } 

    public void zeroCleaner(ArrayList<Integer> toClear) { 
     if (toClear.size() == 0) { 
      return; 
     } 
     else { 
      int x = toClear.get(0)/100; 
      int y = toClear.get(0) % 100; 
      toClear.remove(0); 
      if(x > 0 && y > 0 && buttons[x-1][y-1].isEnabled()) { //up and left 
       buttons[x - 1][y - 1].setText(counts[x-1][y-1] + ""); 
       buttons[x - 1][y - 1].setEnabled(false); 
       if (counts[x - 1][y - 1] == 0) { 
        toClear.add((x-1) * 100 + (y-1)); 
       } 
      } 
      if (y > 0 && buttons[x][y-1].isEnabled()) { // up 
       buttons[x][y - 1].setText(counts[x][y-1] + ""); 
       buttons[x][y - 1].setEnabled(false); 
       if (counts[x][y - 1] == 0) { 
        toClear.add(x * 100+(y - 1)); 
       } 
      } 
      if (x < counts.length - 1 && y > 0 && buttons[x+1][y-1].isEnabled()) { //up right 
       buttons[x + 1][y - 1].setText(counts[x+1][y-1] + ""); 
       buttons[x + 1][y - 1].setEnabled(false); 
       if (counts[x + 1][y - 1] == 0) { 
        toClear.add((x + 1)*100+(y - 1)); 
       } 
      } 
      if(x > 0 && y > 0 && buttons[x-1][y].isEnabled()) { //left 
       buttons[x - 1][y].setText(counts[x-1][y] + ""); 
       buttons[x - 1][y].setEnabled(false); 
       if (counts[x-1][y] == 0) { 
        toClear.add((x-1)*100+y); 
       } 
      } 
      if (x < counts.length - 1 && buttons[x+1][y].isEnabled()) { //right 
       buttons[x + 1][y].setText(counts[x+1][y] + ""); 
       buttons[x + 1][y].setEnabled(false); 
       if (counts[x + 1][y] == 0) { 
        toClear.add((x + 1)*100+y); 
       } 
      } 
      if(x > 0 && y < counts[0].length - 1 && buttons[x-1][y+1].isEnabled()) { //down and left 
       buttons[x - 1][y + 1].setText(counts[x-1][y+1] + ""); 
       buttons[x - 1][y + 1].setEnabled(false); 
       if (counts[x-1][y+1] == 0) { 
        toClear.add((x-1)*100+(y+1)); 
       } 
      } 
      if (y < counts[0].length - 1 && buttons[x][y+1].isEnabled()) { // down 
       buttons[x][y + 1].setText(counts[x][y+1] + ""); 
       buttons[x][y + 1].setEnabled(false); 
       if (counts[x][y + 1] == 0) { 
        toClear.add(x * 100+(y + 1)); 
       } 
      } 
      if (x < counts.length - 1 && y < counts[0].length - 1 && buttons[x+1][y+1].isEnabled()) { //down right 
       buttons[x + 1][y + 1].setText(counts[x+1][y+1] + ""); 
       buttons[x + 1][y + 1].setEnabled(false); 
       if (counts[x + 1][y + 1] == 0) { 
        toClear.add((x + 1)*100+(y + 1)); 
       } 
      } 
      zeroCleaner(toClear); 
     } 
    } 

    @Override 
    public void actionPerformed(ActionEvent event) { 
     if(event.getSource().equals(reset)) { 
     //Resets the playing field 
    	 
    	 start_time = System.currentTimeMillis();
    	 
      for (int x = 0; x < buttons.length; x++) { 
       for (int y = 0; y < buttons[0].length; y++) { 
        buttons[x][y].setEnabled(true); 
        buttons[x][y].setText("▒"); 
       } 
      } 
      makeRandomMines(); 
     } 
     else { 
      for (int x = 0; x < buttons.length ; x++) { 
       for (int y = 0; y < buttons[0].length; y++) { 
        if(event.getSource().equals(buttons[x][y])) { 
         if (counts[x][y]== MINE) { 
          lostGame(); 
         } 
         else if(counts[x][y] == 0) { 
          buttons[x][y].setText(counts[x][y]+ ""); 
          buttons[x][y].setEnabled(false); 
          ArrayList<Integer> toClear = new ArrayList<>(); 
          toClear.add(x*100+y); 
          zeroCleaner(toClear); 
          checkWin(); 
         } 
         else { 
          buttons[x][y].setText(counts[x][y]+ ""); 
          buttons[x][y].setEnabled(false); 
          checkWin(); 
         } 
        } 
       } 
      } 
     } 
    } 
}