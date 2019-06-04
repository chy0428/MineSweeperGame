package JavaProject;

import java.awt.EventQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("============ Welcome! ============\n");
		System.out.println("     This is Mine Sweeper Game    \n");
		System.out.println("1. Command User Interface Version ");
		System.out.println("2. Graphic User Interface Version \n");
		System.out.println("==================================\n");
		System.out.print("Selet version > ");
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
