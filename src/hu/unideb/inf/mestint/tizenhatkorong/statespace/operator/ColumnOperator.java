package hu.unideb.inf.mestint.tizenhatkorong.statespace.operator;

import hu.unideb.inf.mestint.tizenhatkorong.statespace.PuckState;
import hu.unideb.inf.mestint.tizenhatkorong.statespace.State;

public class ColumnOperator implements Operator {
  @Override
  public void apply(State state, int n) {
    PuckState[][] pucks = state.getPucks();
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (j == n && pucks[j][4 - i] == PuckState.RED) {
          pucks[j][i] = PuckState.BLUE;
        } else {
          if (i == n && pucks[j][4 - i] == PuckState.BLUE) {
            pucks[j][i] = PuckState.RED;
          }
        }
      }
    }
    state.setPucks(pucks);
  }
}
