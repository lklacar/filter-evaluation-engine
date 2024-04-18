grammar Lang;

expression
    : expression 'AND' expression           # andExpression
    | expression 'OR' expression            # orExpression
    | expression 'LIKE' expression          # likeExpression
    | expression '>' expression             # greaterThanExpression
    | expression '<' expression             # lessThanExpression
    | expression '=' expression             # equalsExpression
    | 'NOT' expression                      # notExpression
    | INTEGER                               # integerExpression
    | BOOLEAN                               # booleanExpression
    | DATE                                  # dateExpression
    | STRING                                # stringExpression
    | IDENTIFIER                            # identifierExpression
    | '(' expression ')'                    # parenExpression
    ;

IDENTIFIER : [a-zA-Z]+ ;
INTEGER : [0-9]+ ;
BOOLEAN : 'true' | 'false' ;
DATE : [0-9]{4} '-' [0-9]{2} '-' [0-9]{2} ;
STRING : '\'' ( ~'\'' | '\'\'')* '\'' ;
WS : [ \t\r\n]+ -> skip ;