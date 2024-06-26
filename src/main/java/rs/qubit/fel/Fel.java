package rs.qubit.fel;


import rs.qubit.fel.evaluator.DefaultEvaluationContext;
import rs.qubit.fel.evaluator.EvaluationContext;
import rs.qubit.fel.evaluator.FilterEvaluator;
import rs.qubit.fel.parser.FilterParser;

public class Fel {


    public static FelPredicate filter(String filter) {
        var parser = new FilterParser();
        var evaluator = new FilterEvaluator();
        var filterAst = parser.parse(filter);
        var defaultContext = new DefaultEvaluationContext();


        return new FelPredicate(defaultContext) {

            @Override
            public boolean test(Object o) {
                return filterAst.accept(evaluator, defaultContext, o).asBoolean();
            }
        };
    }
}
