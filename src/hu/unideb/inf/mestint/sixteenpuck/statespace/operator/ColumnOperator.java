package hu.unideb.inf.mestint.sixteenpuck.statespace.operator;

import hu.unideb.inf.mestint.sixteenpuck.statespace.PuckState;
import hu.unideb.inf.mestint.sixteenpuck.statespace.State;

public class ColumnOperator implements Operator {
  private final int column;

  public ColumnOperator(int column) {
    this.column = column;
  }

  @Override
  public State apply(State state) {
    PuckState[][] pucks = state.getPucks();
    PuckState[][] tempPucks = new PuckState[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (j == column && pucks[3 - i][j] == PuckState.RED) {
          tempPucks[i][j] = PuckState.BLUE;
        } else {
          if (j == column && pucks[3 - i][j] == PuckState.BLUE) {
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
    return "ColumnOperator(" + column + ')';
  }
}
