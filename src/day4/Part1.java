package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {

	public static void main(String args[]) throws FileNotFoundException {
		
		File file = new File("inputs\\cleaning.txt");
		Scanner text = new Scanner(file);
		
		
		while(text.hasNextLine()) {
			String read = text.nextLine();
			
			
			
		}
		
		text.close();
	}
	
}