package day11;

import java.lang.invoke.WrongMethodTypeException;

public class Item {
	
	int[] mods = {11,19,5,2,13,7,3,17};
	int[] values = new int[mods.length];
	
	
	Item(Integer itemValue){
		for(int i = 0; i < mods.length; i++) {
			values[i] = itemValue % mods[i];
		}
	}

	public void changeValue(CalculateWorryLevel calculate) {
		for(int i = 0; i < mods.length; i++) {
			values[i] = (calculate.calculate(values[i]) % mods[i]);
		}
	}
	
	public int getValue(int mod) {
		
		for(int i = 0; i < mods.length; i++) {
			if(mods[i] == mod) return values[i];
		}
		throw new WrongMethodTypeException();
	}
	
}
