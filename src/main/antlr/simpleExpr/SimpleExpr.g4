grammar SimpleExpr; // 和文件名保持一致

import SimpleExprRules; // 导入词法规则

@header {
    package simpleexpr;
}

// 语法单元
prog: stat* EOF ; // 一个程序包含零到多个语句，以文件结束符EOF结尾
stat: expr ';'
    | ID '=' expr ';'
    | 'if' expr ';'
    ;
expr: expr ('*' | '/') expr
    | expr ('+' | '-') expr
    | '(' expr ')'
    | ID
    | INT
    | FLOAT
    ;
