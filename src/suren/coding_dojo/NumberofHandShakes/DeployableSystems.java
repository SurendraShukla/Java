package suren.coding_dojo.NumberofHandShakes;

public class DeployableSystems {
    public int getMinimumHandshakes(int noOfSystems) {
        return noOfSystems <= 1 ? 0 : (noOfSystems - 1) + getMinimumHandshakes(noOfSystems - 1);
    }
}
