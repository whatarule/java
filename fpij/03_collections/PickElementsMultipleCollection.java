
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.function.Predicate;


public class PickElementsMultipleCollection {
  public static void main(String[] args) {
    final List<String> friends =
      Arrays.asList(
          "aaa"
        , "bbb"
        , "ccc"
        , "NNN"
        , "NNN"
        );
    final Predicate<String> startsWithN =
      name -> name.startsWith("N");
    final long countFriendsStartN =
      friends.stream().filter(startsWithN).count();
    System.out.println(
      String.format(
          "Found %d names"
        , countFriendsStartN
        )
      );
  }
}


