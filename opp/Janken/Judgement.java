
package janken;

import janken.*;
import janken.Result.*;

public class Judgement {
  public static class HandPair {
    private Hand _handPlayer;
    private Hand _handOpponent;
    public HandPair (Hand handPlayer, Hand handOpponent) {
      _handPlayer = handPlayer;
      _handOpponent = handOpponent;
    }
    public String toString () {
      return (this._handPlayer.toString() + "," + this._handOpponent.toString());
    }
  }
  public Result judge (
    double numRandomOpponent, Player opponent
  , double numRandomPlayer, Player player) {
    Hand handPlayer = player.showHand(numRandomPlayer);
    Hand handOpponent = opponent.showHand(numRandomOpponent);
    HandPair pairHand = new HandPair(handPlayer, handOpponent);
  //System.out.println(
  ////pairHand.toString()
  //  handPlayer.isStone()
  //);
  //return new Lose();
  //if (handPlayer.toString() == handOpponent.toString()) {
  //  return new Draw();
  //} else if (pairHand.toString() == "Stone,Scissors") {
  //  return new Win();
  //} else if (pairHand.toString() == "Scissors,Paper") {
  //  return new Win();
  //} else if (pairHand.toString() == "Paper,Stone") {
  //  return new Win();
  //} else {
  //  return new Lose();
  //}
    if (handPlayer.toString() == handOpponent.toString()) {
      return new Draw();
    } else if (handPlayer.isStone() && handOpponent.isScissors()) {
      return new Win();
    } else if (handPlayer.isScissors() && handOpponent.isPaper()) {
      return new Win();
    } else if (handPlayer.isPaper() && handOpponent.isStone()) {
      return new Win();
    } else {
      return new Lose();
    }
  }
}

