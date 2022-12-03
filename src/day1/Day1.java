package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

	public static void main(String args[]) throws FileNotFoundException {

		int max = 0;
		int current = 0;
		String read;

		File file = new File("calories.txt");
		Scanner text = new Scanner(file);

		while (text.hasNextLine()) {
			read = text.nextLine();

			if (read != "")
				current = +Integer.parseInt(read);

			else {
				if (current > max)
					max = current;
				current = 0;
			}
		}

		System.out.println(max);
	}

}
