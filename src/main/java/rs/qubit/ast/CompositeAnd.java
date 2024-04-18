package rs.qubit.ast;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.qubit.visitor.Visitor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompositeAnd implements ExpressionNode {

    private List<ExpressionNode> expressions;

    public ExpressionNode toBinaryExpression() {
        return expressions.stream()
                .reduce(AndExpressionNode::new)
                .orElseThrow();
    }

    @Override
    public <TRet, TArg> TRet accept(Visitor<TRet, TArg> visitor, TArg tArg) {
        return visitor.visit(this, tArg);
    }
}
