import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task t1, Task t2) {
        // Compare based on priority
        if (t1.getPriority() != t2.getPriority()) {
            return t2.getPriority() - t1.getPriority();
        }
        // If priority is the same, compare based on execution time
        else if (t1.getExecutionTime() != t2.getExecutionTime()) {
            return t2.getExecutionTime() - t1.getExecutionTime();
        }
        // If execution time is also the same, choose randomly
        else {
            return Math.random() > 0.5 ? 1 : -1;
        }
    }
}
