package JavaProject;

import JavaProject.CommandBoard;

public class CommandAnswerBoard extends CommandBoard {
   
   int mm;
   public CommandAnswerBoard() {
      
   }
   
   //for test
   public void print() {
       //보드판 출력
       for (int i = 0; i < my; i++) {
          for (int k = 0; k < mx; k++) {
             System.out.print(board[k][i] + " ");
          }
          System.out.println();
       }

   }
   
   public CommandAnswerBoard(int mx,int my,int mm) {
      
      super(mx,my);
      this.mm = mm;
        //답지보드 생성
        for (int i = 0; i < my; i++) {
           for (int j = 0; j < mx; j++) {
              board[i][j] = 0;
           }
        }
        
       //랜덤으로 지뢰 생성
        for (int i = 0; i < mm; i++) {
           int x = (int)(Math.random()*mx);
           int y = (int)(Math.random()*my);
           board[y][x] = 9;
        }
        
      //지뢰 위치에 따라서 판 위에 숫자 생성
        for (int i = 0; i < my; i++) {
           for (int k = 0; k < mx; k++) {
              if (board[i][k] == 9) {
                 if (i > 0) {
                        board[i-1][k] += 1;
                        if (k > 0) board[i-1][k-1] += 1;
                        if (k < mx-1) board[i-1][k+1] += 1;}
                    if (i < my-1) {
                        board[i+1][k] += 1;
                        if (k > 0) board[i+1][k-1] += 1;
                        if (k < mx-1) board[i+1][k+1] += 1;}
                    if (k > 0) board[i][k-1] += 1;
                    if (k < mx-1) board[i][k+1] += 1;
              }
              for (int q = 0; q < my; q++) {
                 for (int p = 0; p < mx; p++) {
                    if (board[q][p] >9) board[q][p] = 9;
                 }
              }
           }
        }//for
        
        
   }
}