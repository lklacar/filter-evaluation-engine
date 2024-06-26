package rs.qubit.fel.evaluator.value;

import rs.qubit.fel.exception.FilterException;

public record ObjectValue(Object value) implements Value {
    @Override
    public boolean asBoolean() {
        throw new FilterException("Cannot convert object to boolean");
    }

    @Override
    public boolean greaterThan(Value value) {
        throw new FilterException("Cannot compare object to " + value.getClass().getSimpleName());
    }

    @Override
    public boolean lessThan(Value value) {
        throw new FilterException("Cannot compare object to " + value.getClass().getSimpleName());
    }

    @Override
    public boolean equal(Value value) {
        return switch (value) {
            case NullValue nullValue -> this.value == null;
            default -> throw new FilterException("Cannot compare object to " + value.getClass().getSimpleName());
        };
    }

    @Override
    public boolean lessThanOrEquals(Value right) {
        throw new FilterException("Cannot compare object to " + right.getClass().getSimpleName());
    }

    @Override
    public boolean greaterThanOrEquals(Value right) {
        throw new FilterException("Cannot compare object to " + right.getClass().getSimpleName());
    }

    @Override
    public Object asObject() {
        return value;
    }

    @Override
    public String asString() {
        return value.toString();
    }

    @Override
    public Long asLong() {
        throw new FilterException("Cannot convert object to long");
    }

    @Override
    public Double asDouble() {
        throw new FilterException("Cannot convert object to double");
    }
}

