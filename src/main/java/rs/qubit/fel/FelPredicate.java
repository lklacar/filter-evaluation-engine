package rs.qubit.fel;

import lombok.Getter;
import rs.qubit.fel.evaluator.FelFunction;
import rs.qubit.fel.evaluator.value.Value;
import rs.qubit.fel.parser.ast.ExpressionNode;
import rs.qubit.fel.visitor.ExpressionVisitor;
import rs.qubit.fel.visitor.VisitorContext;

import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public abstract class FelPredicate implements Predicate<Object> {

    private final VisitorContext context;
    private final ExpressionNode ast;

    public FelPredicate(VisitorContext context, ExpressionNode ast) {
        this.context = context;
        this.ast = ast;
    }

    public <T> FelPredicate withMapper(Class<T> type, Function<T, Value> mapper) {
        context.addMapper(type, mapper);
        return this;
    }

    public FelPredicate withFunction(String name, FelFunction function) {
        context.addFunction(name, function);
        return this;
    }

    public <T extends VisitorContext> String generate(ExpressionVisitor<String, T, Void> visitor, T context) {
        return ast.accept(visitor, context, null);
    }
}
