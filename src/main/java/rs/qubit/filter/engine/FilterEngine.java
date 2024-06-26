package rs.qubit.filter.engine;

import rs.qubit.filter.evaluator.EvaluationContext;
import rs.qubit.filter.evaluator.FilterEvaluator;
import rs.qubit.filter.evaluator.value.Value;
import rs.qubit.filter.parser.FilterParser;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
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

    public static class Builder {
        private final Map<Class<?>, Function<Object, Value>> additionalValueParsers = new HashMap<>();

        private Builder() {
        }

        public <T> Builder withAdditionalMapper(Class<T> clazz, Function<T, Value> mapper) {
            additionalValueParsers.put(clazz, (Function<Object, Value>) mapper);
            return this;
        }

        public FilterEngine build() {
            return new FilterEngine(additionalValueParsers);
        }
    }
}
