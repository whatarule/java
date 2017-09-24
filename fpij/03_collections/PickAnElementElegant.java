
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.Optional;


public class PickAnElementElegant {
  public static void
  pickName(final List<String> names, final String startingLetter) {
    final Optional<String> foundName =
      names.stream()
        .filter(name -> name.startsWith(startingLetter))
        .findFirst()
        ;
    System.out.println(String.format(
        "A name starting with %s: %s"
      , startingLetter
      , foundName.orElse("No name found")
      ));
    foundName.ifPresent(name ->
      System.out.println(
        "Hello " + name
      ));
  }
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
    pickName(friends, "N");
    pickName(friends, "Z");
  }
}


