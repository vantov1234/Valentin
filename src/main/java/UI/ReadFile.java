package UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users//Asus RG/Desktop/Test1.csv"));
        scanner.useDelimiter(String.valueOf(';'));
        int b = 0;
        int a = 20;
        while (scanner.hasNext()) {
            //System.out.print(scanner.next());

            // System.out.println(b);
            // if (scanner.hasNext()) {
            //      System.out.println("I am here");
            // }
            // }
            String[][] dataFile = new String[a][b];
            for (int x = a; x >= 0; x--) {
                for (int y = b; y >= 0; b--) {
                    dataFile[x][y] = scanner.next();
                    System.out.print(dataFile[x][y]);
                }
            }
            b = b + 1;
            scanner.close();
        }
    }
}