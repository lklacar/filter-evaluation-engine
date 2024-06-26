package rs.qubit.filter.evaluator;

import rs.qubit.filter.evaluator.value.*;
import rs.qubit.filter.exception.FilterException;
import rs.qubit.filter.parser.ast.*;
import rs.qubit.filter.visitor.ExpressionVisitor;
import rs.qubit.filter.visitor.Record;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FilterEvaluator implements ExpressionVisitor<Value, EvaluationContext, Record> {

    public boolean evaluate(ExpressionNode filter, EvaluationContext env, Record record) {
        var result = filter.accept(this, env, record);
        return result != null && result.asBoolean();
    }

    @Override
    public Value visit(OrExpressionNode orExpressionNode, EvaluationContext env, Record record) {
        var left = orExpressionNode.left().accept(this, env, record);
        var right = orExpressionNode.right().accept(this, env, record);

        return new BooleanValue(left.asBoolean() || right.asBoolean());
    }

    @Override
    public Value visit(AndExpressionNode andExpressionNode, EvaluationContext env, Record record) {
        var left = andExpressionNode.left().accept(this, env, record);
        var right = andExpressionNode.right().accept(this, env, record);

        return new BooleanValue(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Value visit(EqualsExpressionNode equalsExpressionNode, EvaluationContext env, Record record) {
        var left = equalsExpressionNode.left().accept(this, env, record);
        var right = equalsExpressionNode.right().accept(this, env, record);

        return new BooleanValue(left.equal(right));
    }

    @Override
    public Value visit(NotExpressionNode notExpressionNode, EvaluationContext env, Record record) {
        var value = notExpressionNode.expression().accept(this, env, record);
        return new BooleanValue(!value.asBoolean());
    }

    @Override
    public Value visit(StringExpressionNode stringExpressionNode, EvaluationContext env, Record record) {
        var value = stringExpressionNode.value();
        return new StringValue(value);
    }

    @Override
    public Value visit(BooleanExpressionNode booleanExpressionNode, EvaluationContext env, Record record) {
        var value = booleanExpressionNode.value();
        return new BooleanValue(value);
    }

    @Override
    public Value visit(NullExpressionNode nullExpressionNode, EvaluationContext env, Record record) {
        return new NullValue();
    }

    @Override
    public Value visit(IdentifierExpressionNode identifierExpressionNode, EvaluationContext env, Record record) {
        var identifier = identifierExpressionNode.value();
        var value = record.get(identifier);
        return parseValue(value);
    }

    private static Value parseValue(Object value) {
        return switch (value) {
            case String s -> new StringValue(s);
            case Integer d -> new LongValue(Long.valueOf(d));
            case Boolean b -> new BooleanValue(b);
            case Double d -> new DoubleValue(d);
            case LocalDateTime d -> new DateTimeValue(d);
            case LocalDate d -> new DateTimeValue(d.atStartOfDay());
            case null -> new NullValue();
            default -> throw new FilterException("Unsupported value type: " + value.getClass());
        };
    }

    @Override
    public Value visit(LongExpressionNode longExpressionNode, EvaluationContext env, Record record) {
        var value = longExpressionNode.value();
        return new LongValue(value);
    }

    @Override
    public Value visit(DoubleExpressionNode doubleExpressionNode, EvaluationContext env, Record record) {
        var value = doubleExpressionNode.value();
        return new DoubleValue(value);
    }

    @Override
    public Value visit(DateTimeExpressionNode dateTimeExpressionNode, EvaluationContext env, Record record) {
        var value = dateTimeExpressionNode.date();
        return new DateTimeValue(value);
    }

    @Override
    public Value visit(GreaterThanExpressionNode greaterThanExpressionNode, EvaluationContext env, Record record) {
        var left = greaterThanExpressionNode.left().accept(this, env, record);
        var right = greaterThanExpressionNode.right().accept(this, env, record);
        return new BooleanValue(left.greaterThan(right));
    }

    @Override
    public Value visit(LessThanOrEqualsExpressionNode lessThanOrEqualsExpressionNode, EvaluationContext env, Record record) {
        var left = lessThanOrEqualsExpressionNode.left().accept(this, env, record);
        var right = lessThanOrEqualsExpressionNode.right().accept(this, env, record);
        return new BooleanValue(left.lessThanOrEquals(right));
    }

    @Override
    public Value visit(GreaterThanOrEqualsExpressionNode greaterThanOrEqualsExpressionNode, EvaluationContext env, Record record) {
        var left = greaterThanOrEqualsExpressionNode.left().accept(this, env, record);
        var right = greaterThanOrEqualsExpressionNode.right().accept(this, env, record);
        return new BooleanValue(left.greaterThanOrEquals(right));
    }

    @Override
    public Value visit(NotEqualsExpressionNode notEqualsExpressionNode, EvaluationContext env, Record record) {
        var left = notEqualsExpressionNode.left().accept(this, env, record);
        var right = notEqualsExpressionNode.right().accept(this, env, record);
        return new BooleanValue(!left.equal(right));
    }

    @Override
    public Value visit(LessThanExpressionNode lessThanExpressionNode, EvaluationContext env, Record record) {
        var left = lessThanExpressionNode.left().accept(this, env, record);
        var right = lessThanExpressionNode.right().accept(this, env, record);
        return new BooleanValue(left.lessThan(right));
    }
}
