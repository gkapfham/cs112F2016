import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Sentences {

  private Sentence[] sentences;
  private int currentSentence;
  private static final String SENTENCESFILE = "sentences.txt";
  private static final int NUMBER_OF_SENTENCES = 10;

  public Sentences() {
    sentences = new Sentence[NUMBER_OF_SENTENCES];
    currentSentence = 0;
  }

  public void addSentence(Sentence sentence) {
    sentences[currentSentence] = sentence;
    currentSentence = (currentSentence + 1) % NUMBER_OF_SENTENCES;
  }

  public void readSentencesFromFile() throws IOException {
    Scanner fileScanner = new Scanner(new File(SENTENCESFILE));
    while(fileScanner.hasNext()) {
      String sentenceString = fileScanner.nextLine();
      Sentence sentence = new Sentence(sentenceString);
      this.addSentence(sentence);
    }
  }

  public void printSentences() {
    for(int i = 0; i < sentences.length; i++) {
      System.out.println(((Sentence)sentences[i]).getSentence());
    }
  }

  public void reverseSentences() {

  }

}
