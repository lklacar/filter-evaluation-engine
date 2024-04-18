package rs.qubit.value;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public final class StringValue implements ComparableValue {
    private String value;

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(ComparableValue other) {
        return switch (other) {
            case StringValue stringValue -> value.equals(stringValue.value);
            default -> throw new IllegalArgumentException("Cannot compare StringValue with " + other.getClass());
        };
    }

    @Override
    public boolean greaterThan(ComparableValue other) {
        return switch (other) {
            case StringValue stringValue -> value.compareTo(stringValue.value) > 0;
            default -> throw new IllegalArgumentException("Cannot compare StringValue with " + other.getClass());
        };
    }
}
