package rs.qubit.ast;


import lombok.*;
import rs.qubit.visitor.Visitor;

@AllArgsConstructor
@Builder
@Data
public class EqualsNode implements ExpressionNode {
    private ExpressionNode left;
    private ExpressionNode right;

    @Override
    public <TRet, TArg> TRet accept(Visitor<TRet, TArg> visitor, TArg tArg) {
        return visitor.visit(this, tArg);
    }
}
