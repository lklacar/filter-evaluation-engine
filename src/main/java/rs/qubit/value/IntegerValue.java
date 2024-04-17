package rs.qubit.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public final class IntegerValue implements Value {
    private int value;

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
