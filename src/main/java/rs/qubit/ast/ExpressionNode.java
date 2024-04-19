package rs.qubit.ast;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import rs.qubit.visitor.Visitor;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StringExpression.class, name = "STRING"),
        @JsonSubTypes.Type(value = IntegerExpression.class, name = "INTEGER"),
        @JsonSubTypes.Type(value = EqualsNode.class, name = "EQUALS"),
        @JsonSubTypes.Type(value = OrExpression.class, name = "OR"),
        @JsonSubTypes.Type(value = IdentifierExpression.class, name = "COLUMN"),
        @JsonSubTypes.Type(value = NotExpression.class, name = "NOT"),
        @JsonSubTypes.Type(value = DateExpression.class, name = "DATE"),
        @JsonSubTypes.Type(value = BooleanExpression.class, name = "BOOLEAN"),
        @JsonSubTypes.Type(value = GreaterThanExpression.class, name = "GREATER_THAN"),
        @JsonSubTypes.Type(value = AndExpressionNode.class, name = "AND"),
        @JsonSubTypes.Type(value = LikeExpressionNode.class, name = "LIKE"),
        @JsonSubTypes.Type(value = LessThanExpression.class, name = "LESS_THAN"),
        @JsonSubTypes.Type(value = CompositeAnd.class, name = "COMPOSITE_AND"),
        @JsonSubTypes.Type(value = CompositeOr.class, name = "COMPOSITE_OR")
})
public interface ExpressionNode {
    <TRet, TArg> TRet accept(Visitor<TRet, TArg> visitor, TArg arg);

}
