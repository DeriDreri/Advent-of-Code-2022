package day7;

import java.util.LinkedList;

public class Directory {

	private LinkedList<String> files;
	private String name;
	private Directory parent;
	private int size; 
	
	Directory(String name, Directory parent) {
		this.files = new LinkedList<String>();
		this.name = name;
		this.parent = parent;
		this.size = 0;
	}

	public void addFile(String name, int size) {
		for (String i : files) {
			if (i == name)
				return;
		}
		files.add(name);
		this.size += size;
	}
	
	public int getSize() {
		return size;
		
	}

	public String getName() {
		return name;
	}

	public Directory getParent() {
		if (parent == null) return this;
		return parent;
	}
	
	public int getSizeUnder100_000() {
		if (this.size < 100000) return this.size;
		return 0;
	}
}
