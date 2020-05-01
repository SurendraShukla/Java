package me.surendra.learning.generics;

import me.surendra.learning.generics.basic.ClassWithGenericMethods;
import me.surendra.learning.generics.basic.ClassWithoutGenericMethod;
import me.surendra.learning.generics.basic.GenericImpl;
import org.junit.Test;

public class GenericMethodOnlyTest {

    @Test
    public void test() {
        final GenericImpl generic = new GenericImpl();
        final ClassWithGenericMethods classWithGenericMethods = new ClassWithGenericMethods();
        final ClassWithoutGenericMethod classWithoutGenericMethod = new ClassWithoutGenericMethod();

//        generic.accept(classWithGenericMethods);
//        generic.accept(classWithoutGenericMethod);
    }

}
