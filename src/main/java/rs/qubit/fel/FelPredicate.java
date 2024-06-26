package rs.qubit.fel;

import lombok.Getter;
import rs.qubit.fel.evaluator.value.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public abstract class FelPredicate implements Predicate<Object> {

    private final Map<Class<?>, Function<Object, Value>> additionalMappers;

    public FelPredicate() {
        this.additionalMappers = new HashMap<>();
    }

    public <T> FelPredicate withMapper(Class<T> type, Function<T, Value> mapper) {
        additionalMappers.put(type, (Function<Object, Value>) mapper);
        return this;
    }
}
