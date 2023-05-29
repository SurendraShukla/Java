package me.surendra.leetcode.graph.adjacency.matrix;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/number-of-provinces/">Number of Provinces</a>
 * Also Know as
 *    - Friend Circle
 *    - Connected Network
 */
public class ProvinceFinder {

    /*
        Time complexity: O(n*m)
        Space complexity: O(n)
     */
    public int findCircleNum(int[][] matrix) {
        int length = matrix.length;

        int[] cityWithProvince = new int[length];
        for (int i = 0; i < length; i++) {
            cityWithProvince[i] = i;
        }

        for (int row = 0; row < length; row++) {
            for (int col = row+1; col < length; col++) {
                if (row != col) {
                  if (matrix[row][col] == 1) {
                      replaceProvinceForCity(cityWithProvince, col, cityWithProvince[row]);
                      matrix[col][row] = 0;
                  }
                }
            }
        }
        final Long count = Arrays.stream(cityWithProvince).distinct().count();
        return count.intValue();
    }

    private void replaceProvinceForCity(final int[] cityWithItsProvince,
                                        final int city,
                                        final int province) {

        int cityOldProvince = cityWithItsProvince[city];
        if (cityOldProvince == city) {
            cityWithItsProvince[city] = province;
            return;
        }
        replaceAllTheCitiesHavingOldProvinces(cityWithItsProvince, cityOldProvince, province);

    }

    private void replaceAllTheCitiesHavingOldProvinces(final int[] cityWithItsProvince, final int oldProvince, final int province) {
        for (int tmpCity = 0; tmpCity < cityWithItsProvince.length; tmpCity++) {
            if (cityWithItsProvince[tmpCity] == oldProvince) {
                cityWithItsProvince[tmpCity] = province;
            }
        }
    }

}
