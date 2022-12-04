package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {

	public static void main(String args[]) throws FileNotFoundException {
		File file = new File("inputs\\cleaning.txt");
		Scanner text = new Scanner(file);
		int sum = 0;

		while (text.hasNextLine()) {
			String read = text.nextLine();

			String[] elves = read.split(",");
			String[][] valuesS = { elves[0].split("-"), elves[1].split("-") };
			int[][] values = { { Integer.parseInt(valuesS[0][0]), Integer.parseInt(valuesS[0][1]) },
					{ Integer.parseInt(valuesS[1][0]), Integer.parseInt(valuesS[1][1]) } };
			if (values[0][0] > values[1][1] || values[0][1] < values[1][0])
				continue;
			sum++;

		}
		System.out.println(sum);
		text.close();
	}
}
