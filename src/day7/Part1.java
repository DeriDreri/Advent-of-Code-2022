package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
	
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
				if(command[1] != "cd") break;
				if(command[2] == "..") {
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
		
		int size = 0;
		for (Directory i : dirs) {
			size += i.getSizeUnder100_000();
		}
		System.out.println(size);
	}
}
