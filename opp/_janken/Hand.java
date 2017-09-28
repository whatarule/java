
package janken;

import janken.Result.*;

import java.util.List;
import java.util.Arrays;

public class Hand {
//abstract String toString();
//abstract boolean equals();
  public static class Stone extends Hand {
    public Stone() {}
    public String toString () {
      return "Stone";
    }
  }
  public static class Scissors extends Hand {
    public Scissors() {}
    public String toString () {
      return "Scissors";
    }
  }
  public static class Paper extends Hand {
    public Paper() {}
    public String toString () {
      return "Paper";
    }
  }

  public boolean isStone() {
    return this instanceof Stone;
  }
  public boolean isScissors() {
    return this instanceof Scissors;
  }
  public boolean isPaper() {
    return this instanceof Paper;
  }

  private boolean _winTo(Hand opponentHand) {
    final List<Boolean> listCondition = Arrays.asList (
        this.isStone() && opponentHand.isScissors()
      , this.isScissors() && opponentHand.isPaper()
      , this.isPaper() && opponentHand.isStone()
      );
    return listCondition.stream().reduce(false, (x,y) -> x || y);
  }
  private boolean _drawTo(Hand opponentHand) {
    final List<Boolean> listCondition = Arrays.asList (
        this.isStone() && opponentHand.isStone()
      , this.isScissors() && opponentHand.isScissors()
      , this.isPaper() && opponentHand.isPaper()
      );
    return listCondition.stream().reduce(false, (x,y) -> x || y);
  }

  public Result matchTo(Hand opponentHand) {
    if (this._winTo(opponentHand)) {
      return new Win();
    } else if (this._drawTo(opponentHand)) {
      return new Draw();
    } else {
      return new Lose();
    }
  }

}

