class TestA {
	int a= 10;
}

class TestA1 extends TestA {
	 TestA1() {
	}
	int b=20;
}


public class TestB extends TestA1 {

	int c=20;

	public static void main(final String[] args) {

		TestA1 obj = new TestB();
		System.out.println(obj);
	}

}

