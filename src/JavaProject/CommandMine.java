package JavaProject;
import java.util.*;

public class CommandMine {
      
    	 public void CommandPlay(){
         CommandMenu menu = new CommandMenu();
         
         Scanner sc = new Scanner(System.in);
         int select = 0;
         int levelselect;
         
         while(!(select == 4)) {
        	 menu.showMenu();
	         System.out.print(" Select Menu >> ");
	         select = sc.nextInt();
	         
	         if(select == 1) {
	            System.out.println("Please Select level which you want to play");
	            System.out.println("beginner : 1, Intermediate : 2, Advanced : 3, Customize : else ");
	            //레벨 선택  
	        
	            levelselect = sc.nextInt();
	            menu.Select_level(levelselect);
	            
	         }
	         else if(select == 2) {
	            //메뉴얼 보여줌   
	            menu.howToPlay();
	         }
	         else if(select == 3) {
	            //랭킹 보여줌   
	            //menu.ranking();   /play
	         }
	         
	         else if(select == 4) {
	            System.out.println("End");
	            System.exit(0);
	         }
	         else {
	            System.out.println("Incorrect Input");
	         }
         }//while
      
      }
     /*** 메뉴판 출력 ***/
     
    
}//class