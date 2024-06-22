public class Processor {
    // This static variable will be useful for auto-generating IDs
    private static int idCounter = 1;

    private final int id;
    private Task currentTask;
    private int remainingTime;

    public Processor() {
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public boolean isBusy() {
        return currentTask != null;
    }

    public void assignTask(Task task) {
        currentTask = task;
        remainingTime = task.getExecutionTime();
    }

    public Task tick() {
        if (currentTask != null) {
            remainingTime--;
            if (remainingTime == 0) {
                // Return completed task
                Task completedTask = currentTask;
                currentTask = null;
                return completedTask;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return id + ": " + (isBusy() ? "Executing " + currentTask : "Idle");
    }
}
