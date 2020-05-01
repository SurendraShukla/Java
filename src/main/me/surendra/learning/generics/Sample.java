package me.surendra.learning.generics;

class A<T> { }
class B<T> extends A<T> { }
class C<T> extends B<T> { }


public class Sample {
    public static <T> void use(A<? super T> inst) {
        System.out.println(inst);
    }

    public static void main(String[] args) {
        Sample.use(new A<>());
        Sample.use(new B<>());
        Sample.use(new C<>());
//        Sample.use(new Object<>());
    }
}

