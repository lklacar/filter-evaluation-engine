package rs.qubit.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public final class DateValue implements ComparableValue {
    private Date value;

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(ComparableValue other) {
        return switch (other) {
            case DateValue dateValue -> value.equals(dateValue.value);
            default -> throw new IllegalArgumentException("Cannot compare DateValue with " + other.getClass());
        };
    }

    @Override
    public boolean greaterThan(ComparableValue other) {
        return switch (other) {
            case DateValue dateValue -> value.compareTo(dateValue.value) > 0;
            default -> throw new IllegalArgumentException("Cannot compare DateValue with " + other.getClass());
        };
    }
}
