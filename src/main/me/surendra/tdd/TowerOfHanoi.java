package me.surendra.tdd;

import java.util.List;

public class TowerOfHanoi {

    static void move(List<Integer> sourceTower, List<Integer> destinationTower, List<Integer> tmpTower, final int noOfPlates) {
        if ( noOfPlates == 1) {
            final Integer plate = sourceTower.remove(sourceTower.size() - 1);
            destinationTower.add(plate);
            return;
        }
//        TowerOfHanoi.printTowers(sourceTower, destinationTower, tmpTower);
        TowerOfHanoi.move(sourceTower, tmpTower, destinationTower, noOfPlates-1);
        TowerOfHanoi.move(sourceTower, destinationTower, tmpTower, 1);
        TowerOfHanoi.move(tmpTower, destinationTower, sourceTower, noOfPlates-1);
    }

    static void printTowers(List<Integer> sourceTower, List<Integer> destinationTower, List<Integer> tmpTower) {
        System.out.println("\nsourceTower: " + sourceTower);
        System.out.println("tmpTower: " + tmpTower);
        System.out.println("destinationTower: " + destinationTower);
    }

}
