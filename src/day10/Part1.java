package day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		var file = new File("inputs//cycles.txt");
		var text = new Scanner(file);
		
		int registerX = 1;
		int cycleNumber = 0;
		int sumOfRegisters = 0;
		
		while(text.hasNextLine()) {
			cycleNumber++;
			if(cycleNumber % 40 == 20) sumOfRegisters += registerX * cycleNumber;
			String[] command = text.nextLine().split(" ");
			if (command[0].equals("noop")) continue;
			cycleNumber++;
			if(cycleNumber % 40 == 20) sumOfRegisters += registerX * cycleNumber;
			registerX += Integer.parseInt(command[1]);
		}
		
		System.out.println(sumOfRegisters);
	}

}
