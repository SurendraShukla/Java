package suren.design_patterns.Singleton;

// Bill Pugh Singleton Implementation
public class StaticNestedClass {

    private StaticNestedClass(){}

    private static class SingletonHelper{
        private static final StaticNestedClass INSTANCE = new StaticNestedClass();
    }

    public static StaticNestedClass getInstance(){
        return SingletonHelper.INSTANCE;
    }

}
