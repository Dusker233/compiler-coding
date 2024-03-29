package dragon;

public abstract class Lexer {
    public static final char EOF = (char) -1;

    final String input;
    char peek;
    int pos;

    public Lexer(String input) {
        this.input = input;
        this.pos = 0;
        this.peek = input.charAt(pos);
    }

    public abstract Token nextToken();

    public void advance() {
        this.pos++;
        if (this.pos >= this.input.length()) {
            this.peek = EOF;
        } else {
            this.peek = this.input.charAt(this.pos);
        }
    }

    public void reset(int pos) {
        this.pos = pos;
        this.peek = this.input.charAt(this.pos);
    }
}
