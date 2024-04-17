package rs.qubit;

import rs.qubit.ast.*;

import java.util.Arrays;
import java.util.Date;

public class Query {

    public static OrExpression or(ExpressionNode... expressions) {
        return ((OrExpression) Arrays.stream(expressions)
                .reduce(OrExpression::new)
                .orElseThrow());
    }

    public static AndExpressionNode and(ExpressionNode... expressions) {
        return ((AndExpressionNode) Arrays.stream(expressions)
                .reduce(AndExpressionNode::new)
                .orElseThrow());
    }

    public static NotExpression not(ExpressionNode expression) {
        return new NotExpression(expression);
    }

    public static ColumnNameExpression column(String columnName) {
        return new ColumnNameExpression(columnName);
    }

    public static DateExpression date(Date date) {
        return new DateExpression(date);
    }

    public static NumberExpression number(int value) {
        return new NumberExpression(value);
    }

    public static StringExpression string(String value) {
        return new StringExpression(value);
    }

    public static LikeExpressionNode like(ExpressionNode left, ExpressionNode right) {
        return new LikeExpressionNode(left, right);
    }

    public static GreaterThanExpression greaterThan(ExpressionNode left, ExpressionNode right) {
        return new GreaterThanExpression(left, right);
    }

    public static EqualsNode equal(ExpressionNode left, ExpressionNode right) {
        return new EqualsNode(left, right);
    }



}
