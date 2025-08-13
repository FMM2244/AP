
public class Context {
	private IPayment payment;

	public Context(IPayment payment) {
		this.payment = payment;
	}

	public void executePayment(int ID,String name) {
		payment.doPayment(ID, name);
	}
}
