/*
 * Student ID: 20221623
 * Name: K.G.N.S.Dharmapriya
 */
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class Parser {

    private final ArrayList<String> mazeLines = new ArrayList();
    public int[] startPosition;
    public int[] endPosition;
    public int[][] maze;
    private File readedTextFile;


    public int[] getStartPosition() {
        return startPosition;
    }

    public int[] getEndPosition() {
        return endPosition;
    }

    public int[][] getPuzzle() {
        return maze;
    }


    public void readTxtFile() {
        try {
            FileDialog inputWindow = new FileDialog((Frame)null, "select a maze");
            inputWindow.setMode(0);
            inputWindow.setDirectory(System.getProperty("user.dir"));
            inputWindow.setFile("*.txt");
            inputWindow.setVisible(true);
            String file = inputWindow.getFile();
            this.readedTextFile = inputWindow.getFiles()[0];

        }catch (Exception e){
            System.out.println("An error occured during read the maze file ");
            System.out.println(e.getMessage());
        }

    }
    public void storeLines() throws IOException {
        mazeLines.addAll(Files.readAllLines(this.readedTextFile.toPath(), Charset.defaultCharset()));
    }



    public void storeCharactors() {

        int mazeSize = ((String)mazeLines.get(0)).trim().length();
        maze = new int[mazeLines.size()][mazeSize];
        int lineCount = 0;

        for(Iterator iterator = mazeLines.iterator(); iterator.hasNext(); ++lineCount) {

            String mazeLine = (String)iterator.next();
            int[] mazeRows = new int[mazeSize];

            for(int i = 0; i < mazeSize; ++i) {
                char mazeCharator = 0;

                if (i < mazeLine.length())
                    mazeCharator = mazeLine.charAt(i);


                if (mazeCharator == 'S') {
                    startPosition = new int[]{lineCount, i};
                    mazeRows[i] = 0;
                } else if (mazeCharator == 'F') {
                    endPosition = new int[]{lineCount, i};
                    mazeRows[i] = 0;
                } else {
                    if (mazeCharator == '.') {
                        mazeRows[i] = 0;
                    } else {
                        mazeRows[i] = 1;
                    }
                }
            }

            this.maze[lineCount] = mazeRows;
        }




    }
    public void printLines() {
        Iterator iterator = this.mazeLines.iterator();

        while(iterator.hasNext()) {
            String mazeCharctors = (String)iterator.next();
            System.out.println(mazeCharctors);
        }
    }

}



