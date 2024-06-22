import java.util.*;

public class Scheduler {
    private Queue<Task> taskQueue = new PriorityQueue<>(new TaskComparator());

    public void addNewTasks(List<Task> tasks, int cycle) {
        for (Task task : tasks) {
            if (task.getCreationTime() == cycle) {
                taskQueue.add(task);
                System.out.println("Task " + task.getId() + " created at cycle " + cycle);
            }
        }
        System.out.println();
    }

    public void scheduleTask(List<Processor> processors) {
        for (Processor processor : processors) {
            // Schedule
            Task completedTask = processor.tick();
            if (completedTask != null) {
                System.out.println("Task " + completedTask.getId() + " was completed");
            }

            // If the processor is IDLE then assign it a task
            if (!processor.isBusy() && !taskQueue.isEmpty()) {
                Task task = taskQueue.poll();
                processor.assignTask(task);
                System.out.println("Task " + task.getId() + " assigned to processor " + processor.getId());
            }
        }
        System.out.println();
    }
}
