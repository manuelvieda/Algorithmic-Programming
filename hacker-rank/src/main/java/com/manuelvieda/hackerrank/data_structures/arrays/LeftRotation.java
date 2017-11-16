package com.manuelvieda.hackerrank.data_structures.arrays;

import java.util.Scanner;

/**
 * A left rotation operation on an array of size {@code n} shifts each of the array's elements 1 unit to the left. For
 * example, if 2 left rotations are performed on array {@code [1,2,3,4,5]}, then the array would become {@code
 * [3,4,5,1,2]}.
 * <p>
 * Given an array of n integers and a number, d, perform d left rotations on the array. Then print the updated array as
 * a single line of space-separated integers.
 * <p>
 * <strong>Input Format</strong>
 * <p>
 * The first line contains two space-separated integers denoting the respective values of n(the number of integers) and
 * d(the number of left rotations you must perform). The second line contains n space-separated integers describing the
 * respective elements of the array's initial state
 * <p>
 * <strong>Output Format</strong>
 * Print a single line of n space-separated integers denoting the final state of the array after performing d left
 * rotations.
 */
public class LeftRotation {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		//solution1(a, n, k);
		//solution2(a, n, k);
		solution3(a, n, k);
	}

	private static void solution1(int[] a, int n, int k) {
		for (int a_i = 0; a_i < n; a_i++) {
			System.out.print(a[(a_i + k) % n] + " ");
		}
	}


	private static void solution2(int[] a, int n, int k) {

		for (int a_i = k % n; a_i < n; a_i++) {
			System.out.print(a[a_i] + " ");
		}

		for (int a_i = 0; a_i < k % n; a_i++) {
			System.out.print(a[a_i] + " ");
		}
	}

	private static void solution3(int[] a, int n, int k){

		int[] resp = new int[a.length];
		for (int a_i = 0; a_i < n; a_i++) {
			resp[a_i] = a[(a_i + k) % n];
		}

		for (int i = 0; i < resp.length; i++) {
			System.out.print(resp[i] + (i != resp.length - 1 ? " " : ""));
		}
	}
}
