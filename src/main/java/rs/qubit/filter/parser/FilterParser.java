package rs.qubit.filter.parser;

import org.antlr.v4.runtime.CharStreams;
import rs.qubit.filter.parser.ast.ExpressionNode;
import rs.qubit.filter.parser.generated.FilterLexer;

public class FilterParser {

    public ExpressionNode parse(String filter) {
        var charStream = CharStreams.fromString(filter);
        var lexer = new FilterLexer(charStream);
        var parser = new rs.qubit.filter.parser.generated.FilterParser(new org.antlr.v4.runtime.CommonTokenStream(lexer));
        var visitor = new ExpressionParserVisitor();
        return visitor.visit(parser.expression());
    }
}
