package me.surendra.learning.functional_interface;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionProgramTest {

    private final FunctionProgram functionProgram = new FunctionProgram();

    @Test
    public void testAll() {

    }

    @Test
    public void testObjectCall() {
        functionProgram.genericMethod(Person.class);
//        person.setAddress("wow");
        functionProgram.handleObjects(new Dummy());
    }

    @Test
    public void testFunctionCall() {
        functionProgram.handleFunctions(
            (str) -> {
                System.out.println(str);
                return true;
            }
        );
    }

    @Test
    public void testSupplierCall() {
//        final Dummy supplierReturnedDummy = functionProgram.handleFunctions(() -> new Dummy());
//        System.out.println(supplierReturnedDummy.getStr());

        final Person person = functionProgram.handleFunctions(() -> new Person("Surendra", 30, "Programmer"));
        System.out.println("Person Detail 1:" + person.getName() + ", " + person.getAge() + ", " + person.getAddress());

        final Supplier<Person> supplier = () -> { return new Person("Suren", 30, "Programmer"); };
        Person p = supplier.get();
        System.out.println("Person Detail 2:" + p.getName() + ", " + p.getAge() + ", " + p.getAddress());

    }

    @Test
    public void testConsumerCall() {
        final Consumer<String> consumer1 = (arg) -> {System.out.println(arg + "OK");};
//        consumer1.accept("TestConsumerAccept - ");

        Consumer < String > consumer2 = (x) -> { System.out.println(x + "OK!!!"); };
        consumer1.andThen(consumer2).accept("TestConsumerAfterThen - ");
    }

    class Dummy{
        final String str = "Dummy";

        public String getStr() {
            return str;
        }

        @Override
        public String toString() {
            return "Dummy{" +
                "str='" + str + '\'' +
                '}';
        }
    }

    class Person {
        private String name;
        private int age;
        private String address;

        public Person(final String name, final int age, final String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(final int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(final String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
        }
    }
}
