package Lab7;

public class landShipment {
	public static void createShipment(Order order){
		int shipmentID=1;
		String shipmentDetails=new StringBuilder().append("origin: sourse")
				.append(" , destination: goal")
				.append(" , vehcleNo: 64-1234")
				.append(" , driver name: someone")
				.toString();
		
		Shipment shipment=new Shipment(shipmentID,shipmentDetails);
		order.setShipmant(shipment);
	}
}
