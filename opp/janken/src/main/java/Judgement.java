
package janken;

import janken.*;
import janken.hand.*;
import janken.result.*;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Judgement {
  private final int _numMatch;
  private final List<Hand> _listOpponentHand;
  private final List<Hand> _listPlayerHand;
  public Judgement (
    int numMatch, List<Hand> listOpponentHand, List<Hand> listPlayerHand) {
    this._numMatch = numMatch;
    this._listOpponentHand = listOpponentHand;
    this._listPlayerHand = listPlayerHand;
  }
  private class Pair<A, B> {
    private final Hand _opponentHand;
    private final Hand _playerHand;
    public Pair(Hand opponentHand, Hand playerHand) {
      this._opponentHand = opponentHand;
      this._playerHand = playerHand;
    };
    public Hand getOpponentHand() {
      return this._opponentHand;
    }
    public Hand getPlayerHand() {
      return this._playerHand;
    }
  }
  private Stream<Pair<Hand, Hand>> listPairHand() {
    return IntStream.range(0, this._numMatch)
      .mapToObj(i -> new Pair<Hand,Hand>(
          this._listOpponentHand.get(i)
        , this._listPlayerHand.get(i)
        ))
      //.collect(Collectors.toList())
      ;
  }

  public List<Result> judgeMatches() {
    final int numMatchOpponent = this._listOpponentHand.size();
    final int numMatchPlayer = this._listPlayerHand.size();
    if (numMatchOpponent == numMatchPlayer) {
      return this.listPairHand()
        .map(pair -> pair._playerHand.matchTo(pair._opponentHand))
        .collect(Collectors.toList());
    } else {
      return Arrays.asList(new NoGame());
    }
  }

  public int countResult(Class classResult) {
    return this.judgeMatches().stream()
      .filter(result -> result.getClass() == classResult)
      .collect(Collectors.toList()).size();
  }
  public Result judgeWinner() {
    final double numConditionWin =
      (this._numMatch - this.countResult(Draw.class)) / 2;
    final int countWin = this.countResult(Win.class);
    final int countDraw = this.countResult(Draw.class);
    final int countLose = this.countResult(Lose.class);
    if (countWin > numConditionWin) {
      return new Win();
    } else if (countWin == countLose) {
      return new Draw();
    } else {
      return new Lose();
    }
  }

}

