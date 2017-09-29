
package janken.hand;

import janken.hand.*;
import janken.result.*;

public abstract class Hand {
  public final String toString() {
    return this.getClass().getSimpleName();
  }

  abstract boolean winTo(Hand opponentHand);
  public boolean isStone() {
    return this instanceof Stone;
  }
  public final boolean isScissors() {
    return this instanceof Scissors;
  }
  public final boolean isPaper() {
    return this instanceof Paper;
  }
  private final boolean equals(Hand opponentHand) {
    return opponentHand.getClass() == this.getClass();
  }

  public final Result matchTo(Hand opponentHand) {
    if (this.winTo(opponentHand)) {
      return new Win();
    } else if (this.equals(opponentHand)) {
      return new Draw();
    } else {
      return new Lose();
    }
  }

}

