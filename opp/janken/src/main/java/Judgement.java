
package janken;

import janken.*;
import janken.hand.*;
import janken.result.*;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public final class Judgement {
  private final List<Double> _listRandomDoubleOpponent;
  private final List<Double> _listRandomDoublePlayer;
  private final Player _opponent;
  private final Player _player;
  private final List<Hand> _listOpponentHand;
  private final List<Hand> _listPlayerHand;
  private final int _sizeOpponentHand;
  private final int _sizePlayerHand;
  private final int _numMatch;
  public Judgement (
      List<Double> listRandomDoubleOpponent
    , List<Double> listRandomDoublePlayer
    , Player opponent, Player player
    ) {
    this._listRandomDoubleOpponent = listRandomDoubleOpponent;
    this._listRandomDoublePlayer = listRandomDoublePlayer;
    this._opponent = opponent;
    this._player = player;

    this._listOpponentHand = opponent.showHands(listRandomDoubleOpponent);
    this._listPlayerHand = opponent.showHands(listRandomDoublePlayer);
    this._sizeOpponentHand = listRandomDoubleOpponent.size();
    this._sizePlayerHand = listRandomDoublePlayer.size();
    this._numMatch = _sizeOpponentHand < _sizePlayerHand ? _sizeOpponentHand : _sizePlayerHand;
  }
  private final class Tuple<A, B> {
    private final A _first;
    private final B _second;
    public Tuple(A first, B second) {
      this._first = first;
      this._second = second;
    };
    public final A first() {
      return this._first;
    }
    public final B second() {
      return this._second;
    }
  }
  private final <A,B> Stream<Tuple<A, B>> zip(
      List<A> listA, List<B> listB
    ) {
    final int sizeA = listA.size();
    final int sizeB = listB.size();
    final int size = sizeA < sizeB ? sizeA : sizeB;
    return IntStream.range(0, size)
      .mapToObj(i -> new Tuple<A,B>(listA.get(i), listB.get(i)))
      //.collect(Collectors.toList())
      ;
  }

  public final List<Result> judgeMatches() {
    if (_sizeOpponentHand == _sizePlayerHand) {
      return this.<Hand,Hand>zip(this._listOpponentHand, this._listPlayerHand)
        .map(tuple -> tuple.second().matchTo(tuple.first()))
        .collect(Collectors.toList());
    } else {
      return Arrays.asList(new NoGame());
    }
  }

  public final int countResult(Class classResult) {
    return this.judgeMatches().stream()
      .filter(result -> result.getClass() == classResult)
      .collect(Collectors.toList()).size();
  }
  public final Result judgeWinner() {
    final int countWin = this.countResult(Win.class);
    final int countDraw = this.countResult(Draw.class);
    final int countLose = this.countResult(Lose.class);
    final double numConditionWin = (this._numMatch - countDraw) / 2;
    if (countWin > numConditionWin) {
      return new Win();
    } else if (countWin == countLose) {
      return new Draw();
    } else {
      return new Lose();
    }
  }

}

