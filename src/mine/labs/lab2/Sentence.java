public class Sentence {

  private int id;
  private static int nextId = 0;
  private String sentence;

  public Sentence(String sentence) {
    id = nextId;
    nextId++;
    this.sentence = sentence;
  }

  public int getId() {
    return id;
  }

  public String getSentence() {
    return sentence;
  }

  public String toString() {
    return new String("(" + id + ", " + sentence + ")");
  }
}
