package rs.qubit.ast;

import rs.qubit.visitor.Visitor;

public interface Node {

    <TRet, TArg> TRet accept(Visitor<TRet, TArg> visitor, TArg arg);

}
