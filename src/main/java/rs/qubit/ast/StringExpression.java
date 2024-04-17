package rs.qubit.ast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.visitor.Visitor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class StringExpression implements ExpressionNode {

    private String value;

    @Override
    public <TRet, TArg> TRet accept(Visitor<TRet, TArg> visitor, TArg tArg) {
        return visitor.visit(this, tArg);
    }
}
