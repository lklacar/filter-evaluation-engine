package rs.qubit.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
public class StringValue implements Value {
    private String value;

    @Override
    public String toString() {
        return value;
    }
}
