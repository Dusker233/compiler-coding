lexer grammar SimpleExprRules; // lexer grammar 表示只包含词法单元

// 词法单元

SEMI : ';' ;
ASSIGN : '=' ;
IF : 'if' ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
LPAREN : '(' ;
RPAREN : ')' ;
ID: (LETTER | '_') WORD* ; // 一个标识符由字母或下划线开头，后面跟着零到多个字母、数字或下划线
INT: '0' | [1-9]DIGIT* ; // 一个整数由一位或多位数字组成
FLOAT: INT '.' DIGIT*
     | '.' DIGIT+
     ; // 最长匹配原则
WS: [ \t\r\n]+ -> skip ; // 一个空白字符由空格、制表符、回车符或换行符组成，检测到空白符时跳过

//SingleLine_Comment: '//' .*? '\n' -> skip; // 单行注释 .匹配任意字符
// 注意到'.*'写法只会匹配开头是否是双斜杠，结尾是否是换行符，并不能判断是否真的只是单行注释
// （反例：出现一个空行，会导致单行注释到空行之前的所有内容都被判定为注释）
// .* 被称为“贪婪匹配”，即能匹配多少匹配多少，直到之后有一个换行符
// .*? 被称为“非贪婪匹配”，即只匹配长度最短的一个字符串
Doc_Comment: '/**' .*? '*/' -> skip; // javadoc 格式注释
MultiLine_Comment: '/*' .*? '*/' -> skip; // 多行注释
SingleLine_Comment2: '//' ~[\n]* '\n' -> skip; // ~'\n' 表示匹配换行符以外的所有字符
// 注意到这种写法会被多行注释匹配规则包含
// 考虑提高其优先级即可，即将 Doc_Comment 放在 MultiLine_Comment 前

// 辅助规则 有 fragment 标识符
fragment DIGIT: [0-9];
fragment LETTER: [a-zA-Z];
fragment WORD: LETTER | DIGIT | '_';