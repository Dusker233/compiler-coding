// Generated from //wsl$/Ubuntu-22.04/home/dusker/compiler-2023-nju-ant/compilers-coding/src/main/antlr/simpleExpr\SimpleExpr.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SEMI=1, ASSIGN=2, IF=3, MUL=4, DIV=5, ADD=6, SUB=7, LPAREN=8, RPAREN=9, 
		ID=10, INT=11, FLOAT=12, WS=13, Doc_Comment=14, MultiLine_Comment=15, 
		SingleLine_Comment2=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SEMI", "ASSIGN", "IF", "MUL", "DIV", "ADD", "SUB", "LPAREN", "RPAREN", 
			"ID", "INT", "FLOAT", "WS", "Doc_Comment", "MultiLine_Comment", "SingleLine_Comment2", 
			"DIGIT", "LETTER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'if'", "'*'", "'/'", "'+'", "'-'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SEMI", "ASSIGN", "IF", "MUL", "DIV", "ADD", "SUB", "LPAREN", "RPAREN", 
			"ID", "INT", "FLOAT", "WS", "Doc_Comment", "MultiLine_Comment", "SingleLine_Comment2"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SimpleExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010\u0093\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0003\t;\b\t\u0001\t\u0001\t\u0001\t\u0005\t@\b\t\n"+
		"\t\f\tC\t\t\u0001\n\u0001\n\u0001\n\u0005\nH\b\n\n\n\f\nK\t\n\u0003\n"+
		"M\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000bR\b\u000b\n\u000b"+
		"\f\u000bU\t\u000b\u0001\u000b\u0001\u000b\u0004\u000bY\b\u000b\u000b\u000b"+
		"\f\u000bZ\u0003\u000b]\b\u000b\u0001\f\u0004\f`\b\f\u000b\f\f\fa\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\rk\b\r\n\r\f"+
		"\rn\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000ey\b\u000e\n\u000e\f\u000e|\t\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0087\b\u000f\n\u000f"+
		"\f\u000f\u008a\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0002lz\u0000\u0012\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0000#\u0000\u0001\u0000\u0005\u0001\u000019\u0003"+
		"\u0000\t\n\r\r  \u0001\u0000\n\n\u0001\u000009\u0002\u0000AZaz\u009d\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0001%\u0001"+
		"\u0000\u0000\u0000\u0003\'\u0001\u0000\u0000\u0000\u0005)\u0001\u0000"+
		"\u0000\u0000\u0007,\u0001\u0000\u0000\u0000\t.\u0001\u0000\u0000\u0000"+
		"\u000b0\u0001\u0000\u0000\u0000\r2\u0001\u0000\u0000\u0000\u000f4\u0001"+
		"\u0000\u0000\u0000\u00116\u0001\u0000\u0000\u0000\u0013:\u0001\u0000\u0000"+
		"\u0000\u0015L\u0001\u0000\u0000\u0000\u0017\\\u0001\u0000\u0000\u0000"+
		"\u0019_\u0001\u0000\u0000\u0000\u001be\u0001\u0000\u0000\u0000\u001dt"+
		"\u0001\u0000\u0000\u0000\u001f\u0082\u0001\u0000\u0000\u0000!\u008f\u0001"+
		"\u0000\u0000\u0000#\u0091\u0001\u0000\u0000\u0000%&\u0005;\u0000\u0000"+
		"&\u0002\u0001\u0000\u0000\u0000\'(\u0005=\u0000\u0000(\u0004\u0001\u0000"+
		"\u0000\u0000)*\u0005i\u0000\u0000*+\u0005f\u0000\u0000+\u0006\u0001\u0000"+
		"\u0000\u0000,-\u0005*\u0000\u0000-\b\u0001\u0000\u0000\u0000./\u0005/"+
		"\u0000\u0000/\n\u0001\u0000\u0000\u000001\u0005+\u0000\u00001\f\u0001"+
		"\u0000\u0000\u000023\u0005-\u0000\u00003\u000e\u0001\u0000\u0000\u0000"+
		"45\u0005(\u0000\u00005\u0010\u0001\u0000\u0000\u000067\u0005)\u0000\u0000"+
		"7\u0012\u0001\u0000\u0000\u00008;\u0003#\u0011\u00009;\u0005_\u0000\u0000"+
		":8\u0001\u0000\u0000\u0000:9\u0001\u0000\u0000\u0000;A\u0001\u0000\u0000"+
		"\u0000<@\u0003#\u0011\u0000=@\u0003!\u0010\u0000>@\u0005_\u0000\u0000"+
		"?<\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?>\u0001\u0000\u0000"+
		"\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000"+
		"\u0000\u0000B\u0014\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"DM\u00050\u0000\u0000EI\u0007\u0000\u0000\u0000FH\u0003!\u0010\u0000G"+
		"F\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000"+
		"\u0000IJ\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000"+
		"\u0000\u0000LD\u0001\u0000\u0000\u0000LE\u0001\u0000\u0000\u0000M\u0016"+
		"\u0001\u0000\u0000\u0000NO\u0003\u0015\n\u0000OS\u0005.\u0000\u0000PR"+
		"\u0003!\u0010\u0000QP\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T]\u0001\u0000\u0000"+
		"\u0000US\u0001\u0000\u0000\u0000VX\u0005.\u0000\u0000WY\u0003!\u0010\u0000"+
		"XW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000Z[\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000\u0000\\N\u0001\u0000"+
		"\u0000\u0000\\V\u0001\u0000\u0000\u0000]\u0018\u0001\u0000\u0000\u0000"+
		"^`\u0007\u0001\u0000\u0000_^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000cd\u0006\f\u0000\u0000d\u001a\u0001\u0000\u0000\u0000ef\u0005"+
		"/\u0000\u0000fg\u0005*\u0000\u0000gh\u0005*\u0000\u0000hl\u0001\u0000"+
		"\u0000\u0000ik\t\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mo\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005*\u0000\u0000pq\u0005"+
		"/\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0006\r\u0000\u0000s\u001c\u0001"+
		"\u0000\u0000\u0000tu\u0005/\u0000\u0000uv\u0005*\u0000\u0000vz\u0001\u0000"+
		"\u0000\u0000wy\t\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000y|\u0001\u0000"+
		"\u0000\u0000z{\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000{}\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0005*\u0000\u0000~\u007f"+
		"\u0005/\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0006"+
		"\u000e\u0000\u0000\u0081\u001e\u0001\u0000\u0000\u0000\u0082\u0083\u0005"+
		"/\u0000\u0000\u0083\u0084\u0005/\u0000\u0000\u0084\u0088\u0001\u0000\u0000"+
		"\u0000\u0085\u0087\b\u0002\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000"+
		"\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008b\u0001\u0000\u0000\u0000"+
		"\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u008c\u0005\n\u0000\u0000\u008c"+
		"\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0006\u000f\u0000\u0000\u008e"+
		" \u0001\u0000\u0000\u0000\u008f\u0090\u0007\u0003\u0000\u0000\u0090\""+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0007\u0004\u0000\u0000\u0092$\u0001"+
		"\u0000\u0000\u0000\r\u0000:?AILSZ\\alz\u0088\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}