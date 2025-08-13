
public class LandShipmentHandler implements Handler {
	Handler h;

	public void setNextHandler(Handler h) {
		this.h = h;
	}

	public void handleShipment(Shipment sh) {
		if (sh.getShipmentDetails().contains("vehcleNo"))
			System.out.println("shipment handled in Land Shipment Handler");
			System.out.println(sh.getShipmentDetails());
		else
			h.handleShipment(sh);
	}
}
