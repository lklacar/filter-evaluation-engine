grammar FilterLanguage;

expression
    : left=expression 'AND' right=expression           # andExpression
    | left=expression 'OR' right=expression            # orExpression
    | left=expression 'LIKE' right=expression          # likeExpression
    | left=expression '>' right=expression             # greaterThanExpression
    | left=expression '<' right=expression             # lessThanExpression
    | left=expression '=' right=expression             # equalsExpression
    | 'NOT' expression                                 # notExpression
    | value=INTEGER                                    # integerExpression
    | value=BOOLEAN                                    # booleanExpression
    | value=DATE                                       # dateExpression
    | value=STRING                                     # stringExpression
    | value=IDENTIFIER                                 # identifierExpression
    | '(' expression ')'                               # parenExpression
    ;

IDENTIFIER : [a-zA-Z]+ ;
INTEGER : [0-9]+ ;
BOOLEAN : 'true' | 'false' ;
DATE : [0-9]{4} '-' [0-9]{2} '-' [0-9]{2} ;
STRING : '\'' ( ~'\'' | '\'\'')* '\'' ;
WS : [ \t\r\n]+ -> skip ;