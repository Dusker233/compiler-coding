grammar Cymbol;

@header {
    package cymbol;
}

prog: (varDecl | functionDecl)* EOF ;

varDecl: type ID ('=' expr)? ';' ;

/*等价于
varDecl: type ID ';'
       | type ID '=' expr ';'
       ;
*/

type: 'int' | 'double' | 'void' ;

// type ID, type ID, ...
functionDecl: type ID '(' formalParameters? ')' block ;

formalParameters: formalParameter (',' formalParameter)* ;

formalParameter: type ID ;

block: '{' stat* '}' ;

stat: block // 语句嵌套
    | varDecl
    | 'if' expr 'then' stat ('else' stat)?
    | 'return' expr? ';'
    | expr '=' expr ';'
    | expr ';'
    ;

expr: ID '(' exprList? ')' // function call
    | expr '[' expr ']' // array subscript
    // 高维数组时展开前面的 expr，从后依次到前构造
    | '-' expr
    | '!' expr
    | <assoc = right> expr '^' expr
    | expr ('*' | '/') expr
    | expr ('+' | '-') expr
    | expr ('==' | '!=') expr
    | '(' expr ')'
    | ID
    | INT
    ;

exprList: expr (',' expr)* ;

// alt+insert to generate literal tokens
EQUAL : '=' ;
SEMI : ';' ;
DOUBLE : 'double' ;
VOID : 'void' ;
LPAREN : '(' ;
RPAREN : ')' ;
COMMA : ',' ;
LBRACE : '{' ;
RBRACE : '}' ;
IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;
RETURN : 'return' ;
LBRACK : '[' ;
RBRACK : ']' ;
SUB : '-' ;
BANG : '!' ;
CARET : '^' ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
EQUAL_EQUAL : '==' ;
NOT_EQUAL : '!=' ;

WS  : [ \t\n\r]+ -> skip ;

ID : LETTER (LETTER | DIGIT)* ;
INT : '0' | [1-9]DIGIT* ;

fragment LETTER : [a-zA-Z] ;
fragment DIGIT : [0-9] ;