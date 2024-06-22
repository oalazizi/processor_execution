public class Task {
    // This static variable will be useful for auto-generating IDs
    private static int idCounter = 1;

    private final int id;
    private final int creationTime;
    private final int executionTime;
    private final int priority;

    public Task(int creationTime, int executionTime, int priority) {
        this.id = idCounter++;
        this.creationTime = creationTime;
        this.executionTime = executionTime;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getCreationTime() {
        return creationTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task " + id + ": [Creation Time: " + creationTime + ", Execution Time: " + executionTime + ", Priority: " + priority + "]";
    }
}
