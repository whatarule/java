
package janken;

public class Hand {
  public static class Stone extends Hand {
    public Stone() {}
    public String toString () {
      return "Stone";
    }
  }
  public static class Scissors extends Hand {
    public Scissors() {}
    public String toString () {
      return "Scissors";
    }
  }
  public static class Paper extends Hand {
    public Paper() {}
    public String toString () {
      return "Paper";
    }
  }

  public boolean isStone() {
    return this instanceof Stone;
  }
  public boolean isScissors() {
    return this instanceof Scissors;
  }
  public boolean isPaper() {
    return this instanceof Paper;
  }

}

