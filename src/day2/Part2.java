package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
	
	public static void main(String args[]) throws FileNotFoundException {
		
		File file = new File("rock-paper-scissors.txt");
		Scanner text = new Scanner(file);
		
		int points = 0;
		while (text.hasNextLine()) {
			String read;
			char player, opponent;

			read = text.nextLine();
			opponent = read.charAt(0);
			player = read.charAt(2);
			
		}
		System.out.println(points);
		text.close();

		
	}

}
