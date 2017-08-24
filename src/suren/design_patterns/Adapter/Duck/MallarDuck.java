package suren.design_patterns.Adapter.Duck;

public class MallarDuck implements Duck{

	@Override
	public void quack() {
		System.out.println("Quack");
		
	}

	@Override
	public void fly() {
		System.out.println("I am flying");
	}

}
