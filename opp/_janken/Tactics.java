
package janken;

import janken.Hand.*;

public interface Tactics {
  public Hand readTactics(double numRandom);

  public class RandomTactics implements Tactics {
    public Hand readTactics (double numRandom) {
      if (numRandom < 1 ) {
        return new Stone();
      } else if (numRandom < 2) {
        return new Scissors();
      } else {
        return new Paper();
      }
    }
  }

}

