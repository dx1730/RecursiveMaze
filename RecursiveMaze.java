/**
 * Given a text file representing a maze, this program will solve it recursively.
 *
 * @author David Xue
 * @version 1/10/20
 */

import java.io.*;
import java.util.*;

public class RecursiveMaze {

    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("maze4.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int[][] maze = new int[row][col];

        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int blockedRow = Integer.parseInt(st.nextToken());
            int blockedCol = Integer.parseInt(st.nextToken());
            maze[blockedRow][blockedCol] = 1;
        }

        printMaze(maze);

        System.out.println(canSolveMaze(0, 0, maze));
    }

    public static boolean canSolveMaze(int row, int col, int[][] maze) {
        System.out.println(row + " " + col);
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
            System.out.println("out of bounds");
            return false;
        } else if (maze[row][col] == 1) {
            System.out.println("blocked");
            return false;
        } else if (maze[row][col] == 2) {
            System.out.println("already");
            return false;
        } else if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println("solved");
            return true;
        } else {
            maze[row][col] = 2;
            return canSolveMaze(row + 1, col, maze) || canSolveMaze(row - 1, col, maze) ||
            canSolveMaze(row, col + 1, maze) || canSolveMaze(row, col - 1, maze);
        }
    }

    public static void printMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            printRepeat("-", maze[0].length * 2 + 1);
            System.out.print("\n");
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print("|");
                if (maze[i][j] == 1) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        printRepeat("-", maze[0].length * 2 + 1);
    }

    public static void printRepeat(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(str);
        }
    }
}
