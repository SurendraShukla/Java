class PrivateMethodCheck {

	private void privateFun() {
		System.out.println("Private");
	}
	
	public void publicFun() {
		privateFun();
		System.out.println("Public");
	}

}


public class Test{
	public static void main(String str[]){
		PrivateMethodCheck pmk = new PrivateMethodCheck();
		pmk.publicFun();
	}
}

