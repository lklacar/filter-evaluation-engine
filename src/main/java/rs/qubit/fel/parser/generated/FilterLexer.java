// Generated from /home/luka/Projects/Personal/filter-evaluation-engine/src/main/antlr4/Filter.g4 by ANTLR 4.13.1
package rs.qubit.fel.parser.generated;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class FilterLexer extends Lexer {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, LEFT_PAREN = 4, RIGHT_PAREN = 5, LEFT_BRACKET = 6, RIGHT_BRACKET = 7,
            COMMA = 8, EQUALS = 9, NOTEQUALS = 10, GT = 11, LT = 12, GTE = 13, LTE = 14, OR = 15,
            AND = 16, NOT = 17, STRING = 18, NULL = 19, BOOLEAN = 20, IDENTIFIER = 21, LONG = 22,
            DOUBLE = 23, DOT = 24, WS = 25;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\u0004\u0000\u0019\u0093\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002" +
            "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002" +
            "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002" +
            "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002" +
            "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e" +
            "\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011" +
            "\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014" +
            "\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017" +
            "\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001" +
            "\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004" +
            "\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007" +
            "\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001" +
            "\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001" +
            "\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001" +
            "\u0010\u0001\u0011\u0001\u0011\u0005\u0011]\b\u0011\n\u0011\f\u0011`\t" +
            "\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001" +
            "\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001" +
            "\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013r\b" +
            "\u0013\u0001\u0014\u0001\u0014\u0005\u0014v\b\u0014\n\u0014\f\u0014y\t" +
            "\u0014\u0001\u0015\u0004\u0015|\b\u0015\u000b\u0015\f\u0015}\u0001\u0016" +
            "\u0004\u0016\u0081\b\u0016\u000b\u0016\f\u0016\u0082\u0001\u0016\u0001" +
            "\u0016\u0004\u0016\u0087\b\u0016\u000b\u0016\f\u0016\u0088\u0001\u0017" +
            "\u0001\u0017\u0001\u0018\u0004\u0018\u008e\b\u0018\u000b\u0018\f\u0018" +
            "\u008f\u0001\u0018\u0001\u0018\u0000\u0000\u0019\u0001\u0001\u0003\u0002" +
            "\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013" +
            "\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011" +
            "#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u0019\u0001\u0000" +
            "\u0005\u0001\u0000\'\'\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u0000" +
            "09\u0003\u0000\t\n\r\r  \u0099\u0000\u0001\u0001\u0000\u0000\u0000\u0000" +
            "\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000" +
            "\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b" +
            "\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001" +
            "\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001" +
            "\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001" +
            "\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001" +
            "\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001" +
            "\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000" +
            "\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000" +
            "\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-" +
            "\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000" +
            "\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000\u0000" +
            "\u00057\u0001\u0000\u0000\u0000\u00079\u0001\u0000\u0000\u0000\t;\u0001" +
            "\u0000\u0000\u0000\u000b=\u0001\u0000\u0000\u0000\r?\u0001\u0000\u0000" +
            "\u0000\u000fA\u0001\u0000\u0000\u0000\u0011C\u0001\u0000\u0000\u0000\u0013" +
            "E\u0001\u0000\u0000\u0000\u0015H\u0001\u0000\u0000\u0000\u0017J\u0001" +
            "\u0000\u0000\u0000\u0019L\u0001\u0000\u0000\u0000\u001bO\u0001\u0000\u0000" +
            "\u0000\u001dR\u0001\u0000\u0000\u0000\u001fU\u0001\u0000\u0000\u0000!" +
            "X\u0001\u0000\u0000\u0000#Z\u0001\u0000\u0000\u0000%c\u0001\u0000\u0000" +
            "\u0000\'q\u0001\u0000\u0000\u0000)s\u0001\u0000\u0000\u0000+{\u0001\u0000" +
            "\u0000\u0000-\u0080\u0001\u0000\u0000\u0000/\u008a\u0001\u0000\u0000\u0000" +
            "1\u008d\u0001\u0000\u0000\u000034\u0005-\u0000\u00004\u0002\u0001\u0000" +
            "\u0000\u000056\u0005T\u0000\u00006\u0004\u0001\u0000\u0000\u000078\u0005" +
            ":\u0000\u00008\u0006\u0001\u0000\u0000\u00009:\u0005(\u0000\u0000:\b\u0001" +
            "\u0000\u0000\u0000;<\u0005)\u0000\u0000<\n\u0001\u0000\u0000\u0000=>\u0005" +
            "[\u0000\u0000>\f\u0001\u0000\u0000\u0000?@\u0005]\u0000\u0000@\u000e\u0001" +
            "\u0000\u0000\u0000AB\u0005,\u0000\u0000B\u0010\u0001\u0000\u0000\u0000" +
            "CD\u0005=\u0000\u0000D\u0012\u0001\u0000\u0000\u0000EF\u0005!\u0000\u0000" +
            "FG\u0005=\u0000\u0000G\u0014\u0001\u0000\u0000\u0000HI\u0005>\u0000\u0000" +
            "I\u0016\u0001\u0000\u0000\u0000JK\u0005<\u0000\u0000K\u0018\u0001\u0000" +
            "\u0000\u0000LM\u0005>\u0000\u0000MN\u0005=\u0000\u0000N\u001a\u0001\u0000" +
            "\u0000\u0000OP\u0005<\u0000\u0000PQ\u0005=\u0000\u0000Q\u001c\u0001\u0000" +
            "\u0000\u0000RS\u0005|\u0000\u0000ST\u0005|\u0000\u0000T\u001e\u0001\u0000" +
            "\u0000\u0000UV\u0005&\u0000\u0000VW\u0005&\u0000\u0000W \u0001\u0000\u0000" +
            "\u0000XY\u0005!\u0000\u0000Y\"\u0001\u0000\u0000\u0000Z^\u0005\'\u0000" +
            "\u0000[]\b\u0000\u0000\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000" +
            "\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_a\u0001" +
            "\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ab\u0005\'\u0000\u0000b$\u0001" +
            "\u0000\u0000\u0000cd\u0005n\u0000\u0000de\u0005u\u0000\u0000ef\u0005l" +
            "\u0000\u0000fg\u0005l\u0000\u0000g&\u0001\u0000\u0000\u0000hi\u0005t\u0000" +
            "\u0000ij\u0005r\u0000\u0000jk\u0005u\u0000\u0000kr\u0005e\u0000\u0000" +
            "lm\u0005f\u0000\u0000mn\u0005a\u0000\u0000no\u0005l\u0000\u0000op\u0005" +
            "s\u0000\u0000pr\u0005e\u0000\u0000qh\u0001\u0000\u0000\u0000ql\u0001\u0000" +
            "\u0000\u0000r(\u0001\u0000\u0000\u0000sw\u0007\u0001\u0000\u0000tv\u0007" +
            "\u0002\u0000\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000" +
            "wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x*\u0001\u0000\u0000" +
            "\u0000yw\u0001\u0000\u0000\u0000z|\u0007\u0003\u0000\u0000{z\u0001\u0000" +
            "\u0000\u0000|}\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001" +
            "\u0000\u0000\u0000~,\u0001\u0000\u0000\u0000\u007f\u0081\u0007\u0003\u0000" +
            "\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000" +
            "\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000" +
            "\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0086\u0005.\u0000\u0000" +
            "\u0085\u0087\u0007\u0003\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000" +
            "\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000" +
            "\u0088\u0089\u0001\u0000\u0000\u0000\u0089.\u0001\u0000\u0000\u0000\u008a" +
            "\u008b\u0005.\u0000\u0000\u008b0\u0001\u0000\u0000\u0000\u008c\u008e\u0007" +
            "\u0004\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001" +
            "\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001" +
            "\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0006" +
            "\u0018\u0000\u0000\u00922\u0001\u0000\u0000\u0000\b\u0000^qw}\u0082\u0088" +
            "\u008f\u0001\u0006\u0000\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    static {
        RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public FilterLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET",
                "RIGHT_BRACKET", "COMMA", "EQUALS", "NOTEQUALS", "GT", "LT", "GTE", "LTE",
                "OR", "AND", "NOT", "STRING", "NULL", "BOOLEAN", "IDENTIFIER", "LONG",
                "DOUBLE", "DOT", "WS"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'-'", "'T'", "':'", "'('", "')'", "'['", "']'", "','", "'='",
                "'!='", "'>'", "'<'", "'>='", "'<='", "'||'", "'&&'", "'!'", null, "'null'",
                null, null, null, null, "'.'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET",
                "RIGHT_BRACKET", "COMMA", "EQUALS", "NOTEQUALS", "GT", "LT", "GTE", "LTE",
                "OR", "AND", "NOT", "STRING", "NULL", "BOOLEAN", "IDENTIFIER", "LONG",
                "DOUBLE", "DOT", "WS"
        };
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

    @Override
    public String getGrammarFileName() {
        return "Filter.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}