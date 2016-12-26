package com.manuelvieda.problems;

import java.util.Scanner;

/**
 * <b>The 3n+1 Problem </b>
 * <p>
 * <ul>
 * <li>SPOJ: </li>
 * <li>UVa: </li>
 * </ul>
 *
 * @author Manuel E Vieda (https://manuelvieda.com)
 */
public class UVa100_PROBTNPO_The3nPlus1PRoblem {

    /**
     *
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

    public static void main(final String[] args) {

       final Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int i = in.nextInt();
            int j = in.nextInt();
            long resp = maxCycleLength(i, j);
            System.out.println(i + " " + j + " " +resp);
        }
    }

    /**
     * Calculates the maximum cycle length for all the numbers between {@code min} and {@code max}
     *
     * @param min
     * @param max
     *
     * @return
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
        if (n<cacheSize && cache[(int)n]!=0) {
            return cache[(int)n];
        } else {

            long length = 1 + cycleLength((n&1) == 0 ? n>>1 : 3 * n + 1);
            if(n<cacheSize){
                cache[(int)n] = length;
            }
            return length;
        }
    }
}
