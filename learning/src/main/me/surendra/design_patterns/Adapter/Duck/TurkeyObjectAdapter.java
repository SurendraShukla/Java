package me.surendra.design_patterns.Adapter.Duck;

// Object adapter
public class TurkeyObjectAdapter implements Duck {
	//Adaptee
	Turkey turkey;

	public TurkeyObjectAdapter(Turkey turkey) {
		this.turkey = turkey;	
	}

	@Override
	public void quack() {	
		System.out.println("\n**Adapted Behaviour**");
		turkey.gobble();
	}

	@Override
	public void fly() {
		System.out.println("\n**Adapted Behaviour**");
		turkey.fly();	
	}

}
