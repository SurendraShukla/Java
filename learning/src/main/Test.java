import org.joda.time.DateTime;

import java.util.Date;

class PrivateMethodCheck {

	private void privateFun() {
		System.out.println("Private");
	}

	public void publicFun() {
		privateFun();
		System.out.println("Public");
	}

}


public class Test {

	public static void main(String str[]) {
		final PrivateMethodCheck privateMethodCheck = new PrivateMethodCheck();


		Date jdkDate = DateTime.now().toDate();

		System.out.println(jdkDate);
		System.out.println(new DateTime(jdkDate).minusDays(1).withMillisOfSecond(0));

		PrivateMethodCheck pmk = new PrivateMethodCheck();
		pmk.publicFun();
	}

}

