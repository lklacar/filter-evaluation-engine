package rs.qubit.fel.evaluator;

import rs.qubit.fel.evaluator.value.Value;

import java.util.List;
import java.util.function.Function;

public interface EvaluationContext {

    Function<List<Value>, Value> getFunction(String function);

    Function<Object, Value> getMapper(Class<?> aClass);

    <T> void addMapper(Class<T> type, Function<T, Value> mapper);

    void addFunction(String name, Function<List<Value>, Value> function);
}
