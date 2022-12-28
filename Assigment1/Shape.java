import java.util.ArrayList;

public class Shape {
    public ArrayList<Point> points;

    public Shape() {
        points = new ArrayList<>();
    }

    public void addPoint(Point P){
        points.add(P);
    }

    public void getPoints() {
        for (int i=0; i< points.size(); i++) {
            System.out.println(points.get(i).getX() +" "+ points.get(i).getY());
        }
    }

    public double calculatePerimeter() {
        double Perimeter = 0;
        for (int i = 0; i<points.size(); i++) {
            int j = i + 1;
            if( j == points.size()) j=0;
            Perimeter += points.get(i).distance(points.get(j));
        }
        return Perimeter;
    }

    public double longestSide() {
        double lside = Integer.MIN_VALUE;
        for (int i = 0; i<points.size(); i++) {
            int j = i + 1;
            if( j == points.size()) j=0;
            if (points.get(i).distance(points.get(j))>lside) lside=points.get(i).distance(points.get(j));
        }
        return lside;
    }

    public double averageLength() {
        return calculatePerimeter()/ points.size();
    }
}
