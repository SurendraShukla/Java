package me.surendra.leetcode.linked_list;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


public class ListNode {
    int val;
    ListNode next;

    ListNode(final int val) {
        this.val = val;
    }

    ListNode(final int val, final ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(val)
            .append(next)
            .toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof ListNode)) {
            return false;
        }

        final ListNode other = (ListNode) obj;
        return new EqualsBuilder()
            .append(this.val, other.val)
            .append(this.next, other.next)
            .isEquals();
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            ", next=" + next +
            '}';
    }
    
}
