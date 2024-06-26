package rs.qubit.fel.engine;

import rs.qubit.fel.evaluator.EvaluationContext;
import rs.qubit.fel.evaluator.FilterEvaluator;
import rs.qubit.fel.evaluator.value.Value;
import rs.qubit.fel.parser.FilterParser;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterEngine {

    private final FilterParser parser;
    private final FilterEvaluator evaluator;

    private FilterEngine(Map<Class<?>, Function<Object, Value>> additionalValueParsers) {
        this.parser = new FilterParser();
        this.evaluator = new FilterEvaluator(additionalValueParsers);
    }

    public <T> Stream<T> filter(Stream<T> items, String filterString) {
        var filter = parser.parse(filterString);
        var env = new EvaluationContext();

        return items.filter(item -> evaluator.evaluate(filter, env, item));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static FilterEngine create() {
        return new Builder().build();
    }

    public Predicate<Object> createFilter(String filter) {
        var parsedFilter = parser.parse(filter);
        return item -> evaluator.evaluate(parsedFilter, new EvaluationContext(), item);
    }


    public static class Builder {
        private final Map<Class<?>, Function<Object, Value>> additionalValueParsers = new HashMap<>();

        private Builder() {
        }

        @SuppressWarnings("unchecked")
        public <T> Builder withAdditionalMapper(Class<T> clazz, Function<T, Value> mapper) {
            additionalValueParsers.put(clazz, (Function<Object, Value>) mapper);
            return this;
        }

        public FilterEngine build() {
            return new FilterEngine(additionalValueParsers);
        }
    }
}
