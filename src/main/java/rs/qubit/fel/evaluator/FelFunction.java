package rs.qubit.fel.evaluator;

import rs.qubit.fel.evaluator.value.Value;

import java.util.List;
import java.util.function.Function;

public interface FelFunction extends Function<List<Value>, Value> {
}
