package suren.design_patterns.Facade.Computer;

public class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Memory load position is "+position+" and data is "+data);
    }
}
