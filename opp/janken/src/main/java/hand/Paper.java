
package janken.hand;

import janken.hand.Hand;

public final class Paper extends Hand {
  public boolean winTo(Hand opponentHand) {
    return opponentHand instanceof Stone;
  }

}

