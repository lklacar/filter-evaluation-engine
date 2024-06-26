package rs.qubit.fel;


import rs.qubit.fel.evaluator.DefaultEvaluationContext;
import rs.qubit.fel.evaluator.EvaluationContext;
import rs.qubit.fel.evaluator.FilterEvaluator;
import rs.qubit.fel.parser.FilterParser;

public class Fel {

    public static FelPredicate filter(String filter) {
        return filter(filter, new DefaultEvaluationContext());
    }

    public static FelPredicate filter(String filter, EvaluationContext evaluationContext) {
        var parser = new FilterParser();
        var evaluator = new FilterEvaluator();
        var filterAst = parser.parse(filter);

        return new FelPredicate(evaluationContext, filterAst) {

            @Override
            public boolean test(Object o) {
                return filterAst.accept(evaluator, evaluationContext, o).asBoolean();
            }
        };
    }
}
