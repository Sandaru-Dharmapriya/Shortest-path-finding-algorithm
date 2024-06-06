/*
 * Student ID: 20221623
 * Name: K.G.N.S.Dharmapriya
 */
import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {

    Queue<Coordinator> queue = new LinkedList<>();
    String[] directions = {"UP", "DOWN", "LEFT", "RIGHT"};
    int[][] derectionVectors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};



    public String algorithm(int[][] maze, int[] start, int[] end) {
        int numberOfRows = maze.length;
        int numberOfColumns = maze[0].length;

        boolean[][] visitedQueue = new boolean[numberOfRows][numberOfColumns];

        Coordinator startPosition = new Coordinator(start[0], start[1], 0, "");
        queue.add(startPosition);

        while (!queue.isEmpty()) {
            Coordinator position = queue.poll();

            if (position.row == end[0] && position.column == end[1])
                return position.toString();

            for (int i = 0; i < derectionVectors.length; i++) {
                int row = position.row;
                int column = position.column;
                int distance = position.distance;
                String path = position.path;

                // Explore directions until a wall or the end point is reached
                while (row >= 0 && row < numberOfRows && column >= 0 && column < numberOfColumns &&
                        maze[row][column] == 0 && (row != end[0] || column != end[1])) {

                    // Move in the current direction
                    row += derectionVectors[i][0];
                    column += derectionVectors[i][1];
                    distance += 1;

                }

                // Roll back one step if the goal is not found
                if (row != end[0] || column != end[1]) {
                    row -= derectionVectors[i][0];
                    column -= derectionVectors[i][1];
                    distance -= 1;
                }
                // Check if the new position has already been visited
                if (!visitedQueue[row][column]) {
                    visitedQueue[row][column] = true;
                    queue.add(new Coordinator(row, column, distance, path + directions[i]));
                }
            }
        }

        return "There is no path available!";


}

}

