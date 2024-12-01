import java.io.FileNotFoundException;

public class Main {
    public static final int BOARD_SIZE = 4;
    public static String[][] getBoard () {
        String[][] board = new String[BOARD_SIZE][BOARD_SIZE];

        board[0][0] = "a";
        board[0][1] = "u";
        board[0][2] = "c";
        board[0][3] = "o";

        board[1][0] = "n";
        board[1][1] = "l";
        board[1][2] = "n";
        board[1][3] = "i";

        board[2][0] = "o";
        board[2][1] = "s";
        board[2][2] = "a";
        board[2][3] = "e";

        board[3][0] = "m";
        board[3][1] = "a";
        board[3][2] = "i";
        board[3][3] = "e";

//        board[0][0] = "h";
//        board[0][1] = "q";
//        board[0][2] = "q";
//        board[0][3] = "q";
//
//        board[1][0] = "e";
//        board[1][1] = "q";
//        board[1][2] = "q";
//        board[1][3] = "q";
//
//        board[2][0] = "l";
//        board[2][1] = "q";
//        board[2][2] = "q";
//        board[2][3] = "q";
//
//        board[3][0] = "l";
//        board[3][1] = "o";
//        board[3][2] = "q";
//        board[3][3] = "q";

        return board;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello, World!");
        String[][] board = getBoard();

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDirectory);
//        Dictionary dict = new Dictionary("testDict.txt");
//        System.out.println(dict.isWord("ally"));
//        System.out.println(dict.isWord("how"));
//        dict.addWord("how");
//        System.out.println(dict.isWord("how"));

        // set board
        Boggle boggle = new Boggle("dictionary.txt", board);

//        boggle.solveBoard();
//        boggle.printSolvedWords();

        DiceSet dice = new DiceSet("dieconfig.txt");
        System.out.println(boggle.toString());

    }

}