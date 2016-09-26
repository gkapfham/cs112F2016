package edu.allegheny.experiment;

import java.util.Arrays;
import java.util.Collections;

import dsaj.arrays.InsertionSort;

public class SortArrayExperiment {

  private static class StatisticsCalculator {

    public static long calculateArithmeticMean(Long[] timings) {
      long runningTotal = 0;
      for (int i = 0; i < timings.length; i++) {
        runningTotal = runningTotal + timings[i];
      }
      return runningTotal / (long)timings.length;
    }

    public static long calculateVariance(Long[] timings) {
      long arithmeticMean = calculateArithmeticMean(timings);
      long runningTotal = 0;
      for (int i = 0; i < timings.length; i++) {
        runningTotal = (timings[i] - arithmeticMean) * (timings[i] - arithmeticMean);
      }
      return runningTotal / (long)timings.length;
    }

    public static double calculateStandardDeviation(Long[] timings) {
      return Math.sqrt(calculateVariance(timings));
    }

  }

  public static void main(String[] args) {
    String indentation = new String("  ");
    boolean debug = true;
    boolean always = true;
    int size = 10;
    int trials = 1;

    Long[] integerTimings = new Long[trials];
    Long[] floatTimings = new Long[trials];
    Long[] integerTimingsCollections = new Long[trials];
    Long[] floatTimingsCollections = new Long[trials];

    Character[] randomCharacterArray = new Character[size];
    randomCharacterArray = RandomArrayGenerator.generateRandomCharacterArray(size);
    ArrayPrinter.print(randomCharacterArray, indentation, debug);

    System.out.println("InsertionSort Trials: ");
    System.out.print(indentation);
    for (int i = 0; i < trials; i++) {
      long beforeIntegerReverse = System.nanoTime();
      InsertionSort.insertionSort(randomCharacterArray);
      long afterIntegerReverse = System.nanoTime();
      integerTimings[i] = new Long(afterIntegerReverse - beforeIntegerReverse);
      System.out.print(".");
    }

    System.out.println();
    ArrayPrinter.print(randomCharacterArray, indentation, debug);
    System.out.println();

    System.out.println("Summary of Timing Results:");
    System.out.println();

    System.out.println("Integer Reversal Provided (ns):");
    ArrayPrinter.print(integerTimings, indentation, always);
    System.out.println(indentation + "Arithmetic Mean (ns): " + StatisticsCalculator.calculateArithmeticMean(integerTimings));
    System.out.println(indentation + "Standard Deviation (ns): " + StatisticsCalculator.calculateStandardDeviation(integerTimings));
    System.out.println();

  }
}
