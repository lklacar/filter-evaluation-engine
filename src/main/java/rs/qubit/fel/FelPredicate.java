package rs.qubit.fel;

import lombok.Getter;
import rs.qubit.fel.evaluator.EvaluationContext;
import rs.qubit.fel.evaluator.FelFunction;
import rs.qubit.fel.evaluator.value.Value;

import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public abstract class FelPredicate implements Predicate<Object> {

    private final EvaluationContext context;

    public FelPredicate(EvaluationContext context) {
        this.context = context;
    }

    public <T> FelPredicate withMapper(Class<T> type, Function<T, Value> mapper) {
        context.addMapper(type, mapper);
        return this;
    }

    public FelPredicate withFunction(String name, FelFunction function) {
        context.addFunction(name, function);
        return this;
    }
}
