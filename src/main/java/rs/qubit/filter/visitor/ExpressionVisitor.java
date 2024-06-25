package rs.qubit.filter.visitor;

import rs.qubit.filter.parser.ast.*;

public interface ExpressionVisitor<T, E, R> {
    T visit(OrExpressionNode orExpressionNode, E env, R record);

    T visit(AndExpressionNode andExpressionNode, E env, R record);

    T visit(EqualsExpressionNode equalsExpressionNode, E env, R record);

    T visit(NotExpressionNode notExpressionNode, E env, R record);

    T visit(StringExpressionNode stringExpressionNode, E env, R record);

    T visit(BooleanExpressionNode booleanExpressionNode, E env, R record);

    T visit(NullExpressionNode nullExpressionNode, E env, R record);

    T visit(IdentifierExpressionNode identifierExpressionNode, E env, R record);

    T visit(LongExpressionNode longExpressionNode, E env, R record);

    T visit(DoubleExpressionNode doubleExpressionNode, E env, R record);

    T visit(DateTimeExpressionNode dateTimeExpressionNode, E env, R record);

    T visit(GreaterThanExpressionNode greaterThanExpressionNode, E env, R record);

    T visit(LessThanOrEqualsExpressionNode lessThanOrEqualsExpressionNode, E env, R record);

    T visit(GreaterThanOrEqualsExpressionNode greaterThanOrEqualsExpressionNode, E env, R record);

    T visit(NotEqualsExpressionNode notEqualsExpressionNode, E env, R record);

    T visit(LessThanExpressionNode lessThanExpressionNode, E env, R record);
}
