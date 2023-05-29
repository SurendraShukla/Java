package me.surendra.leetcode.trees.n_ary_tree;


import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal/">N-ary Tree Postorder Traversal</a>
 */
public class PostOrderTraverser {

    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    final List<Integer> returnList = new ArrayList<>();
    public List<Integer> postorder(final Node root) {
        if (root == null) {
            return returnList;
        }
        for (Node children: root.children) {
            postorder(children);
        }
        returnList.add(root.val);
        return returnList;
    }

    public List<Integer> postorderUsingIterative(final Node root) {
        final List<Integer> returnList = new ArrayList<>();

        return returnList;
    }

}
