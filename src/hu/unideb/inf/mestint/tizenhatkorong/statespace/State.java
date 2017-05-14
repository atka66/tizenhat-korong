package hu.unideb.inf.mestint.tizenhatkorong.statespace;

import java.util.Arrays;
import hu.unideb.inf.mestint.tizenhatkorong.statespace.operator.Operator;

public class State {
  private PuckState[][] pucks;
  private Operator[] applicableOperators;

  public State(PuckState[][] pucks) {
    this.pucks = pucks;
  }

  public PuckState[][] getPucks() {
    return pucks;
  }

  public void setPucks(PuckState[][] pucks) {
    this.pucks = pucks;
  }

  @Override
  public String toString() {
    return "State{" +
        "pucks=" + Arrays.deepToString(pucks) +
        '}';
  }
}
