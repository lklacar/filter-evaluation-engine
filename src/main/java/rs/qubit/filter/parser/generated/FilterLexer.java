// Generated from /home/luka/Projects/Personal/filter-evaluation-engine/src/main/antlr4/Filter.g4 by ANTLR 4.13.1
package rs.qubit.filter.parser.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class FilterLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, DOT=4, LEFT_PAREN=5, RIGHT_PAREN=6, LEFT_BRACKET=7, 
		RIGHT_BRACKET=8, COMMA=9, EQUALS=10, NOTEQUALS=11, GT=12, LT=13, GTE=14, 
		LTE=15, OR=16, AND=17, NOT=18, STRING=19, NULL=20, BOOLEAN=21, IDENTIFIER=22, 
		LONG=23, DOUBLE=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "DOT", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "COMMA", "EQUALS", "NOTEQUALS", "GT", "LT", "GTE", "LTE", 
			"OR", "AND", "NOT", "STRING", "NULL", "BOOLEAN", "IDENTIFIER", "LONG", 
			"DOUBLE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", "'T'", "':'", "'.'", "'('", "')'", "'['", "']'", "','", 
			"'='", "'!='", "'>'", "'<'", "'>='", "'<='", null, null, null, null, 
			"'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "DOT", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "COMMA", "EQUALS", "NOTEQUALS", "GT", "LT", "GTE", "LTE", 
			"OR", "AND", "NOT", "STRING", "NULL", "BOOLEAN", "IDENTIFIER", "LONG", 
			"DOUBLE", "WS"
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


	public FilterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Filter.g4"; }

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
		"\u0004\u0000\u0019\u00a1\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"Y\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010a\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011i\b\u0011\u0001\u0012"+
		"\u0001\u0012\u0005\u0012m\b\u0012\n\u0012\f\u0012p\t\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0082\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u0086\b\u0015\n\u0015\f\u0015\u0089\t\u0015\u0001"+
		"\u0016\u0004\u0016\u008c\b\u0016\u000b\u0016\f\u0016\u008d\u0001\u0017"+
		"\u0004\u0017\u0091\b\u0017\u000b\u0017\f\u0017\u0092\u0001\u0017\u0001"+
		"\u0017\u0004\u0017\u0097\b\u0017\u000b\u0017\f\u0017\u0098\u0001\u0018"+
		"\u0004\u0018\u009c\b\u0018\u000b\u0018\f\u0018\u009d\u0001\u0018\u0001"+
		"\u0018\u0000\u0000\u0019\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0015+\u0016-\u0017/\u00181\u0019\u0001\u0000\u0005\u0001\u0000"+
		"\'\'\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0003\u0000\t"+
		"\n\r\r  \u00aa\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0001"+
		"3\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000\u0000\u00057\u0001"+
		"\u0000\u0000\u0000\u00079\u0001\u0000\u0000\u0000\t;\u0001\u0000\u0000"+
		"\u0000\u000b=\u0001\u0000\u0000\u0000\r?\u0001\u0000\u0000\u0000\u000f"+
		"A\u0001\u0000\u0000\u0000\u0011C\u0001\u0000\u0000\u0000\u0013E\u0001"+
		"\u0000\u0000\u0000\u0015G\u0001\u0000\u0000\u0000\u0017J\u0001\u0000\u0000"+
		"\u0000\u0019L\u0001\u0000\u0000\u0000\u001bN\u0001\u0000\u0000\u0000\u001d"+
		"Q\u0001\u0000\u0000\u0000\u001fX\u0001\u0000\u0000\u0000!`\u0001\u0000"+
		"\u0000\u0000#h\u0001\u0000\u0000\u0000%j\u0001\u0000\u0000\u0000\'s\u0001"+
		"\u0000\u0000\u0000)\u0081\u0001\u0000\u0000\u0000+\u0083\u0001\u0000\u0000"+
		"\u0000-\u008b\u0001\u0000\u0000\u0000/\u0090\u0001\u0000\u0000\u00001"+
		"\u009b\u0001\u0000\u0000\u000034\u0005-\u0000\u00004\u0002\u0001\u0000"+
		"\u0000\u000056\u0005T\u0000\u00006\u0004\u0001\u0000\u0000\u000078\u0005"+
		":\u0000\u00008\u0006\u0001\u0000\u0000\u00009:\u0005.\u0000\u0000:\b\u0001"+
		"\u0000\u0000\u0000;<\u0005(\u0000\u0000<\n\u0001\u0000\u0000\u0000=>\u0005"+
		")\u0000\u0000>\f\u0001\u0000\u0000\u0000?@\u0005[\u0000\u0000@\u000e\u0001"+
		"\u0000\u0000\u0000AB\u0005]\u0000\u0000B\u0010\u0001\u0000\u0000\u0000"+
		"CD\u0005,\u0000\u0000D\u0012\u0001\u0000\u0000\u0000EF\u0005=\u0000\u0000"+
		"F\u0014\u0001\u0000\u0000\u0000GH\u0005!\u0000\u0000HI\u0005=\u0000\u0000"+
		"I\u0016\u0001\u0000\u0000\u0000JK\u0005>\u0000\u0000K\u0018\u0001\u0000"+
		"\u0000\u0000LM\u0005<\u0000\u0000M\u001a\u0001\u0000\u0000\u0000NO\u0005"+
		">\u0000\u0000OP\u0005=\u0000\u0000P\u001c\u0001\u0000\u0000\u0000QR\u0005"+
		"<\u0000\u0000RS\u0005=\u0000\u0000S\u001e\u0001\u0000\u0000\u0000TU\u0005"+
		"O\u0000\u0000UY\u0005R\u0000\u0000VW\u0005o\u0000\u0000WY\u0005r\u0000"+
		"\u0000XT\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000Y \u0001\u0000"+
		"\u0000\u0000Z[\u0005A\u0000\u0000[\\\u0005N\u0000\u0000\\a\u0005D\u0000"+
		"\u0000]^\u0005a\u0000\u0000^_\u0005n\u0000\u0000_a\u0005d\u0000\u0000"+
		"`Z\u0001\u0000\u0000\u0000`]\u0001\u0000\u0000\u0000a\"\u0001\u0000\u0000"+
		"\u0000bc\u0005N\u0000\u0000cd\u0005O\u0000\u0000di\u0005T\u0000\u0000"+
		"ef\u0005n\u0000\u0000fg\u0005o\u0000\u0000gi\u0005t\u0000\u0000hb\u0001"+
		"\u0000\u0000\u0000he\u0001\u0000\u0000\u0000i$\u0001\u0000\u0000\u0000"+
		"jn\u0005\'\u0000\u0000km\b\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000"+
		"mp\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000oq\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005\'\u0000"+
		"\u0000r&\u0001\u0000\u0000\u0000st\u0005n\u0000\u0000tu\u0005u\u0000\u0000"+
		"uv\u0005l\u0000\u0000vw\u0005l\u0000\u0000w(\u0001\u0000\u0000\u0000x"+
		"y\u0005t\u0000\u0000yz\u0005r\u0000\u0000z{\u0005u\u0000\u0000{\u0082"+
		"\u0005e\u0000\u0000|}\u0005f\u0000\u0000}~\u0005a\u0000\u0000~\u007f\u0005"+
		"l\u0000\u0000\u007f\u0080\u0005s\u0000\u0000\u0080\u0082\u0005e\u0000"+
		"\u0000\u0081x\u0001\u0000\u0000\u0000\u0081|\u0001\u0000\u0000\u0000\u0082"+
		"*\u0001\u0000\u0000\u0000\u0083\u0087\u0007\u0001\u0000\u0000\u0084\u0086"+
		"\u0007\u0002\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0089"+
		"\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088,\u0001\u0000\u0000\u0000\u0089\u0087\u0001"+
		"\u0000\u0000\u0000\u008a\u008c\u0007\u0003\u0000\u0000\u008b\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008b\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e.\u0001\u0000"+
		"\u0000\u0000\u008f\u0091\u0007\u0003\u0000\u0000\u0090\u008f\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000"+
		"\u0000\u0000\u0094\u0096\u0005.\u0000\u0000\u0095\u0097\u0007\u0003\u0000"+
		"\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u00990\u0001\u0000\u0000\u0000\u009a\u009c\u0007\u0004\u0000\u0000"+
		"\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"+
		"\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0006\u0018\u0000\u0000"+
		"\u00a02\u0001\u0000\u0000\u0000\u000b\u0000X`hn\u0081\u0087\u008d\u0092"+
		"\u0098\u009d\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}