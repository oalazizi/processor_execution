public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Main <num_processors> <num_cycles> <num_file_path>");
            return;
        }
        int numProcessors = Integer.parseInt(args[0]);
        int numCycles = Integer.parseInt(args[1]);
        String tasksFilePath = args[2];

        Simulator simulator = new Simulator(numProcessors, numCycles, tasksFilePath);
        simulator.start();
    }
}