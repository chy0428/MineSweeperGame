package JavaProject;

public class CommandBoard {
	int[][] board ; //답지 보드
	String[][] gboard ; //출 보드
	int mx;
	int my;
	int mm;
	public CommandBoard() {
		 	
	}
	public CommandBoard(int x,int y) {
		board = new int[y][x];
		gboard = new String[y][x];
		mx = x;
		my = y;
	}
}
