
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

  public List<Result> judge() {
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

}

