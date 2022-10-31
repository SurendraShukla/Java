package me.surendra.leetcode.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @see <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">Serialize and Deserialize Binary Tree</a>
 */
public class SerializeAndDeserialize {

    public class DFS {
        /*
            Time complexity : O(n)
            Space complexity: O(n)
         */
        private static final String NULL_NODE = " ";
        private final static String NODE_DELIMITER = ",";

        public String serialize(final TreeNode root) {
            final StringBuilder sb = new StringBuilder();
            populateUsingPreOrder(root, sb);
            return sb.toString();
        }

        private void populateUsingPreOrder(final TreeNode root, final StringBuilder sb) {
            if (root == null) {
                sb.append(NULL_NODE).append(NODE_DELIMITER);
                return;
            }
            sb.append(root.val).append(NODE_DELIMITER);
            populateUsingPreOrder(root.left, sb);
            populateUsingPreOrder(root.right, sb);
        }

        /*
            Time complexity : O(n)
            Space complexity: O(n)
         */
        public TreeNode deserialize(final String data) {
            final List<String> preOrderList = new LinkedList<>();
            for (String str: data.split(NODE_DELIMITER)) {
                preOrderList.add(str);
            }

            return createTreeNodeFromPreOrderList(preOrderList);
        }

        private TreeNode createTreeNodeFromPreOrderList(final List<String> preOrderList) {
            if (preOrderList.isEmpty()) {
                return null;
            }
            final String rootVal = preOrderList.get(0);
            preOrderList.remove(0);
            if (NULL_NODE.equals(rootVal)) {
                return null;
            }
            final TreeNode root = new TreeNode(Integer.parseInt(rootVal));
            root.left = createTreeNodeFromPreOrderList(preOrderList);
            root.right = createTreeNodeFromPreOrderList(preOrderList);
            return root;
        }

    }

    public class BFS {

        final static String NULL_NODE = " ";
        final static String NODE_DELIMITER = ",";
        final static String LEVEL_END = "\n";

        // Encodes a tree to a single string.
        /*
            Time complexity : O(n)
            Space complexity: O(n)
         */
        public String serialize(final TreeNode root) {
            if (root == null) {
                return "";
            }
            final StringBuilder sb = new StringBuilder();
            final Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            sb.append(root.val).append(LEVEL_END);

            while (!q.isEmpty()) {
                final int queueSize = q.size();
                for (int i = 0; i < queueSize; i++) {
                    final TreeNode currentNode = q.poll();
                    if (currentNode.left == null) {
                        sb.append(NULL_NODE);
                    } else {
                        sb.append(currentNode.left.val);
                        q.add(currentNode.left);
                    }
                    sb.append(NODE_DELIMITER);

                    if (currentNode.right == null) {
                        sb.append(NULL_NODE);
                    } else {
                        sb.append(currentNode.right.val);
                        q.add(currentNode.right);
                    }
                    sb.append(NODE_DELIMITER);
                }
                sb.append(LEVEL_END);
            }

            return sb.toString();
        }


        // Decodes your encoded data to tree.
        /*
            Time complexity : O(n)
            Space complexity: O(n)
         */
        public TreeNode deserialize(final String data) {
            if (data.length() == 0) {
                return null;
            }

            final String[] treeNodeInfo = data.split(LEVEL_END);

            final Queue<TreeNode> queue = new LinkedList<>();
            final TreeNode returnNode = createTreeNode(treeNodeInfo[0]);
            queue.add(returnNode);

            int treeNodeInfoCounter = 1;
            while (!queue.isEmpty()) {

                final String[] nodes = treeNodeInfo[treeNodeInfoCounter].split(NODE_DELIMITER);
                int nodeCounter = 0;

                while (nodeCounter < nodes.length) {
                    final TreeNode currentNode = queue.poll();

                    final String leftNodeVal = nodes[nodeCounter++];
                    if (NULL_NODE.equals(leftNodeVal)) {
                        currentNode.left = null;
                    } else {
                        final TreeNode leftNode = createTreeNode(leftNodeVal);
                        currentNode.left = leftNode;
                        queue.add(leftNode);
                    }

                    final String rightNodeVal = nodes[nodeCounter++];
                    if (NULL_NODE.equals(rightNodeVal)) {
                        currentNode.right = null;
                    } else {
                        final TreeNode rightNode = createTreeNode(rightNodeVal);
                        currentNode.right = rightNode;
                        queue.add(rightNode);
                    }
                }

                treeNodeInfoCounter++;
            }
            return returnNode;
        }

        private TreeNode createTreeNode(final String rightNodeVal) {
            final int rightVal = Integer.parseInt(rightNodeVal);
            return new TreeNode(rightVal);
        }

    }

}
