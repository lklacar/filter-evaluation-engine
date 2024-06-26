package rs.qubit.fel;

import rs.qubit.fel.evaluator.EvaluationContext;

public class FilterFactory {

    private final EvaluationContext evaluationContext;

    public FilterFactory(EvaluationContext evaluationContext) {
        this.evaluationContext = evaluationContext;
    }

    public FelPredicate crateFilter(String filter) {
        return Fel.filter(filter, evaluationContext);
    }

}
