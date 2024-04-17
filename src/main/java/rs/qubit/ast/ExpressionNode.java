package rs.qubit.ast;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = StringExpression.class, name = "string"),
        @JsonSubTypes.Type(value = NumberExpression.class, name = "number"),
        @JsonSubTypes.Type(value = EqualsNode.class, name = "equal"),
        @JsonSubTypes.Type(value = OrExpression.class, name = "or"),
        @JsonSubTypes.Type(value = ColumnNameExpression.class, name = "column"),
        @JsonSubTypes.Type(value = NotExpression.class, name = "not"),
        @JsonSubTypes.Type(value = DateExpression.class, name = "date"),
        @JsonSubTypes.Type(value = BooleanExpression.class, name = "boolean"),
        @JsonSubTypes.Type(value = GreaterThanExpression.class, name = "greaterThan"),
        @JsonSubTypes.Type(value = AndExpressionNode.class, name = "and"),
})
public interface ExpressionNode extends Node {

}
