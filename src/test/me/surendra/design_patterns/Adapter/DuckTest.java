package me.surendra.design_patterns.Adapter;

import me.surendra.design_patterns.Adapter.Duck.Duck;
import me.surendra.design_patterns.Adapter.Duck.MallarDuck;
import me.surendra.design_patterns.Adapter.Duck.TurkeyObjectAdapter;
import me.surendra.design_patterns.Adapter.Duck.WildTurkey;

public class DuckTest {
    public static void main(String[] args){
        MallarDuck duck = new MallarDuck();
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyObjectAdapter(turkey);

        System.out.println("The Turkey Says.....");
        turkey.gobble();
        turkey.fly();

        System.out.println("========================================");

        System.out.println("\nThe Duck Says.....");
        testDuck(duck);

        System.out.println("========================================");

        System.out.println("\nThe TurkeyAdapeter Says.....");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
