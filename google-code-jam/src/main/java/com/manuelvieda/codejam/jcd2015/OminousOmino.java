/**
 * Manuel Vieda - Copyright (c) 2015
 * http://manuelvieda.com
 * Date: 11/04/2015
 */
package com.manuelvieda.codejam.jcd2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import com.manuelvieda.codejam.practice.OldMagician;

/**
 * <b>Problem D. Ominous Omino</b>
 *
 * <p>
 * An N-omino is a two-dimensional shape formed by joining N unit cells fully along their edges in
 * some way. More formally, a 1-omino is a 1x1 unit square, and an N-omino is an (N-1)omino with one
 * or more of its edges joined to an adjacent 1x1 unit square. For the purpose of this problem, we
 * consider two N-ominoes to be the same if one can be transformed into the other via reflection
 * and/or rotation.
 *
 * <p>
 * Richard and Gabriel are going to play a game with the following rules, for some predetermined
 * values of X, R, and C:
 * <ol>
 * <li>Richard will choose any one of the possible X-ominoes.
 * <li>Gabriel must use at least one copy of that X-omino, along with arbitrarily many copies of any
 * X-ominoes (which can include the one Richard chose), to completely fill in an R-by-C grid, with
 * no overlaps and no spillover. That is, every cell must be covered by exactly one of the X cells
 * making up an X-omino, and no X-omino can extend outside the grid. Gabriel is allowed to rotate or
 * reflect as many of the X-ominoes as he wants, including the one Richard chose. If Gabriel can
 * completely fill in the grid, he wins; otherwise, Richard wins.</li>
 * </ol>
 *
 * <p>
 * Given particular values X, R, and C, can Richard choose an X-omino that will ensure that he wins,
 * or is Gabriel guaranteed to win no matter what Richard chooses?
 *
 * @author Manuel E. Vieda
 * @version 1.0
 */
public class OminousOmino {

	/**
	 * The first line of the input gives the number of test cases, T. T lines follow. Each contains
	 * three space-separated integers: X, R, and C.
	 */
	private static final String INPUT_FILE = "ominous-omino/D-large-practice.in";
	// private static final String INPUT_FILE = "ominous-omino/D-small-practice.in";

	/**
	 * For each test case, output one line containing "Case #x: y", where x is the test case number
	 * (starting from 1) and y is either RICHARD (if there is at least one choice that ensures
	 * victory for Richard) or GABRIEL (if Gabriel will win no matter what Richard chooses).
	 */
	private static final String OUTPUT_FILE = "ominous-omino/D-large-practice.out";
	// private static final String OUTPUT_FILE = "ominous-omino/D-small-practice.out";

	/**
	 * Main Method
	 *
	 * @param args Program arguments
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(final String[] args) throws NumberFormatException, IOException {

		final File outputFile = new File(StandingOvation.class.getClassLoader().getResource(OUTPUT_FILE).getPath());

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
				final int x = Integer.valueOf(inputData[0]);
				final int r = Integer.valueOf(inputData[1]);
				final int c = Integer.valueOf(inputData[2]);

				bw.write("Case #" + i + ": " + (winsRichard(x, r, c) ? "RICHARD" : "GABRIEL") + "\n");
			}

		}
	}

	/**
	 * Determines if Richard can win the game with the given parameter
	 *
	 * @param x The N-omino definition (Number N)
	 * @param r Board width
	 * @param c Board high
	 * @return {@code true} if Richard has an option to win
	 */
	public static boolean winsRichard(final int x, final int r, final int c) {

		boolean winsRichard = false;

		if (x >= 7 || (r * c) % x != 0) {
			winsRichard = true;
		}
		else {
			switch (x) {
				case 6:
					winsRichard = Math.min(r, c) <= 3;
					break;
				case 5:
					winsRichard = Math.min(r, c) <= 2 || Math.min(r, c) == 3 && Math.max(r, c) == 5;
					break;
				case 4:
					winsRichard = Math.min(r, c) <= 2;
					break;
				case 3:
					winsRichard = Math.min(r, c) <= 1;
					break;
			}
		}

		return winsRichard;
	}

}
