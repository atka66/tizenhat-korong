package hu.unideb.inf.mestint.sixteenpuck.statespace.operator;

import hu.unideb.inf.mestint.sixteenpuck.statespace.PuckState;
import hu.unideb.inf.mestint.sixteenpuck.statespace.State;

public class RowOperator implements Operator {
  private final int row;

  public RowOperator(int row) {
    this.row = row;
  }

  @Override
  public State apply(State state) {
    PuckState[][] pucks = state.getPucks();
    PuckState[][] tempPucks = new PuckState[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (i == row && pucks[i][3 - j] == PuckState.RED) {
          tempPucks[i][j] = PuckState.BLUE;
        } else {
          if (i == row && pucks[i][3 - j] == PuckState.BLUE) {
            tempPucks[i][j] = PuckState.RED;
          } else {
            tempPucks[i][j] = pucks[i][j];
          }
        }
      }
    }
    return new State(tempPucks);
  }

  @Override
  public String toString() {
    return "RowOperator(" + row + ')';
  }
}
