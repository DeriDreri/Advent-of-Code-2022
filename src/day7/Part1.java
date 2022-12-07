package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("inputs\\files.txt");
		Scanner text = new Scanner(file);
		
		ArrayList<Directory> directories = new ArrayList<Directory>();
		
		while(text.hasNextLine()) {
			String read = text.nextLine();
		}
	}
}
