import java.io.IOException;

class TestA {
	int age= 10;

	void start() {
		System.out.println("TestA");
	}

	void exceptionChecking() {
		System.out.println("wow in TestA");
	}
}

public class TestB extends TestA{
	
	void exceptionChecking() throws ArithmeticException {
		System.out.println("TestB "+(new TestA()).age);
	}

	public static void main(String[] args) {
		try{
			TestB obj = new TestB();
			obj.start();
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}

