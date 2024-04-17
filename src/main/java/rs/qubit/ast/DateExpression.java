package rs.qubit.ast;

import lombok.*;
import rs.qubit.visitor.Visitor;

import java.util.Date;

@AllArgsConstructor
@Builder
@Data
public class DateExpression implements ExpressionNode {
    private Date date;

    @Override
    public <TRet, TArg> TRet accept(Visitor<TRet, TArg> visitor, TArg tArg) {
        return visitor.visit(this, tArg);
    }
}
