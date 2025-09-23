package finalAssignment;

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
			System.out.println("sorry!!! a problem occurred while reading or righting from the part time employee file");
		}
	}

	public EmployeePartTimeFileStrategy(char mode, boolean append) {
		try {
			if (mode == 'r') {
				readMode = new File("data/employees_part_time.txt");
				scan = new Scanner(readMode);
			}
			else if (mode == 'w') {
				writeMode = new FileWriter("data/employees_part_time.txt", append);
			}
		}
		catch (IOException e) {
			System.out.println("sorry!!! a problem occurred while reading or righting from the part time employee file");
		}
	}

	@Override
	public String [] read() {
		String [] splitedLine = null;
		String line;
	
		if (readMode.canRead() && scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.compareTo("employee_id\tfull_name\tdate_of_birth\tgender\temail\tphone_number\thire_date\tjob_title\temployment_type\tdepartment_id\tstatus\tlast_promotion_date\tPassword\tworking_hours_per_month\trate_per_hour") == 0)
				line = scan.nextLine();
			splitedLine = line.split("\t");
		}

		return splitedLine;
	}

	@Override
	public void write(String input) {
		try {
			writeMode.write(input + "\n");
		}
		catch (Exception e) {
			System.out.println("sorry!!! a problem occurred while writing to Part Time Employee file");
		}
	}
	
	public void close() {
		try {
			writeMode.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
