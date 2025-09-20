package finalAssignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeContractFileStrategy implements IFileStrategy {

	private File readMode;
	private Scanner scan;
	private FileWriter writeMode;

	public EmployeeContractFileStrategy(char mode) {
		try {
			if (mode == 'r') {
				readMode = new File("data/employees_contract.txt");
				scan = new Scanner(readMode);
			}
			else if (mode == 'w') {
				writeMode = new FileWriter("data/employees_contract.txt");
			}
		}
		catch (IOException e) {
			System.out.println("sorry!!! a problem occurred while reading or righting from the contract employee file");
		}
	}

	@Override
	public String [] read() {
		String [] splitedLine = null;
		String line;
	
		if (readMode.canRead() && scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.compareTo("employee_id\tfull_name\tdate_of_birth\tgender\temail\tphone_number\thire_date\tjob_title\tEmployee_type\tdepartment_id\tstatus\tlast_promotion_date\tpassword\tduration\toverall_payment\r\n") == 0)
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

