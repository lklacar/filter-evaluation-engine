package rs.qubit.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class NumberValue implements Value {
    private int value;

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
