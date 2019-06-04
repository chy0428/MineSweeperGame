package JavaProject;

import java.util.Scanner;

public class CommandMenu {
	public void showMenu() {
        System.out.println("== MineSweeper Game ==");
        System.out.println("1. Play");
        System.out.println("2. How to Play");
        System.out.println("3. Ranking");
        System.out.println("4. Exit");
        System.out.println("=======================");
     }//showmenu
     
    /*** 메뉴얼 ***/
    public void howToPlay(){//메뉴얼 
       System.out.println("=========================== Manual ===================================");
       System.out.println("Minesweeper program has 3 steps, Beginner, Intermediate, Advanced.");
       System.out.println("Each box can contain numbers, spaces, and mines.");
       System.out.println("When you choose a mine, the game ends with your lose.");
       System.out.println("The goal is to click on the rest except for land mines,");
        System.out.println("and if you think you have a land mine, you can flag it up.");
        System.out.println("Since there are a number of land mines in the remaining blanks");
        System.out.println("surrounding the numbers displayed above the boxes you clicked on,");
        System.out.println("you have to guess them along with the surrounding numbers.");
        System.out.println("If you find all the blanks except mines, the game ends with your wins.");
       System.out.println("=======================================================================");
    }//howToPlay
    
    public void Select_level(int level) {
    	CommandPlay play;
    	CommandAnswerBoard answerboard;
    	CommandOutputBoard outputboard;
        Scanner keyboard = new Scanner(System.in);
        int mx; int my; int mm;
        
        if (level == 1) { //초급선택시 10 by 10 지뢰 10개 
           mx = 10;
           my = 10;
           mm = 10;
        }
        else if (level == 2) { //중급 선택 시 20 by 20 지뢰 20개
           mx = 20;
           my = 20;
           mm = 20;
        }
        else if (level == 3 ) {//고급 선택 시 30 by 30 지뢰 30개
           mx = 30;
           my = 30;
           mm = 30;
        }
        else {
           System.out.print("Please input x size Board ");
           mx = keyboard.nextInt();
           System.out.print("Please input y size Board ");
           my = keyboard.nextInt();
           System.out.print("Please input number of mines ");
           mm = keyboard.nextInt();
        }
     
        answerboard = new CommandAnswerBoard(mx,my,mm);
        outputboard = new CommandOutputBoard(mx,my);
        //for test
        answerboard.print();
        System.out.println();
        outputboard.print();
        
        play = new CommandPlay(answerboard,outputboard,level);
        play.playGame();
        
     
    }
}