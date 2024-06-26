package rs.qubit.fel.functions;

import rs.qubit.fel.evaluator.FelFunction;
import rs.qubit.fel.evaluator.value.StringValue;
import rs.qubit.fel.evaluator.value.Value;
import rs.qubit.fel.exception.FilterException;

import java.util.List;

public class TrimFunction implements FelFunction {
    @Override
    public Value apply(List<Value> values) {
        if (values.size() != 1) {
            throw new FilterException("toUpperCase function accepts only one argument");
        }
        var value = values.get(0).asString();
        var trimmedValue = value.trim();
        return new StringValue(trimmedValue);
    }
}
