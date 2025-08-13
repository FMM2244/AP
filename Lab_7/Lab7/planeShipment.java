package Lab7;

public class planeShipment {
	public static void createShipment(Order order){
		int shipmentID=1;
		String shipmentDetails=new StringBuilder().append("origin: sourse")
				.append(" , destination: goal")
				.append(" , flightNo: ABC123")
				.append(" , flightcompany: abc airlines")
				.toString();
		
		Shipment shipment=new Shipment(shipmentID,shipmentDetails);
		order.setShipmant(shipment);
	}
}
