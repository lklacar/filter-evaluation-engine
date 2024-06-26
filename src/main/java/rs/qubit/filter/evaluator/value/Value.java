package rs.qubit.filter.evaluator.value;

public sealed interface Value permits ObjectValue, BooleanValue, DateTimeValue, DoubleValue, LongValue, NullValue, StringValue {
    boolean asBoolean();

    boolean greaterThan(Value value);

    boolean lessThan(Value value);

    boolean equal(Value value);

    boolean lessThanOrEquals(Value right);

    boolean greaterThanOrEquals(Value right);

    Object asObject();
}
