package me.surendra.leetcode.trees.breadth_first_search;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateBinaryTreeNodesTest {
    final ValidateBinaryTreeNodes validateBinaryTreeNodes = new ValidateBinaryTreeNodes();

    private boolean callMethod(final int n, final int[] leftChild, final int[] rightChild) {
        return validateBinaryTreeNodes.validateBinaryTreeNodes(n, leftChild, rightChild);
    }

    @Test
    public void testForTrue() {
        assertTrue(callMethod(4,
            new int[]{1, -1, 3, -1},
            new int[]{2, -1, -1, -1})
        );

        assertTrue(callMethod(4,
            new int[]{3, -1, 1, -1},
            new int[]{-1, -1, 0, -1})
        );
    }

    @Test
    public void testForFalse() {
        assertFalse(callMethod(2,
            new int[]{1, 0},
            new int[]{-1, -1})
        );

        assertFalse(callMethod(4,
            new int[]{1, -1, 3, -1},
            new int[]{2, 3, -1, -1})
        );

        assertFalse(callMethod(4,
            new int[]{1, 0, 3, -1},
            new int[]{-1, -1, -1, -1})
        );

        assertFalse(callMethod(6,
            new int[]{1, -1, -1, 4, -1, -1},
            new int[]{2, -1, -1, 5, -1, -1})
        );
    }

}
