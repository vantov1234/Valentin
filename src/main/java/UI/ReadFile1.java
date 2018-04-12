package UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users//Asus RG/Desktop/Test1.csv"));
        scanner.useDelimiter(";");
        int a = 0;

        List<String> dataFile = new ArrayList<>();
        dataFile.add(scanner.next());

        for (a = 0; a < 5; a++) {
            List aa = new ArrayList();
            aa.add(a);
            System.out.println(aa);
        }
    }
}