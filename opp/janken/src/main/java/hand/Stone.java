
package janken.hand;

import janken.hand.Hand;

public final class Stone extends Hand {
  public boolean winTo(Hand opponentHand) {
    return opponentHand instanceof Scissors;
  }

}

