import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AssignmentOne {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/totae/Desktop/Assigment1/file2.txt");

        Scanner sc = new Scanner(file);

        Shape shape = new Shape();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] stringArray = line.trim().split(", ");

            Point P = new Point(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]));

            shape.addPoint(P);
        }

        shape.getPoints();
        System.out.println(shape.calculatePerimeter());
        System.out.println(shape.longestSide());
        System.out.println(shape.averageLength());
    }
}