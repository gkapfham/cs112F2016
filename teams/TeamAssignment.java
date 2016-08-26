import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class TeamAssignment 
{
  static final int TEAM_SIZE = 3;

  static final Map<Integer, String> STUDENTS = new HashMap<Integer, String>() {{
    put(1, "Becker");
    put(2, "Bracken");
    put(3, "Bryan");
    put(4, "Cabo");
    put(5, "Camara");
    put(6, "Dilla");
    put(7, "Dunaway-Barlow");
    put(8, "Guillaume");
    put(9, "Hamilton");
    put(10, "Hudac");
    put(11, "Jackelen");
    put(12, "Kroon");
    put(13, "Miller, Gary");
    put(14, "Miller, Izaak");
    put(15, "Paul");
    put(16, "Rajeh");
    put(17, "Smith");
    put(18, "Torrance");
  }};

  public static void main(String[] args) {

    ArrayList<Integer> students = new ArrayList<Integer>();

    // populate the arraylist with the integers
    for(int i = 1; i <= 18; i++) {
      Integer I = new Integer(i);
      students.add(I);
    }

    // pick the ordering for the talks today
    ArrayList<Integer> studentsTodaysOrdering = (ArrayList<Integer>)students.clone();
    Collections.shuffle(studentsTodaysOrdering);
    System.out.println("Today's random ordering of the students: "); // + studentsTodaysOrdering);
    System.out.println();

    for(Integer studentToday : studentsTodaysOrdering) {

      System.out.println(STUDENTS.get(studentToday));

    }

    System.out.println();

    System.out.println("These are the teams for the final project assignment:");

    int i = 0;
    int team = 1;
    for(Integer studentToday : studentsTodaysOrdering) {

      if(i % TEAM_SIZE == 0) {

        System.out.println();
        System.out.println("Team " + team);
        team++;

      }

      System.out.println(STUDENTS.get(studentToday));

      i++;

    }

  }

}
