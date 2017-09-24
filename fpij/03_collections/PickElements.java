
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PickElements {
  public static void main(String[] args) {
    final List<String> friends =
      Arrays.asList(
          "aaa"
        , "bbb"
        , "ccc"
        , "NNN"
        , "NNN"
        );
    final List<String> startsWithN =
      friends.stream()
        .filter(name -> name.startsWith("N"))
        .collect(Collectors.toList())
        ;
    System.out.println(
      String.format(
          "Found %d names"
        , startsWithN.size()
        )
      );
  }
}


