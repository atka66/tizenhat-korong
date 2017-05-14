package hu.unideb.inf.mestint.tizenhatkorong;

import hu.unideb.inf.mestint.tizenhatkorong.statespace.PuckState;
import hu.unideb.inf.mestint.tizenhatkorong.statespace.State;

public class Main {
  public static void main(String[] args) {
    State startState = new State(new PuckState[][]{
        {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED},
        {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED},
        {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED},
        {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED}
    });
    State[] goalStates = new State[] {
        new State(new PuckState[][]{
            {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED},
            {PuckState.RED, PuckState.BLUE, PuckState.BLUE, PuckState.RED},
            {PuckState.RED, PuckState.BLUE, PuckState.BLUE, PuckState.RED},
            {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED}
        })
    };
  }
}
