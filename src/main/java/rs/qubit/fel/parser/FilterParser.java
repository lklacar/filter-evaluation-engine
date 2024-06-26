package rs.qubit.fel.parser;

import org.antlr.v4.runtime.CharStreams;
import rs.qubit.fel.parser.ast.ExpressionNode;
import rs.qubit.fel.parser.generated.FilterLexer;

public class FilterParser {

    public ExpressionNode parse(String filter) {
        var charStream = CharStreams.fromString(filter);
        var lexer = new FilterLexer(charStream);
        var parser = new rs.qubit.fel.parser.generated.FilterParser(new org.antlr.v4.runtime.CommonTokenStream(lexer));
        var visitor = new ExpressionParserVisitor();
        return visitor.visit(parser.expression());
    }
}
