
/**
 * status == true --> Full time employee
 * status == false --> Part time employee
 */
public class PartFull {
	private boolean status;

	public PartFull() {
		status = true;
	}

	public void set_status(boolean status) {
		this.status = status;
	}

	public void get_status() {
		return status;
	}
}
