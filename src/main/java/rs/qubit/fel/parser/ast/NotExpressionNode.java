package rs.qubit.fel.parser.ast;

import rs.qubit.fel.visitor.ExpressionVisitor;

public record NotExpressionNode(ExpressionNode expression) implements ExpressionNode {

    @Override
    public <T, E, R> T accept(ExpressionVisitor<T, E, R> visitor, E env, R record) {
        return visitor.visit(this, env, record);
    }
}
