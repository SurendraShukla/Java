package me.surendra.learning.functional_interface.lambda;

public class CapturingLambda {

    public void beforeCompile() {
        final String effectivelyFinal = "effectivelyFinal";
        Runnable capturingLambda = () -> System.out.println("capturingLambda " + effectivelyFinal);
        capturingLambda.run();
    }
    public void afterCompile() {
        String effectivelyFinal = "effectivelyFinal";
//        Runnable capturingLambda = (Runnable) LambdaMetafactory.metafactory(null, null, null, ()V, lambda$0(java.lang.String ), ()V)((String)effectivelyFinal);
//        capturingLambda.run();
    }

    private static /* synthetic */ void lambda$0(String string) {
        System.out.println("capturingLambda " + string);
    }
}
