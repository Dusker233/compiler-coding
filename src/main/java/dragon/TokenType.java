package dragon;

public enum TokenType {
    // Group 0
    EOF,
    WS,
    UNKNOWN,

    // Group 1: lookahead = 1(LA(1))
    // 只需向前看一个字符就能确定的 token
    IF, ELSE,
    ID,
    INT,

    // Group 2: lookahead = 2(LA(2))
    EQ, NE, LT, LE, GT, GE,

    // Group 3: arbitrary lookahead
    // 需要向前看任意多个字符才能确定的 token
    REAL,
    SCI,

    DOT,POS,NEG,

}
