package day9;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Part1 {

	public static void main(String args[]) throws FileNotFoundException {
		File file = new File("inputs\\rope.txt");
		Scanner text = new Scanner(file);

		Point headPoint = new Point();
		Point tailPoint = new Point();

		LinkedList<Point> uniquePositionsOfTail = new LinkedList<Point>();
		uniquePositionsOfTail.add(new Point(tailPoint));
		
		while (text.hasNextLine()) {
			String read = text.nextLine();
			String directionOfMotion = read.substring(0, 1);
			int periodOfMotion = Integer.parseInt(read.substring(2));
			int dX = 0, dY = 0;
			switch (directionOfMotion) {
			case "R":
				dX = 1;
				break;
			case "L":
				dX = -1;
				break;
			case "U":
				dY = 1;
				break;
			case "D":
				dY = -1;
				break;
			}

			LinkedList<Point> newPositions = moveHead(headPoint, tailPoint, dX, dY, periodOfMotion);
			
			for(Point newPosition : newPositions) {
				boolean isOnList = false;
				for (Point oldPosition : uniquePositionsOfTail){
					if(newPosition.x == oldPosition.x && newPosition.y == oldPosition.y) {
						isOnList = true;
						break;
					}
				}
				if(!isOnList) uniquePositionsOfTail.add(newPosition);
			}
		}
		
		System.out.println(uniquePositionsOfTail.size());

	}

	public static LinkedList<Point> moveHead(Point headPoint, Point tailPoint, int dX, int dY, int period) {
		LinkedList<Point> toReturn = new LinkedList<Point>();
		
		for (int move = 0; move < period; move++) {
			headPoint.translate(dX, dY);
			if (headPoint.distance(tailPoint) > 1.42) {
				moveTail(headPoint, tailPoint);
				toReturn.add(new Point(tailPoint));
				}
		}
		return toReturn;

	}

	public static void moveTail(Point headPoint, Point tailPoint) {

		if (headPoint.x == tailPoint.x) {
			int dY = (headPoint.y - tailPoint.y) / Math.abs(headPoint.y - tailPoint.y);
			tailPoint.translate(0, dY);
			return;
		}
		int dX = (headPoint.x - tailPoint.x) / Math.abs(headPoint.x - tailPoint.x);
		if (headPoint.y == tailPoint.y) {
			tailPoint.translate(dX, 0);
			return;
		}
		int dY = (headPoint.y - tailPoint.y) / Math.abs(headPoint.y - tailPoint.y);
		tailPoint.translate(dX, dY);
	}
}
