
package janken.result;

public abstract class Result {
  public String toString() {
    return this.getClass().getSimpleName();
  }
}

