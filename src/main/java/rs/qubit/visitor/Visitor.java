package rs.qubit.visitor;

import rs.qubit.ast.*;

public interface Visitor<TRet, TEnv> {
    TRet visit(AndExpressionNode andExpressionNode, TEnv tArg);

    TRet visit(ColumnNameExpression columnNameExpression, TEnv tArg);

    TRet visit(DateExpression dateExpression, TEnv tArg);

    TRet visit(NotExpression notExpression, TEnv tArg);

    TRet visit(IntegerExpression integerExpression, TEnv tArg);

    TRet visit(OrExpression orExpression, TEnv tArg);

    TRet visit(EqualsNode equalsNode, TEnv tArg);

    TRet visit(StringExpression stringExpression, TEnv tArg);

    TRet visit(BooleanExpression booleanExpression, TEnv tArg);

    TRet visit(LikeExpressionNode likeExpressionNode, TEnv tArg);

    TRet visit(GreaterThanExpression greaterThanExpression, TEnv tArg);

    TRet visit(LessThanExpression lessThanExpression, TEnv tArg);
}
