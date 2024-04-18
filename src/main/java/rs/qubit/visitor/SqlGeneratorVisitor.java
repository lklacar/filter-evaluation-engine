package rs.qubit.visitor;

import rs.qubit.Record;
import rs.qubit.ast.*;

public class SqlGeneratorVisitor implements Visitor<String, Record> {
    @Override
    public String visit(AndExpressionNode andExpressionNode, Record tArg) {
        var left = andExpressionNode.getLeft().accept(this, tArg);
        var right = andExpressionNode.getRight().accept(this, tArg);

        return "(%s AND %s)".formatted(left, right);
    }

    @Override
    public String visit(ColumnNameExpression columnNameExpression, Record tArg) {
        return columnNameExpression.getColumnName();
    }

    @Override
    public String visit(DateExpression dateExpression, Record tArg) {
        return dateExpression.getDate().toString();
    }

    @Override
    public String visit(NotExpression notExpression, Record tArg) {
        var expression = notExpression.getExpression().accept(this, tArg);

        return "(NOT %s)".formatted(expression);
    }

    @Override
    public String visit(IntegerExpression integerExpression, Record tArg) {
        var value = integerExpression.getValue();
        return Integer.toString(value);
    }

    @Override
    public String visit(OrExpression orExpression, Record tArg) {
        var left = orExpression.getLeft().accept(this, tArg);
        var right = orExpression.getRight().accept(this, tArg);

        return "(%s OR %s)".formatted(left, right);
    }

    @Override
    public String visit(EqualsNode equalsNode, Record tArg) {
        var left = equalsNode.getLeft().accept(this, tArg);
        var right = equalsNode.getRight().accept(this, tArg);

        return "%s = %s".formatted(left, right);
    }

    @Override
    public String visit(StringExpression stringExpression, Record tArg) {
        return "'%s'".formatted(stringExpression.getValue());
    }

    @Override
    public String visit(BooleanExpression booleanExpression, Record tArg) {
        return Boolean.toString(booleanExpression.isValue());
    }

    @Override
    public String visit(LikeExpressionNode likeExpressionNode, Record tArg) {
        var left = likeExpressionNode.getLeft().accept(this, tArg);
        var right = likeExpressionNode.getRight().accept(this, tArg);
        return "(%s LIKE %s)".formatted(left, right);
    }

    @Override
    public String visit(GreaterThanExpression greaterThanExpression, Record tArg) {
        var left = greaterThanExpression.getLeft().accept(this, tArg);
        var right = greaterThanExpression.getRight().accept(this, tArg);

        return "(%s > %s)".formatted(left, right);
    }

    @Override
    public String visit(LessThanExpression lessThanExpression, Record tArg) {
        var left = lessThanExpression.getLeft().accept(this, tArg);
        var right = lessThanExpression.getRight().accept(this, tArg);

        return "(%s < %s)".formatted(left, right);
    }
}
