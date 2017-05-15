package hu.unideb.inf.mestint.sixteenpuck.statespace;

import hu.unideb.inf.mestint.sixteenpuck.statespace.operator.Operator;

public class Node {
  private final State state;
  private final Node parentNode;
  private final Operator appliedOperator;

  public Node(State state, Node parentNode, Operator appliedOperator) {
    this.state = state;
    this.parentNode = parentNode;
    this.appliedOperator = appliedOperator;
  }

  public State getState() {
    return state;
  }

  public Node getParentNode() {
    return parentNode;
  }

  public Operator getAppliedOperator() {
    return appliedOperator;
  }
}
