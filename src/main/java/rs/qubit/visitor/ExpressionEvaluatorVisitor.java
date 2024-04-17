package rs.qubit.visitor;

import rs.qubit.Record;
import rs.qubit.ast.*;
import rs.qubit.value.*;

import java.util.regex.Pattern;

public class ExpressionEvaluatorVisitor implements Visitor<Value, Record> {

    @Override
    public Value visit(AndExpressionNode andExpressionNode, Record tArg) {
        var left = ((BooleanValue) andExpressionNode.getLeft().accept(this, tArg));
        var right = ((BooleanValue) andExpressionNode.getRight().accept(this, tArg));
        return new BooleanValue(left.isValue() && right.isValue());
    }

    @Override
    public Value visit(ColumnNameExpression columnNameExpression, Record tArg) {
        var value = tArg.get(columnNameExpression.getColumnName());
        return new StringValue(value.toString());
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
    public Value visit(NumberExpression numberExpression, Record tArg) {
        return new NumberValue(numberExpression.getValue());
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

        if(left instanceof BooleanValue leftValue && right instanceof BooleanValue rightValue) {
            return new BooleanValue(leftValue.isValue() == rightValue.isValue());
        }

        if(left instanceof NumberValue leftValue && right instanceof NumberValue rightValue) {
            return new BooleanValue(leftValue.getValue() == rightValue.getValue());
        }

        if(left instanceof StringValue leftValue && right instanceof StringValue rightValue) {
            return new BooleanValue(leftValue.getValue().equals(rightValue.getValue()));
        }

        if(left instanceof DateValue leftValue && right instanceof DateValue rightValue) {
            return new BooleanValue(leftValue.getValue().equals(rightValue.getValue()));
        }

        // try to cast both to string
        return new BooleanValue(left.toString().equals(right.toString()));


        //throw new IllegalArgumentException("Unsupported types for equals operation");

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


        var like = rightValue.replace("%", ".*")
                .replace("_", ".");


        var pattern = Pattern.compile(like);
        var matcher = pattern.matcher(leftValue);
        return new BooleanValue(matcher.matches());

    }

    @Override
    public Value visit(GreaterThanExpression greaterThanExpression, Record tArg) {
        var left = greaterThanExpression.getLeft().accept(this, tArg);
        var right = greaterThanExpression.getRight().accept(this, tArg);

        if(left instanceof NumberValue leftValue && right instanceof NumberValue rightValue) {
            return new BooleanValue(leftValue.getValue() > rightValue.getValue());
        }

        if(left instanceof DateValue leftValue && right instanceof DateValue rightValue) {
            return new BooleanValue(leftValue.getValue().compareTo(rightValue.getValue()) > 0);
        }


        // try to parse into numbers
        try {
            var leftValue = Double.parseDouble(left.toString());
            var rightValue = Double.parseDouble(right.toString());
            return new BooleanValue(leftValue > rightValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unsupported types for greater than operation");
        }


        //throw new IllegalArgumentException("Unsupported types for greater than operation");
    }
}
