package me.surendra.learning;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class EqualAndHashCode {
    private boolean isEqual;
    private String hashCode;

    public boolean isEqual() {
        return isEqual;
    }

    public void setEqual(final boolean equal) {
        isEqual = equal;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(final String hashCode) {
        this.hashCode = hashCode;
    }

//    @Override
//    public boolean equals(final Object o) {
//        if (this == o) return true;
//        if (!(o instanceof EqualAndHashCode)) return false;
//        final EqualAndHashCode that = (EqualAndHashCode) o;
//        return isEqual() == that.isEqual() &&
//            Objects.equals(getHashCode(), that.getHashCode());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(isEqual(), getHashCode());
//    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final EqualAndHashCode that = (EqualAndHashCode) o;

        return new EqualsBuilder()
            .append(isEqual, that.isEqual())
            .append(hashCode, that.getHashCode())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
            .append(isEqual)
            .append(hashCode)
            .toHashCode();
    }

    @Override
    public String toString() {
        return "EqualAndHashCode{" +
            "isEqual=" + isEqual +
            ", hashCode='" + hashCode + '\'' +
            '}';
    }
}
