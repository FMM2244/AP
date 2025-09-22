package finalAssignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeFullTimeFileStrategy implements IFileStrategy {

	private File readMode;
	private Scanner scan;
	private FileWriter writeMode;

	public EmployeeFullTimeFileStrategy(char mode) {
		try {
			if (mode == 'r') {
				readMode = new File("data/employees_full_time.txt");
				scan = new Scanner(readMode);
			}
			else if (mode == 'w') {
				writeMode = new FileWriter("data/employees_full_time.txt");
			}
		}
		catch (IOException e) {
			System.out.println("sorry!!! a problem occurred while reading or righting from the full time employee file");
		}
	}

	@Override
	public String [] read() {
		String [] splitedLine = null;
		String line;
	
		if (readMode.canRead() && scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.compareTo("employee_id\tfull_name\tdate_of_birth\tgender\temail\tphone_number\thire_date\tjob_title\temployment_type\tdepartment_id\tstatus\tlast_promotion_date\tPassword\tsalary_base") == 0)
				line = scan.nextLine();
			splitedLine = line.split("\t");
		}

//		for (int i = 0; i != 14; i++) {
//			System.out.println(i + ": " + splitedLine[i]);
//		}
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
