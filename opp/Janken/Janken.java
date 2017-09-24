
import janken.*;
import janken.Hand.*;
import janken.Player.*;

public class Janken {
  public static void main (String [] args ) {
    System.out.println(
      new Stone().toString()
    );
    System.out.println(
      new Stone() instanceof Stone
    );

    double numRandom = Math.random() * 3;
    System.out.println(
      new Player("aaa").showHand(numRandom)
    );

    double numRandomPlayer = Math.random() * 3;
    double numRandomOpponent = Math.random() * 3;
    System.out.println(
      new Judgement().judge(
        numRandomOpponent, new Player("opponent")
      , numRandomPlayer, new Player("player")
      )
      //.toString();
    );

  }
}

