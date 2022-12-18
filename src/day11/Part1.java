package day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("inputs\\monkeys.txt");
		Scanner text = new Scanner(file);

		var monkeys = new ArrayList<Monkey>();

		while (text.hasNextLine()) {
			text.nextLine();
			String[] itemsData = text.nextLine().substring(2).split(": ")[1].split(", ");
			var itemsList = new LinkedList<Integer>();
			for (String item : itemsData) {
				try {
					itemsList.add(Integer.parseInt(item));
				} catch (NumberFormatException e) {
					;
				}
			}
			String[] operationData = text.nextLine().split(" ");
			CalculateWorryLevel calculate = (i -> {
				return 0;
			});
			if (operationData[operationData.length - 2].equals("+"))
				calculate = (i -> {
					return i + Integer.parseInt(operationData[operationData.length - 1]);
				});

			if (operationData[operationData.length - 2].equals("*")) {
				if (operationData[operationData.length - 1].equals("old"))
					calculate = (i -> {
						return i * i;
					});
				else
					calculate = (i -> {
						return i * Integer.parseInt(operationData[operationData.length - 1]);
					});
			}

			String[] testData = text.nextLine().split(" ");
			int test = Integer.parseInt(testData[testData.length - 1]);
			String[] positiveMonkeyData = text.nextLine().split(" ");
			int positiveMonkey = Integer.parseInt(positiveMonkeyData[positiveMonkeyData.length - 1]);
			String[] negativeMonkeyData = text.nextLine().split(" ");
			int negativeMonkey = Integer.parseInt(negativeMonkeyData[negativeMonkeyData.length - 1]);
			if (text.hasNextLine())
				text.nextLine();

			monkeys.add(new Monkey(itemsList, calculate, test, positiveMonkey, negativeMonkey, monkeys));

		}
		text.close();

		for (int i = 0; i < 2; i++) {
			for (Monkey monkey : monkeys) {
				monkey.inspectItems();
			}
		}

		int biggestInspectAmount = 0;
		int secondBiggestInspectAmount = 0;
		for (Monkey monkey : monkeys) {
			int monkeyAmount = monkey.getInspectionsAmount();
			if (monkeyAmount > secondBiggestInspectAmount) {
				secondBiggestInspectAmount = monkeyAmount;
				if (monkeyAmount > biggestInspectAmount) {
					secondBiggestInspectAmount = biggestInspectAmount;
					biggestInspectAmount = monkeyAmount;
				}
			}
		}
		System.out.println(biggestInspectAmount * secondBiggestInspectAmount);

	}

}
