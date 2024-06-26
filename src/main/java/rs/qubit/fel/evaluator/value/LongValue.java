package rs.qubit.fel.evaluator.value;

import rs.qubit.fel.exception.FilterException;

public record LongValue(Long value) implements Value {
    @Override
    public boolean asBoolean() {
        throw new FilterException("Cannot convert long to boolean");
    }

    @Override
    public boolean greaterThan(Value value) {
        return switch (value) {
            case LongValue longValue -> this.value > longValue.value;
            case DoubleValue doubleValue -> this.value > doubleValue.value();
            default -> throw new FilterException("Cannot compare long with " + value.getClass().getSimpleName());
        };
    }

    @Override
    public boolean lessThan(Value value) {
        return switch (value) {
            case LongValue longValue -> this.value < longValue.value;
            case DoubleValue doubleValue -> this.value < doubleValue.value();
            default -> throw new FilterException("Cannot compare long with " + value.getClass().getSimpleName());
        };
    }

    @Override
    public boolean equal(Value value) {
        return switch (value) {
            case LongValue longValue -> this.value.equals(longValue.value);
            case DoubleValue doubleValue -> doubleValue.value() == this.value;
            default -> throw new FilterException("Cannot compare long with " + value.getClass().getSimpleName());
        };
    }

    @Override
    public boolean lessThanOrEquals(Value right) {
        return switch (right) {
            case LongValue longValue -> this.value <= longValue.value;
            case DoubleValue doubleValue -> this.value <= doubleValue.value();
            default -> throw new FilterException("Cannot compare long with " + right.getClass().getSimpleName());
        };
    }

    @Override
    public boolean greaterThanOrEquals(Value right) {
        return switch (right) {
            case LongValue longValue -> this.value >= longValue.value;
            case DoubleValue doubleValue -> this.value >= doubleValue.value();
            default -> throw new FilterException("Cannot compare long with " + right.getClass().getSimpleName());
        };
    }

    @Override
    public Object asObject() {
        throw new FilterException("Cannot convert long to object");
    }
}
