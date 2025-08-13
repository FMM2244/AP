package Lab7;

public class CreditPayment implements IPayment {
	int cardNum;
	String cardHolder;
	public void doPayment(int num,String name) {
		cardNum=num;
		cardHolder=name;
	}

}
