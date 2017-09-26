
package janken;

public class Result {
  public static class Win extends Result {
    public Win() {}
    public String toString () {
      return "Win";
    }
  }
  public static class Lose extends Result {
    public Lose() {}
    public String toString () {
      return "Lose";
    }
  }
  public static class Draw extends Result {
    public Draw() {}
    public String toString () {
      return "Draw";
    }
  }
  public static class NoGame extends Result {
    public NoGame() {}
    public String toString () {
      return "NoGame";
    }
  }
}

