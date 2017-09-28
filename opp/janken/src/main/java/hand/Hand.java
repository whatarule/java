
package janken.hand;

import janken.hand.*;
import janken.result.*;

public abstract class Hand {
  public String toString() {
    return this.getClass().getSimpleName();
  }

  abstract boolean winTo(Hand opponentHand);
  public boolean isStone() {
    return this instanceof Stone;
  }
  public boolean isScissors() {
    return this instanceof Scissors;
  }
  public boolean isPaper() {
    return this instanceof Paper;
  }
  private boolean equals(Hand opponentHand) {
    return opponentHand.getClass() == this.getClass();
  }

  public Result matchTo(Hand opponentHand) {
    if (this.winTo(opponentHand)) {
      return new Win();
    } else if (this.equals(opponentHand)) {
      return new Draw();
    } else {
      return new Lose();
    }
  }

}

