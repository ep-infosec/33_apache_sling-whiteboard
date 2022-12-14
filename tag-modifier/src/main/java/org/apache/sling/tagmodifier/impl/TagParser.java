/* Generated By:JavaCC: Do not edit this line. TagParser.java */
package org.apache.sling.tagmodifier.impl;

import org.apache.sling.tagmodifier.*;
import org.apache.sling.tagmodifier.impl.tag.*;
import java.util.*;

public class TagParser implements TagParserConstants {

  private static String getTokenHtmlText(Token first, Token cur) {
    Token t;
    StringBuilder sb = new StringBuilder();

    for (t=first; t != cur.next; t = t.next) {
      if (t.specialToken != null) {
        Token tt=t.specialToken;
        while (tt.specialToken != null)
          tt = tt.specialToken;
        for (; tt != null; tt = tt.next)
          sb.append(tt.image);
      };
      sb.append(t.image);
    };
    return sb.toString();
  }

  final public Element element() throws ParseException {
  Element e;
  Token text;
    if (jj_2_1(2)) {
      e = tag();
                            {if (true) return e;}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ENDTAG_START:
        e = endHtmlElement();
                                    {if (true) return e;}
        break;
      case COMMENT_START:
        e = commentHtmlElement();
                                    {if (true) return e;}
        break;
      case DECL_START:
        e = decltag();
                            {if (true) return e;}
        break;
      default:
        jj_la1[0] = jj_gen;
        if (jj_2_2(2)) {
          jj_consume_token(TAG_START);
          text = jj_consume_token(LST_ERROR);
              {if (true) return new TextData("<" + text.image);}
        } else {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case RAWTEXT:
            text = jj_consume_token(RAWTEXT);
                             {if (true) return new TextData(text.image);}
            break;
          case 0:
            jj_consume_token(0);
              {if (true) return new EndOfFile();}
            break;
          default:
            jj_la1[1] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

/** @return an attribute */
  final public void attribute(Map<String,AttrValue > alist) throws ParseException {
  Token t1, t2=null;
    t1 = jj_consume_token(ATTR_NAME);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ATTR_EQ:
    case ATTR_VAL:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ATTR_EQ:
        jj_consume_token(ATTR_EQ);
        t2 = jj_consume_token(STRING);
        break;
      case ATTR_VAL:
        t2 = jj_consume_token(ATTR_VAL);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
     if (t2 == null) {
        alist.put(t1.image,new AttrValue());
      } else {
        alist.put(t1.image,new AttrValue(t2.image));
     }
  }

  final public Map<String,AttrValue> attributeList() throws ParseException {
  Map<String,AttrValue> alist = new HashMap<String,AttrValue>();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ATTR_NAME:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_1;
      }
      attribute(alist);
    }
     {if (true) return alist;}
    throw new Error("Missing return statement in function");
  }

  final public Element tag() throws ParseException {
  Token t, et;
  Map<String,AttrValue> alist;
  Token firstToken = getToken(1);
    try {
      jj_consume_token(TAG_START);
      t = jj_consume_token(TAG_NAME);
      alist = attributeList();
      et = jj_consume_token(END_OF_TAG);
      {if (true) return new StartTag(t.image, alist, et.image.equals(">"));}
    } catch (ParseException ex) {
    token_source.SwitchTo(DEFAULT);
    String s = getTokenHtmlText(firstToken, getNextToken());
    {if (true) return new TextData(s);}
    }
    throw new Error("Missing return statement in function");
  }

/** @return the end of a tag */
  final public Element endHtmlElement() throws ParseException {
  Token t;
  Token firstToken = getToken(1);
    try {
      jj_consume_token(ENDTAG_START);
      t = jj_consume_token(TAG_NAME);
      jj_consume_token(END_OF_TAG);
      {if (true) return new EndTag(t.image);}
    } catch (ParseException ex) {
    token_source.SwitchTo(DEFAULT);
    String s = getTokenHtmlText(firstToken, getNextToken());
    {if (true) return new TextData(s);}
    }
    throw new Error("Missing return statement in function");
  }

  final public Comment commentHtmlElement() throws ParseException {
  StringBuilder sb = new StringBuilder();
    jj_consume_token(COMMENT_START);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMENT_WORD:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_2;
      }
      jj_consume_token(COMMENT_WORD);
                                     sb.append(token.image);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 0:
      jj_consume_token(0);
      break;
    case COMMENT_END:
      jj_consume_token(COMMENT_END);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return new Comment(sb.toString());}
    throw new Error("Missing return statement in function");
  }

/** @return the start of a DECLARATION */
  final public Element decltag() throws ParseException {
  Token tok = null;
  Map<String,AttrValue > alist = new HashMap<String,AttrValue>();
  Token firstToken = getToken(1);
    try {
      jj_consume_token(DECL_START);
      tok = jj_consume_token(DECL_TAG);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DECL_ATTR:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_3;
        }
        jj_consume_token(DECL_ATTR);
                                                 alist.put(token.image,new AttrValue());
      }
      jj_consume_token(DECL_END);
      {if (true) return new StartTag(tok.image, alist);}
    } catch (ParseException ex) {
    token_source.SwitchTo(DEFAULT);
    String s = getTokenHtmlText(firstToken, getNextToken());
    {if (true) return new TextData(s);}
    }
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_3_2() {
    if (jj_scan_token(TAG_START)) return true;
    if (jj_scan_token(LST_ERROR)) return true;
    return false;
  }

  private boolean jj_3R_4() {
    if (jj_scan_token(TAG_START)) return true;
    if (jj_scan_token(TAG_NAME)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_4()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public TagParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[8];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x380,0x401,0x50000,0x50000,0x4000,0x1000000,0x800001,0x4000000,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[2];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public TagParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public TagParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new TagParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public TagParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new TagParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public TagParser(TagParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(TagParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[28];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 8; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 2; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
