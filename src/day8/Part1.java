package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.StringConcatFactory;
import java.util.LinkedList;
import java.util.Scanner;

public class Part1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("inputs\\trees.txt");
		Scanner text = new Scanner(file);
		
		LinkedList<LinkedList<Integer>> trees = new LinkedList<LinkedList<Integer>>();
		
		String read = text.nextLine();
		int sizeX = read.length();
		int sizeY = 1;
		trees.add(getTreesInRow(read));
		
		while(text.hasNextLine()) {
			read = text.nextLine();
			trees.add(getTreesInRow(read));
			sizeY++;
		}
		//printTrees(trees);
		
	}
	
	public static void printTrees(LinkedList<LinkedList<Integer>> trees) {
		for(LinkedList<Integer> row : trees) {
			for (Integer tree : row) {
				System.out.print(tree);
			}
			System.out.println();
		}
	}
	
	public static LinkedList<Integer> getTreesInRow(String read){
		LinkedList<Integer> toReturn = new LinkedList<Integer>();
		for(char i : read.toCharArray()) {
			toReturn.add(Integer.parseInt(Character.toString(i)));
		}
		
		
		
		return toReturn;
	}

}
