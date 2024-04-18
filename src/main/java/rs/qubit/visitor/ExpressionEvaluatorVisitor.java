package rs.qubit.visitor;

import org.apache.commons.lang3.tuple.Pair;
import rs.qubit.Record;
import rs.qubit.ast.*;
import rs.qubit.value.*;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class ExpressionEvaluatorVisitor implements Visitor<ComparableValue, Record> {

    @Override
    public ComparableValue visit(AndExpressionNode andExpressionNode, Record tArg) {
        var left = ((BooleanValue) andExpressionNode.getLeft().accept(this, tArg));
        var right = ((BooleanValue) andExpressionNode.getRight().accept(this, tArg));
        return new BooleanValue(left.isValue() && right.isValue());
    }

    @Override
    public ComparableValue visit(ColumnNameExpression columnNameExpression, Record tArg) {
        var value = tArg.get(columnNameExpression.getColumnName());
        return parseValue(value);
    }

    private static ComparableValue parseValue(Object value) {
        return switch (value) {
            case String s -> new StringValue(s);
            case Integer d -> new IntegerValue(d);
            case Boolean b -> new BooleanValue(b);
            case Date d -> new DateValue(d);
            default -> throw new IllegalArgumentException("Unsupported type");
        };
    }

    @Override
    public ComparableValue visit(DateExpression dateExpression, Record tArg) {
        return new DateValue(dateExpression.getDate());
    }

    @Override
    public ComparableValue visit(NotExpression notExpression, Record tArg) {
        var expression = ((BooleanValue) notExpression.getExpression().accept(this, tArg));

        return new BooleanValue(!expression.isValue());
    }

    @Override
    public ComparableValue visit(IntegerExpression integerExpression, Record tArg) {
        return new IntegerValue(integerExpression.getValue());
    }

    @Override
    public ComparableValue visit(OrExpression orExpression, Record tArg) {
        var left = ((BooleanValue) orExpression.getLeft().accept(this, tArg));
        var right = ((BooleanValue) orExpression.getRight().accept(this, tArg));

        return new BooleanValue(left.isValue() || right.isValue());
    }

    @Override
    public ComparableValue visit(EqualsNode equalsNode, Record tArg) {
        var left = equalsNode.getLeft().accept(this, tArg);
        var right = equalsNode.getRight().accept(this, tArg);

        var result = left.equals(right);

        return new BooleanValue(result);
    }

    @Override
    public ComparableValue visit(StringExpression stringExpression, Record tArg) {
        return new StringValue(stringExpression.getValue());
    }

    @Override
    public ComparableValue visit(BooleanExpression booleanExpression, Record tArg) {
        return new BooleanValue(booleanExpression.isValue());
    }

    @Override
    public ComparableValue visit(LikeExpressionNode likeExpressionNode, Record tArg) {
        var left = ((StringValue) likeExpressionNode.getLeft().accept(this, tArg));
        var right = ((StringValue) likeExpressionNode.getRight().accept(this, tArg));

        var leftValue = left.getValue();
        var rightValue = right.getValue();

        var like = rightValue
                .replace("%", ".*")
                .replace("_", ".");

        var pattern = Pattern.compile(like);
        var matcher = pattern.matcher(leftValue);
        return new BooleanValue(matcher.matches());

    }

    @Override
    public ComparableValue visit(GreaterThanExpression greaterThanExpression, Record tArg) {
        var left = greaterThanExpression.getLeft().accept(this, tArg);
        var right = greaterThanExpression.getRight().accept(this, tArg);

        var result = left.greaterThan(right);

        return new BooleanValue(result);
    }

    @Override
    public ComparableValue visit(LessThanExpression lessThanExpression, Record tArg) {
        var left = lessThanExpression.getLeft().accept(this, tArg);
        var right = lessThanExpression.getRight().accept(this, tArg);

        var result = left.lessThan(right);

        return new BooleanValue(result);
    }

    @Override
    public ComparableValue visit(CompositeAnd compositeAnd, Record tArg) {
        var binaryAnd = compositeAnd.toBinaryExpression();
        return binaryAnd.accept(this, tArg);
    }

    @Override
    public ComparableValue visit(CompositeOr compositeOr, Record tArg) {
        var binaryOr = compositeOr.toBinaryExpression();
        return binaryOr.accept(this, tArg);
    }
}
