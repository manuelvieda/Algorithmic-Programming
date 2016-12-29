/*
 * Manuel Vieda - Copyright (c) 2016
 * http://manuelvieda.com
 */

package com.manuelvieda.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Jennifer is a teacher in the first year of a primary school. She has gone for a trip with her class today. She has
 * taken a packet of candies for each child. Unfortunatelly, the sizes of the packets are not the same.
 * <p>
 * Jennifer is afraid that each child will want to have the biggest packet of candies and this will lead to quarrels or
 * even fights among children. She wants to avoid this. Therefore, she has decided to open all the packets, count the
 * candies in each packet and move some candies from bigger packets to smaller ones so that each packet will contain the
 * same number of candies. The question is how many candies she has to move.
 * <p>
 * Input specification
 * <p>
 * The input file consists of several blocks of data. Each block starts with the number of candy packets N(1<= N
 * <=10000) followed by N integers (each less than 1000) in separate lines, giving the number of candies in each packet.
 * After the last block of data there is the number -1.
 * <p>
 * Output specification
 * <p>
 * The output file should contain one line with the smallest number of moves for each block of data. One move consists
 * of taking one candy from a packet and putting it into another one. If it is not possible to have the same number of
 * candies in each packet, output the number -1.
 * <p>
 * http://www.spoj.com/problems/CANDY/
 * Created by manue on 25/12/2016.
 */
public class CANDY_Candy1 {

    /**
     * @param args
     *
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int candyBags = Integer.parseInt(br.readLine());
        while (candyBags > 0) {

            int total = 0;
            int[] bags = new int[candyBags];

            for (int i = 0; i < candyBags; i++) {
                bags[i] = Integer.parseInt(br.readLine());
                total += bags[i];
            }

            if (total % candyBags == 0) {
                int expected = total / candyBags;
                int movements = 0;
                for (int i = 0; i < bags.length; i++) {
                    if (bags[i] < expected) {
                        movements += expected - bags[i];
                    }
                }
                System.out.println(movements);
            } else {
                System.out.println("-1");
            }

            candyBags = Integer.parseInt(br.readLine());
        }
    }
}
