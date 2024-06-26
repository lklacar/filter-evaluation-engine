package rs.qubit.fel.evaluator.value;

import rs.qubit.fel.exception.FilterException;

public record BooleanValue(boolean value) implements Value {
    @Override
    public boolean asBoolean() {
        return value;
    }

    @Override
    public boolean greaterThan(Value value) {
        throw new FilterException("Cannot compare boolean values");
    }

    @Override
    public boolean lessThan(Value value) {
        throw new FilterException("Cannot compare boolean values");
    }

    @Override
    public boolean equal(Value value) {
        return switch (value) {
            case BooleanValue booleanValue -> this.value == booleanValue.value;
            default -> false;
        };
    }

    @Override
    public boolean lessThanOrEquals(Value right) {
        throw new FilterException("Cannot compare boolean values");
    }

    @Override
    public boolean greaterThanOrEquals(Value right) {
        throw new FilterException("Cannot compare boolean values");
    }

    @Override
    public Object asObject() {
        throw new FilterException("Cannot convert boolean to object");
    }

    @Override
    public String asString() {
        return String.valueOf(value);
    }

    @Override
    public Long asLong() {
        throw new FilterException("Cannot convert boolean to long");
    }

    @Override
    public Double asDouble() {
        throw new FilterException("Cannot convert boolean to double");
    }
}
