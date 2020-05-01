package me.surendra.design_patterns.Facade.Computer;


/* Facade */
public class ComputerFacade {
    private static final long BOOT_ADDRESS = 100L;
    private static final long BOOT_SECTOR = 101L;
    private static final int SECTOR_SIZE = 102;

    private CPU processor;
    private Memory ram;
    private HardDrive hd;

    public ComputerFacade() {
        this.processor = new CPU();
        this.ram = new Memory();
        this.hd = new HardDrive();
    }

    public void start() {
        processor.freeze();
        ram.load(BOOT_ADDRESS, hd.read(BOOT_SECTOR, SECTOR_SIZE));
        processor.jump(BOOT_ADDRESS);
        processor.execute();
    }
}
