package rs.qubit.fel.functions;

import rs.qubit.fel.evaluator.FelFunction;
import rs.qubit.fel.evaluator.value.StringValue;
import rs.qubit.fel.evaluator.value.Value;
import rs.qubit.fel.exception.FilterException;

import java.util.List;

public class SubstringFunction implements FelFunction {
    @Override
    public Value apply(List<Value> values) {
        if (values.size() != 3) {
            throw new FilterException("substring function accepts only three arguments");
        }
        var value = values.get(0).asString();
        var start = values.get(1).asLong().intValue();
        var end = values.get(2).asLong().intValue();

        if (start < 0 || start > value.length()) {
            throw new FilterException("substring function start index out of bounds");
        }

        if (end < 0 || end > value.length()) {
            throw new FilterException("substring function end index out of bounds");
        }

        if (start > end) {
            throw new FilterException("substring function start index greater than end index");
        }

        var substringValue = value.substring(start, end);
        return new StringValue(substringValue);
    }
}
