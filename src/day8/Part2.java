package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("inputs\\trees.txt");
		Scanner text = new Scanner(file);

		LinkedList<LinkedList<Integer>> trees = new LinkedList<LinkedList<Integer>>();

		String read = text.nextLine();
		int sizeX = read.length();
		int sizeY = 1;
		trees.add(Part1.getTreesInRow(read));

		while (text.hasNextLine()) {
			read = text.nextLine();
			trees.add(Part1.getTreesInRow(read));
			sizeY++;
		}

		int maximumVisibilityScore = 0;

		ArrayList<ArrayList<Integer>> treesToAnalyse = Part1.LinkedLinkedListToArrayArrayList(trees);
		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				int visibilityScore = analyseTreeVisibilityScore(j, i, treesToAnalyse, sizeX, sizeY);
				if (visibilityScore > maximumVisibilityScore)
					maximumVisibilityScore = visibilityScore;
			}
		}
		
		System.out.println(maximumVisibilityScore);

	}

	public static int analyseTreeVisibilityScore(Integer treeX, Integer treeY, ArrayList<ArrayList<Integer>> treesList,
			int sizeX, int sizeY) {

		int toReturn = 1;
		int treeHigh = treesList.get(treeY).get(treeX).intValue();
		int localVisibility = 0;

		for (int i = treeX - 1; i >= 0; i--) {
			localVisibility++;
			if (treesList.get(treeY).get(i).intValue() >= treeHigh)
				break;
		}
		toReturn *= localVisibility;
		localVisibility = 0;
		for (int i = treeX + 1; i < sizeX; i++) {
			localVisibility++;
			if (treesList.get(treeY).get(i).intValue() >= treeHigh)
				break;

		}
		toReturn *= localVisibility;
		localVisibility = 0;
		for (int i = treeY - 1; i >= 0; i--) {
			localVisibility++;
			if (treesList.get(i).get(treeX).intValue() >= treeHigh)
				break;

		}
		toReturn *= localVisibility;
		localVisibility = 0;
		for (int i = treeY + 1; i < sizeY; i++) {
			localVisibility++;
			if (treesList.get(i).get(treeX).intValue() >= treeHigh)
				break;

		}
		return toReturn * localVisibility;

	}

}
