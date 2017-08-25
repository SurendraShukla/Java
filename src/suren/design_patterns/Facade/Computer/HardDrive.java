package suren.design_patterns.Facade.Computer;

public class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("HardDrive read lba is "+lba+ " and size is "+size);
        return new byte[] {1, 6, 3};
    }
}
