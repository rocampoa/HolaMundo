package com.bdg.main;

/**
 * Created by Rafael on 1/07/2017.
 */
public class RunCommand implements Command {

  private final Move move;

  public RunCommand(Move move) {
    this.move = move;
  }

  @Override
  public boolean execute() {
    return move.run();
  }
}
