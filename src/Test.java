import java.io.*;

public class Test{
    public static void main(String[] args)  {
        try {
            FillInPuzzle fp = new FillInPuzzle();
            BufferedReader inStream = new BufferedReader(new StringReader(
                    "6 5 4\n" +
                            "0 0 5 h\n" +
                            "1 2 5 h\n" +
                            "1 4 5 v\n" +
                            "4 3 4 v\n" +
                            "bash\n" +
                            "array\n" +
                            "frail\n" +
                            "plush"));
            fp.loadPuzzle(inStream);
            fp.construct2dgrid();
            FileWriter file = new FileWriter("solution.txt", false);
            PrintWriter solvedpuzzle = new PrintWriter(file);
            fp.print(solvedpuzzle);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}