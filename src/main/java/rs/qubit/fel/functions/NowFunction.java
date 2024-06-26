package rs.qubit.fel.functions;

import rs.qubit.fel.evaluator.FelFunction;
import rs.qubit.fel.evaluator.value.DateTimeValue;
import rs.qubit.fel.evaluator.value.LongValue;
import rs.qubit.fel.evaluator.value.Value;
import rs.qubit.fel.exception.FilterException;

import java.util.List;

public class NowFunction implements FelFunction {
    @Override
    public Value apply(List<Value> values) {
        if (values.size() != 1) {
            throw new FilterException("length function accepts only one argument");
        }

        var localDateTime = java.time.LocalDateTime.now();

        return new DateTimeValue(localDateTime);
    }
}
