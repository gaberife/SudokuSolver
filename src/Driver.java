import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Welcome user, its time to solve Sudoku. Please enter the file path.");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine() + ".txt";
        File confirmedFile;
        try {
            confirmedFile = new File(String.valueOf(check(fileName))); // Variable that represents the file path
            init(confirmedFile); //Initializes the data into a table
            print();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File check(String fileName) throws IOException {
        File file = new File(fileName);
        //Creates instance of file object
        BufferedReader print;
        String absolute = file.getAbsolutePath();
        // Finds absolute path of file object
        if (!file.exists()) {
            //Determines if file is valid, if not returns error message and kills program
            System.out.println("Error, file does not exist.");
            System.exit(0);
        } else {
            //Else prints the maze to the terminal
            print = new BufferedReader(new FileReader(absolute));
            String line;
            while (null != (line = print.readLine())) {
                System.out.println(line);
            }
            System.out.println();
        }
        return file;
    }

    public static void init(File file) throws IOException {
        BufferedReader line = new BufferedReader(new FileReader(file));
        //Isolates the String first line which shows N number of cities
        Sudoku.game = new int[Sudoku.numRow][Sudoku.numCol];
        for (int row = 0; row < Sudoku.numRow; row++) {
            //Reads String line and removes all non numeric values from it
            String test = line.readLine().replaceAll("[^0-9.]", "");
            for (int col = 0; col < test.length(); col++) {
                Sudoku.game[row][col] = Sudoku.convertToInt(test, col);
            }
        }
    }

    public static void solve(){
        for(int row = 0; row < Sudoku.numCol; row++) {
            for(int col = 0; col < Sudoku.numCol; col++) {
                if (!Sudoku.checkZero(row, col))
                    System.out.print(Sudoku.returnNonZero(row, col) + " ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void print(){
        System.out.println("This is the current state of the game.\n");
        Sudoku.printCurrentGame(Sudoku.game);
    }
}
