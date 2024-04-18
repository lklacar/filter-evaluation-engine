package rs.qubit.value;

public sealed interface ComparableValue extends Value permits BooleanValue, DateValue, IntegerValue, StringValue {
    boolean equals(ComparableValue other);

    boolean greaterThan(ComparableValue other);
}
