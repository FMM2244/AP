package Lab7;
import java.util.ArrayList;

public class Lab7 {

	public static void main(String[] args) {
		ArrayList<Order> orders=new ArrayList<Order>();
		
		Order order1=new Order(1,new Customer("ali","amman"));
		order1.addItem(new Item(10,"item1",1));
		order1.addItem(new Item(17,"item2",1));
		order1.addItem(new Item(13,"item3",2));
		order1.setPrice(101.50);
		order1.setPayment(new CashPayment());
		order1.getPayment().doPayment(1, "ali");
		planeShipment.createShipment(order1);
		
		orders.add(order1);
		
		Order order2=new Order(1,new Customer("sami","amman"));
		order2.addItem(new Item(17,"item2",3));
		order2.addItem(new Item(23,"item6",1));
		order2.addItem(new Item(13,"item3",1));
		order2.setPrice(175.50);
		order2.setPayment(new ChequePayment());
		order2.getPayment().doPayment(100, "sami");
		seaShipment.createShipment(order2);
		
		orders.add(order2);
		
		Order order3=new Order(1,new Customer("hani","Irbid"));
		order3.addItem(new Item(10,"item1",3));
		order3.addItem(new Item(23,"item6",2));
		order3.addItem(new Item(17,"item2",1));
		order3.setPrice(213.75);
		order3.setPayment(new CreditPayment());
		order3.getPayment().doPayment(100, "hani");
		landShipment.createShipment(order3);
		
		orders.add(order3);
		
		for(Order o:orders) {
			System.out.println("Order ID: "+o.getID()+"\tCustomer: "+o.getCustomer().getName());
			for(Item i:o.getItems()) {
				System.out.println("\t"+i.getName()+"\t"+i.getQnt());
			}
			System.out.println("price: "+o.getPrice());
			System.out.println(o.getShipmant().getShipmentDetails());
		}	
		WriteToTextFile.writeToTextFile(order1, "order1.txt");
		WriteToXMLFile.writeToXMLFile(order1, "order1.xml");
	}

}
