package rs.qubit.filter.engine;

import rs.qubit.filter.evaluator.EvaluationContext;
import rs.qubit.filter.evaluator.FilterEvaluator;
import rs.qubit.filter.parser.FilterParser;
import rs.qubit.filter.reflection.ReflectionUtil;

import java.util.stream.Stream;

public class FilterEngine {

    private final FilterParser parser;
    private final FilterEvaluator evaluator;

    public FilterEngine() {
        this.parser = new FilterParser();
        this.evaluator = new FilterEvaluator();
    }

    public <T> Stream<T> filter(Stream<T> items, String filterString) {
        var filter = parser.parse(filterString);
        var env = new EvaluationContext();

        return items.filter(item -> {
            var map = ReflectionUtil.getFields(item);
            var record = new rs.qubit.filter.visitor.Record(map);
            return evaluator.evaluate(filter, env, record);
        });
    }
}
