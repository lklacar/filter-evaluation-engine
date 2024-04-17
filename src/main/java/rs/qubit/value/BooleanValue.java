package rs.qubit.value;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BooleanValue implements Value {
    private boolean value;

    @Override
    public String toString() {
        return Boolean.toString(value);
    }
}
