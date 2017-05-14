package hu.unideb.inf.mestint.tizenhatkorong.statespace;

public enum PuckState {
  RED("R"),
  BLUE("B");

  private final String name;

  PuckState(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return this.getName();
  }
}
