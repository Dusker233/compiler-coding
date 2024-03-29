lexer grammar DragonLexerRules;

@header {
    package dragon;
}

WS: [ \t\r\n]+ -> skip;

IF: 'if' ;
ELSE: 'else' ;

ID: LETTER (LETTER | DIGIT)* ;

INT: DIGITS ;

EQ: '=' ;
NE: '<>' ;
LT: '<' ;
LE: '<=' ;
GT: '>' ;
GE: '>=' ;

DOT: '.' ;
POS: '+' ;
NEG: '-' ;

REAL: DIGITS ('.' DIGITS)? ;
SCI: DIGITS ('.' DIGITS)? ([eE] [+-]? DIGITS)? ;

fragment DIGIT: [0-9] ;
fragment DIGITS: DIGIT+ ;
fragment LETTER: [a-zA-Z] ;