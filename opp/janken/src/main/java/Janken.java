
import janken.*;
import janken.hand.*;
import janken.result.*;
import janken.Player.*;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public final class Janken {
  public final static double numRandomDouble() {
    return Math.random() * 3;
  }
  public final static List<Double> listRandomDouble (int numMatch) {
    return  IntStream.range(0, numMatch)
      .mapToObj(i -> Janken.numRandomDouble())
      .collect(Collectors.toList());
  }

  public final static void main (String [] args ) {
    final int numMatch = 3;
    final Judgement judgement = new Judgement(
        Janken.listRandomDouble(numMatch)
      , Janken.listRandomDouble(numMatch)
      , new Player("opponent")
      , new Player("player")
      );
    judgement.judgeMatches()
      .forEach(result -> System.out.println(result));
    System.out.println(
      judgement.judgeWinner()
    );
  }
}

