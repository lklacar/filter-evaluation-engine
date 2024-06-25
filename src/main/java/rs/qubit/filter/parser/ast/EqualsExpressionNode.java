package rs.qubit.filter.parser.ast;

import rs.qubit.filter.visitor.ExpressionVisitor;

public record EqualsExpressionNode(ExpressionNode left, ExpressionNode right) implements ExpressionNode {
    @Override
    public <T, E, R> T accept(ExpressionVisitor<T, E, R> visitor, E env, R record) {
        return visitor.visit(this, env, record);
    }
}
