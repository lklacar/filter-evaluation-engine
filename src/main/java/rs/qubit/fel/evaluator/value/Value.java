package rs.qubit.fel.evaluator.value;

import java.time.LocalDateTime;

public sealed interface Value permits ObjectValue, BooleanValue, DateTimeValue, DoubleValue, LongValue, NullValue, StringValue {
    boolean asBoolean();

    boolean greaterThan(Value value);

    boolean lessThan(Value value);

    boolean equal(Value value);

    boolean lessThanOrEquals(Value right);

    boolean greaterThanOrEquals(Value right);

    Object asObject();

    String asString();

    Long asLong();

    Double asDouble();

    LocalDateTime asDateTime();
}
