package rs.qubit.fel.evaluator.value;

public record NullValue() implements Value {
    @Override
    public boolean asBoolean() {
        throw new UnsupportedOperationException("Cannot convert null to boolean");
    }

    @Override
    public boolean greaterThan(Value value) {
        throw new UnsupportedOperationException("Cannot compare null with " + value.getClass().getSimpleName());
    }

    @Override
    public boolean lessThan(Value value) {
        throw new UnsupportedOperationException("Cannot compare null with " + value.getClass().getSimpleName());
    }

    @Override
    public boolean equal(Value value) {
        return switch (value) {
            case NullValue nullValue -> true;
            default -> false;
        };
    }

    @Override
    public boolean lessThanOrEquals(Value right) {
        throw new UnsupportedOperationException("Cannot compare null with " + right.getClass().getSimpleName());
    }

    @Override
    public boolean greaterThanOrEquals(Value right) {
        throw new UnsupportedOperationException("Cannot compare null with " + right.getClass().getSimpleName());
    }

    @Override
    public Object asObject() {
        throw new UnsupportedOperationException("Cannot convert null to object");
    }

    @Override
    public String asString() {
        return "null";
    }

    @Override
    public Long asLong() {
        throw new UnsupportedOperationException("Cannot convert null to long");
    }

    @Override
    public Double asDouble() {
        throw new UnsupportedOperationException("Cannot convert null to double");
    }
}
