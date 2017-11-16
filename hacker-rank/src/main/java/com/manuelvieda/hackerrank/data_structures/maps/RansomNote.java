package com.manuelvieda.hackerrank.data_structures.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know
 * if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in
 * his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings
 * or concatenation to create the words he needs.
 * <p>
 * Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note
 * exactly using whole words from the magazine; otherwise, print No.
 * <p>
 * <strong>Input Format</strong>
 * <p>
 * The first line contains two space-separated integers describing the respective values of  (the number of words in the
 * magazine) and  (the number of words in the ransom note).
 * The second line contains m space-separated strings denoting the words present in the magazine.
 * The third line contains n space-separated strings denoting the words present in the ransom note.
 * <p>
 * <strong>Constraints</strong>
 * <p>
 * <ul>
 * <li>1 <= m,n>=30000</=></li>
 * <li>1 <= length of any word <= 5</li>
 * <li>Each word consists of English alphabetic letters (i.e.,  to  and  to ).</li>
 * <li>The words in the note and magazine are case-sensitive.</li>
 * </ul>
 * <p>
 * <strong>Output Format</strong>
 * <p>
 * Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.
 */
public class RansomNote {


	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();

		boolean possible = true;

		if (n > m) {
			possible = false;
		} else {

			Map<String, Integer> magazine = new HashMap<>(m);
			for (int magazine_i = 0; magazine_i < m; magazine_i++) {
				String word = in.next();
				magazine.compute(word, (k, v) -> v == null ? 1 : v + 1);

			}
			for (int ransom_i = 0; ransom_i < n; ransom_i++) {
				String word = in.next();
				if (!magazine.containsKey(word)) {
					possible = false;
					break;
				}
				if (magazine.compute(word, (k, v) -> v == null ? -1 : v - 1) < 0) {
					possible = false;
					break;
				}
			}
		}

		System.out.println(possible ? "Yes" : "No");
	}
}
