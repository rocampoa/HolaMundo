package com.bdg.main.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Rafael on 1/07/2017.
 * ejemplo del patrón estrategia
 * El patrón estrategia permite que un algoritmo sea seleccionado en tiempo de ejecución basado en las
 * necesidades de la aplicación. En lugar de utilizar IF para seleccionar el tipo de algoritmo que se desea utilizar
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

  // Para simplificar mas sin necesidad de tener que declarar la interface
  private Function<List<Task>, Task> strategy2;

  public void setStrategy2(Function<List<Task>, Task> strategy2) {
    this.strategy2 = strategy2;
  }

  public Task getNextTask() {
    if (strategy != null) {
      return strategy.nextTask(tasks);
    } else {
      return strategy2.apply(tasks);
    }
  }

  public static void main(String[] args) {

    System.out.println("Enfoque tradicional patrón estategia");
    Task tasks[] = {new Task("Quick", 25), new Task("Longest", 200),
            new Task("Shortest", 2), new Task("Slow", 35)};
    Tasks taskList1 = new Tasks();
    taskList1.setTasks(Arrays.asList(tasks));
    taskList1.setStrategy(new STFStrategy());
    System.out.println(taskList1.getNextTask());
    taskList1.setStrategy(new LTFStrategy());
    System.out.println(taskList1.getNextTask());

    // Usando un enfoque funcional
    System.out.println("Enfoque funcional patrón strategia");
    Comparator<Task> comparator = (x, y) -> x.getDuration() - y.getDuration();
    SchedulingStrategy stfs = t -> t.stream().min(comparator).get();
    SchedulingStrategy ltfs = t -> t.stream().max(comparator).get();
    SchedulingStrategy fcfs = t -> t.get(0);
    taskList1.setStrategy(stfs);
    System.out.println(taskList1.getNextTask());
    taskList1.setStrategy(ltfs);
    System.out.println(taskList1.getNextTask());
    taskList1.setStrategy(fcfs);
    System.out.println(taskList1.getNextTask());
    System.out.println("Para simplificar mas sin necesidad de tener que declarar la interface schedulingStrategy");
    Function<List<Task>, Task> fcfs2 = t -> t.get(0);
    Function<List<Task>, Task> ltfs2 = t -> t.stream().max(comparator).get();
    Function<List<Task>, Task> stfs2 = t -> t.stream().min(comparator).get();
    taskList1.setStrategy2(stfs2);
    System.out.println(taskList1.getNextTask());
    taskList1.setStrategy2(ltfs2);
    System.out.println(taskList1.getNextTask());
    taskList1.setStrategy2(fcfs2);
    System.out.println(taskList1.getNextTask());
  }
}
