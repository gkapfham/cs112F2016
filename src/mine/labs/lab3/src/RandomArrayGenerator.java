import java.util.Random;

public class RandomArrayGenerator {

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
  boolean debug = true;
  Integer[] example = RandomArrayGenerator.generateRandomIntegerArray(10);
  ArrayPrinter.print(example, indentation, debug);
}

}
