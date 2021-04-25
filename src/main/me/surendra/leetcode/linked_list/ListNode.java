package me.surendra.leetcode.linked_list;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.UUID;

public class ListNode {
    UUID uuid = UUID.randomUUID();
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(val)
            .append(next)
            .append(uuid)
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
            .append(this.uuid, other.uuid)
            .isEquals();
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            ", next=" + next +
            ", uuid=" + uuid +
            '}';
    }
}
