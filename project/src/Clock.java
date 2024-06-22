/**
 * I decided to go with the singleton design pattern for the clock, to
 * ensure that there is one and only one clock throughout the simulation.
 */
public class Clock {
    private static Clock instance;
    private int currentCycle; // Cycle ID

    // Private constructor to prevent instantiation
    private Clock() {
        resetClock();
    }

    // Resetting the clock in case we wanted to restart the simulation
    public void resetClock() {
        currentCycle = 0;
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public void tick() {
        ++currentCycle;
    }

    public int getCurrentCycle() {
        return currentCycle;
    }
}
