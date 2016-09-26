package edu.allegheny.experiment;

import java.util.Arrays;
import java.util.Collections;

import dsaj.arrays.BubbleSort;
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

    Long[] bubbleSortTimings = new Long[trials];
    Long[] insertionSortTimings = new Long[trials];
    Long[] utilSortTimings = new Long[trials];

    Character[] randomCharacterArray = new Character[size];
    randomCharacterArray = RandomArrayGenerator.generateRandomCharacterArray(size);
    System.out.println("InsertionSort Array: ");
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

    randomCharacterArray = new Character[size];
    randomCharacterArray = RandomArrayGenerator.generateRandomCharacterArray(size);
    System.out.println("BubbleSort Array: ");
    ArrayPrinter.print(randomCharacterArray, indentation, debug);

    System.out.println("BubbleSort Trials: ");
    System.out.print(indentation);
    for (int i = 0; i < trials; i++) {
      long beforeBubbleSort = System.nanoTime();
      BubbleSort.bubbleSort(randomCharacterArray);
      long afterBubbleSort = System.nanoTime();
      bubbleSortTimings[i] = new Long(afterBubbleSort - beforeBubbleSort);
      System.out.print(".");
    }

    System.out.println();
    ArrayPrinter.print(randomCharacterArray, indentation, debug);
    System.out.println();

    randomCharacterArray = new Character[size];
    randomCharacterArray = RandomArrayGenerator.generateRandomCharacterArray(size);
    System.out.println("java.util.Arrays.sort Array: ");
    ArrayPrinter.print(randomCharacterArray, indentation, debug);

    System.out.println("java.util.Arrays.sort Trials: ");
    System.out.print(indentation);
    for (int i = 0; i < trials; i++) {
      long beforeUtilSort = System.nanoTime();
      Arrays.sort(randomCharacterArray);
      long afterUtilSort = System.nanoTime();
      utilSortTimings[i] = new Long(afterUtilSort - beforeUtilSort);
      System.out.print(".");
    }

    System.out.println();
    ArrayPrinter.print(randomCharacterArray, indentation, debug);
    System.out.println();

    System.out.println("Summary of Timing Results:");
    System.out.println();

    System.out.println("InsertionSort Timings (ns):");
    ArrayPrinter.print(insertionSortTimings, indentation, always);
    System.out.println(indentation + "Arithmetic Mean (ns): "
        + StatisticsCalculator.calculateArithmeticMean(insertionSortTimings, discardFirst));
    System.out.println(indentation + "Standard Deviation (ns): "
        + StatisticsCalculator.calculateStandardDeviation(insertionSortTimings, discardFirst));
    System.out.println();

    System.out.println("BubbleSort Timings (ns):");
    ArrayPrinter.print(bubbleSortTimings, indentation, always);
    System.out.println(indentation + "Arithmetic Mean (ns): "
        + StatisticsCalculator.calculateArithmeticMean(bubbleSortTimings, discardFirst));
    System.out.println(indentation + "Standard Deviation (ns): "
        + StatisticsCalculator.calculateStandardDeviation(bubbleSortTimings, discardFirst));
    System.out.println();

    System.out.println("java.util.Arrays.sort Timings (ns):");
    ArrayPrinter.print(utilSortTimings, indentation, always);
    System.out.println(indentation + "Arithmetic Mean (ns): "
        + StatisticsCalculator.calculateArithmeticMean(utilSortTimings, discardFirst));
    System.out.println(indentation + "Standard Deviation (ns): "
        + StatisticsCalculator.calculateStandardDeviation(utilSortTimings, discardFirst));
    System.out.println();

  }
}
