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

stat : block    # BlockStat
     | varDecl  # VarDeclStat
     | 'if' expr 'then' stat ('else' stat)? # IfStat
     | 'return' expr? ';'   # ReturnStat
     | expr '=' expr ';'    # AssignStat
     | expr ';'             # ExprStat
     ;



expr: ID '(' exprList? ')'    # Call // function call
    | expr '[' expr ']'       # Index // array subscripts
    | op = '-' expr           # Negate // right association
    | op = '!' expr           # Not // right association
    | <assoc = right> lhs = expr '^' rhs = expr # Power
    | lhs = expr (op = '*' | op = '/') rhs = expr     # MultDiv // 这样 ANTLR 会生成一个成员类，其中有一个变量为 op
    | lhs = expr (op = '+' | op = '-') rhs = expr     # AddSub
    | lhs = expr (op = '==' | op = '!=') rhs = expr   # EQNE
    | '(' expr ')'            # Parens
    | ID                      # Id
    | INT                     # Int
    ;

//stat: block // 语句嵌套
//    | varDecl
//    | 'if' expr 'then' stat ('else' stat)?
//    | 'return' expr? ';'
//    | expr '=' expr ';'
//    | expr ';'
//    ;
//
//expr: ID '(' exprList? ')' #FunctionCall // function call
//    | expr '[' expr ']' // array subscript
//    // 高维数组时展开前面的 expr，从后依次到前构造
//    | '-' expr
//    | '!' expr
//    | <assoc = right> lhs = expr '^' rhs = expr
//    | lhs = expr (op = '*' | op = '/') rhs = expr
//    | lhs = expr (op = '+' | op = '-') rhs = expr
//    | lhs = expr (op = '==' | op = '!=') rhs = expr
//    | '(' expr ')'
//    | ID
//    | INT
//    ;

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