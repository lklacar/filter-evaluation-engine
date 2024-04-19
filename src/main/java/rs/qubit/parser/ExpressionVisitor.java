package rs.qubit.parser;

import lombok.SneakyThrows;
import rs.qubit.ast.*;
import rs.qubit.generated.FilterLanguageBaseVisitor;
import rs.qubit.generated.FilterLanguageParser;

import java.text.DateFormat;
import java.util.Date;

public class ExpressionVisitor extends FilterLanguageBaseVisitor<ExpressionNode> {

    @Override
    public ExpressionNode visitIdentifierExpression(FilterLanguageParser.IdentifierExpressionContext ctx) {
        return new IdentifierExpression(ctx.value.getText());
    }

    @Override
    @SneakyThrows
    public ExpressionNode visitDateExpression(FilterLanguageParser.DateExpressionContext ctx) {
        var dateString = ctx.value.getText();
        var date = DateFormat.getDateInstance().parse(dateString);
        return new DateExpression(date);
    }

    @Override
    public ExpressionNode visitNotExpression(FilterLanguageParser.NotExpressionContext ctx) {
        var expression = ctx.expression().accept(this);
        return new NotExpression(expression);
    }

    @Override
    public ExpressionNode visitParenExpression(FilterLanguageParser.ParenExpressionContext ctx) {
        return ctx.expression().accept(this);
    }

    @Override
    public ExpressionNode visitGreaterThanExpression(FilterLanguageParser.GreaterThanExpressionContext ctx) {
        var left = ctx.left.accept(this);
        var right = ctx.right.accept(this);

        return new GreaterThanExpression(left, right);
    }

    @Override
    public ExpressionNode visitBooleanExpression(FilterLanguageParser.BooleanExpressionContext ctx) {
        var value = Boolean.parseBoolean(ctx.value.getText());
        return new BooleanExpression(value);
    }

    @Override
    public ExpressionNode visitIntegerExpression(FilterLanguageParser.IntegerExpressionContext ctx) {
        var value = Integer.parseInt(ctx.value.getText());
        return new IntegerExpression(value);
    }

    @Override
    public ExpressionNode visitOrExpression(FilterLanguageParser.OrExpressionContext ctx) {
        var left = ctx.left.accept(this);
        var right = ctx.right.accept(this);

        return new OrExpression(left, right);
    }

    @Override
    public ExpressionNode visitAndExpression(FilterLanguageParser.AndExpressionContext ctx) {
        var left = ctx.left.accept(this);
        var right = ctx.right.accept(this);

        return new AndExpressionNode(left, right);
    }

    @Override
    public ExpressionNode visitStringExpression(FilterLanguageParser.StringExpressionContext ctx) {
        var value = ctx.value.getText();
        return new StringExpression(value);
    }

    @Override
    public ExpressionNode visitEqualsExpression(FilterLanguageParser.EqualsExpressionContext ctx) {
        var left = ctx.left.accept(this);
        var right = ctx.right.accept(this);

        return new EqualsNode(left, right);
    }

    @Override
    public ExpressionNode visitLessThanExpression(FilterLanguageParser.LessThanExpressionContext ctx) {
        return super.visitLessThanExpression(ctx);
    }

    @Override
    public ExpressionNode visitLikeExpression(FilterLanguageParser.LikeExpressionContext ctx) {
        return super.visitLikeExpression(ctx);
    }
}
