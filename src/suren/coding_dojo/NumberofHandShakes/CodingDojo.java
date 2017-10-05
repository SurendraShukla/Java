package suren.coding_dojo.NumberofHandShakes;

public class CodingDojo {
    public int getNumberofHandShakes(final int numberOfSystems) {
        if (numberOfSystems <= 1) {
            return 0;
        } else {
            return calculateNumberOfHandShakes(numberOfSystems - 1);
        }
    }

    private int calculateNumberOfHandShakes(int numberOfSystems) {
        int handshakes = 0;
        if (numberOfSystems >= 1) {
            handshakes = numberOfSystems + calculateNumberOfHandShakes(numberOfSystems - 1);
        }
        return handshakes;
    }
}
