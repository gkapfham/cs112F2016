import java.io.IOException;
import java.util.Scanner;
import java.util.Iterator;

public class SentencesReverser {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    Sentences sentences = new Sentences();

    long beforeRead = System.currentTimeMillis();
    sentences.readSentencesFromFile();
    long afterRead = System.currentTimeMillis();
    System.out.println("Read time: " + (afterRead - beforeRead));

    sentences.printSentences();
    sentences.reverseSentences();
    sentences.printSentences();
  }

}
