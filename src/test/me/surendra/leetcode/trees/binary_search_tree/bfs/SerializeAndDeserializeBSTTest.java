package me.surendra.leetcode.trees.binary_search_tree.bfs;

import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SerializeAndDeserializeBSTTest {

    private void callAndVerify(final TreeNode treeNode) {
        final SerializeAndDeserializeBST serializeAndDeserializeBST = new SerializeAndDeserializeBST();

        final String serialize = serializeAndDeserializeBST.serialize(treeNode);
        final TreeNode deserialize = serializeAndDeserializeBST.deserialize(serialize);

        assertThat(deserialize, equalTo(treeNode));
    }


    @Test
    public void nullTest() {
//        []
        callAndVerify(null);
    }

    @Test
    public void oneLevelTree() {
//        [2,1,3]
        final TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        callAndVerify(treeNode);
    }

    @Test
    public void unBalancedTree1() {
//        [4,2,5,1,3]
        final TreeNode leftNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        final TreeNode treeNode = new TreeNode(4, leftNode, new TreeNode(5));

        callAndVerify(treeNode);
    }


    @Test
    public void unBalancedTree2() {
//          [4,2,null,1,3]
        final TreeNode leftNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        final TreeNode treeNode = new TreeNode(4, leftNode, null);

        callAndVerify(treeNode);
    }

    @Test
    public void doubleDigitalValues() {
//        [41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23]
//        [41,37,44,24,39,42,48]
//        final List<Integer> integerList = Lists.newArrayList(41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23);
//        TreeNode treeNode = TreeCreator.fromPreOrder(integerList);

        final TreeNode leftNode = new TreeNode(37, new TreeNode(24), new TreeNode(39));
        final TreeNode rightNode = new TreeNode(44, new TreeNode(42), new TreeNode(48));
        final TreeNode treeNode = new TreeNode(41, leftNode, rightNode);

        callAndVerify(treeNode);
    }

}
