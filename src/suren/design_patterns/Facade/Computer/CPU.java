package suren.design_patterns.Facade.Computer;

/* Complex parts */
public class CPU {

    public void freeze() {
        System.out.println("CPU freeze");
    }
    public void jump(long position) { System.out.println("CPU "+position+" Jump"); }
    public void execute() {
        System.out.println("CPU executed");
    }
}

