package me.surendra.design_problems.parrot;

public class NorwegianBlueParrot extends Parrot {
    private double voltage;
    private boolean isNailed;

    protected NorwegianBlueParrot(double voltage, boolean isNailed) {
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    @Override
    public double getSpeed() {
        return (isNailed) ? 0 : getBaseSpeed();
    }

    protected double getBaseSpeed() {
        double speed = this.voltage * super.getBaseSpeed();
        return Math.min(24.0, speed);
    }

}
