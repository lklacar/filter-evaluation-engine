grammar Filter;

expression
    : LEFT_PAREN expression RIGHT_PAREN                                                           # parenExpression
    | NOT expression                                                                              # notExpression
    | left=expression EQUALS right=expression                                                     # equalsExpression
    | left=expression NOTEQUALS right=expression                                                  # notEqualsExpression
    | left=expression GT right=expression                                                         # greaterThanExpression
    | left=expression LT right=expression                                                         # lessThanExpression
    | left=expression GTE right=expression                                                        # greaterThanOrEqualsExpression
    | left=expression LTE right=expression                                                        # lessThanOrEqualsExpression
    | left=expression AND right=expression                                                        # andExpression
    | left=expression OR right=expression                                                         # orExpression
    | IDENTIFIER                                                                                  # identifierExpression
    | STRING                                                                                      # stringExpression
    | LONG                                                                                        # longExpression
    | DOUBLE                                                                                      # doubleExpression
    | BOOLEAN                                                                                     # booleanExpression
    | NULL                                                                                        # nullExpression
    | year=LONG '-' month=LONG '-' day=LONG ('T' hour=LONG ':' minute=LONG ':' second=LONG)?      # dateTimeExpression
    ;





LEFT_PAREN
    : '('
    ;

RIGHT_PAREN
    : ')'
    ;

LEFT_BRACKET
    : '['
    ;

RIGHT_BRACKET
    : ']'
    ;

COMMA
    : ','
    ;

EQUALS
    : '='
    ;

NOTEQUALS
    : '!='
    ;

GT
    : '>'
    ;

LT
    : '<'
    ;

GTE
    : '>='
    ;

LTE
    : '<='
    ;

OR
    : 'OR' | 'or'
    ;

AND
    : 'AND' | 'and'
    ;

NOT
    : 'NOT' | 'not'
    ;

STRING
    : '\'' ( ~'\'' )* '\''
    ;

NULL
    : 'null'
    ;

BOOLEAN
    : 'true' | 'false'
    ;

IDENTIFIER
    : [a-zA-Z_] [a-zA-Z_0-9]*
    ;

LONG
    : [0-9]+
    ;

DOUBLE
    : [0-9]+ '.' [0-9]+
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
