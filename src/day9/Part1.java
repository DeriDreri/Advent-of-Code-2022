package day9;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
	
	public static void main(String args[]) throws FileNotFoundException {
		File file = new File("inputs\\rope.txt");
		Scanner text = new Scanner(file);
		
		Point headKnot = new Point();
		Point tailKnot = new Point();
		
		while(text.hasNextLine()) {
			String read = text.nextLine();
			String directionOfMotion = read.substring(0,1);
			String periodOfMotion = read.substring(2);
			
			System.out.println("Move " + directionOfMotion + " for " + periodOfMotion);
			
		}
		
		
	}

}
