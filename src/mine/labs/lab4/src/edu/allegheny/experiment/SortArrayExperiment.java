package edu.allegheny.experiment;

import java.util.Arrays;
import java.util.Collections;

import dsaj.arrays.InsertionSort;

public class SortArrayExperiment {

  private static class StatisticsCalculator {

    public static long calculateArithmeticMean(Long[] timings, boolean discardFirst) {
      long runningTotal = 0;
      int start = 0;
      if (discardFirst) {
        start = 1;
      }
      for (int i = start; i < timings.length; i++) {
        runningTotal = runningTotal + timings[i];
      }
      return runningTotal / (long)timings.length;
    }

    public static long calculateVariance(Long[] timings, boolean discardFirst) {
      long arithmeticMean = calculateArithmeticMean(timings, discardFirst);
      long runningTotal = 0;
      int start = 0;
      if (discardFirst) {
        start = 1;
      }
      for (int i = start; i < timings.length; i++) {
        runningTotal = (timings[i] - arithmeticMean) * (timings[i] - arithmeticMean);
      }
      return runningTotal / (long)timings.length;
    }

    public static double calculateStandardDeviation(Long[] timings, boolean discardFirst) {
      return Math.sqrt(calculateVariance(timings, discardFirst));
    }

  }

  public static void main(String[] args) {
    String indentation = new String("  ");
    boolean debug = false;
    boolean always = true;
    boolean discardFirst = true;
    int size = 10000;
    int trials = 11;

    Long[] insertionSortTimings = new Long[trials];

    Character[] randomCharacterArray = new Character[size];
    randomCharacterArray = RandomArrayGenerator.generateRandomCharacterArray(size);
    ArrayPrinter.print(randomCharacterArray, indentation, debug);

    System.out.println("InsertionSort Trials: ");
    System.out.print(indentation);
    for (int i = 0; i < trials; i++) {
      long beforeInsertionSort = System.nanoTime();
      InsertionSort.insertionSort(randomCharacterArray);
      long afterInsertionSort = System.nanoTime();
      insertionSortTimings[i] = new Long(afterInsertionSort - beforeInsertionSort);
      System.out.print(".");
    }

    System.out.println();
    ArrayPrinter.print(randomCharacterArray, indentation, debug);
    System.out.println();

    System.out.println("Summary of Timing Results:");
    System.out.println();

    System.out.println("Integer Reversal Provided (ns):");
    ArrayPrinter.print(insertionSortTimings, indentation, always);
    System.out.println(indentation + "Arithmetic Mean (ns): "
        + StatisticsCalculator.calculateArithmeticMean(insertionSortTimings, discardFirst));
    System.out.println(indentation + "Standard Deviation (ns): "
        + StatisticsCalculator.calculateStandardDeviation(insertionSortTimings, discardFirst));
    System.out.println();

  }
}
