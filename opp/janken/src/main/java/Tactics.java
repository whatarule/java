
package janken;

import janken.hand.*;

import java.util.function.Function;

public interface Tactics {
  public Function readTactics();

  public class RandomTactics implements Tactics {
    public RandomTactics() {}
    public Function<Double, Hand> readTactics () {
      return numRandom -> {
        if (numRandom < 1 ) {
          return new Stone();
        } else if (numRandom < 2) {
          return new Scissors();
        } else {
          return new Paper();
    }};}
  }

}

