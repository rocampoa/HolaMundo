package com.bdg.main.strategy;

import java.util.List;

/**
 * Created by Rafael on 1/07/2017.
 * Estrategia First-come-first-serve
 */
public class FCFSStrategy implements SchedulingStrategy {

  @Override
  public Task nextTask(List<Task> tasks) {
    return tasks.get(0);
  }
}
