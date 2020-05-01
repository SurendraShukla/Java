abstract class Employee {
	
	protected abstract double getSalesAmount();

	public double getCommision() {
		return getSalesAmount() * 0.15;
	}
}

public class Sales extends Employee {

	public double getSalesAmount() { return 1230.45; }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
