package rs.qubit.fel;


import rs.qubit.fel.evaluator.DefaultEvaluationContext;
import rs.qubit.fel.visitor.VisitorContext;
import rs.qubit.fel.evaluator.FilterEvaluator;
import rs.qubit.fel.parser.FilterParser;
import rs.qubit.fel.parser.ast.ExpressionNode;

public class Fel {

    private Fel() {
        throw new IllegalStateException("Utility class");
    }

    public static FelPredicate filter(String filter) {
        return filter(filter, new DefaultEvaluationContext());
    }

    public static FelPredicate fromAst(ExpressionNode filterAst) {
        return fromAst(filterAst, new DefaultEvaluationContext());
    }

    public static FelPredicate filter(String filter, VisitorContext evaluationContext) {
        var parser = new FilterParser();
        var filterAst = parser.parse(filter);
        return fromAst(filterAst, evaluationContext);
    }

    public static FelPredicate fromAst(ExpressionNode filterAst, VisitorContext evaluationContext) {
        var evaluator = new FilterEvaluator();

        return new FelPredicate(evaluationContext, filterAst) {
            @Override
            public boolean test(Object o) {
                return filterAst.accept(evaluator, evaluationContext, o).asBoolean();
            }
        };
    }
}
