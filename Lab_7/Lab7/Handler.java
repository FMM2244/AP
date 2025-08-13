
public Interface Handler {
	void setNextHandler(Handler h);
	void handleShipment(Shipment sh);
}