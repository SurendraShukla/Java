package suren.design_patterns.Builder.Pizza;

public class PizzaBuilderDemo {
    public static void main(String[] args) {

        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder( hawaiianPizzabuilder );
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
//        System.out.println(pizza.getDough()+" == "+pizza.getSauce()+" == "+pizza.getTopping());
    }
}
