package Lab7;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.StringBuilder;
public class WriteToTextFile implements Template {
	StringBuilder info=new StringBuilder();

	protected void start() {
		info.append("Order ID: "+order.getID()+"\n");
	}

	protected void appendInfo() {
		.append("Customer: "+order.getCustomer().getName()+"\n")
		.append("Customer Address: "+order.getCustomer().getAddress()+"\n")
		.append("Items:\n");
		ArrayList<Item> items=order.getItems();
		for(int i=0;i<items.size();i++) {
			info.append("\tItem "+(i+1)+": "+items.get(i).getName()+"\tqnt: "+items.get(i).getQnt()+"\n");
		}
		info.append("Shipment ID: "+order.getShipmant().getID()+"\nShipment details: \n"+order.getShipmant().getShipmentDetails())
		.append("Price: "+order.getPrice()+"\n")
		.append("Payment method: "+order.getPayment().getClass().getSimpleName());
	}
}
