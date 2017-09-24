
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.Optional;


public class PickALongest {
  public static void
  main(String[] args) {
    final List<String>
    friends = Arrays.asList(
        "aaa"
      , "bbb"
      , "ccc"
      , "NNN"
      , "NNN"
      , "BBB"
      , "aaaa"
      );

    final Optional<String>
    aLongName = friends.stream()
      .reduce((name1, name2) ->
        name1.length() >= name2.length()
          ? name1
          : name2
          )
      ;
    final String
    steveOrLonger = friends.stream()
      .reduce("Steve", (name1, name2) ->
        name1.length() >= name2.length()
          ? name1
          : name2
        )
      ;
    aLongName.ifPresent(name ->
      System.out.println(String.format(
        "A longest name: %s"
      , steveOrLonger
      ))
    );
    System.out.println(friends.stream()
      .map(String::toUpperCase)
      .collect(Collectors.joining(","))
      );

    final Function<String, Predicate<String>>
    startWithLetter =
      letter -> name -> name.startsWith(letter);
  }
}


