public class ReverseArray {

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
    int size = 100;

    System.out.println("Random Integer[]\n");
    Integer[] randomIntegerArray = new Integer[size];
    randomIntegerArray = RandomArrayGenerator.generateRandomIntegerArray(10);
    RandomArrayGenerator.ArrayPrinter.print(randomIntegerArray, indentation);
    ReverseArray.reverse(randomIntegerArray);
    RandomArrayGenerator.ArrayPrinter.print(randomIntegerArray, indentation);

    System.out.println("Random Float[]\n");
    Float[] randomFloatArray = new Float[size];
    randomFloatArray = RandomArrayGenerator.generateRandomFloatArray(10);
    RandomArrayGenerator.ArrayPrinter.print(randomFloatArray, indentation);
    ReverseArray.reverse(randomFloatArray);
    RandomArrayGenerator.ArrayPrinter.print(randomFloatArray, indentation);

  }

}
