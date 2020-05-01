package me.surendra.learning.functional_interface.lambda;

public class NonCapturingLambda {

    public void beforeCompile() {
        Runnable nonCapturingLambda = () -> System.out.println("NonCapturingLambda");
        nonCapturingLambda.run();
    }


    public void afterCompile() {
//        Runnable nonCapturingLambda = (Runnable) LambdaMetafactory.metafactory(null, null, null, ()V, lambda$0(), ()V)();
//        nonCapturingLambda.run();
    }

    private static /* synthetic */ void lambda$0() {
        System.out.println("NonCapturingLambda");
    }

}
