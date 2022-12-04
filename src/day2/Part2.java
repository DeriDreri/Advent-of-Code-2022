package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {

	public static void main(String args[]) throws FileNotFoundException {

		File file = new File("inputs\\rock-paper-scissors.txt");
		Scanner text = new Scanner(file);

		int points = 0;
		while (text.hasNextLine()) {
			String read;
			char playerChoice, opponentFigure;
			int playerFigure = 0;

			read = text.nextLine();
			opponentFigure = read.charAt(0);
			playerChoice = read.charAt(2);

			switch (playerChoice) {
			case 'X':
				playerFigure = opponentFigure + 2;
				break;

			case 'Y':
				playerFigure = opponentFigure;
				points += 3;
				break;

			case 'Z':
				playerFigure = opponentFigure + 1;
				points += 6;
				break;
			}
			if (playerFigure > 67)
				playerFigure -= 3;
			points += playerFigure - 64;

		}
		System.out.println(points);
		text.close();

	}

}
