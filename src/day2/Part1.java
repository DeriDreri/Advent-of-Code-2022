package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
	
	public static void main(String args[]) throws FileNotFoundException {
		File file = new File("rock-paper-scissors.txt");
		Scanner text = new Scanner(file);
		
		while(text.hasNextLine()) {
			String read;
			char player, opponent;
			read = text.nextLine();
			opponent = read.charAt(0);
			player = read.charAt(2); 
			System.out.print(opponent + " vs " + player);
			switch (player - opponent) {
				case 23:
					System.out.println(" Remis");
					break;
				case 24:
				case 21:
					System.out.println(" Wygrana");
					break;
				case 22:
				case 25:
					System.out.println(" Pora¿ka");
					break;
			}
		}
		
		text.close();
		
	}

}
