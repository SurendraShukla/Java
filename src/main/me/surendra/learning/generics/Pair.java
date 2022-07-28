package me.surendra.learning.generics;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.annotation.Nonnull;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Data structure for holding a pair of values.
 *
 * @param <L> type for the left value.
 * @param <R> type for the right value.
 */
public class Pair<L, R> {

    private final L left;
    private final R right;

    @Nonnull
    public static <L, R> Pair<L, R> of(final L left, final R right) {
        return new Pair<>(left, right);
    }

    public Pair(final L left, final R right) {
        this.left = left;
        this.right = right;
    }

    public final L getLeft() {
        return left;
    }

    public final R getRight() {
        return right;
    }

    public final L getKey() {
        return left;
    }

    public final R getValue() {
        return right;
    }

    public <M> Pair<M, R> mapLeft(final Function<L, M> func) {
        return of(func.apply(left), right);
    }

    public <M> Pair<L, M> mapRight(final Function<R, M> func) {
        return of(left, func.apply(right));
    }

    public <M> M reduce(final BiFunction<L, R, M> f) {
        return f.apply(left, right);
    }

    public void onPerfectPair(final BiConsumer<L, R> consumer) {
        if (getLeft() != null && getRight() != null) {
            consumer.accept(getLeft(), getRight());
        }
    }

    public void onLeftOnly(final Consumer<L> consumer) {
        if (getLeft() != null && getRight() == null) {
            consumer.accept(getLeft());
        }
    }

    public void onRightOnly(final Consumer<R> consumer) {
        if (getLeft() == null && getRight() != null) {
            consumer.accept(getRight());
        }
    }

    @Override
    public String toString() {
        return "{" + left + ", " + right + "}";
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(left)
            .append(right)
            .toHashCode();
    }


    @Override
    public boolean equals(final Object rawOther) {
        if (rawOther == null) {
            return false;
        } else if (!(rawOther instanceof Pair)) {
            return false;
        }

        final Pair<?, ?> other = (Pair<?, ?>) rawOther;
        return new EqualsBuilder()
            .append(this.left, other.left)
            .append(this.right, other.right)
            .isEquals();
    }

}
