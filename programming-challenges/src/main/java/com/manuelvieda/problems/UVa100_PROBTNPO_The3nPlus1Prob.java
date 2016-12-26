package com.manuelvieda.problems;

import java.util.Scanner;

/**
 * <b>The 3n+1 Problem </b>
 * <p>
 * <b>The problem:</b>
 * <p>Consider the following algorithm:
 * <ol>
 * <li>input n</li>
 * <li>print n</li>
 * <li>if n = 1 then STOP</li>
 * <li>if n is odd then n = 3n + 1</li>
 * <li>else n = n / 2</li>
 * <li>GOTO 2</li>
 * </ol>
 * <p>Given the input 22, the following sequence of numbers will be printed 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 * <p>It is conjectured that the algorithm above will terminate (when a 1 is printed) for any integral input value.
 * Despite
 * the simplicity of the algorithm, it is unknown whether this conjecture is true. It has been verified, however, for
 * all integers n such that 0 < n < 1,000,000 (and, in fact, for many more numbers than this.)
 * <p>Given an input n, it is possible to determine the number of numbers printed (including the 1). For a given n this
 * is called the cycle-length of n. In the example above, the cycle length of 22 is 16.
 * <p>For any two numbers i and j you are to determine the maximum cycle length over all numbers between i and j.
 * <p>
 * <b>The Input</b>
 * <p>
 * The input will consist of a series of pairs of integers i and j, one pair of integers per line. All integers will be
 * less than 1,000,000 and greater than 0.
 * <p>You should process all pairs of integers and for each pair determine the maximum cycle length over all integers
 * between and including i and j.
 * <p>You can assume that no operation overflows a 32-bit integer.
 * <p>
 * <b>The Output:</b>
 * <p>For each pair of input integers i and j you should output i, j, and the maximum cycle length for integers between
 * and including i and j. These three numbers should be separated by at least one space with all three numbers on one
 * line and with one line of output for each line of input. The integers i and j must appear in the output in the same
 * order in which they appeared in the input and should be followed by the maximum cycle length (on the same line).
 * <ul>
 * <li>SPOJ: http://www.spoj.com/problems/PROBTNPO/</li>
 * <li>UVa: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=36</li>
 * </ul>
 *
 * @author Manuel E Vieda (https://manuelvieda.com)
 */
public class UVa100_PROBTNPO_The3nPlus1Prob {

    /**
     * Constant that defines the size of the cache
     */
    public static final int cacheSize = 1000000;

    /**
     * Array that contains the length for positive integers that was already calculated
     */
    private static long[] cache = new long[cacheSize];

    static {
        cache[1] = 1;
        cache[2] = 2;
        cache[4] = 3;
        cache[8] = 4;
        cache[16] = 5;
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int i = in.nextInt();
            int j = in.nextInt();
            long resp = maxCycleLength(i, j);
            System.out.println(i + " " + j + " " + resp);
        }
    }

    /**
     * Calculates the maximum cycle length for all the numbers between {@code min} and {@code max}
     *
     * @param min The lower limit of the range (Included)
     * @param max The upper limit of the range (Included)
     *
     * @return The maximum cycle length
     */
    public static long maxCycleLength(long min, long max) {

        long start = Math.min(min, max);
        long end = Math.max(min, max);
        long maxCycleLength = 0;

        for (long i = start; i <= end; i++) {
            long cycleLength = cycleLength(i);
            if (cycleLength > maxCycleLength) {
                maxCycleLength = cycleLength;
            }
        }

        return maxCycleLength;

    }

    /**
     * Calculates the cycle length for the given positive integer
     *
     * @param n
     *
     * @return
     */
    public static long cycleLength(long n) {
        if (n < cacheSize && cache[(int) n] != 0) {
            return cache[(int) n];
        } else {

            long length = 1 + cycleLength((n & 1) == 0 ? n >> 1 : 3<<1 + n + 1);
            if (n < cacheSize) {
                cache[(int) n] = length;
            }
            return length;
        }
    }
}
