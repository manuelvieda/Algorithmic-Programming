package com.manuelvieda.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * TEX is a typesetting language developed by Donald Knuth. It takes source text together with a few typesetting
 * instructions and produces, one hopes, a beautiful document. Beautiful documents use “ and ” to delimit quotations,
 * rather than the mundane " which is what is provided by most keyboards. Keyboards typically do not have an oriented
 * double-quote, but they do have a left-single-quote ` and a right-single-quote '. Check your keyboard now to locate
 * the left-single-quote key ` (sometimes called the “backquote key”) and the right-single-quote key ' (sometimes
 * called the “apostrophe” or just “quote”). Be careful not to confuse the left-single-quote ` with the “backslash”
 * key \. TEX lets the user type two left-single-quotes `` to create a left-double-quote “ and two
 * right-single-quotes '' to create a right-double-quote ”. Most typists, however, are accustomed to delimiting their
 * quotations with the un-oriented double-quote ".
 * <p>If the source contained
 * <pre>"To be or not to be," quoth the bard, "that is the question."</pre>
 * <p>then the typeset document produced by TEX would not contain the desired form:
 * <pre>“To be or not to be,” quoth the bard, “that is the question.”</pre>
 * <p>In order to produce the desired form, the source file must contain the sequence:
 * <pre>``To be or not to be,'' quoth the bard, ``that is the question.''</pre>
 * <p>You are to write a program which converts text containing double-quote (") characters into text that is
 * identical except that double-quotes have been replaced by the two-character sequences required by TEX for
 * delimiting quotations with oriented double-quotes. The double-quote (") characters should be replaced
 * appropriately by either `` if the " opens a quotation and by '' if the " closes a quotation. Notice that the
 * question of nested quotations does not arise: The first " must be replaced by ``, the next by '', the next by ``,
 * the next by '', the next by ``, the next by '', and so on.
 * <p><b>Input</b>
 * <p> Input will consist of several lines of text containing an even number of double-quote (") characters. Input is
 * ended with an end-of-file character.
 * <p><b>Output</b>
 * <p>The text must be output exactly as it was input except that:
 * <ul>
 * <li>the first " in each pair is replaced by two ` characters: `` and</li>
 * <li>the second " in each pair is replaced by two ' characters: ''.</li>
 * </ul>
 * <p><b>Online Judges:</b>
 * <ul>
 * <li>UVa: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=208</li>
 * </ul>
 *
 * @author Manuel E Vieda (https://manuelvieda.com)
 * @version 1.0
 * @since 1.0
 */
public class UVa272_TexQuotes {

    /**
     * Sequence of characters used to open a single quote in TEXT format
     */
    public static final char[] openQuote = { '`', '`' };

    /**
     * Sequence of characters used to close a single quote in TEXT format
     */
    public static final char[] closeQuote = { '\'', '\'' };

    /**
     * Flag that indicates if the characters read are inside a quote (Meaning that the next closing " must be
     * replaced by '')
     */
    boolean insideQuote = true;

    public static void main(String[] args) {

        UVa272_TexQuotes main = new UVa272_TexQuotes();
        main.solveProblem();
    }

    /**
     * Solves the TEX Quotes problem
     */
    public void solveProblem() {

        try (
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader in = new BufferedReader(inputStreamReader);
                PrintWriter out = new PrintWriter(System.out, true);
        ) {

            int r;
            while ((r = in.read()) != -1) {
                char ch = (char) r;
                if (ch == '"') {
                    out.write(insideQuote ? openQuote : closeQuote);
                    insideQuote = !insideQuote;
                } else {
                    out.write(ch);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
