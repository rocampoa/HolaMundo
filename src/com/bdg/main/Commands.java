package com.bdg.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael on 1/07/2017.
 * Patrón command enfoque tradicional
 */
public class Commands {

  private final List<Command> commands = new ArrayList<>();

  public void addCommand(Command action) {
    commands.add(action);
  }

  public void executeCommand() {
    commands.forEach(Command::execute);
  }

  public static void main(String[] args) {
    Character character = new Character();
    Commands commands = new Commands();
    commands.addCommand(new WalkCommand(character));
    commands.addCommand(new JumpCommand(character));
    commands.addCommand(new RunCommand(character));
    commands.executeCommand();

    //Functiona approach
    FunctionalCommand fc = new FunctionalCommand();
    fc.addCommand(() -> character.walk());
    fc.addCommand(() -> character.run());
    fc.addCommand(() -> character.jump());
    fc.executeCommand();

    // otra forma
    fc = new FunctionalCommand();
    fc.addCommand(character::walk);
    fc.addCommand(character::run);
    fc.addCommand(character::jump);
    fc.executeCommand();

  }
}
