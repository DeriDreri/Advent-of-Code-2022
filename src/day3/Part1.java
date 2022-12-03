package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
	public static void main(String args[]) throws FileNotFoundException {

		File file = new File("inputs\\rucksack.txt");
		Scanner text = new Scanner(file);
		String read;
		int sum = 0;

		while (text.hasNextLine()) {
			read = text.nextLine();
			char common = findCommonInHalfs(read);
			sum += calculatePriority(common);
		}
		System.out.println(sum);
		text.close();
	}

	public static int calculatePriority(char item) {
		int priority = 0;

		if (item > 95) {
			priority = item - 96;
		} else {
			priority = item - 38;
		}
		return priority;
	}

	public static char findCommonInHalfs(String rucksack) {
		int middle = rucksack.length() / 2;
		String[] rucksackParts = { rucksack.substring(0, middle), rucksack.substring(middle) };

		for (char i : rucksackParts[0].toCharArray()) {
			String check = Character.toString(i);
			if (rucksackParts[1].contains(check)) {
				return  i;

			}

		}
		return ' ';
	}
}
