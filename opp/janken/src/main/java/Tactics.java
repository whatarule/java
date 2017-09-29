
package janken;

import janken.hand.*;

import java.util.function.*;

public interface Tactics {
  public Function readTactics();

  public final class RandomTactics implements Tactics {
    public final Function<Double, Hand> readTactics () {
      return numRandom -> {
        if (numRandom < 1 ) {
          return new Stone();
        } else if (numRandom < 2) {
          return new Scissors();
        } else {
          return new Paper();
        }};
    }
  }

}

