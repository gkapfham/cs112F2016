public class ArrayPrinter {

  public static <T> void print(T[] data, String indent, boolean debug) {
    if(debug) {
      for(int i = 0; i < data.length; i++) {
        System.out.println(indent + data[i]);
      }
    }
    else {
      System.out.print(indent + " ... elided array ...");
    }
  }

}
