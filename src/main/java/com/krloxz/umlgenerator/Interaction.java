package com.krloxz.umlgenerator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Interaction {

    private final Operation operation;

    public Interaction(final Operation operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Interaction) {
            final Interaction other = (Interaction) object;
            return new EqualsBuilder()
                    .append(this.operation, other.operation)
                    .isEquals();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.operation)
                .toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
