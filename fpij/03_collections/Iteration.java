
import java.util.List;
import java.util.Arrays;

public class Iteration {
  public static void main(String[] args) {
    final List<String> friends =
      Arrays.asList(
          "aaa"
        , "bbb"
        , "ccc"
        );
  //friends.forEach(name -> System.out.println(name));
    friends.forEach(System.out::println);
  }
}


