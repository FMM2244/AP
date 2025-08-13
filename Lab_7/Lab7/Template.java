
public abstract class Template {
	protected abstract void start();
	protected abstract void appendInfo();
	protected void orderOfOperation(Order order, String fileName) {
		start();
		appendInfo();
		try {
			FileWriter fw=new FileWriter(fileName);
			fw.write(info.toString());
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}