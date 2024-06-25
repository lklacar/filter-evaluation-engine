package rs.qubit.filter.parser.ast;

import rs.qubit.filter.visitor.ExpressionVisitor;

public record DoubleExpressionNode(double value) implements ExpressionNode {
    @Override
    public <T, E, R> T accept(ExpressionVisitor<T, E, R> visitor, E env, R record) {
        return visitor.visit(this, env, record);
    }
}
