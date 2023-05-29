package me.surendra.leetcode.trees.depth_first_search;

import me.surendra.leetcode.trees.TreeNode;


/**
 * @see <a href="https://leetcode.com/problems/count-univalue-subtrees/">Count Univalue Subtrees</a>
 */
public class CountUniValueSubtreesFinder {

    /*
        Time Complexity - O(n)
        Space Complexity - O(h) - Height of the tree
     */
    int count = 0;
    public int countUniValSubtrees(final TreeNode root) {
        if (root == null) {
            return count;
        }
        populateUniValCount(root);
//        isValidPart(root, 0);
//        populateUniValCountSelfThought(root);
        return count;
    }

    private boolean populateUniValCount(final TreeNode root) {
        // Base case - if the node has no children this is a UniValue subtree
        if (root.left == null && root.right == null) {
            // found a UniValue subtree - increment
            count++;
            return true;
        }

        boolean uniVal = true;
        // Check if all of node's children are UniValue subtrees and if they have the same value
        // also recursively call is_uni for children
        if (root.left != null) {
            uniVal = populateUniValCount(root.left) && uniVal && root.left.val == root.val;
        }
        if (root.right != null) {
            uniVal = populateUniValCount(root.right) && uniVal && root.right.val == root.val;
        }
        // Return if a UniValue tree exists here and increment if it does
        if (uniVal) {
            count++;
        }
        return uniVal;
    }


    boolean isValidPart(final TreeNode node, final int val) {

        // considered a valid subtree
        if (node == null) return true;

        // check if node.left and node.right are UniValue subtrees of value node.val
        // note that || short circuits but | does not - both sides of the or get evaluated with | so we explore all possible routes
        if (!isValidPart(node.left, node.val) | !isValidPart(node.right, node.val)) return false;

        // if it passed the last step then this a valid subtree - increment
        count++;

        // at this point we know that this node is a UniValue subtree of value node.val
        // pass a boolean indicating if this is a valid subtree for the parent node
        return node.val == val;
    }

    private boolean populateUniValCountSelfThought(final TreeNode root) {
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        final boolean uniVal;
        if (root.left == null) {
            final boolean leftNode = root.left == null || (populateUniValCountSelfThought(root.left) && root.left.val == root.val);
            final boolean rightNode = root.right == null || (populateUniValCountSelfThought(root.right) && root.right.val == root.val);
            uniVal = leftNode && rightNode;
        } else {
            final boolean leftNode = populateUniValCountSelfThought(root.left);
            final boolean rightNode = populateUniValCountSelfThought(root.right);
            uniVal = leftNode && rightNode && root.left.val == root.val && root.right.val == root.val;
        }
        if (uniVal) {
            count++;
        }
        return uniVal;
    }

}
