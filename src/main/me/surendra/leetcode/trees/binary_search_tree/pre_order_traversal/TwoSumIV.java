package me.surendra.leetcode.trees.binary_search_tree.pre_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

import java.util.HashSet;
import java.util.Set;


/**
 * @see <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/">Two Sum IV - Input is a BST</a>
 */
public class TwoSumIV {

    /*
        Time complexity : O(n)
        Space complexity: O(n) Size of the set can grow upto nn in the worst case
     */
    public boolean findTargetWhileTraversing(final TreeNode root, final int k) {
        return find(root, k, new HashSet());
    }

    public boolean find(final TreeNode root, final int k, final Set<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }


    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public boolean findTargetAfterTraversing(final TreeNode root, final int k) {
        final Set<Integer> set = new HashSet<>();
        dfsPreOrder(root, set);
        for (Integer no: set) {
            final int otherNo = k - no;
            if (otherNo == no) {
                continue;
            }
            if (set.contains(otherNo)) {
                return true;
            }
        }
        return false;
    }

    public void dfsPreOrder(final TreeNode root, final Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        dfsPreOrder(root.left, set);
        dfsPreOrder(root.right, set);
    }

}
