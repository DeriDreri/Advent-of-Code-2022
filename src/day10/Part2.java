package day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		var file = new File("inputs//cycles.txt");
		var text = new Scanner(file);
		
		int registerX = 1;
		int cycleNumber = 0;
		int sumOfRegisters = 0;
		
		
		
		while(text.hasNextLine()) {
			cycleNumber = executeCycle(cycleNumber, registerX);
			String[] command = text.nextLine().split(" ");
			if (command[0].equals("noop")) continue;
			cycleNumber = executeCycle(cycleNumber, registerX);
			registerX += Integer.parseInt(command[1]);
		}
	}
	
	public static int executeCycle(int cycleNumber, int positionX) {
		cycleNumber++;
		char toPrint = '#';
		if(cycleNumber < positionX || cycleNumber > positionX+2) toPrint = '.';
		System.out.print(toPrint);
		if(cycleNumber % 40 == 0) {
			cycleNumber = 0;
			System.out.println();
			}
		return cycleNumber;
	}

}
