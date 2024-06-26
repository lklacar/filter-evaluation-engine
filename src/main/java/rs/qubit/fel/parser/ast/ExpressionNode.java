package rs.qubit.fel.parser.ast;

import rs.qubit.fel.visitor.ExpressionVisitor;

public interface ExpressionNode extends Node {

    <T, E, R> T accept(ExpressionVisitor<T, E, R> visitor, E env, R record);
}
