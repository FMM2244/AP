package Lab7;

public class CashPayment implements IPayment {
	int payerID;
	String payerName;
	
	public void doPayment(int ID,String name) {
		payerID=ID;
		payerName=name;
	}
	
}
