package com.bdg.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Rafael on 1/07/2017.
 */
public class FunctionalCommand {

  private final List<Supplier<Boolean>> commands = new ArrayList<>();

  public void addCommand(Supplier<Boolean> action) {
    commands.add(action);
  }

  public void executeCommand() {
    commands.forEach(Supplier::get);
  }
}
