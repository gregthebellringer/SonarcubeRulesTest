package monty.hall;

import monty.hall.simulation.Simulation;

public class Main {
    private static final int DEFAULT_SIMULATION_AMOUNT = 1000;
    private static final int MIN_SIMULATION_AMOUNT = 10;
    private static final int MAX_SIMULATION_AMOUNT = 2000000000;

    public static void main(String[] args) {
        Integer amountOfSimulations = parseArgsToInteger(args);

        Simulation simulation = new Simulation();
        simulation.runSimulations(amountOfSimulations);
    }

    public static Integer parseArgsToInteger(String[] args) {
        int inputNumber = 0;

        try {
            inputNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
            System.out.println("The first argument must be an integer.");
            System.exit(1);
        }
        if (inputNumber >= MIN_SIMULATION_AMOUNT && inputNumber <= MAX_SIMULATION_AMOUNT) {
            return inputNumber;
        } else {
            System.out.println("Input value less than 10 or greater than 2.000.000.000. "
                    + "Running simulation with default value: " + DEFAULT_SIMULATION_AMOUNT);
            return DEFAULT_SIMULATION_AMOUNT;
        }
    }

}
