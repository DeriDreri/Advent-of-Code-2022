package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {

	public static void main(String args[]) throws FileNotFoundException {
		File file = new File("inputs\\rucksack.txt");
		Scanner text = new Scanner(file);
		String rucksacks[] = new String[3];

		while (text.hasNextLine()) {
			for (int i = 0; i < 3; i++)
				rucksacks[i] = text.nextLine();
			System.out.println(findCommonIn3(rucksacks[0], rucksacks[1], rucksacks[2]));
		}
		text.close();
	}

	public static char findCommonIn3(String first, String second, String third) {
		for (char i : first.toCharArray()) {
			String check = Character.toString(i);

			if (second.contains(check))
				if (third.contains(check)) {
					return i;
				}

		}

		return ' ';
	}

}
