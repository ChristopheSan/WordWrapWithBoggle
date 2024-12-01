public class Boggle {
    private static final int BOARD_SIZE = 4;

    private Dictionary dict;
    private Dictionary wordsFound;

    private DiceSet diceSet;
    private String[][] board;
    private int[][] visited;

    public Boggle() {
        this.dict = new Dictionary("mySmallDictionary.txt");
        this.wordsFound = new Dictionary();

        diceSet = new DiceSet("dieconfig.txt");
        configureBoardWithDie();

//        board = new String[BOARD_SIZE][BOARD_SIZE];
        visited = new int[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "";
            }
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                visited[i][j] = 0;
            }
        }
    }

    public Boggle(String filename) {
        this.dict = new Dictionary(filename);
        this.wordsFound = new Dictionary();

        board = new String[BOARD_SIZE][BOARD_SIZE];
        visited = new int[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "";
            }
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                visited[i][j] = 0;
            }
        }

    }

    public Boggle(String filename, String[][] board) {
        this.dict = new Dictionary(filename);
        this.wordsFound = new Dictionary();

        this.board = new String[BOARD_SIZE][BOARD_SIZE];
        setBoard(board);

        visited = new int[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                visited[i][j] = 0;
            }
        }

    }

    public void setBoard(String[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    public void solveBoard() {
        // we need to solve the board from every position
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                solveBoardHelper(i, j, "", 1);
            }
        }
    }

    public void printSolvedWords() {
        wordsFound.printWords();
    }

    // private methods
    private void configureBoardWithDie(){
        // With the diceSet use the showingside to configure a board

    }

    private void solveBoardHelper(int row, int col, String prefix, int numLetters) {
        if(row < 0 || col < 0 || row >= BOARD_SIZE || col >= BOARD_SIZE) // BOUNDS CHECK
            return;
        if (!dict.isPrefix(prefix+board[row][col])) // if the prefix is not a valid prefix, no more searches in this branch
            return;
        if (visited[row][col] > 0) // current letter has already used
            return;
        visited[row][col] = numLetters;

        if (dict.isWord(prefix+board[row][col])) {
            if(!wordsFound.isWord(prefix+board[row][col])) { // Word doesn't already exist
                wordsFound.addWord(prefix+board[row][col]);

                // print board logic here but i dont think we need this
            }
        }

        solveBoardHelper(row-1, col, prefix + board[row][col], numLetters); // N
        solveBoardHelper(row-1, col+1, prefix + board[row][col], numLetters); // NE
        solveBoardHelper(row, col+1, prefix + board[row][col], numLetters); // E
        solveBoardHelper(row+1, col+1, prefix + board[row][col], numLetters); // SE

        solveBoardHelper(row+1, col, prefix + board[row][col], numLetters); // S
        solveBoardHelper(row+1, col-1, prefix + board[row][col], numLetters); // SW
        solveBoardHelper(row, col-1, prefix + board[row][col], numLetters); // W
        solveBoardHelper(row-1, col-1, prefix + board[row][col], numLetters); // NW

        visited[row][col] = 0; // remove breadcrumb
    }

    private void resetVisited(){
        visited = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                visited[i][j] = 0;
            }
        }
    }

}
