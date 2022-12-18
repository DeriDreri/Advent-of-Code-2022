package day11;

import java.util.ArrayList;
import java.util.LinkedList;

public class SuperMonkey {
	private LinkedList<Item> items;
	private CalculateWorryLevel worryLevel;
	private int test;
	private int positiveMonkey;
	private int negativeMonkey;
	private ArrayList<SuperMonkey> monkeys;
	private long inspectionsAmount;

	SuperMonkey(LinkedList<Item> items, CalculateWorryLevel worryLevel, int test, int positiveMonkey, int negativeMonkey,
			ArrayList<SuperMonkey> monkeys) {
		this.worryLevel = worryLevel;
		this.test = test;
		this.items = items;
		this.positiveMonkey = positiveMonkey;
		this.negativeMonkey = negativeMonkey;
		this.inspectionsAmount = 0;
		this.monkeys = monkeys;
	}

	public long getInspectionsAmount() {
		return this.inspectionsAmount;
	}

	public void giveItem(Item item) {
		this.items.add(item);
	}

	public void inspectItems() {
		for (Item item : items) {
			item.changeValue(worryLevel);
			//System.out.println(item);
			if (item.getValue(test) == 0) {
				this.monkeys.get(positiveMonkey).giveItem(item);
				//System.out.println("Monkey " + test + " throws item to " + positiveMonkey);
			} else {
				this.monkeys.get(negativeMonkey).giveItem(item);
				//System.out.println("Monkey " + test + " throws item to " + negativeMonkey);
			}
			this.inspectionsAmount++;
		}
		this.items.clear();
	}
}
