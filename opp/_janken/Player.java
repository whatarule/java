
package janken;

import janken.*;
import janken.Hand.*;

import java.util.List;
import java.util.stream.Collectors;

public class Player {
  private String _name;
  public Player (String name) {
    this._name = name;
  }

  public Hand showHand (double numRandom) {
    if (numRandom < 1 ) {
      return new Stone();
    } else if (numRandom < 2) {
      return new Scissors();
    } else {
      return new Paper();
    }
  }
  public List<Hand> showHands (List<Double> listDouble) {
    return listDouble.stream()
      .map(numDouble -> this.showHand(numDouble))
      .collect(Collectors.toList());
  }
}

