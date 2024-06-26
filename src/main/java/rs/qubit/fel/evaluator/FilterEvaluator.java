package rs.qubit.fel.evaluator;

import rs.qubit.fel.evaluator.value.*;
import rs.qubit.fel.parser.ast.*;
import rs.qubit.fel.reflection.ReflectionUtil;
import rs.qubit.fel.visitor.ExpressionVisitor;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class FilterEvaluator implements ExpressionVisitor<Value, EvaluationContext, Object> {

    public final Map<Class<?>, Function<Object, Value>> additionalValueParsers;

    public FilterEvaluator(Map<Class<?>, Function<Object, Value>> additionalValueParsers) {
        this.additionalValueParsers = additionalValueParsers;
    }

    public boolean evaluate(ExpressionNode filter, EvaluationContext env, Object record) {
        var result = filter.accept(this, env, record);
        return result != null && result.asBoolean();
    }

    @Override
    public Value visit(OrExpressionNode orExpressionNode, EvaluationContext env, Object record) {
        var left = orExpressionNode.left().accept(this, env, record);
        var right = orExpressionNode.right().accept(this, env, record);

        return new BooleanValue(left.asBoolean() || right.asBoolean());
    }

    @Override
    public Value visit(AndExpressionNode andExpressionNode, EvaluationContext env, Object record) {
        var left = andExpressionNode.left().accept(this, env, record);
        var right = andExpressionNode.right().accept(this, env, record);

        return new BooleanValue(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Value visit(EqualsExpressionNode equalsExpressionNode, EvaluationContext env, Object record) {
        var left = equalsExpressionNode.left().accept(this, env, record);
        var right = equalsExpressionNode.right().accept(this, env, record);

        return new BooleanValue(left.equal(right));
    }

    @Override
    public Value visit(NotExpressionNode notExpressionNode, EvaluationContext env, Object record) {
        var value = notExpressionNode.expression().accept(this, env, record);
        return new BooleanValue(!value.asBoolean());
    }

    @Override
    public Value visit(StringExpressionNode stringExpressionNode, EvaluationContext env, Object record) {
        var value = stringExpressionNode.value();
        return new StringValue(value);
    }

    @Override
    public Value visit(BooleanExpressionNode booleanExpressionNode, EvaluationContext env, Object record) {
        var value = booleanExpressionNode.value();
        return new BooleanValue(value);
    }

    @Override
    public Value visit(NullExpressionNode nullExpressionNode, EvaluationContext env, Object record) {
        return new NullValue();
    }

    @Override
    public Value visit(IdentifierExpressionNode identifierExpressionNode, EvaluationContext env, Object record) {
        var identifier = identifierExpressionNode.value();

        var value = ReflectionUtil.accessField(record, identifier);

        return parseValue(value);
    }

    private Value parseValue(Object value) {
        return switch (value) {
            case Byte b -> new LongValue(Long.valueOf(b));
            case Short s -> new LongValue(Long.valueOf(s));
            case Integer d -> new LongValue(Long.valueOf(d));
            case Long l -> new LongValue(l);
            case Float f -> new DoubleValue(f);
            case Double d -> new DoubleValue(d);
            case Character c -> new StringValue(String.valueOf(c));
            case String s -> new StringValue(s);
            case Boolean b -> new BooleanValue(b);
            case Enum<?> e -> new StringValue(e.name());
            case LocalDateTime d -> new DateTimeValue(d);
            case LocalDate d -> new DateTimeValue(d.atStartOfDay());
            case Instant i -> new DateTimeValue(i.atZone(ZoneId.systemDefault()).toLocalDateTime());
            case null -> new NullValue();
            case Object o -> {
                var parser = additionalValueParsers.get(value.getClass());
                yield Optional.ofNullable(parser)
                        .map(p -> p.apply(value))
                        .orElseGet(() -> new ObjectValue(o));
            }
        };
    }

    @Override
    public Value visit(LongExpressionNode longExpressionNode, EvaluationContext env, Object record) {
        var value = longExpressionNode.value();
        return new LongValue(value);
    }

    @Override
    public Value visit(DoubleExpressionNode doubleExpressionNode, EvaluationContext env, Object record) {
        var value = doubleExpressionNode.value();
        return new DoubleValue(value);
    }

    @Override
    public Value visit(DateTimeExpressionNode dateTimeExpressionNode, EvaluationContext env, Object record) {
        var value = dateTimeExpressionNode.date();
        return new DateTimeValue(value);
    }

    @Override
    public Value visit(GreaterThanExpressionNode greaterThanExpressionNode, EvaluationContext env, Object record) {
        var left = greaterThanExpressionNode.left().accept(this, env, record);
        var right = greaterThanExpressionNode.right().accept(this, env, record);
        return new BooleanValue(left.greaterThan(right));
    }

    @Override
    public Value visit(LessThanOrEqualsExpressionNode lessThanOrEqualsExpressionNode, EvaluationContext env, Object record) {
        var left = lessThanOrEqualsExpressionNode.left().accept(this, env, record);
        var right = lessThanOrEqualsExpressionNode.right().accept(this, env, record);
        return new BooleanValue(left.lessThanOrEquals(right));
    }

    @Override
    public Value visit(GreaterThanOrEqualsExpressionNode greaterThanOrEqualsExpressionNode, EvaluationContext env, Object record) {
        var left = greaterThanOrEqualsExpressionNode.left().accept(this, env, record);
        var right = greaterThanOrEqualsExpressionNode.right().accept(this, env, record);
        return new BooleanValue(left.greaterThanOrEquals(right));
    }

    @Override
    public Value visit(NotEqualsExpressionNode notEqualsExpressionNode, EvaluationContext env, Object record) {
        var left = notEqualsExpressionNode.left().accept(this, env, record);
        var right = notEqualsExpressionNode.right().accept(this, env, record);
        return new BooleanValue(!left.equal(right));
    }

    @Override
    public Value visit(LessThanExpressionNode lessThanExpressionNode, EvaluationContext env, Object record) {
        var left = lessThanExpressionNode.left().accept(this, env, record);
        var right = lessThanExpressionNode.right().accept(this, env, record);
        return new BooleanValue(left.lessThan(right));
    }

    @Override
    public Value visit(DotExpressionNode dotExpressionNode, EvaluationContext env, Object record) {
        var object = dotExpressionNode.object().accept(this, env, record);
        var field = dotExpressionNode.field();
        var originalObject = object.asObject();
        var fieldValue = ReflectionUtil.accessField(originalObject, field);
        return parseValue(fieldValue);
    }
}
