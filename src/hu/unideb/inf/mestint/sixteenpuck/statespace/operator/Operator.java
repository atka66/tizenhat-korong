package hu.unideb.inf.mestint.sixteenpuck.statespace.operator;

import hu.unideb.inf.mestint.sixteenpuck.statespace.State;

public interface Operator {
  State apply(State state);
}
