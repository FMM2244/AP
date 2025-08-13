
public class PlaneShipmentHandler implements Handler {
	Handler h;

	public void setNextHandler(Handler h) {
		this.h = h;
	}

	public void handleShipment(Shipment sh) {
		if (sh.getShipmentDetails().contains("flightNo"))
			System.out.println("shipment handled in Plane Shipment Handler");
			System.out.println(sh.getShipmentDetails());
		else
			h.handleShipment(sh);
	}
}
