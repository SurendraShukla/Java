package me.surendra.learning.functional_interface;

import me.surendra.learning.functional_interface.lambda.CapturingLambda;
import me.surendra.learning.functional_interface.lambda.NonCapturingLambda;
import org.junit.Test;

public class LambdaTest {

    @Test
    public void shouldTest() {
//        https://dzone.com/articles/how-lambdas-and-anonymous-inner-classesaic-work
        final NonCapturingLambda nonCapturingLambda = new NonCapturingLambda();
        nonCapturingLambda.beforeCompile();

        final CapturingLambda capturingLambda = new CapturingLambda();
        capturingLambda.beforeCompile();
    }

}
