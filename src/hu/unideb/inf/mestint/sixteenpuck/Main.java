package hu.unideb.inf.mestint.sixteenpuck;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import hu.unideb.inf.mestint.sixteenpuck.statespace.Node;
import hu.unideb.inf.mestint.sixteenpuck.statespace.PuckState;
import hu.unideb.inf.mestint.sixteenpuck.statespace.State;
import hu.unideb.inf.mestint.sixteenpuck.statespace.operator.Operator;

public class Main {

  private static List<State> goalStates = Arrays.asList(
      new State(new PuckState[][]{
          {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED},
          {PuckState.RED, PuckState.BLUE, PuckState.BLUE, PuckState.RED},
          {PuckState.RED, PuckState.BLUE, PuckState.BLUE, PuckState.RED},
          {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED}
      })
  );

  private static Node breadthFirstSearch(Node root) {
    Queue<Node> nodeQueue = new ArrayDeque<>();
    nodeQueue.add(root);
    while (!nodeQueue.isEmpty()) {
      Node currentNode = nodeQueue.remove();
      State currentNodeState = currentNode.getState();
      if (goalStates.contains(currentNodeState)) {
        return currentNode;
      }
      currentNodeState.getAvailableOperators().forEach(
          operator -> nodeQueue.add(new Node(operator.apply(currentNodeState), currentNode, operator))
      );
    }
    return null;
  }

  private static List<Operator> getSolution(Node goalNode) {
    LinkedList<Operator> solution = new LinkedList<>();
    Node currentNode = goalNode;
    while (currentNode != null && currentNode.getAppliedOperator() != null) {
      solution.addFirst(currentNode.getAppliedOperator());
      currentNode = currentNode.getParentNode();
    }
    return solution;
  }

  public static void main(String[] args) {
    Node startNode = new Node(
        new State(new PuckState[][]{
            {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED},
            {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED},
            {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED},
            {PuckState.RED, PuckState.RED, PuckState.RED, PuckState.RED}
        }),
        null,
        null
    );
    Node goalNode = breadthFirstSearch(startNode);
    if (goalNode == null) {
      System.out.println("The algorithm could not find a solution for the problem.");
    } else {
      System.out.println("The algorithm found a solution for the problem:");
      System.out.println(getSolution(goalNode));
    }
  }
}
