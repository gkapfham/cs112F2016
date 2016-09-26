package dsaj.arrays;

public class BubbleSort {

  /** Bubble-sort of an array of characters into nondecreasing order */
  public static void bubbleSort(Character[] data) {
    int length = data.length;
    for (int i = 0; i < length; i++) {
      for (int j = 1; j < (length - i); j++) {
        if (data[j - 1] > data[j]) {
          char temporary = data[j - 1];
          data[j - 1] = data[j];
          data[j] = temporary;
        }
      }
    }
  }

  public static void main(String[] args) {
    Character[] characterExamples = {'C', 'E', 'B', 'D', 'A', 'I', 'J', 'L', 'K', 'H', 'G', 'F'};
    System.out.println(java.util.Arrays.toString(characterExamples));
    bubbleSort(characterExamples);
    System.out.println(java.util.Arrays.toString(characterExamples));
  }
}
