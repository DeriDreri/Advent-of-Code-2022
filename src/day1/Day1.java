package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

	public static void main(String args[]) throws FileNotFoundException {

		int[] max = {0, 0, 0};
		int current = 0;
		String read;

		File file = new File("inputs\\calories.txt");
		Scanner text = new Scanner(file);

		while (text.hasNextLine()) {
			read = text.nextLine();

			if (read != "") current += Integer.parseInt(read);

			else {
				if (current <= max[2]) {
					current = 0;
					continue;
				}
				if (current <= max[1]) {
					max[2] = current;
					current = 0;
					continue;
				}
				if (current <= max[0]) {
					max[2] = max[1];
					max[1] = current;
					current = 0;
					continue;
				}
				max[2] = max[1];
				max[1] = max[0];
				max[0] = current;
				current = 0;
				
			}
			
		}

		text.close();
		System.out.println(max[0] + " " + max[1] + " " + max[2]);
		System.out.println(max[0] + max[1] + max[2]);
	}

}
