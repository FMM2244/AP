package Lab7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class WriteToXMLFile implements Template {

	
	public static void writeToXMLFile(Order order, String fileName) {
		ArrayList<Item> items=order.getItems();
		StringBuilder itemsStringBuilder=new StringBuilder();
		for(int i=0;i<items.size();i++) {
			itemsStringBuilder.append("\t\t<Item id=\""+items.get(i).getID()+"\">\n")
			.append("\t\t\t<Name>"+items.get(i).getName()+"</Name>\n")
			.append("\t\t\t<Quantity>"+items.get(i).getQnt()+"</Quantity>\n")
			.append("\t\t</Item>\n");
		}
		String itemsString=itemsStringBuilder.toString();
		String info=new StringBuilder().append("<Order id=\""+order.getID()+"\">\n")
				.append("\t<Customer>\n")
				.append("\t\t<Name>"+order.getCustomer().getName()+"</Name>\n")
				.append("\t\t<Address>"+order.getCustomer().getAddress()+"</Address>\n")
				.append("\t</Customer>\n")
				.append("\t<Items>\n")
				.append(itemsString)
				.append("\t</Items>\n")
				.append("\t<Shipment>\n")
				.append("\t\t<ID>"+order.getShipmant().getID()+"</ID>\n")
				.append("\t\t<Details>"+order.getShipmant().getShipmentDetails()+"</Details>\n")
				.append("\t</Shipment>\n")
				.append("\t<Price>"+order.getPrice()+"</Price>\n")
				.append("\t<Payment_method>"+order.getPayment().getClass().getSimpleName()+"</Payment_method>\n")
				.append("</Order>")
				.toString();
		
		
		try {
			FileWriter fw=new FileWriter(fileName);
			fw.write(info);
			fw.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
