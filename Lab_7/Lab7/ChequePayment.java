package Lab7;

public class ChequePayment implements IPayment {
	int chequeNum;
	String payerName;
	public void doPayment(int num,String name) {
		chequeNum=num;
		payerName=name;
	}
}
