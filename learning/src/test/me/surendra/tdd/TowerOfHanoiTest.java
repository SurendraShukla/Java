package me.surendra.tdd;

import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class TowerOfHanoiTest {

    @Test
    public void testFor1PlateTower() {
        final List<Integer> sourceTower = newArrayList(1);
        final List<Integer> destinationTower = newArrayList();
        final List<Integer> tmpTower = newArrayList();

        TowerOfHanoi.move(sourceTower, destinationTower, tmpTower, sourceTower.size());
        TowerOfHanoi.printTowers(sourceTower, destinationTower, tmpTower);
        System.out.println("======== 1 Plate Tower =============");
    }

    @Test
    public void testFor2PlateTower() {
        final List<Integer> sourceTower = newArrayList(2, 1);
        final List<Integer> destinationTower = newArrayList();
        final List<Integer> tmpTower = newArrayList();

        TowerOfHanoi.move(sourceTower, destinationTower, tmpTower, sourceTower.size());
        TowerOfHanoi.printTowers(sourceTower, destinationTower, tmpTower);
        System.out.println("======== 2 Plate Tower =============");
    }

    @Test
    public void testFor3PlateTower() {
        final List<Integer> sourceTower = newArrayList(3,2,1);
        final List<Integer> destinationTower = newArrayList();
        final List<Integer> tmpTower = newArrayList();

        TowerOfHanoi.move(sourceTower, destinationTower, tmpTower, sourceTower.size());
        TowerOfHanoi.printTowers(sourceTower, destinationTower, tmpTower);
        System.out.println("======== 3 Plate Tower =============");
    }

    @Test
    public void testFor4PlateTower() {
        final List<Integer> sourceTower = newArrayList(4,3,2,1);
        final List<Integer> destinationTower = newArrayList();
        final List<Integer> tmpTower = newArrayList();

        TowerOfHanoi.move(sourceTower, destinationTower, tmpTower, sourceTower.size());
        TowerOfHanoi.printTowers(sourceTower, destinationTower, tmpTower);
        System.out.println("======== 4 Plate Tower =============");
    }

    @Test
    public void testFor5PlateTower() {
        final List<Integer> sourceTower = newArrayList(5,4,3,2,1);
        final List<Integer> destinationTower = newArrayList();
        final List<Integer> tmpTower = newArrayList();

        TowerOfHanoi.move(sourceTower, destinationTower, tmpTower, sourceTower.size());
        TowerOfHanoi.printTowers(sourceTower, destinationTower, tmpTower);
        System.out.println("======== 5 Plate Tower =============");
    }

}
