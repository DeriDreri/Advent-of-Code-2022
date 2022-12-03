package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {

	public static void main(String args[]) throws FileNotFoundException {
		File file = new File("inputs\\rock-paper-scissors.txt");
		Scanner text = new Scanner(file);

		int points = 0;

		while (text.hasNextLine()) {
			String read;
			char player, opponent;

			read = text.nextLine();
			opponent = read.charAt(0);
			player = read.charAt(2);

			points += player - 87;

			switch (player - opponent) {
			case 23:
				points += 3;
				break;
			case 24:
			case 21:
				points += 6;
				break;
			case 22:
			case 25:
				break;
			}
		}
		System.out.println(points);
		text.close();

	}

}
