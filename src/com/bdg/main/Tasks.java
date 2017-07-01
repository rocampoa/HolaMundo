package com.bdg.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rafael on 1/07/2017.
 * ejemplo del patrón estrategia
 */
public class Tasks {

  private List<Task> tasks = new ArrayList<>();
  private SchedulingStrategy strategy;

  public void addTask(Task task) {
    tasks.add(task);
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public SchedulingStrategy getStrategy() {
    return strategy;
  }

  public void setStrategy(SchedulingStrategy strategy) {
    this.strategy = strategy;
  }

  public Task getNextTask() {
    return strategy.nextTask(tasks);
  }

  public static void main(String[] args) {
    Task tasks[] = {new Task("Quick", 25), new Task("Longest", 200),
            new Task("Shortest", 2), new Task("Slow", 35)};
    Tasks taskList1 = new Tasks();
    taskList1.setTasks(Arrays.asList(tasks));
    taskList1.setStrategy(new STFStrategy());
    System.out.println(taskList1.getNextTask());
  }
}
