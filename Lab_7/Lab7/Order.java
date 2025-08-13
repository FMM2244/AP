package Lab7;
import java.util.ArrayList;

public class Order {
	private int ID;
	private Customer customer;
	private ArrayList<Item> items;
	private Shipment shipmant;
	private double price;
	private Context payment;
	
	public Order(int ID, Customer customer) {
		this.ID = ID;
		this.customer = customer;
		items=new ArrayList<Item>();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shipment getShipmant() {
		return shipmant;
	}

	public void setShipmant(Shipment shipmant) {
		this.shipmant = shipmant;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Context getPayment() {
		return payment;
	}

	public void setPayment(Context payment) {
		this.payment = payment;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	public ArrayList<Item> getItems(){
		return items;
	}
}
