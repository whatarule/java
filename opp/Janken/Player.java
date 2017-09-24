
package janken;

import janken.*;
import janken.Hand.*;

public class Player {
  private String _name;
  public Player (String name) {
    this._name = name;
  }
  private int _countWin = 0;


  public Hand showHand(double numRandom) {
    if (numRandom < 1 ) {
      return new Stone();
    } else if (numRandom < 2) {
      return new Scissors();
    } else {
      return new Paper();
    }
  }

}

