package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Part1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("inputs\\crates.txt");
		Scanner text = new Scanner(file);
		boolean initialScan = true;
		LinkedList<char[]> crates = new LinkedList<char[]>();
		while(true) {
			String read = text.nextLine();
			char[] cratesRead = new char[9];
			if (read.charAt(1) == '1') break;
			for (int i = 0; i < 9; i++) {
				cratesRead[i] = read.charAt(1 + 4 * i);
			}
			crates.add(cratesRead);
		}
		text.nextLine();
		
		for(char[] i : crates) {
			for(char j : i) {
				System.out.print("[" + j + "] ");
			}
			System.out.println();
		}
		/*while(text.hasNextLine()) {
			
		}*/
		text.close();
	}
}
