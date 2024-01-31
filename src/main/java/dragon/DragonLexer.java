package dragon;

public class DragonLexer extends Lexer {
    private final KeywordTable kwTable = new KeywordTable();

    public DragonLexer(String input) {
        super(input);
    }

    @Override
    public Token nextToken() {
        // WS, ID, INT(NUMBER)
        if (peek == EOF) {
            return Token.EOF;
        }
        if (Character.isWhitespace(peek)) {
            return WS();
        }
        if (Character.isLetter(peek)) {
            return ID();
        }
        // int, real, sci?
        if (Character.isDigit(peek)) {
            return NUMBER();
        }
        // relop (relation operator)
        // < -> <= / <> / < +x
        // = -> EQ
        // > -> >= / > +x
        if (peek == '<' || peek == '=' || peek == '>') {
            return RELOP();
        }
        if (peek == '.') {
            advance();
            return Token.DOT;
        }
        if (peek == '+') {
            advance();
            return Token.POS;
        }
        if (peek == '-') {
            advance();
            return Token.NEG;
        }

        // unknown
        Token unknown = new Token(TokenType.UNKNOWN, Character.toString(peek));
        advance();
        return unknown;
    }

    private Token NUMBER() {
        // int real sci
        // 必须考虑匹配失败时的回退！
        // 似乎只需要考虑一步回退？
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(peek);
            advance();
        } while (Character.isDigit(peek));
        // state 13 -> 16
        if (peek == 'E' || peek == 'e') {
            return SCI(sb);
        }
        // state 13 -> 14
        if (peek == '.') {
            sb.append(peek);
            advance();
            // state 14 other
            if (!Character.isDigit(peek)) {
                reset(pos - 1);
                return new Token(TokenType.INT, sb.deleteCharAt(sb.length() - 1).toString());
            }
            // state 14 -> 15
            while (Character.isDigit(peek)) {
                sb.append(peek);
                advance();
            }
            // state 15 -> 16
            if (peek == 'E' || peek == 'e') {
                return SCI(sb);
            }
            // state 15 -> 21
            return new Token(TokenType.REAL, sb.toString());
        }
        // state 13 -> 20
        return new Token(TokenType.INT, sb.toString());
    }

    private Token SCI(StringBuilder sb) {
        sb.append(peek);
        advance();
        // state 13/15 -> 16
        if (peek == '+' || peek == '-') {
            sb.append(peek);
            advance();
        } else if (!Character.isDigit(peek)) {
            reset(pos - 1);
            // state 16 other
            if (sb.toString().contains("."))
                return new Token(TokenType.REAL, sb.deleteCharAt(sb.length() - 1).toString());
            return new Token(TokenType.INT, sb.deleteCharAt(sb.length() - 1).toString());
        }

        // state 17 other
        if (!Character.isDigit(peek) && (sb.toString().charAt(sb.length() - 1) == '+' || sb.toString().charAt(sb.length() - 1) == '-')) {
            reset(pos - 2);
            sb.delete(sb.length() - 2, sb.length());
            if (sb.toString().contains("."))
                return new Token(TokenType.REAL, sb.toString());
            return new Token(TokenType.INT, sb.toString());
        }

        while (Character.isDigit(peek)) {
            sb.append(peek);
            advance();
        }
        return new Token(TokenType.SCI, sb.toString());
    }

    private Token WS() {
        while (Character.isWhitespace(peek)) {
            advance();
        }
        return Token.WS;
    }

    private Token RELOP() {
        if (peek == '=') {
            advance();
            return Token.EQ;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(peek);
        advance();
        if (peek == '=') {
            sb.append(peek);
            advance();
        }
        return switch (sb.toString()) {
            case "<" -> Token.LT;
            case "<=" -> Token.LE;
            case ">" -> Token.GT;
            case ">=" -> Token.GE;
            default -> new Token(TokenType.UNKNOWN, sb.toString());
        };
    }

    private Token ID() {
        // 在开始已经判断过首字符是否为字母，不需再次考虑
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(peek);
            advance();
        } while (Character.isLetterOrDigit(peek));

        // 考虑关键字问题
        Token token = this.kwTable.getKeyword(sb.toString());
        return token != null ? token : new Token(TokenType.ID, sb.toString());
    }

}
