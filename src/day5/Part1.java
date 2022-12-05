package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("inputs\\crates.txt");
		Scanner text = new Scanner(file);

		LinkedList<char[]> cratesBuff = new LinkedList<char[]>();
		while (true) {
			String read = text.nextLine();
			char[] cratesRead = new char[9];
			if (read.charAt(1) == '1')
				break;
			for (int i = 0; i < 9; i++) {
				cratesRead[i] = read.charAt(1 + 4 * i);
			}
			cratesBuff.add(cratesRead);
		}
		text.nextLine();

		ArrayList<LinkedList<Character>> crates = new ArrayList<LinkedList<Character>>();
		for (int i = 0; i < 9; i++)
			crates.add(new LinkedList<Character>());
		for (int i = cratesBuff.size() - 1; i >= 0; i--) {
			char[] split = cratesBuff.get(i);
			for (int j = 0; j < split.length; j++) {
				if(split[j] != ' ') crates.get(j).add(split[j]);
			}
		}
		

		while (text.hasNextLine()) {
			String instrRaw = text.nextLine(); 
			String[] instrPart1 = instrRaw.split(" from "); 
			String[] instrPart2 = instrPart1[1].split(" to ");
			int[] inst = {Integer.parseInt(instrPart1[0].substring(5)), Integer.parseInt(instrPart2[0])-1,Integer.parseInt(instrPart2[1])-1};
			for(int i = inst[0]; i > 0; i--) {
				crates.get(inst[2]).add(crates.get(inst[1]).getLast());
				crates.get(inst[1]).removeLast();
			}
			
		}

		text.close();
		
		  for (LinkedList<Character> i : crates) { for (Character j : i) {
		  System.out.print(j); } System.out.println(); }
		 
	}
}
