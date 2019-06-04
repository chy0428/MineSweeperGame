package JavaProject;

import java.util.Scanner;

public class CommandPlay {
	//게임 시작 
	CommandAnswerBoard ab;
	CommandOutputBoard ob;
	Scanner keyboard = new Scanner(System.in);
    long starttime = System.currentTimeMillis();
    int cnt = 0; //판 여는 횟수 count. 게임 승리 판별 조건
    boolean fmine = false; //지뢰 밟았는지 판별 조건.
    int setflg = 0; //입력한 좌표가 flag 좌표인지 열어보는 좌표인지 판별.
    int xinput = 0; //사용자로 부터 입력받는 x 좌표
    int yinput = 0; //사용자로 부터 입력받는 y 좌표
    int level;
    
	public CommandPlay(CommandAnswerBoard ab,CommandOutputBoard ob,int level) {
		this.ab = ab;
		this.ob = ob;
		this.level = level;
	}
	
	public void playGame() {
		
		while(!fmine && cnt < ab.mx*ab.my-ab.mm) {
		       
		       do {  
		    	  setflg = 0;
		          System.out.println("Input your coordinate. If you want set flag, Plz input more than 99");
		          System.out.print("Input x (1 ~ "+ab.mx+")  ");
		          xinput = keyboard.nextInt();
		          
		          //flag 입력 조건
		          if (xinput >= 98) {
		             setflg = -1;
		             System.out.print ("Below Input coordinate will set Flag. ");
		             System.out.print("Input x (1 ~ "+ab.mx+")  ");
		             xinput = keyboard.nextInt();
		          }
		          System.out.print("input Y (1 ~ "+ab.my+")  ");
		          yinput = keyboard.nextInt();
		          
		          //입력값이 좌표 범위를 초과했을 경우
		          if (xinput < 1 || yinput < 1 || xinput > ab.mx || yinput > ab.my) {System.out.println("Wrong Input. Plz input again");}
		          else {
		             xinput = xinput - 1;
		             yinput = yinput - 1;
		             break;
		          }
		          
		       } while(true);
		       
		       checkboard();
		       
		       //좌표 입력 후 결과창 표시
		       for (int i = 0; i < ob.my; i++) {
		          for (int k = 0; k < ob.mx; k++) {
		             System.out.print(ob.gboard[k][i] + " ");
		          }
		          System.out.println();
		       }
		       
		     
		    }//while
		//게임 종료 시간
	       long endtime = System.currentTimeMillis();
	       
	       //플레이 타임 계산
	       float timming = (float)(endtime - starttime)/(float)1000;
	       
	       //플레이 타임 표시 / millisecond
	       System.out.println("Taking time = " + timming);
	       
	       //게임 종료 후 게임 결과 표시
	       if (fmine == false) {
	    	  keyboard.nextLine();
	          System.out.println("You Win!");
	          System.out.print("InputYourName");
	          String winner = keyboard.nextLine();
	          CommandFileIO scores = new CommandFileIO(level);
	          scores.saveScore(scores.fileRead(),winner,timming);
	          
	       }
	       else System.out.println("You lose");
		
		
	}
	
	public void checkboard() {
		//flag 세팅 (*은 해당 좌표가 Flag임을 표시함)
	       if (setflg != 0 ) {
	          if (ob.gboard[xinput][yinput] == "#") ob.gboard[xinput][yinput] = "F";
	          else if (ob.gboard[xinput][yinput].equals("F")) ob.gboard[xinput][yinput] = "#";
	       }
	       
	       //좌표 클릭했을 경우
	       else {
	          if (ob.gboard[xinput][yinput].equals("F")) System.out.println("This place is Flag.");
	          else if (ab.board[xinput][yinput] == 9) {
	             ob.gboard[xinput][yinput] = "X";
	             fmine = true;
	          }
	          
	          else {
	             if (ob.gboard[xinput][yinput] != "#") System.out.println("It is already opened. Please another Input");
	             else {
	            	
	                ob.gboard[xinput][yinput] = Integer.toString(ab.board[xinput][yinput]);
	                cnt += 1;
	                System.out.println();
	             }
	          }
	       }
	       
	       
	       
	}

	
}