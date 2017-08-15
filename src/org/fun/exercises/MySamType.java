package org.fun.exercises;

import java.util.function.UnaryOperator;

public class MySamType {

//    static int cube(int a) {
//        return a*a*a;
//    }

    int cube(int a) {
        return a*a*a;
    }

    static int printResult(UnaryOperator<Integer> a) {
        return a.apply(3);
    }

    public static void main(String[] args) {
//
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello run!");
//            }
//        };
//
//        Runnable r2 = () -> System.out.println("Hello run!");
//        execute(r2);
//
//        MyRunnable m = () -> System.out.println("Hello run!");
//        execute(m);

//        System.out.println(printResult(x -> x * x));
//        System.out.println(printResult(x -> cube(x)));
//        System.out.println(printResult(MySamType::cube));

        MySamType t = new MySamType();
        System.out.println(printResult(x -> x * x));
        System.out.println(printResult(x -> t.cube(x)));
        System.out.println(printResult(t::cube));

    }

//    private static void execute(Runnable r) {
//        r.run();
//    }
//
//    interface MyRunnable {
//        void myRun();
//    }


}
