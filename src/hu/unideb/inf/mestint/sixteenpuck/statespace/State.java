package hu.unideb.inf.mestint.sixteenpuck.statespace;

import java.util.Arrays;
import java.util.List;
import hu.unideb.inf.mestint.sixteenpuck.statespace.operator.ColumnOperator;
import hu.unideb.inf.mestint.sixteenpuck.statespace.operator.Operator;
import hu.unideb.inf.mestint.sixteenpuck.statespace.operator.RowOperator;

public class State {
  private PuckState[][] pucks;
  private final List<Operator> availableOperators;

  public State(PuckState[][] pucks) {
    this.pucks = pucks;
    this.availableOperators = Arrays.asList(
        new RowOperator(0), new RowOperator(1), new RowOperator(2), new RowOperator(3),
        new ColumnOperator(0), new ColumnOperator(1), new ColumnOperator(2), new ColumnOperator(3)
    );
  }

  public PuckState[][] getPucks() {
    return pucks;
  }

  public List<Operator> getAvailableOperators() {
    return availableOperators;
  }

  @Override
  public String toString() {
    String result = "State:\n";
    for (PuckState[] puck : pucks) {
      result = result.concat(Arrays.toString(puck) + "\n");
    }
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    State state = (State) o;
    return Arrays.deepEquals(this.getPucks(), ((State) o).getPucks());
  }
}
