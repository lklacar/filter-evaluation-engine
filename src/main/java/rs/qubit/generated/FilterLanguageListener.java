// Generated from /Users/luka.klacar/Projects/poc/src/main/antlr4/FilterLanguage.g4 by ANTLR 4.13.1
package rs.qubit.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FilterLanguageParser}.
 */
public interface FilterLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(FilterLanguageParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(FilterLanguageParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDateExpression(FilterLanguageParser.DateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDateExpression(FilterLanguageParser.DateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(FilterLanguageParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(FilterLanguageParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(FilterLanguageParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(FilterLanguageParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterThanExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanExpression(FilterLanguageParser.GreaterThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterThanExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanExpression(FilterLanguageParser.GreaterThanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(FilterLanguageParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(FilterLanguageParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntegerExpression(FilterLanguageParser.IntegerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntegerExpression(FilterLanguageParser.IntegerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(FilterLanguageParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(FilterLanguageParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(FilterLanguageParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(FilterLanguageParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(FilterLanguageParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(FilterLanguageParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalsExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualsExpression(FilterLanguageParser.EqualsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalsExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualsExpression(FilterLanguageParser.EqualsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessThanExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessThanExpression(FilterLanguageParser.LessThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessThanExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessThanExpression(FilterLanguageParser.LessThanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code likeExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLikeExpression(FilterLanguageParser.LikeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code likeExpression}
	 * labeled alternative in {@link FilterLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLikeExpression(FilterLanguageParser.LikeExpressionContext ctx);
}