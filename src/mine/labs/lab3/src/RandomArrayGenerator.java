import java.util.Random;

public class RandomArrayGenerator {

public static class ArrayPrinter {

  public static <T> void print(T[] data, String indent) {
    for(int i = 0; i < data.length; i++) {
      System.out.println(indent + data[i]);
    }
  }

}

private static Random generator;

static {
  generator = new Random();
}

public static Integer[] generateRandomIntegerArray(int size) {
  Integer[] data = new Integer[size];
  for(int i = 0; i < size; i++) {
    data[i] = new Integer(generator.nextInt());
  }
  return data;
}

public static Float[] generateRandomFloatArray(int size) {
  Float[] data = new Float[size];
  for(int i = 0; i < size; i++) {
    data[i] = new Float(generator.nextInt());
  }
  return data;
}

public static void main(String[] args) {
  String indentation = new String("  ");
  Integer[] example = RandomArrayGenerator.generateRandomIntegerArray(10);
  ArrayPrinter.print(example, indentation);
}

}
