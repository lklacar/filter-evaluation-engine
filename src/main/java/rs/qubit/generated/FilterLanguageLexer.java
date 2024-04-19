// Generated from /Users/luka.klacar/Projects/poc/src/main/antlr4/FilterLanguage.g4 by ANTLR 4.13.1
package rs.qubit.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class FilterLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		IDENTIFIER=10, INTEGER=11, BOOLEAN=12, DATE=13, STRING=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"IDENTIFIER", "INTEGER", "BOOLEAN", "DATE", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'AND'", "'OR'", "'LIKE'", "'>'", "'<'", "'='", "'NOT'", "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "IDENTIFIER", 
			"INTEGER", "BOOLEAN", "DATE", "STRING", "WS"
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


	public FilterLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FilterLanguage.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 12:
			DATE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void DATE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			4
			break;
		case 1:
			2
			break;
		case 2:
			2
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u000fi\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0004\t;\b\t\u000b\t\f\t<\u0001\n\u0004\n@\b\n\u000b"+
		"\n\f\nA\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bM\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r\\\b\r\n\r\f\r_\t\r\u0001\r\u0001\r"+
		"\u0001\u000e\u0004\u000ed\b\u000e\u000b\u000e\f\u000ee\u0001\u000e\u0001"+
		"\u000e\u0000\u0000\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u0001\u0000\u0004\u0002\u0000AZaz\u0001"+
		"\u000009\u0001\u0000\'\'\u0003\u0000\t\n\r\r  n\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0001\u001f\u0001\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005"+
		"&\u0001\u0000\u0000\u0000\u0007+\u0001\u0000\u0000\u0000\t-\u0001\u0000"+
		"\u0000\u0000\u000b/\u0001\u0000\u0000\u0000\r1\u0001\u0000\u0000\u0000"+
		"\u000f5\u0001\u0000\u0000\u0000\u00117\u0001\u0000\u0000\u0000\u0013:"+
		"\u0001\u0000\u0000\u0000\u0015?\u0001\u0000\u0000\u0000\u0017L\u0001\u0000"+
		"\u0000\u0000\u0019N\u0001\u0000\u0000\u0000\u001bW\u0001\u0000\u0000\u0000"+
		"\u001dc\u0001\u0000\u0000\u0000\u001f \u0005A\u0000\u0000 !\u0005N\u0000"+
		"\u0000!\"\u0005D\u0000\u0000\"\u0002\u0001\u0000\u0000\u0000#$\u0005O"+
		"\u0000\u0000$%\u0005R\u0000\u0000%\u0004\u0001\u0000\u0000\u0000&\'\u0005"+
		"L\u0000\u0000\'(\u0005I\u0000\u0000()\u0005K\u0000\u0000)*\u0005E\u0000"+
		"\u0000*\u0006\u0001\u0000\u0000\u0000+,\u0005>\u0000\u0000,\b\u0001\u0000"+
		"\u0000\u0000-.\u0005<\u0000\u0000.\n\u0001\u0000\u0000\u0000/0\u0005="+
		"\u0000\u00000\f\u0001\u0000\u0000\u000012\u0005N\u0000\u000023\u0005O"+
		"\u0000\u000034\u0005T\u0000\u00004\u000e\u0001\u0000\u0000\u000056\u0005"+
		"(\u0000\u00006\u0010\u0001\u0000\u0000\u000078\u0005)\u0000\u00008\u0012"+
		"\u0001\u0000\u0000\u00009;\u0007\u0000\u0000\u0000:9\u0001\u0000\u0000"+
		"\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000"+
		"\u0000\u0000=\u0014\u0001\u0000\u0000\u0000>@\u0007\u0001\u0000\u0000"+
		"?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000"+
		"\u0000AB\u0001\u0000\u0000\u0000B\u0016\u0001\u0000\u0000\u0000CD\u0005"+
		"t\u0000\u0000DE\u0005r\u0000\u0000EF\u0005u\u0000\u0000FM\u0005e\u0000"+
		"\u0000GH\u0005f\u0000\u0000HI\u0005a\u0000\u0000IJ\u0005l\u0000\u0000"+
		"JK\u0005s\u0000\u0000KM\u0005e\u0000\u0000LC\u0001\u0000\u0000\u0000L"+
		"G\u0001\u0000\u0000\u0000M\u0018\u0001\u0000\u0000\u0000NO\u0007\u0001"+
		"\u0000\u0000OP\u0006\f\u0000\u0000PQ\u0005-\u0000\u0000QR\u0007\u0001"+
		"\u0000\u0000RS\u0006\f\u0001\u0000ST\u0005-\u0000\u0000TU\u0007\u0001"+
		"\u0000\u0000UV\u0006\f\u0002\u0000V\u001a\u0001\u0000\u0000\u0000W]\u0005"+
		"\'\u0000\u0000X\\\b\u0002\u0000\u0000YZ\u0005\'\u0000\u0000Z\\\u0005\'"+
		"\u0000\u0000[X\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\_\u0001"+
		"\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000"+
		"^`\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`a\u0005\'\u0000\u0000"+
		"a\u001c\u0001\u0000\u0000\u0000bd\u0007\u0003\u0000\u0000cb\u0001\u0000"+
		"\u0000\u0000de\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0006\u000e\u0003\u0000"+
		"h\u001e\u0001\u0000\u0000\u0000\u0007\u0000<AL[]e\u0004\u0001\f\u0000"+
		"\u0001\f\u0001\u0001\f\u0002\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}