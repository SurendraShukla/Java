package me.surendra.leetcode.design;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQL {

    /*
        Space complexity: O(n)
     */
    private final Map<String, Integer> tableInfoMap;
    private final Map<String, Map<Integer, List<String>>> tableDataMap;
    public SQL(final List<String> names, final List<Integer> columns) {
        tableInfoMap = new HashMap<>();
        tableDataMap = new HashMap<>();
        for (int row = 0; row < names.size(); row++) {
            tableInfoMap.put(names.get(row), 1);
            tableDataMap.put(names.get(row), new HashMap<>());
        }
    }

    /*
        Time complexity: O(1)
     */
    public void insertRow(final String name, final List<String> row) {
        final int rowId = tableInfoMap.get(name);
        tableInfoMap.put(name, rowId + 1);
        tableDataMap.get(name).put(rowId, row);
    }

    /*
        Time complexity: O(1)
     */
    public void deleteRow(final String name, final int rowId) {
        tableDataMap.get(name).remove(rowId);
    }

    /*
        Time complexity: O(1)
     */
    public String selectCell(final String name, final int rowId, final int columnId) {
        return tableDataMap.get(name).get(rowId).get(columnId - 1);
    }

}
