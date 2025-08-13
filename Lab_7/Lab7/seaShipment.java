package Lab7;

public class seaShipment {
	public static void createShipment(Order order) {
		int shipmentID=1;
		String shipmentDetails=new StringBuilder().append("origin: sourse")
				.append(" , destination: goal")
				.append(" , ship: shipname")
				.append(" , shipper: shipping company")
				.toString();
		
		Shipment shipment=new Shipment(shipmentID,shipmentDetails);
		order.setShipmant(shipment);
	}

}
