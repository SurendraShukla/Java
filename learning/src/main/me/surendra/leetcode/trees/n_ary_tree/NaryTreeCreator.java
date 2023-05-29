package me.surendra.leetcode.trees.n_ary_tree;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NaryTreeCreator {

    public static Node from(final Integer ...numbers) {
        if (numbers == null) {
            return null;
        }
        return from(Lists.newArrayList(numbers));
    }


    /*
        Time complexity : O(n)
        Space complexity: O(n) - Breadth of Tree
     */
    public static Node from(final List<Integer> integerList) {
        if (integerList == null || integerList.isEmpty()) {
            return null;
        }

        final Node returnNode = new Node(integerList.get(0), new ArrayList<>());
        Node currentNode = returnNode;
        final Queue<Node> q = new LinkedList<>();
        q.add(returnNode);

        for (int i = 1; i < integerList.size(); i++) {
            final Integer nodeVal = integerList.get(i);
            if (nodeVal == null) {
                currentNode = q.remove();
                continue;
            }
            final Node children = new Node(nodeVal, new ArrayList<>());
            currentNode.getChildren().add(children);
            q.add(children);
        }
        return returnNode;
    }

}
