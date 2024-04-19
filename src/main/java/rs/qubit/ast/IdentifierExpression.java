package rs.qubit.ast;

import lombok.*;
import rs.qubit.visitor.Visitor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class IdentifierExpression implements ExpressionNode {
    private String columnName;


    @Override
    public <TRet, TArg> TRet accept(Visitor<TRet, TArg> visitor, TArg tArg) {
        return visitor.visit(this, tArg);
    }
}