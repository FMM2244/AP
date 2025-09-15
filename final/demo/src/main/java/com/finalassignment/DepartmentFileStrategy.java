/**
 * this strategy reads and write date from and to the departments file
 */

package com.finalassignment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DepartmentFileStrategy implements IFileStrategy {

	private File readMode;
	private Scanner scan;
	private FileWriter writeMode;

	public DepartmentFileStrategy(char mode) {
		try {
			if (mode == 'r') {
				readMode = new File("/home/fatima/Documents/repositories/AP/final/demo/src/main/java/bin/data/departments.txt");
				scan = new Scanner(readMode);
			}
			else if (mode == 'w') {
				writeMode = new FileWriter("/home/fatima/Documents/repositories/AP/final/demo/src/main/java/bin/data/departments.txt");
			}
		}
		catch (IOException e) {
			System.out.println("sorry!!! can't instantiate FileWriter");
		}
	}

	@Override
	public String [] read() {
		
		String [] splitedLine = null;
		String line;
	
		if (readMode.canRead()) {
			line = scan.nextLine();
			splitedLine = line.split("\t ");
		}

		return splitedLine;
	}

	@Override
	public void write(String input) {
		
	}

	// Generated getters and setters
	public File getReadMode() {
		return readMode;
	}

	public void setReadMode(File readMode) {
		this.readMode = readMode;
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public FileWriter getWriteMode() {
		return writeMode;
	}

	public void setWriteMode(FileWriter writeMode) {
		this.writeMode = writeMode;
	}
}
