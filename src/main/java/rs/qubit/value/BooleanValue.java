package rs.qubit.value;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public final class BooleanValue implements ComparableValue {
    private boolean value;

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    @Override
    public boolean equals(ComparableValue other) {
        return switch (other) {
            case BooleanValue booleanValue -> value == booleanValue.value;
            default -> throw new IllegalArgumentException("Cannot compare BooleanValue with " + other.getClass());
        };
    }

    @Override
    public boolean greaterThan(ComparableValue other) {
        throw new UnsupportedOperationException("Cannot compare BooleanValue with " + other.getClass());
    }
}
