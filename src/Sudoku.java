import java.io.IOException;

public class Sudoku {
    public static int SIZE= 9;
    public static int game[][];

    public static int convertToInt(String line, int column)  throws IOException {
        char ch = line.charAt(column);
        int number = Character.getNumericValue(ch);
        return number;
    }

    public static void printCurrentGame(int game[][]) {
        for (int row = 0; row < SIZE; row++) {
            for(int col = 0; col< SIZE; col++)
                System.out.print(game[row][col] + " ");
            System.out.println();
        }
    }

    public static boolean checkRow(int row, int number) {
        for (int i = 0; i < SIZE; i++)
            if (game[row][i] == number)
                return true;
        return false;
    }

    public static boolean checkCol(int col, int number) {
        for (int i = 0; i < SIZE; i++)
            if (game[i][col] == number)
                return true;
        return false;
    }

    public static boolean checkBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (game[i][j] == number)
                    return true;
        return false;
    }

    public static boolean check(int row, int col, int number) {
        return !checkRow(row, number)  &&  !checkCol(col, number)  &&  !checkBox(row, col, number);
    }
}
