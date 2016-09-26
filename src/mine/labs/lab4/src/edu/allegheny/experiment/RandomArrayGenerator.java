package edu.allegheny.experiment;

import java.util.Random;

public class RandomArrayGenerator {

  private static Random generator;
  private static final int ALPHABET_SIZE = 26;
  private static final char LETTER_A = 'a';

  static {
    generator = new Random();
  }

  public static Character[] generateRandomCharacterArray(int size) {
    Character[] data = new Character[size];
    for (int i = 0; i < size; i++) {
      data[i] = new Character((char)(generator.nextInt(ALPHABET_SIZE) + LETTER_A));
    }
    return data;
  }

  public static Integer[] generateRandomIntegerArray(int size) {
    Integer[] data = new Integer[size];
    for (int i = 0; i < size; i++) {
      data[i] = new Integer(generator.nextInt());
    }
    return data;
  }

  public static Float[] generateRandomFloatArray(int size) {
    Float[] data = new Float[size];
    for (int i = 0; i < size; i++) {
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
