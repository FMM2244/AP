
public class SeaShipmentHandler implements Handler {
	Handler h;

	public void setNextHandler(Handler h) {
		this.h = h;
	}

	public void handleShipment(Shipment sh) {
		if (sh.getShipmentDetails().contains("ship"))
			System.out.println("shipment handled in Sea Shipment Handler");
			System.out.println(sh.getShipmentDetails());
		else
			h.handleShipment(sh);
	}
}
