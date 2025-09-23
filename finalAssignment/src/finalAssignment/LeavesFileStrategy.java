package finalAssignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeavesFileStrategy implements IFileStrategy {

	private File readMode;
	private Scanner scan;
	private FileWriter writeMode;

	public LeavesFileStrategy(char mode) {
		try {
			if (mode == 'r') {
				readMode = new File("data/leaves.txt");
				scan = new Scanner(readMode);
			}
			else if (mode == 'w') {
				writeMode = new FileWriter("data/leaves.txt");
			}
		}
		catch (IOException e) {
			System.out.println("sorry!!! a problem occurred while reading or righting from the leaves file");
		}
	}

	public LeavesFileStrategy(char mode, boolean append) {
		try {
			if (mode == 'r') {
				readMode = new File("data/leaves.txt");
				scan = new Scanner(readMode);
			}
			else if (mode == 'w') {
				writeMode = new FileWriter("data/leaves.txt", append);
			}
		}
		catch (IOException e) {
			System.out.println("sorry!!! a problem occurred while reading or righting from the leaves file");
		}
	}

	@Override
	public String [] read() {
		String [] splitedLine = null;
		String line;
	
		if (readMode.canRead() && scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.compareTo("leave_id\temployee_id\tleave_type\tstart_date\tend_date\tapproval_status\tapprover_id") == 0)
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
			System.out.println("sorry!!! a problem occurred while writing to Leaves file");
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

