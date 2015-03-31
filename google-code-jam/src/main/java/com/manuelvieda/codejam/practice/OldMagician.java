/**
 * Manuel Vieda - Copyright (c) 2015
 * http://manuelvieda.com
 * Date: 31/03/2015
 */
package com.manuelvieda.codejam.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * <b>Problem A. Old Magician</b>
 *
 * <p>
 * A magician does the following magic trick. He puts W white balls and B black balls in his hat and
 * asks someone from the audience, say Bob, to remove pairs of balls in whatever order Bob would
 * desire. After removing a pair of balls, Bob is asked to place a white ball back into the hat if
 * they are the same color. Otherwise he is asked to place a black ball into the hat.
 * <p>
 * When Bob is left with only one ball in the hat, he asks the magician what color the last ball is.
 * Needless to say, the magician can't see the order by which Bob does the replacements.
 * <p>
 * The problem is that the magician, like most magicians, is old and sometimes forgets how to do the
 * trick. Being the kind person you are, you are going to help the magician.
 * <p>
 * For each pair of numbers (W,B) you are asked to output one of the following:
 * <p>
 * <ul>
 * <li>"WHITE" - if the last ball in the hat will be white for sure.
 * <li>"BLACK" - if the last ball in the hat will be black for sure.
 * <li>"UNKNOWN" - if you can't be sure of the last ball's color.
 * </ul>
 *
 * @author Manuel E. Vieda
 * @version 1.0
 */
public class OldMagician {

	/**
	 * <b>Input rules:</b>
	 * <p>
	 * The first line of the input file contains the number of cases, N. N test cases follow.
	 * <p>
	 * Each case contains W and B on a line separated by a space.
	 * <p>
	 * Small data set:
	 * <ul>
	 * <li>0 < N,B,W ≤ 1000
	 * <li>W + B > 0
	 * </ul>
	 * <p>
	 * Large data data set:
	 * <ul>
	 * <li>0 < N,B,W ≤ 10^9
	 * <li>W + B > 0
	 * </ul>
	 */
	private static final String INPUT_FILE = "old_magician/A-large-practice.in";
	// private static final String INPUT_FILE = "old_magician/A-small-practice.in";

	/**
	 * Output file. For each input case, you should output:
	 * <p>
	 * {@code case #X: Y}
	 * <p>
	 * Where X is the number of the test case and Y is either "WHITE", "BLACK" or "UNKNOWN" as
	 * explained above. (quotes for clarity)
	 */
	private static final String OUTPUT_FILE = "old_magician/A-large-practice.out";
	// private static final String OUTPUT_FILE = "old_magician/A-small-practice.out";

	/**
	 * Main Method
	 *
	 * @param args Program arguments
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(final String[] args) throws NumberFormatException, IOException {

		final File outputFile = new File(OldMagician.class.getClassLoader().getResource(OUTPUT_FILE).getPath());

		try (
				final BufferedReader br = new BufferedReader(new InputStreamReader(
						OldMagician.class.getClassLoader().getResourceAsStream(INPUT_FILE),
						StandardCharsets.UTF_8));

				final OutputStreamWriter bw = new OutputStreamWriter(
						new FileOutputStream(outputFile),
						StandardCharsets.UTF_8)) {

			final int numberOfCases = Integer.valueOf(br.readLine());

			for (int i = 1; i <= numberOfCases; i++) {

				final String[] inputData = br.readLine().split(" ");
				final int black = Integer.valueOf(inputData[1]);
				bw.write("Case #" + i + ": " + (black % 2 == 0 ? "WHITE" : "BLACK") + "\n");
			}

		}

	}
}
