
package janken.hand;

import janken.hand.Hand;

public class Stone extends Hand {
  public Stone() {}
  public boolean winTo(Hand opponentHand) {
    return opponentHand instanceof Scissors;
  }

}

