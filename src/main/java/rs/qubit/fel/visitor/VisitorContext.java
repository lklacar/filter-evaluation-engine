package rs.qubit.fel.visitor;

import rs.qubit.fel.evaluator.FelFunction;
import rs.qubit.fel.evaluator.value.Value;

import java.util.List;
import java.util.function.Function;

public interface VisitorContext {

    Function<List<Value>, Value> getFunction(String function);

    Function<Object, Value> getMapper(Class<?> aClass);

    <T> void addMapper(Class<T> type, Function<T, Value> mapper);

    void addFunction(String name, FelFunction function);
}
