package me.surendra.leetcode.trees.binary_search_tree.bfs;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SerializeAndDeserializeBSTTest {

    final SerializeAndDeserializeBST serializeAndDeserializeBST = new SerializeAndDeserializeBST();

    private TreeNode callDfs(final TreeNode treeNode) {
        final SerializeAndDeserializeBST.DFS dfs = serializeAndDeserializeBST.new DFS();

        final String serialize = dfs.serialize(treeNode);
        final TreeNode deserialize = dfs.deserialize(serialize);
        return deserialize;
    }

    private TreeNode callBfs(final TreeNode treeNode) {
        final SerializeAndDeserializeBST.BFS bfs = serializeAndDeserializeBST.new BFS();

        final String serialize = bfs.serialize(treeNode);
        final TreeNode deserialize = bfs.deserialize(serialize);
        return deserialize;
    }

    private void callAndVerify(final TreeNode treeNode) {
        final TreeNode deserialize = callDfs(treeNode);
//        final TreeNode deserialize = callBfs(treeNode);

        assertThat(deserialize, equalTo(treeNode));
    }


    @Test
    public void nullTest() {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder();

        callAndVerify(treeNode);
    }

    @Test
    public void oneLevelTree() {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(2, 1, 3);

        callAndVerify(treeNode);
    }

    @Test
    public void unBalancedTree1() {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(4, 2, 5, 1, 3);

        callAndVerify(treeNode);
    }


    @Test
    public void unBalancedTree2() {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(4, 2, null, 1, 3);

        callAndVerify(treeNode);
    }

    @Test
    public void doubleDigitalValues() {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(41, 37, 44, 24, 39, 42, 48, 1, 35, 38, 40,
            null, 43, 46, 49, 0, 2, 30, 36, null, null, null, null, null, null, 45, 47, null, null, null, null, null, 4,
            29, 32, null, null, null, null, null, null, 3, 9, 26, null, 31, 34, null, null, 7, 11, 25, 27, null, null, 33,
            null, 6, 8, 10, 16, null, null, null, 28, null, null, 5, null, null, null, null, null, 15, 19, null, null, null,
            null, 12, null, 18, 20, null, 13, 17, null, null, 22, null, 14, null, null, 21, 23);

        callAndVerify(treeNode);
    }

}
