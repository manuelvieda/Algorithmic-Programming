/*
 * Manuel Vieda - Copyright (c) 2016
 * http://manuelvieda.com
 */

package com.manuelvieda.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Antique Comedians of Malidinesia prefer comedies to tragedies. Unfortunately, most of the ancient plays are
 * tragedies. Therefore the dramatic advisor of ACM has decided to transfigure some tragedies into comedies. Obviously,
 * this work is very hard because the basic sense of the play must be kept intact, although all the things change to
 * their opposites. For example the numbers: if any number appears in the tragedy, it must be converted to its reversed
 * form before being accepted into the comedy play.
 * <p>Reversed number is a number written in arabic numerals but the order of digits is reversed. The first digit
 * becomes last and vice versa. For example, if the main hero had 1245 strawberries in the tragedy, he has 5421 of them
 * now. Note that all the leading zeros are omitted. That means if the number ends with a zero, the zero is lost by
 * reversing (e.g. 1200 gives 21). Also note that the reversed number never has any trailing zeros.
 * <p>
 * ACM needs to calculate with reversed numbers. Your task is to add two reversed numbers and output their reversed
 * sum. Of course, the result is not unique because any particular number is a reversed form of several numbers (e.g.
 * 21
 * could be 12, 120 or 1200 before reversing). Thus we must assume that no zeros were lost by reversing (e.g. assume
 * that the original number was 12).
 * <p><b>Input</b>
 * <p>The input consists of N cases (equal to about 10000). The first line of the input contains only positive integer
 * N. Then follow the cases. Each case consists of exactly one line with two positive integers separated by space.
 * These
 * are the reversed numbers you are to add.
 * <p>
 * <b>Output</b
 * <p>
 * For each case, print exactly one line containing only one integer - the reversed sum of two reversed numbers. Omit
 * any leading zeros in the output.
 * <p>
 * <b>Online Judges:</b>
 * <ul>
 * <li>SPOJ: http://www.spoj.com/problems/ADDREV/</li>
 * <li>UVa: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=9&page=show_problem&problem=654</li>
 * </ul>
 *
 * @author Manuel E Vieda (https://manuelvieda.co
 */
public class UVa713_ADDREV_AddingReversedNumbers {

    /**
     * Main Class
     *
     * @param args
     *
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNumbers = Integer.valueOf(br.readLine());
        for (int i = 0; i < caseNumbers; i++) {

            String data = new String(reverseCharArray(br.readLine().toCharArray()));
            String[] numbers = data.split(" ");
            int sum = Integer.valueOf(numbers[0]) + Integer.valueOf(numbers[1]);
            Integer sumReversed = Integer.valueOf(new String(reverseCharArray(String.valueOf(sum).toCharArray())));
            System.out.println(sumReversed);
        }

    }

    /**
     * Reverse an integer in String format
     *
     * @param string
     *
     * @return
     */
    public static int reverseStringNumber(String string) {
        return Integer.valueOf(new String(reverseCharArray(string.toCharArray())));
    }

    /**
     * Reverse a char array
     *
     * @param array
     *
     * @return
     */
    public static char[] reverseCharArray(char[] array) {

        char[] reversedArray = new char[array.length];
        int midpoint = array.length / 2;
        int length = array.length - 1;

        for (int i = 0; i < midpoint; i++) {
            reversedArray[i] = array[length - i];
            reversedArray[length - i] = array[i];
        }

        if (array.length % 2 == 1) {
            reversedArray[midpoint] = array[midpoint];
        }

        return reversedArray;
    }
}
