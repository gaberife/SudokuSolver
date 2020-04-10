
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Sudoku {
    public static int numRow = 9;
    public static int numCol= 9;
    public static int game[][];

    public static int convertToInt(String line, int column)  throws IOException {
        char ch = line.charAt(column);
        int number = Character.getNumericValue(ch);
        return number;
    } //Mutator Method

    public static void printCurrentGame(int game[][]) {
        for (int row = 0; row < numRow; row++) {
            for(int col = 0; col< numCol; col++) {
                System.out.print(game[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkZero(int row, int col){
        if (game[row][col] == 0)
            return true;
        return false;
    }

    public static int returnNonZero(int row, int col){
        return game[row][col];
    }
}
