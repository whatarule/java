
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.function.Function;


public class PickDifferentNames {
  public static void
  main(String[] args) {
    final List<String> friends =
      Arrays.asList(
          "aaa"
        , "bbb"
        , "ccc"
        , "NNN"
        , "NNN"
        , "BBB"
        );
    final Function<String, Predicate<String>>
    startWithLetter =
      letter -> name -> name.startsWith(letter);
    final long countFriendsStartN =
      friends.stream().filter(startWithLetter.apply("N")).count();
    final long countFriendsStartB =
      friends.stream().filter(startWithLetter.apply("B")).count();
    System.out.println(
      String.format(
          "Found %d names"
        , countFriendsStartB
        )
      );
  }
}


