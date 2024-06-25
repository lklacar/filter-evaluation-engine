package rs.qubit.filter.parser.ast;

import rs.qubit.filter.visitor.ExpressionVisitor;

public interface ExpressionNode extends Node {

    <T, E, R> T accept(ExpressionVisitor<T, E, R> visitor, E env, R record);
}
