package rs.qubit.fel.generation;

import rs.qubit.fel.evaluator.FelFunction;
import rs.qubit.fel.evaluator.value.Value;
import rs.qubit.fel.visitor.VisitorContext;

import java.util.List;
import java.util.function.Function;

public class PostgreSQLGenerationContext implements VisitorContext {
    @Override
    public Function<List<Value>, Value> getFunction(String function) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Function<Object, Value> getMapper(Class<?> aClass) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public <T> void addMapper(Class<T> type, Function<T, Value> mapper) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void addFunction(String name, FelFunction function) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
