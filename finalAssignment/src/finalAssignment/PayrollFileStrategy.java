package finalAssignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PayrollFileStrategy implements IFileStrategy {

	private File readMode;
	private Scanner scan;
	private FileWriter writeMode;

	public PayrollFileStrategy(char mode) {
		try {
			if (mode == 'r') {
				readMode = new File("data/payroll.txt");
				scan = new Scanner(readMode);
			}
			else if (mode == 'w') {
				writeMode = new FileWriter("data/payroll.txt");
			}
		}
		catch (IOException e) {
			System.out.println("sorry!!! a problem occurred in reading from or righting to payroll file");
		}
	}

	public PayrollFileStrategy(char mode, boolean append) {
		try {
			if (mode == 'r') {
				readMode = new File("data/payroll.txt");
				scan = new Scanner(readMode);
			}
			else if (mode == 'w') {
				writeMode = new FileWriter("data/payroll.txt", append);
			}
		}
		catch (IOException e) {
			System.out.println("sorry!!! a problem occurred in reading from or righting to payroll file");
		}
	}

	@Override
	public String [] read() {
		String [] splitedLine = null;
		String line;
	
		if (readMode.canRead() && scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.compareTo("payroll_id\temployee_id\tmonth\tbase_salary\tbonuses\tdeductions\tnet_salary\ttax_withheld\tprocessed_date") == 0)
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
			System.out.println("sorry!!! a problem occurred while writing to Payroll file");
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
