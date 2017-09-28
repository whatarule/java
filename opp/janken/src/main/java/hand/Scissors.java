
package janken.hand;

import janken.hand.Hand;

public class Scissors extends Hand {
  public Scissors() {}
  public boolean winTo(Hand opponentHand) {
    return opponentHand instanceof Paper;
  }

}

