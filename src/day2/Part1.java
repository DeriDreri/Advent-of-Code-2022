package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
	
	public static void main(String args[]) throws FileNotFoundException {
		File file = new File("rock-paper-scissors.txt");
		Scanner text = new Scanner(file);
		text.close();
		
	}

}
