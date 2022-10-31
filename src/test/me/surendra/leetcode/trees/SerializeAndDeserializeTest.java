package me.surendra.leetcode.trees;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SerializeAndDeserializeTest {

    final SerializeAndDeserialize serializeAndDeserializeBST = new SerializeAndDeserialize();

    private TreeNode callDfsMethod(final TreeNode treeNode) {
        final SerializeAndDeserialize.DFS dfs = serializeAndDeserializeBST.new DFS();

        final String serialize = dfs.serialize(treeNode);
        final TreeNode deserialize = dfs.deserialize(serialize);
        return deserialize;
    }

    private TreeNode callBfsMethod(final TreeNode treeNode) {
        final SerializeAndDeserialize.BFS bfs = serializeAndDeserializeBST.new BFS();

        final String serialize = bfs.serialize(treeNode);
        final TreeNode deserialize = bfs.deserialize(serialize);
        return deserialize;
    }

    private void callAndVerify(final TreeNode treeNode) {
        final TreeNode deserialize = callDfsMethod(treeNode);
//        final TreeNode deserialize = callBfsMethod(treeNode);

        assertThat(deserialize, equalTo(treeNode));
    }


    @Test
    public void nullTest() {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder();

        callAndVerify(treeNode);
    }

    @Test
    public void withMultipleNodes() {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(1, 2, 3, null, null, 4, 5);

        callAndVerify(treeNode);
    }


}
