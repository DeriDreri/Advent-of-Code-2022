package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
	public static void main(String args[]) throws FileNotFoundException {

		File file = new File("inputs\\rucksack.txt");
		Scanner text = new Scanner(file);
		String read;

		while (text.hasNextLine()) {
			read = text.nextLine();
			char common = findCommon(read);
			System.out.println(read + " : " + common);
		}
		text.close();
	}
	
	
	public static char findCommon(String rucksack) {
		int middle = rucksack.length() / 2;
		char common = ' ';
		String[] rucksackParts = { rucksack.substring(0, middle), rucksack.substring(middle) };

		for (char i : rucksackParts[0].toCharArray()) {
			String check = Character.toString(i);
			if (rucksackParts[1].contains(check)) {
				common = i;
				break;
			}

		}
		return common;
	}
}
