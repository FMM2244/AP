package Lab7;

public class Item {
	private int ID;
	private String name;
	private int qnt;
	
	public Item(int ID, String name, int qnt) {
		this.ID = ID;
		this.name = name;
		this.qnt = qnt;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

}
