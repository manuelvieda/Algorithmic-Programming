package com.manuelvieda.hackerrank.data_structures.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams
 * of each other if the first string's letters can be rearranged to form the second string. In other words, both
 * strings
 * must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc
 * and dcbad are not.
 * <p>
 * Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum
 * number
 * of character deletions required to make the two strings anagrams. Can you help her find this number?
 * <p>
 * Given two strings, a and b, that may or may not be of the same length, determine the minimum number of character
 * deletions required to make a and b anagrams. Any characters can be deleted from either of the strings.
 * <p>
 * Input Format
 * <p>
 * The first line contains a single string, .
 * The second line contains a single string, .
 * <p>
 * <strong>Constraints:</strong>
 * <ul>
 * <li>1 <= |a|, |b|, <= 10^4</li>
 * <li>It is guaranteed that  and  consist of lowercase English alphabetic letters (i.e.,  through ).</li>
 * </ul>
 * <p>
 * <strong>Output Format:</strong>
 * <p>
 * Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each
 * other.
 */
public class MakingAnagrams {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}

	public static int numberNeeded(String first, String second) {

		int[] letter = new int[26];
		char[] firstCh = first.toCharArray();
		char[] secondCh = second.toCharArray();

		for (char ch : firstCh) {
			letter[ch - 'a']++;
		}

		for (char ch : secondCh) {
			letter[ch - 'a']--;
		}

		return Arrays.stream(letter).map(Math::abs).sum();


	}
}
