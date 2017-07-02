package com.bdg.main.strategy;

import java.util.List;

/**
 * Created by Rafael on 1/07/2017.
 * Implementa Longest-task-first
 */
public class LTFStrategy implements SchedulingStrategy{

  @Override
  public Task nextTask(List<Task> tasks) {
    Task longest = tasks.get(0);
    for(Task task : tasks) {
      if (longest.getDuration() < task.getDuration()) {
        longest = task;
      }
    }
    return longest;
  }
}
