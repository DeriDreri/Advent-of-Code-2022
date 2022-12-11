package day11;

import java.util.ArrayList;
import java.util.LinkedList;

public class Monkey {

	private LinkedList<Integer> items;
	private CalculateWorryLevel worryLevel;
	private int test;
	private int positiveMonkey;
	private int negativeMonkey;
	private ArrayList<Monkey> monkeys;
	private int inspectionsAmount;

	Monkey(LinkedList<Integer> items, CalculateWorryLevel worryLevel, int test, int positiveMonkey, int negativeMonkey,
			ArrayList<Monkey> monkeys) {
		this.worryLevel = worryLevel;
		this.test = test;
		this.items = items;
		this.positiveMonkey = positiveMonkey;
		this.negativeMonkey = negativeMonkey;
		this.inspectionsAmount = 0;
		this.monkeys = monkeys;
	}

	public int getInspectionsAmount() {
		return this.inspectionsAmount;
	}

	public void giveItem(Integer item) {
		this.items.add(item);
	}

	public void inspectItems() {
		for (Integer item : items) {
			item = worryLevel.calculate(item);
			item /= 3;
			if (item % test == 0) {
				this.monkeys.get(positiveMonkey).giveItem(item);
			} else {
				this.monkeys.get(negativeMonkey).giveItem(item);
			}
			this.inspectionsAmount++;
		}
		this.items.clear();
	}
}
