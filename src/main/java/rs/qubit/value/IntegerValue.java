package rs.qubit.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public final class IntegerValue implements ComparableValue {
    private int value;

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(ComparableValue other) {
        return switch (other) {
            case IntegerValue integerValue -> value == integerValue.value;
            default -> throw new IllegalArgumentException("Cannot compare IntegerValue with " + other.getClass());
        };
    }

    @Override
    public boolean greaterThan(ComparableValue other) {
        return switch (other) {
            case IntegerValue integerValue -> value > integerValue.value;
            default -> throw new IllegalArgumentException("Cannot compare IntegerValue with " + other.getClass());
        };
    }
}
