package JavaProject;

import JavaProject.CommandBoard;

public class CommandOutputBoard extends CommandBoard {
	public CommandOutputBoard(int mx,int my) {
		super(mx,my);
		for (int i = 0; i < my; i++) {
	           for (int j = 0; j < mx; j++) {
	              gboard[i][j] = "#";
	           }
		}  
	}
	
	
	public void print() {
		 //보드판 출력
        for (int i = 0; i < my ; i++) {
           for (int k = 0; k < mx; k++) {
              System.out.print(gboard[k][i] + " ");
           }
           System.out.println();
        }

	}
	
	
	
}

