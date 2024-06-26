package rs.qubit.filter.evaluator.value;

import rs.qubit.filter.exception.FilterException;

public record LongValue(Long value) implements Value {
    @Override
    public boolean asBoolean() {
        throw new FilterException("Cannot convert long to boolean");
    }

    @Override
    public boolean greaterThan(Value value) {
        return switch (value) {
            case LongValue longValue -> this.value > longValue.value;
            default -> throw new FilterException("Cannot compare long with " + value.getClass().getSimpleName());
        };
    }

    @Override
    public boolean lessThan(Value value) {
        return switch (value) {
            case LongValue longValue -> this.value < longValue.value;
            default -> throw new FilterException("Cannot compare long with " + value.getClass().getSimpleName());
        };
    }

    @Override
    public boolean equal(Value value) {
        return switch (value) {
            case LongValue longValue -> this.value.equals(longValue.value);
            default -> throw new FilterException("Cannot compare long with " + value.getClass().getSimpleName());
        };
    }

    @Override
    public boolean lessThanOrEquals(Value right) {
        return switch (right) {
            case LongValue longValue -> this.value <= longValue.value;
            default -> throw new FilterException("Cannot compare long with " + right.getClass().getSimpleName());
        };
    }

    @Override
    public boolean greaterThanOrEquals(Value right) {
        return switch (right) {
            case LongValue longValue -> this.value >= longValue.value;
            default -> throw new FilterException("Cannot compare long with " + right.getClass().getSimpleName());
        };
    }

    @Override
    public Object asObject() {
        throw new FilterException("Cannot convert long to object");
    }
}
