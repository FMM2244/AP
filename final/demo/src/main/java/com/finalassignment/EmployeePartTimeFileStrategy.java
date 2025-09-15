/**
 * this strategy reads and write date from and to the employees_contract file
 */

package com.finalassignment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeePartTimeFileStrategy implements IFileStrategy {

	private File readMode;
	private Scanner scan;
	private FileWriter writeMode;

	public EmployeePartTimeFileStrategy(char mode) {
		try {
			if (mode == 'r') {
				readMode = new File("data/employees_part_time.txt");
				scan = new Scanner(readMode);
			}
			else if (mode == 'w') {
				writeMode = new FileWriter("data/employees_part_time.txt");
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
