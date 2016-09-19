public class ReverseArrayExperiment {

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
    int size = 100;
    int trials = 10;

    Long[] integerTimings = new Long[trials];
    Long[] floatTimings = new Long[trials];

    System.out.println("Timing Random Integer[]\n");
    Integer[] randomIntegerArray = new Integer[size];
    randomIntegerArray = RandomArrayGenerator.generateRandomIntegerArray(size);
    ArrayPrinter.print(randomIntegerArray, indentation, debug);

    for(int i = 0; i < trials; i++) {
      long beforeIntegerReverse = System.nanoTime();
      ReverseArray.reverse(randomIntegerArray);
      long afterIntegerReverse = System.nanoTime();
      integerTimings[i] = new Long(afterIntegerReverse - beforeIntegerReverse);
    }

    System.out.println();
    ArrayPrinter.print(randomIntegerArray, indentation, debug);
    System.out.println();

    System.out.println("\nTiming Random Float[]\n");
    Float[] randomFloatArray = new Float[size];
    randomFloatArray = RandomArrayGenerator.generateRandomFloatArray(size);
    ArrayPrinter.print(randomFloatArray, indentation, debug);

    for(int i = 0; i < trials; i++) {
      long beforeFloatReverse = System.nanoTime();
      ReverseArray.reverse(randomFloatArray);
      long afterFloatReverse = System.nanoTime();
      floatTimings[i] = afterFloatReverse - beforeFloatReverse;
    }

    System.out.println();
    ArrayPrinter.print(randomFloatArray, indentation, debug);
    System.out.println("\n");

    System.out.println("Timing Results:");
    System.out.println();
    System.out.println("Integer reversal (ns):");
    ArrayPrinter.print(integerTimings, indentation, always);
    System.out.println();
    System.out.println("Float reversal (ns): ");
    ArrayPrinter.print(floatTimings, indentation, always);

  }

}
