import java.util.Arrays;
import java.util.Collections;

public class ReverseArrayExperiment {

private static class StatisticsCalculator {

  public static long calculateArithmeticMean(Long[] timings) {
    long runningTotal = 0;
    for(int i = 0; i < timings.length; i++) {
      runningTotal = runningTotal + timings[i];
    }
    return runningTotal / (long)timings.length;
  }

  public static long calculateVariance(Long[] timings) {
    long arithmeticMean = calculateArithmeticMean(timings);
    long runningTotal = 0;
    for(int i = 0; i < timings.length; i++) {
      runningTotal = (timings[i] - arithmeticMean) * (timings[i] - arithmeticMean);
    }
    return runningTotal / (long)timings.length;
  }

  public static double calculateStandardDeviation(Long[] timings) {
    return Math.sqrt(calculateVariance(timings));
  }

}

  public static <T> void reverse(T[] data) {
    int low = 0, high = data.length - 1;
    while (low < high) {                   // swap data[low] and data[high]
      T temp = data[low];
      data[low++] = data[high];            // post-increment of low
      data[high--] = temp;                 // post-decrement of high
    }
  }

  public static void main(String[] args) {
    String indentation = new String("  ");
    boolean debug = false;
    boolean always = true;
    int size = 1000;
    int trials = 10;

    Long[] integerTimings = new Long[trials];
    Long[] floatTimings = new Long[trials];
    Long[] integerTimingsCollections = new Long[trials];
    Long[] floatTimingsCollections = new Long[trials];

    System.out.println("Timing Random Integer[]\n");
    Integer[] randomIntegerArray = new Integer[size];
    randomIntegerArray = RandomArrayGenerator.generateRandomIntegerArray(size);
    ArrayPrinter.print(randomIntegerArray, indentation, debug);

    System.out.println("Provided Trials: ");
    System.out.print(indentation);
    for(int i = 0; i < trials; i++) {
      long beforeIntegerReverse = System.nanoTime();
      ReverseArrayExperiment.reverse(randomIntegerArray);
      long afterIntegerReverse = System.nanoTime();
      integerTimings[i] = new Long(afterIntegerReverse - beforeIntegerReverse);
      System.out.print(".");
    }

    System.out.println("\nCollections Trials: ");
    System.out.print(indentation);
    for(int i = 0; i < trials; i++) {
      long beforeIntegerReverse = System.nanoTime();
      Collections.reverse(Arrays.asList(randomIntegerArray));
      long afterIntegerReverse = System.nanoTime();
      integerTimingsCollections[i] = new Long(afterIntegerReverse - beforeIntegerReverse);
      System.out.print(".");
    }

    System.out.println();
    ArrayPrinter.print(randomIntegerArray, indentation, debug);
    System.out.println();

    System.out.println("Timing Random Float[]\n");
    Float[] randomFloatArray = new Float[size];
    randomFloatArray = RandomArrayGenerator.generateRandomFloatArray(size);
    ArrayPrinter.print(randomFloatArray, indentation, debug);

    System.out.println("Provided Trials: ");
    System.out.print(indentation);
    for(int i = 0; i < trials; i++) {
      long beforeFloatReverse = System.nanoTime();
      ReverseArrayExperiment.reverse(randomFloatArray);
      long afterFloatReverse = System.nanoTime();
      floatTimings[i] = afterFloatReverse - beforeFloatReverse;
      System.out.print(".");
    }

    System.out.println("\nCollections Trials: ");
    System.out.print(indentation);
    for(int i = 0; i < trials; i++) {
      long beforeFloatReverse = System.nanoTime();
      Collections.reverse(Arrays.asList(randomFloatArray));
      long afterFloatReverse = System.nanoTime();
      floatTimingsCollections[i] = new Long(afterFloatReverse - beforeFloatReverse);
      System.out.print(".");
    }

    System.out.println();
    ArrayPrinter.print(randomFloatArray, indentation, debug);
    System.out.println();

    System.out.println("Summary of Timing Results:");
    System.out.println();

    System.out.println("Integer Reversal Provided (ns):");
    ArrayPrinter.print(integerTimings, indentation, always);
    System.out.println(indentation + "Arithmetic Mean (ns): " + StatisticsCalculator.calculateArithmeticMean(integerTimings));
    System.out.println(indentation + "Standard Deviation (ns): " + StatisticsCalculator.calculateStandardDeviation(integerTimings));
    System.out.println();

    System.out.println("Integer Reversal Collections (ns):");
    ArrayPrinter.print(integerTimingsCollections, indentation, always);
    System.out.println(indentation + "Arithmetic Mean (ns): " + StatisticsCalculator.calculateArithmeticMean(integerTimingsCollections));
    System.out.println();

    System.out.println("Float Reversal Provided (ns): ");
    ArrayPrinter.print(floatTimings, indentation, always);
    System.out.println(indentation + "Arithmetic Mean (ns): " + StatisticsCalculator.calculateArithmeticMean(floatTimings));
    System.out.println();

    System.out.println("Float Reversal Collections (ns): ");
    ArrayPrinter.print(floatTimingsCollections, indentation, always);
    System.out.println(indentation + "Arithmetic Mean (ns): " + StatisticsCalculator.calculateArithmeticMean(floatTimingsCollections));

  }

}
