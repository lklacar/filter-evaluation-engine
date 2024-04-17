package rs.qubit.ast;

import lombok.*;
import rs.qubit.visitor.Visitor;

@AllArgsConstructor
@Builder
@Data
public class NumberExpression implements ExpressionNode {
    private int value;

    @Override
    public <TRet, TArg> TRet accept(Visitor<TRet, TArg> visitor, TArg tArg) {
        return visitor.visit(this, tArg);
    }
}
