package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

		while (text.hasNextLine()) {
			read = text.nextLine();
			trees.add(getTreesInRow(read));
			sizeY++;
		}

		int numberOfVisibleTrees = 2 * sizeX + 2 * (sizeY - 2);

		ArrayList<ArrayList<Integer>> treesToAnalyse = LinkedLinkedListToArrayArrayList(trees);
		for (int i = 1; i < sizeY - 1; i++) {
			for (int j = 1; j < sizeX - 1; j++)
				if (analyseTreeVisibility(j, i, treesToAnalyse, sizeX, sizeY))
					numberOfVisibleTrees++;
		}
		
		
		System.out.println(numberOfVisibleTrees);

	}

	public static boolean analyseTreeVisibility(Integer treeX, Integer treeY, ArrayList<ArrayList<Integer>> treesList,
			int sizeX, int sizeY) {

		int treeHigh = treesList.get(treeY).get(treeX).intValue();
		boolean visibleL = true;
		boolean visibleR = true;
		boolean visibleU = true;
		boolean visibleD = true;

		for (int i = 0; i < treeX; i++) {
			if (treesList.get(treeY).get(i).intValue() >= treeHigh) {
				visibleL = false;
				break;
			}
		}
		if (visibleL)
			return true;
		for (int i = treeX + 1; i < sizeX; i++) {
			if (treesList.get(treeY).get(i).intValue() >= treeHigh) {
				visibleR = false;
				break;
			}
		}
		if (visibleR)
			return true;
		for (int i = 0; i < treeY; i++) {
			if (treesList.get(i).get(treeX).intValue() >= treeHigh) {
				visibleU = false;
				break;
			}
		}
		if (visibleU)
			return true;
		for (int i = treeY + 1; i < sizeY; i++) {
			if (treesList.get(i).get(treeX).intValue() >= treeHigh) {
				visibleD = false;
				break;
			}
		}
		return visibleD;

	}

	public static <T> ArrayList<ArrayList<T>> LinkedLinkedListToArrayArrayList(LinkedList<LinkedList<T>> list) {
		ArrayList<ArrayList<T>> toReturn = new ArrayList<ArrayList<T>>();
		for (LinkedList<T> singleList : list) {
			toReturn.add(new ArrayList<T>(singleList));
		}
		return toReturn;
	}

	public static void printTrees(ArrayList<ArrayList<Integer>> trees) {
		for (ArrayList<Integer> row : trees) {
			for (Integer tree : row) {
				System.out.print(tree);
			}
			System.out.println();
		}
	}

	public static void printTrees(LinkedList<LinkedList<Integer>> trees) {
		for (LinkedList<Integer> row : trees) {
			for (Integer tree : row) {
				System.out.print(tree);
			}
			System.out.println();
		}
	}

	public static LinkedList<Integer> getTreesInRow(String read) {
		LinkedList<Integer> toReturn = new LinkedList<Integer>();
		for (char i : read.toCharArray()) {
			toReturn.add(Integer.parseInt(Character.toString(i)));
		}

		return toReturn;
	}

}
