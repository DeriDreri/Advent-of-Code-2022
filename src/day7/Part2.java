package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;

public class Part2 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("inputs\\files.txt");
		Scanner text = new Scanner(file);
		Directory workingDirectory = new Directory("/",null);
		ArrayList<Directory> dirs = new ArrayList<Directory>();
		dirs.add(workingDirectory);

		while (text.hasNextLine()) {
			String read = text.nextLine();
			String[] command = read.split(" ");

			switch (command[0]) {
			case "$":
				if(command[1].contains("cd") == false) break;
				if(command[2].contains("..")) {
					workingDirectory = workingDirectory.getParent();
					break;
				}
				boolean isInList = false;
				Directory newDirectory = null;
				for(Directory i : dirs) {
					if (i.getName() == command[2]) {
						newDirectory = i;
						isInList = true;
					}
				}
				if(isInList == false) {
					newDirectory = new Directory(command[2], workingDirectory);
					dirs.add(newDirectory);
					workingDirectory.addDirectory(newDirectory);
					
				}
				workingDirectory = newDirectory;
				break;
			
			case "dir":
				break;
			
				
			default:
				workingDirectory.addFile(command[1], Integer.parseInt(command[0]));
				break;
			}
			
			
		}
		
		int spaceNeeded = 30000000 - (70000000 - dirs.get(0).getSize());
		int min = 30000000;
		
		for (Directory i : dirs) {
			if (i.getSize() < spaceNeeded) continue;
			if (i.getSize() < min) min = i.getSize();
		}
		
		System.out.println(min);
	}

}
