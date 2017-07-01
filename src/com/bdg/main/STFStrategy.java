package com.bdg.main;

import java.util.List;

/**
 * Created by Rafael on 1/07/2017.
 * Strategia Shortest-Task-First
 */
public class STFStrategy implements SchedulingStrategy{


  @Override
  public Task nextTask(List<Task> tasks) {
    Task shortest = tasks.get(0);
    for(Task task : tasks) {
      if (shortest.getDuration() > task.getDuration()) {
        shortest = task;
      }
    }
    return shortest;
  }
}
