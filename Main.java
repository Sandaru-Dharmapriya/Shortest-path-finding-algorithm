/*
 * Student ID: 20221623
 * Name: K.G.N.S.Dharmapriya
 */
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Parser parserObject = new Parser();
    private static Algorithm algorithmObject = new Algorithm();


    public static void main(String[] args) {
        while(true) {
            System.out.println("Press 1 : Load a maze");
            System.out.println("Press 0 : Quit ");
            System.out.print("\nchoice: ");
            System.out.println("");
            switch (scanner.nextLine()) {
                case "1":
                    loadMaze();
                    break;

                case "0":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, Please enter 1 or 0 ...\n");
            }
        }
    }

    private static void loadMaze() {
        parserObject = new Parser();
        try {

            parserObject.readTxtFile();
            parserObject.storeLines();
            parserObject.storeCharactors();
            parserObject.printLines();
            System.out.println("");



        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("\nError reading input file, please try again\n");
        }

        findPath();
    }

    private static void findPath() {
        Instant startTime = null;
        Instant endTime = null;
        Duration duration = null;

        algorithmObject = new Algorithm();

        while(true) {

            System.out.println("\nPress 1 : print the path");
            System.out.println("Press 2 : load a new maze ");
            System.out.println("Press 3 : Exit ");
            System.out.print("\nChoice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (startTime == null) {
                        startTime = Instant.now();
                    }

                    System.out.println("\nThe shortest path : ");
                    String shortestPath = algorithmObject.algorithm(parserObject.getPuzzle(), parserObject.getStartPosition(), parserObject.getEndPosition());

                    System.out.println("");
                    System.out.println(shortestPath);

                    if (endTime == null) {
                        endTime = Instant.now();
                        duration = Duration.between(startTime, endTime);
                    }

                    // Print the time duration
                    System.out.print("Time : ");
                    System.out.println(duration.toMillis() + " milliseconds");
                    break;

                case "2":
                    System.out.println("\n");
                    parserObject = null;
                    algorithmObject = null;
                    loadMaze();
                    return;
                case "3":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, Please enter 1, 2, or 3\n");
            }
        }
    }


}
