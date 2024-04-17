package rs.qubit.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public final class DateValue implements Value {
    private Date value;

    @Override
    public String toString() {
        return value.toString();
    }
}
