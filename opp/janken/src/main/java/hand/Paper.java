
package janken.hand;

import janken.hand.Hand;

public class Paper extends Hand {
  public Paper() {}
  public boolean winTo(Hand opponentHand) {
    return opponentHand instanceof Stone;
  }

}

