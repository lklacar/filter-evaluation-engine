package rs.qubit.ast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import rs.qubit.visitor.Visitor;

@AllArgsConstructor
@Builder
@Data
public class StringExpression implements ExpressionNode {

    private String value;

    @Override
    public <TRet, TArg> TRet accept(Visitor<TRet, TArg> visitor, TArg tArg) {
        return visitor.visit(this, tArg);
    }
}
