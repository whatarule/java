
package janken.hand;

import janken.hand.Hand;

public final class Scissors extends Hand {
  public boolean winTo(Hand opponentHand) {
    return opponentHand instanceof Paper;
  }

}

