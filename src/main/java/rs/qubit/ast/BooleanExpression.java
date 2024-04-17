package rs.qubit.ast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.visitor.Visitor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BooleanExpression implements ExpressionNode{
    private boolean value;

    @Override
    public <TRet, TArg> TRet accept(Visitor<TRet, TArg> visitor, TArg tArg) {
        return visitor.visit(this, tArg);
    }
}
