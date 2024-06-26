package rs.qubit.fel.parser;

import rs.qubit.fel.parser.ast.*;
import rs.qubit.fel.parser.generated.FilterBaseVisitor;
import rs.qubit.fel.parser.generated.FilterParser;

import java.time.LocalDateTime;
import java.util.Optional;

public class ExpressionParserVisitor extends FilterBaseVisitor<ExpressionNode> {

    @Override
    public ExpressionNode visitOrExpression(FilterParser.OrExpressionContext ctx) {
        var left = visit(ctx.left);
        var right = visit(ctx.right);

        return new OrExpressionNode(left, right);
    }

    @Override
    public ExpressionNode visitParenExpression(FilterParser.ParenExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public ExpressionNode visitAndExpression(FilterParser.AndExpressionContext ctx) {
        var left = visit(ctx.left);
        var right = visit(ctx.right);

        return new AndExpressionNode(left, right);
    }

    @Override
    public ExpressionNode visitEqualsExpression(FilterParser.EqualsExpressionContext ctx) {
        var left = visit(ctx.left);
        var right = visit(ctx.right);

        return new EqualsExpressionNode(left, right);
    }

    @Override
    public ExpressionNode visitNotExpression(FilterParser.NotExpressionContext ctx) {
        var expression = visit(ctx.expression());
        return new NotExpressionNode(expression);
    }

    @Override
    public ExpressionNode visitStringExpression(FilterParser.StringExpressionContext ctx) {
        var text = ctx.getText();
        var value = text.substring(1, text.length() - 1);
        return new StringExpressionNode(value);
    }

    @Override
    public ExpressionNode visitBooleanExpression(FilterParser.BooleanExpressionContext ctx) {
        var text = ctx.getText();
        var value = Boolean.parseBoolean(text);
        return new BooleanExpressionNode(value);
    }

    @Override
    public ExpressionNode visitNullExpression(FilterParser.NullExpressionContext ctx) {
        return new NullExpressionNode();
    }

    @Override
    public ExpressionNode visitIdentifierExpression(FilterParser.IdentifierExpressionContext ctx) {
        var text = ctx.getText();
        return new IdentifierExpressionNode(text);
    }

    @Override
    public ExpressionNode visitLongExpression(FilterParser.LongExpressionContext ctx) {
        var text = ctx.getText();
        var value = Long.parseLong(text);
        return new LongExpressionNode(value);
    }

    @Override
    public ExpressionNode visitDoubleExpression(FilterParser.DoubleExpressionContext ctx) {
        var text = ctx.getText();
        var value = Double.parseDouble(text);
        return new DoubleExpressionNode(value);
    }

    @Override
    public ExpressionNode visitDateTimeExpression(FilterParser.DateTimeExpressionContext ctx) {
        var year = Integer.parseInt(ctx.year.getText());
        var month = Integer.parseInt(ctx.month.getText());
        var day = Integer.parseInt(ctx.day.getText());
        var hour = Optional.ofNullable(ctx.hour).map(h -> Integer.parseInt(h.getText())).orElse(0);
        var minute = Optional.ofNullable(ctx.minute).map(m -> Integer.parseInt(m.getText())).orElse(0);
        var second = Optional.ofNullable(ctx.second).map(s -> Integer.parseInt(s.getText())).orElse(0);

        var date = LocalDateTime.of(year, month, day, hour, minute, second);
        return new DateTimeExpressionNode(date);
    }


    @Override
    public ExpressionNode visitGreaterThanExpression(FilterParser.GreaterThanExpressionContext ctx) {
        var left = visit(ctx.left);
        var right = visit(ctx.right);

        return new GreaterThanExpressionNode(left, right);
    }

    @Override
    public ExpressionNode visitLessThanOrEqualsExpression(FilterParser.LessThanOrEqualsExpressionContext ctx) {
        var left = visit(ctx.left);
        var right = visit(ctx.right);

        return new LessThanOrEqualsExpressionNode(left, right);
    }

    @Override
    public ExpressionNode visitGreaterThanOrEqualsExpression(FilterParser.GreaterThanOrEqualsExpressionContext ctx) {
        var left = visit(ctx.left);
        var right = visit(ctx.right);

        return new GreaterThanOrEqualsExpressionNode(left, right);
    }

    @Override
    public ExpressionNode visitNotEqualsExpression(FilterParser.NotEqualsExpressionContext ctx) {
        var left = visit(ctx.left);
        var right = visit(ctx.right);

        return new NotEqualsExpressionNode(left, right);
    }

    @Override
    public ExpressionNode visitLessThanExpression(FilterParser.LessThanExpressionContext ctx) {
        var left = visit(ctx.left);
        var right = visit(ctx.right);

        return new LessThanExpressionNode(left, right);
    }

    @Override
    public ExpressionNode visitDotExpression(FilterParser.DotExpressionContext ctx) {
        var object = visit(ctx.object);
        var field = ctx.field.getText();
        return new DotExpressionNode(object, field);
    }

    @Override
    public ExpressionNode visitFunctionCallExpression(FilterParser.FunctionCallExpressionContext ctx) {
        var function = ctx.function.getText();
        var arguments = ctx.expression().stream().map(this::visit).toList();

        return new FunctionCallExpressionNode(function, arguments);
    }
}
