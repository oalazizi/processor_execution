import java.io.BufferedReader;
import java.io.FileReader;
import java.security.PublicKey;
import java.util.*;

public class Simulator {
    private final int numProcessors;
    private final int numCycles;
    private final String tasksFilePath;

    private List<Task> tasks;
    private List<Processor> processors;

    private final Scheduler scheduler;
    private final Clock clock;

    public Simulator(int numProcessors, int numCycles, String tasksFilePath) {
        this.numProcessors = numProcessors;
        this.numCycles = numCycles;
        this.tasksFilePath = tasksFilePath;
        this.tasks = new ArrayList<>();
        this.processors = new ArrayList<>();
        this.scheduler = new Scheduler();
        this.clock = Clock.getInstance(); // Singleton object
        loadTasks();
        initializeProcessors();
    }

    private void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(tasksFilePath))) {
            int totalTasks = Integer.parseInt(reader.readLine());
            for (int i = 0; i < totalTasks; ++i) {
                String line = reader.readLine();
                String[] parts = line.split(" ");
                int creationTime = Integer.parseInt(parts[0]);
                int executionTime = Integer.parseInt(parts[1]);
                int priority = Integer.parseInt(parts[2]);
                tasks.add(new Task(creationTime, executionTime, priority));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeProcessors() {
        for (int i = 0; i < numProcessors; ++i)
            processors.add(new Processor());
    }

    public void start() {
        for (int i = 1; i <= numCycles; ++i) {
            clock.tick();
            scheduler.addNewTasks(tasks, clock.getCurrentCycle());
            scheduler.scheduleTask(processors);
            report(clock.getCurrentCycle());

            try {
                Thread.sleep(1000); // Sleep for 1000 ms (1 second)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        clock.resetClock(); // Resetting clock (in case we want to restart the simulation)
    }

    private void report(int cycle) {
        System.out.println("Cycle " + cycle + ":");
        for (Processor processor : processors) {
            System.out.println(processor);
        }
        System.out.println("------------------------------------------------------------------------");
    }
}
