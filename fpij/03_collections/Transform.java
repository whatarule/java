
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Transform {
  public static void main(String[] args) {
    final List<String> friends =
      Arrays.asList(
          "aaa"
        , "bbb"
        , "ccc"
        );
    final List<String> uppercaseNames = new ArrayList<String>();
    friends.stream()
      .map(String::toUpperCase)
      .forEach(name -> System.out.print(name + " "));
    System.out.println();
    friends.stream()
      .map(name -> name.length())
      .forEach(length -> System.out.print(length + " "));
    System.out.println();
  }
}


