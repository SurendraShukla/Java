package me.surendra.leetcode.trees.binary_search_tree.bfs;

import me.surendra.leetcode.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @see <a href="https://leetcode.com/problems/serialize-and-deserialize-bst/">Serialize and Deserialize BST</a>
 */
public class SerializeAndDeserializeBST {

    final Character NULL_NODE = ' ';
    final String NODE_DELIMITER = ",";
    final String LEVEL_END = "\n";

    // Encodes a tree to a single string.
    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        stringBuilder.append(root.val);
        stringBuilder.append(LEVEL_END);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null) {
                    stringBuilder.append(NULL_NODE + NODE_DELIMITER);
                } else {
                    stringBuilder.append(currentNode.left.val + NODE_DELIMITER);
                    queue.add(currentNode.left);
                }
                if (currentNode.right == null) {
                    stringBuilder.append(NULL_NODE + NODE_DELIMITER);
                } else {
                    stringBuilder.append(currentNode.right.val + NODE_DELIMITER);
                    queue.add(currentNode.right);
                }
            }
            stringBuilder.append(LEVEL_END);
        }

        return stringBuilder.toString();
    }


    // Decodes your encoded data to tree.
    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        final String[] treeNodeInfo = data.split(LEVEL_END);
        final Queue<TreeNode> queue = new LinkedList<>();
        int val = Integer.parseInt(treeNodeInfo[0]);
        final TreeNode returnNode = new TreeNode(val);
        queue.add(returnNode);

        int treeNodeInfoCounter = 0;
        while (!queue.isEmpty()) {
            treeNodeInfoCounter++;
            final String[] nodes = treeNodeInfo[treeNodeInfoCounter].split(NODE_DELIMITER);

            int nodeCounter = 0;
            while (nodeCounter < nodes.length) {
                TreeNode currentNode = queue.poll();

                String leftNodeVal = nodes[nodeCounter++];
                if (leftNodeVal.equals(" ")) {
                    currentNode.left = null;
                } else {
                    int leftVal = Integer.parseInt(leftNodeVal);
                    final TreeNode leftNode = new TreeNode(leftVal);
                    currentNode.left = leftNode;
                    queue.add(leftNode);
                }

                String rightNodeVal = nodes[nodeCounter++];
                if (rightNodeVal.equals(" ")) {
                    currentNode.right = null;
                } else {
                    int rightVal = Integer.parseInt(rightNodeVal);
                    final TreeNode rightNode = new TreeNode(rightVal);
                    currentNode.right = rightNode;
                    queue.add(rightNode);
                }
            }
        }
        return returnNode;
    }

}
