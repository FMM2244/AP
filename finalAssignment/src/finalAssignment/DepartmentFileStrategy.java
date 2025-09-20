package finalAssignment;

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
				readMode = new File("data/departments.txt");
				scan = new Scanner(readMode);
			}
			else if (mode == 'w') {
				writeMode = new FileWriter("data/departments.txt");
			}
		}
		catch (IOException e) {
			System.out.println("sorry!!! a problem occurred while reading or righting from the Department file");
			e.printStackTrace();
		}
	}

	@Override
	public String [] read() {
		
		String [] splitedLine = null;
		String line;
	
		if (readMode.canRead() && scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.compareTo("department_id\tdepartment_name\thead_of_department_id\tbudget\tlocation") == 0)
				line = scan.nextLine();
			splitedLine = line.split("\t");
		}

		return splitedLine;
	}

	@Override
	public void write(String input) {
		
	}

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

