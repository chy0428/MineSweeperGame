package JavaProject;

import java.awt.EventQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("버전을 선택하세요");
		System.out.println("1. Command 창으로 MineSweeper 게임을 하고 싶으신가요?");
		System.out.println("2. Graphic 창으로 MineSweeper 게임을 하고 싶으신가요?");
		int choose = keyboard.nextInt();
		
		if(choose == 1) {
			CommandMine command = new CommandMine();
			command.CommandPlay();
		}
		else if(choose == 2) {
			EventQueue.invokeLater(() -> {

			    GUIGameWindow ex = new GUIGameWindow();
			    
			    ex.setVisible(true);
			});
		}
				
	}

}
