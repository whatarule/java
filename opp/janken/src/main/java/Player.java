
package janken;

import janken.*;
import janken.hand.*;
import janken.Tactics.*;

import java.util.List;
import java.util.stream.Collectors;

public final class Player {
  private final String _name;
  public Player (String name) {
    this._name = name;
  }

  public final Hand showHand (double numRandom) {
    return new RandomTactics().readTactics().apply(numRandom);
  }
  public final List<Hand> showHands (List<Double> listDouble) {
    return listDouble.stream()
      .map(numDouble -> this.showHand(numDouble))
      .collect(Collectors.toList());
  }
}

