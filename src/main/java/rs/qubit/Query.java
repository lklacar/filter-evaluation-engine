package rs.qubit;

import rs.qubit.ast.*;

import java.util.Arrays;
import java.util.Date;

public class Query {

    public static CompositeOr or(ExpressionNode... expressions) {
        return new CompositeOr(Arrays.asList(expressions));
    }

    public static CompositeAnd and(ExpressionNode... expressions) {
        return CompositeAnd.builder()
                .expressions(Arrays.asList(expressions))
                .build();
    }

    public static NotExpression not(ExpressionNode expression) {
        return new NotExpression(expression);
    }

    public static IdentifierExpression column(String columnName) {
        return new IdentifierExpression(columnName);
    }

    public static DateExpression date(Date date) {
        return new DateExpression(date);
    }

    public static IntegerExpression integer(int value) {
        return new IntegerExpression(value);
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
