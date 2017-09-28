
import janken.*;
import janken.Hand.*;
import janken.Player.*;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.DoubleSupplier;

public class Janken {
  public DoubleSupplier
  numRandomDouble = () -> Math.random() * 3;
  public IntFunction<List<Double>>
  listRandomDouble = numMatch ->
    IntStream.range(0, numMatch)
      .mapToObj(i -> this.numRandomDouble.getAsDouble())
      .collect(Collectors.toList());

  public static void main (String [] args ) {
    final Janken janken = new Janken();
    final int numMatch = 3;
    final Player player = new Player("player");
    final Player opponent = new Player("opponent");

    new Judgement(numMatch
      , opponent.showHands(janken.listRandomDouble.apply(numMatch))
      , player.showHands(janken.listRandomDouble.apply(numMatch))
      ).judge()
      .forEach(result -> System.out.println(result));
  }
}

