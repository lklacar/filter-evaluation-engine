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

public class ExpressionEvaluatorVisitor implements Visitor<Value, Record> {

    private final Map<Pair<Class<?>, Class<?>>, BiFunction<Value, Value, Boolean>> EQUALS_OPERATIONS;
    private final Map<Pair<Class<?>, Class<?>>, BiFunction<Value, Value, Boolean>> GREATER_THAN_OPERATIONS;

    public ExpressionEvaluatorVisitor() {
        EQUALS_OPERATIONS = Map.of(
                Pair.of(BooleanValue.class, BooleanValue.class), this::booleanEquals,
                Pair.of(IntegerValue.class, IntegerValue.class), this::integerEquals,
                Pair.of(StringValue.class, StringValue.class), this::stringEquals,
                Pair.of(DateValue.class, DateValue.class), this::dateEquals
        );

        GREATER_THAN_OPERATIONS = Map.of(
                Pair.of(IntegerValue.class, IntegerValue.class), this::integerGreaterThan,
                Pair.of(DateValue.class, DateValue.class), this::dateGreaterThan
        );
    }

    private Boolean integerGreaterThan(Value left, Value right) {
        assert left instanceof IntegerValue;
        assert right instanceof IntegerValue;
        return ((IntegerValue) left).getValue() > ((IntegerValue) right).getValue();
    }

    private Boolean dateGreaterThan(Value left, Value right) {
        assert left instanceof DateValue;
        assert right instanceof DateValue;
        return ((DateValue) left).getValue().compareTo(((DateValue) right).getValue()) > 0;
    }

    private Boolean booleanEquals(Value left, Value right) {
        assert left instanceof BooleanValue;
        assert right instanceof BooleanValue;
        return ((BooleanValue) left).isValue() == ((BooleanValue) right).isValue();
    }

    private Boolean integerEquals(Value left, Value right) {
        assert left instanceof IntegerValue;
        assert right instanceof IntegerValue;
        return ((IntegerValue) left).getValue() == ((IntegerValue) right).getValue();
    }

    private Boolean stringEquals(Value left, Value right) {
        assert left instanceof StringValue;
        assert right instanceof StringValue;
        return ((StringValue) left).getValue().equals(((StringValue) right).getValue());
    }

    private Boolean dateEquals(Value left, Value right) {
        assert left instanceof DateValue;
        assert right instanceof DateValue;
        return ((DateValue) left).getValue().equals(((DateValue) right).getValue());
    }


    @Override
    public Value visit(AndExpressionNode andExpressionNode, Record tArg) {
        var left = ((BooleanValue) andExpressionNode.getLeft().accept(this, tArg));
        var right = ((BooleanValue) andExpressionNode.getRight().accept(this, tArg));
        return new BooleanValue(left.isValue() && right.isValue());
    }

    @Override
    public Value visit(ColumnNameExpression columnNameExpression, Record tArg) {
        var value = tArg.get(columnNameExpression.getColumnName());
        return parseValue(value);
    }

    private static Value parseValue(Object value) {
        return switch (value) {
            case String s -> new StringValue(s);
            case Integer d -> new IntegerValue(d);
            case Boolean b -> new BooleanValue(b);
            case Date d -> new DateValue(d);
            default -> throw new IllegalArgumentException("Unsupported type");
        };
    }

    @Override
    public Value visit(DateExpression dateExpression, Record tArg) {
        return new DateValue(dateExpression.getDate());
    }

    @Override
    public Value visit(NotExpression notExpression, Record tArg) {
        var expression = ((BooleanValue) notExpression.getExpression().accept(this, tArg));

        return new BooleanValue(!expression.isValue());
    }

    @Override
    public Value visit(IntegerExpression integerExpression, Record tArg) {
        return new IntegerValue(integerExpression.getValue());
    }

    @Override
    public Value visit(OrExpression orExpression, Record tArg) {
        var left = ((BooleanValue) orExpression.getLeft().accept(this, tArg));
        var right = ((BooleanValue) orExpression.getRight().accept(this, tArg));

        return new BooleanValue(left.isValue() || right.isValue());
    }

    @Override
    public Value visit(EqualsNode equalsNode, Record tArg) {
        var left = equalsNode.getLeft().accept(this, tArg);
        var right = equalsNode.getRight().accept(this, tArg);

        return Optional.ofNullable(EQUALS_OPERATIONS.get(Pair.of(left.getClass(), right.getClass())))
                .map(operation -> new BooleanValue(operation.apply(left, right)))
                .orElseThrow(() -> new IllegalArgumentException("Unsupported types for equals operation"));
    }

    @Override
    public Value visit(StringExpression stringExpression, Record tArg) {
        return new StringValue(stringExpression.getValue());
    }

    @Override
    public Value visit(BooleanExpression booleanExpression, Record tArg) {
        return new BooleanValue(booleanExpression.isValue());
    }

    @Override
    public Value visit(LikeExpressionNode likeExpressionNode, Record tArg) {
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
    public Value visit(GreaterThanExpression greaterThanExpression, Record tArg) {
        var left = greaterThanExpression.getLeft().accept(this, tArg);
        var right = greaterThanExpression.getRight().accept(this, tArg);

        return Optional.ofNullable(GREATER_THAN_OPERATIONS.get(Pair.of(left.getClass(), right.getClass())))
                .map(operation -> new BooleanValue(operation.apply(left, right)))
                .orElseThrow(() -> new IllegalArgumentException("Unsupported types for greater than operation"));
    }
}
