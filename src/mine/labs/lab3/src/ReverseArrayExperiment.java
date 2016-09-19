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
    int size = 100;

    System.out.println("Timing Random Integer[]\n");
    Integer[] randomIntegerArray = new Integer[size];
    randomIntegerArray = RandomArrayGenerator.generateRandomIntegerArray(size);
    RandomArrayGenerator.ArrayPrinter.print(randomIntegerArray, indentation, debug);

    long beforeIntegerReverse = System.nanoTime();
    ReverseArray.reverse(randomIntegerArray);
    long afterIntegerReverse = System.nanoTime();

    System.out.println();
    RandomArrayGenerator.ArrayPrinter.print(randomIntegerArray, indentation, debug);
    System.out.println();

    System.out.println("\nTiming Random Float[]\n");
    Float[] randomFloatArray = new Float[size];
    randomFloatArray = RandomArrayGenerator.generateRandomFloatArray(size);
    RandomArrayGenerator.ArrayPrinter.print(randomFloatArray, indentation, debug);

    long beforeFloatReverse = System.nanoTime();
    ReverseArray.reverse(randomFloatArray);
    long afterFloatReverse = System.nanoTime();

    System.out.println();
    RandomArrayGenerator.ArrayPrinter.print(randomFloatArray, indentation, debug);
    System.out.println("\n");

    System.out.println("Timing Results:");
    System.out.println("Integer reversal (ns): " + (afterIntegerReverse - beforeIntegerReverse));
    System.out.println("Float reversal (ns): " + (afterFloatReverse - beforeFloatReverse));

  }

}
