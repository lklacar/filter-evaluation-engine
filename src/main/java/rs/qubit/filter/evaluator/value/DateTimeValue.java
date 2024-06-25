package rs.qubit.filter.evaluator.value;

import rs.qubit.filter.exception.FilterException;

public record DateTimeValue(java.time.LocalDateTime value) implements Value {
    @Override
    public boolean asBoolean() {
        throw new FilterException("Cannot convert date time to boolean");
    }

    @Override
    public boolean greaterThan(Value value) {
        return switch (value) {
            case DateTimeValue dateTimeValue -> this.value.isAfter(dateTimeValue.value);
            default -> throw new FilterException("Cannot compare date time with " + value.getClass().getSimpleName());
        };
    }

    @Override
    public boolean lessThan(Value value) {
        return switch (value) {
            case DateTimeValue dateTimeValue -> this.value.isBefore(dateTimeValue.value);
            default -> throw new FilterException("Cannot compare date time with " + value.getClass().getSimpleName());
        };
    }

    @Override
    public boolean equal(Value value) {
        return switch (value) {
            case DateTimeValue dateTimeValue -> this.value.isEqual(dateTimeValue.value);
            default -> throw new FilterException("Cannot compare date time with " + value.getClass().getSimpleName());
        };
    }

    @Override
    public boolean lessThanOrEquals(Value right) {
        return switch (right) {
            case DateTimeValue dateTimeValue ->
                    this.value.isBefore(dateTimeValue.value) || this.value.isEqual(dateTimeValue.value);
            default -> throw new FilterException("Cannot compare date time with " + right.getClass().getSimpleName());
        };
    }

    @Override
    public boolean greaterThanOrEquals(Value right) {
        return switch (right) {
            case DateTimeValue dateTimeValue ->
                    this.value.isAfter(dateTimeValue.value) || this.value.isEqual(dateTimeValue.value);
            default -> throw new FilterException("Cannot compare date time with " + right.getClass().getSimpleName());
        };
    }
}
