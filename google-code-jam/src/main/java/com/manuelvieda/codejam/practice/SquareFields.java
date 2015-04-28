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
 * <b>Problem B: Square Fields<b>:
 * <p>You are given n points in the plane. You are asked to cover these points with k squares.
 * <p>The squares must all be the same size, and their edges must all be parallel to the coordinate axes.
 * <p>A point is covered by a square if it lies inside the square, or on an edge of the square.
 * <p>Squares can overlap.
 * <p>Find the minimum length for the squares' edges such that you can cover the n points with k squares.
 * 
 * @author Manuel E. Vieda
 * @version 1.0
 */
public class SquareFields {
	
	/**
	 * The first line of input gives the number of cases, N. N test cases follow. The first line of each test contains two positive integers n and k. Each of the next n lines contains a point as two integers separated by exactly one space. No point will occur more than once within a test case.
	 * <p>The points' coordinates are non-negative integers smaller than 64000.
	 * <p>{@code 1 ≤ N ≤ 10}
	 * <p>Small dataset: {@code1 ≤ k < n ≤ 7}
	 * <p>Large dataset: {@code 1 ≤ k < n ≤ 15}
	 */
	private static final String INPUT_FILE = "old_magician/A-large-practice.in";
	// private static final String INPUT_FILE = "old_magician/A-small-practice.in";
	
	/**
	 * For each test case, you should output one line containing "Case #X: Y" (quotes for clarity), where X is the number of the test case, starting from 1, and Y is the minimum length for the squares' edges for that test case.
	 */
	private static final String OUTPUT_FILE = "old_magician/A-large-practice.out";
	// private static final String OUTPUT_FILE = "old_magician/A-small-practice.out";
	

	/**
	 * Main Method
	 *
	 * @param args Program arguments
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
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
				
			}
		}
	}

}
