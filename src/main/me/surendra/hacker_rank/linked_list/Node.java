package me.surendra.hacker_rank.linked_list;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

class Node {
    final int data;
    Node next;

    Node(final int d) {
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
            "data=" + data +
            ", next=" + next +
            '}';
    }
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(data)
            .append(next)
            .toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Node)) {
            return false;
        }

        final Node other = (Node) obj;
        return new EqualsBuilder()
            .append(this.data, other.data)
            .append(this.next, other.next)
            .isEquals();
    }

}
