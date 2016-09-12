import java.io.IOException;
import java.util.Scanner;
import java.util.Iterator;

public class SentencesReverser {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Sentences sentences = new Sentences();

        sentences.readSentencesFromFile();
        sentences.printSentences();
        sentences.reverseSentences();
        sentences.printSentences();
    }

}
