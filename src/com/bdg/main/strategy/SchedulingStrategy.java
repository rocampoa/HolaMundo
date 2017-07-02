package com.bdg.main.strategy;

import java.util.List;

/**
 * Created by Rafael on 1/07/2017.
 */
public interface SchedulingStrategy {

  Task nextTask(List<Task> tasks);
}
