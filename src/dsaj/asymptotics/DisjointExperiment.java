/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package edu.allegheny.doubling;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Provides an empirical test of the efficiency of repeated string concatentation
 * versus use of the StringBuilder class.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class DisjointExperiment {

  /**
   * Tests the two versions of the 'repeat' algorithm, doubling the
   * size of n each trial, beginning with the given start value. The
   * first command line argument can be used to change the number of
   * trials, and the second to adjust the start value.
   */
  public static void main(String[] args) {
    int n = 500;                           // starting value
    int trials = 7;

    try {
      if (args.length > 0)
        trials = Integer.parseInt(args[0]);
      if (args.length > 1)
        n = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) { }
    int start = n;  // remember the original starting value

    // let's run version 2 (the quicker one) first
    System.out.println("Testing disjoint2...");
    for (int t=0; t < trials; t++) {
        int first[] = generateRandomArray(n);
        int second[] = generateRandomArray(n);
        int third[] = generateRandomArray(n);
        long startTime = System.currentTimeMillis();
        boolean isDisjoint = DisjointSet.disjoint1(first, second, third);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
        n *= 2;                                // double the problem size
    }

    System.out.println("Testing disjoint1...");
    n = start;                               // restore n to its start value
    for (int t=0; t < trials; t++) {
        int first[] = generateRandomArray(n);
        int second[] = generateRandomArray(n);
        int third[] = generateRandomArray(n);
        long startTime = System.currentTimeMillis();
        boolean isDisjoint = DisjointSet.disjoint2(first, second, third);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
        n *= 2;                                // double the problem size
    }
  }

  public static int[] generateRandomArray(int n) {
      Random random = new Random();
      int[] values = new int[n];
      for(int i = 0; i < n; i++) {
          int value = random.nextInt();
          values[i] = value;
      }
      return values;
  }

  public static void printArray(int[] values) {
      // for(int i = 0; i < values.length; i++) {
      //     System.out.print(values[i]);
      //     System.out.print(" ");
      // }
        System.out.println(values.length);
        System.out.println(values[(int)values.length/2]);
  }
}
