
package janken;

import janken.*;
import janken.Result.*;
import janken.Hand.*;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Judgement {
  private int _numMatch;
  private List<Hand> _listOpponentHand;
  private List<Hand> _listPlayerHand;
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
      .mapToObj(i -> new Pair<Hand,Hand>(this._listOpponentHand.get(i), this._listPlayerHand.get(i)))
      //.collect(Collectors.toList())
      ;
  }

  private Result _judge(
    Hand opponentHand, Hand playerHand) {
    if (playerHand.toString() == opponentHand.toString()) {
      return new Draw();
    } else if (playerHand.isStone() && opponentHand.isScissors()) {
      return new Win();
    } else if (playerHand.isScissors() && opponentHand.isPaper()) {
      return new Win();
    } else if (playerHand.isPaper() && opponentHand.isStone()) {
      return new Win();
    } else {
      return new Lose();
    }
  }
  public List<Result> judge() {
    int numMatchOpponent = this._listOpponentHand.size();
    int numMatchPlayer = this._listPlayerHand.size();
    if (numMatchOpponent == numMatchPlayer) {
      return this.listPairHand()
        .map(pair -> this._judge(pair._opponentHand, pair._playerHand))
        .collect(Collectors.toList());
    } else {
      return Arrays.asList(new NoGame());
    }
  }
}

