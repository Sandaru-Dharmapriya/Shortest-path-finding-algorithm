/*
 * Student ID: 20221623
 * Name: K.G.N.S.Dharmapriya
 */
public class Coordinator {
    int row;
    int column;
    int distance;
    String path;

    public Coordinator(int row, int column, int distance, String path) {
        this.path = path + " (" + (column + 1) + ", " + (row + 1) + ")\n";
        this.column = column;
        this.row = row;
        this.distance = distance;

    }

    @Override
    public String toString() {
        return "Distance: " + distance + "\n\nSTART: " + path;
    }
}
