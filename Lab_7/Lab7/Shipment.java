package Lab7;

public class Shipment {
	private int ID;
	private String shipmentDetails;
	
	public Shipment(int ID, String shipmentDetails) {
		super();
		this.ID = ID;
		this.shipmentDetails = shipmentDetails;
	}

	public int getID() {
		return ID;
	}

	public String getShipmentDetails() {
		return shipmentDetails;
	}	
}
