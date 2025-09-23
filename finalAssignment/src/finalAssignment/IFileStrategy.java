package finalAssignment;

public interface IFileStrategy {
	String [] read();
	void write(String input);
	
	void close();
}
