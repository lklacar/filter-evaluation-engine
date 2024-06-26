package rs.qubit.fel.evaluator;

import rs.qubit.fel.evaluator.value.Value;
import rs.qubit.fel.exception.FilterException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class DefaultEvaluationContext implements EvaluationContext {

    private final Map<String, Function<List<Value>, Value>> functions;
    private final Map<Class<?>, Function<Object, Value>> mappers;


    public DefaultEvaluationContext() {
        this.functions = new HashMap<>();
        this.mappers = new HashMap<>();
    }

    @Override
    public Function<List<Value>, Value> getFunction(String function) {
        return Optional.ofNullable(functions.get(function))
                .orElseThrow(() -> new FilterException("Function not found: " + function));
    }

    @Override
    public Function<Object, Value> getMapper(Class<?> aClass) {
        return Optional.ofNullable(mappers.get(aClass))
                .orElseThrow(() -> new FilterException("Mapper not found: " + aClass));
    }

    @Override
    public <T> void addMapper(Class<T> type, Function<T, Value> mapper) {
        mappers.put(type, (Function<Object, Value>) mapper);
    }

    @Override
    public void addFunction(String name, Function<List<Value>, Value> function) {
        functions.put(name, function);
    }

    public void extendFunctions(Map<String, Function<List<Value>, Value>> additionalFunctions) {
        functions.putAll(additionalFunctions);
    }

    public void extendMappers(Map<Class<?>, Function<Object, Value>> additionalMappers) {
        mappers.putAll(additionalMappers);
    }
}
