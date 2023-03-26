import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class FillInPuzzle {

    // PART 1 Attributes
     int n_columns_puzzle;
     int n_rows_puzzle;
     int n_words_puzzle;

    // PART 2 Attributes;
    int start_col_pos;
    int start_row_pos;
    int n_letters_word;
    String word_orient;

    // Stores all the start_col_pos in the arraylist - start_col_positions.
    List<Integer> start_col_positions = new ArrayList<Integer>();

    // Stores all the start_row_pos in the arraylist - start_row_positions.
    List<Integer> start_row_positions = new ArrayList<Integer>();

    // Stores all the letters that a position can hold in the arraylist - alln_letters_word.
    List<Integer> alln_letters_word = new ArrayList<Integer>();

    // Stores all the orientations of the word in the arraylist - all_word_orient
    List<String> all_word_orient = new ArrayList<String>();

    //Stores all the words in the arraylist - words
    List<String> words = new ArrayList<String>();

    // Create a string grid which will hold the words for the crossword.
    String[][] grid;

    // Holds the value of no.of guesses that the program had to make.
    int n_guesses;
    FillInPuzzle(){

    }

    public int choices(){
        return n_guesses;
    }
    // Returns true if puzzle is loaded successfully. Return false if puzzle is not loaded successfully.
    Boolean loadPuzzle(BufferedReader stream) throws IOException {
        if(stream == null){
            return false;
        }else {
            // Loads part 1 attributes
            String[] parts = stream.readLine().split(" ");
            n_columns_puzzle = Integer.parseInt(parts[0]);
            n_rows_puzzle = Integer.parseInt(parts[1]);
            n_words_puzzle = Integer.parseInt(parts[2]);

            // Loads part 2 attributes
            for (int i = 0; i < n_words_puzzle; i++) {
                parts = stream.readLine().split(" ");

                start_col_pos = Integer.parseInt(parts[0]);
                start_col_positions.add(start_col_pos);

                start_row_pos = Integer.parseInt(parts[1]);
                start_row_positions.add(start_row_pos);

                n_letters_word = Integer.parseInt(parts[2]);
                alln_letters_word.add(n_letters_word);

                word_orient = parts[3];
                all_word_orient.add(word_orient);
            }

            // Loads part 3 attribtues
            int i = 0;
            while (i < n_words_puzzle) {
                parts = stream.readLine().split("\n");
                words.add(parts[0]);
                i++;
            }
            // returns true if successful.
            return true;
        }
    }
     void print(PrintWriter outstream){
        if(grid == null){
            outstream.print("Puzzle is not available");
        }else{
            for(int i=0;i<n_rows_puzzle;i++){
                for(int j=0;j<n_columns_puzzle;j++){
                    if(grid[i][j] == null){
                       outstream.print(" ");
                        System.out.print(" ");
                    }else {
                        outstream.print(grid[i][j]);
                    }
                }
                outstream.println();
            }
        }
        //closes the outstream file
        outstream.close();
    }
    void construct2dgrid() {
        grid = new String[n_rows_puzzle][n_columns_puzzle];

        for (int n_words = 0; n_words < n_words_puzzle; n_words++) {
            if (all_word_orient.get(n_words).equals("h")) {
                for (int k = start_col_positions.get(n_words); k < alln_letters_word.get(n_words) + start_col_positions.get(n_words); k++) {
                    int row_reverse = Math.subtractExact(n_rows_puzzle-1, start_row_positions.get(n_words));
                    grid[row_reverse][k] = ".";
                }
            } else if (all_word_orient.get(n_words).equals("v")) {
                int row_reverse = Math.subtractExact(n_rows_puzzle-1, start_row_positions.get(n_words));
                for (int k = row_reverse; k < alln_letters_word.get(n_words) + row_reverse; k++) {
                    grid[k][start_col_positions.get(n_words)] = ".";
                }
            } else {

            }
        }
    }

    Boolean solve(){
        return false;
    }
}