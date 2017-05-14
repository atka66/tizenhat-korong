package hu.unideb.inf.mestint.tizenhatkorong.statespace.operator;

import hu.unideb.inf.mestint.tizenhatkorong.statespace.PuckState;
import hu.unideb.inf.mestint.tizenhatkorong.statespace.State;

public class RowOperator implements Operator {
  private final int row;

  public RowOperator(int row) {
    this.row = row;
  }

  @Override
  public void apply(State state) {
    PuckState[][] pucks = state.getPucks();
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (i == row && pucks[3 - j][i] == PuckState.RED) {
          pucks[j][i] = PuckState.BLUE;
        } else {
          if (i == row && pucks[3 - j][i] == PuckState.BLUE) {
            pucks[j][i] = PuckState.RED;
          }
        }
      }
    }
    state.setPucks(pucks);
  }
}
